package com.learnyeai.rabbitmq.listener;

import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.util.MQConstants;
import com.learnyeai.rabbitmq.util.RabbitConsumerCache;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.tools.common.JsonMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * RabbitMQ抽象消息监听，所有消息消费者必须继承此类
 *
 */
public abstract class AbstractMessageListener implements ChannelAwareMessageListener {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private Jackson2JsonMessageConverter messageConverter;
    @Autowired
    private RabbitConsumerCache rabbitConsumerCache;
    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 接收消息，子类必须实现该方法
     *  处理结果，放到result第一个元素中
     */
    @Transactional
    public abstract boolean receiveMessage(MqVo msg, Object[] result);

    /**
     * 添加事务，确定缓存与数据库一致性，如果缓存挂了，数据库事务也会回滚
     * @param vo
     * @param rabbitMetaMessage
     */
    @Transactional
    private void toDo(MqVo vo, RabbitMetaMessage rabbitMetaMessage){
        String msgId = rabbitMetaMessage.getMsgId();
        logger.info("开始处理{} {}_{}", msgId, rabbitMetaMessage.getExchange(), rabbitMetaMessage.getRoutingKey());
        boolean isOk = false;
        Object rst = null;
//        try{
            Object rstArr[] = new Object[2];
            isOk = receiveMessage(vo, rstArr);
            rst = rstArr[0];
            logger.error("处理完成 {}", msgId);
//        }catch (Exception e){
//            isOk = false;
//            rst = "处理异常 " + e.getMessage();
//            logger.error("处理异常 {}", msgId);
//        }

        rabbitMetaMessage.setDealStatus(isOk? 1 : 2);
        rabbitMetaMessage.setDealDate(Calendar.getInstance().getTime());
        rabbitMetaMessage.setDealResult(JsonMapper.getInstance().toJson(rst));

        // 如果缓存请求失败，数据库事务回滚
        redisTemplate.opsForHash().put(vo.getCacheKey(), msgId, rabbitMetaMessage);
        // key保存到队列，以便服务端，使用阻塞式队列处理
        String finishQueue = vo.getCacheKey() + MQConstants.CONSUMER_FINISH_QUEUE_KEY;
        redisTemplate.opsForList().leftPush(finishQueue, rabbitMetaMessage.getMsgId());
    }

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        MDC.put("transCode", "mq/recive");
        // 对于同一个消息，要不要加锁处理
        String msgId = message.getMessageProperties().getMessageId();

        MessageProperties messageProperties = message.getMessageProperties();
        Long deliveryTag = messageProperties.getDeliveryTag();
        Long consumerCount = -1l;
        
        /** 执行业务，根据执行情况进行消息的ack */
        RabbitMetaMessage rabbitMetaMessage = null;
        MqVo vo = null;

        // 默认确认返回、重新进入队列，true：确认返回，false重新进入队列
        boolean actResult = true;

        try {
            consumerCount = rabbitConsumerCache.inc(messageProperties.getMessageId());
            logger.info("当前消息ID:{} 消费次数：{}", messageProperties.getMessageId(), consumerCount);
            // 判断message是否处理过，已处理直接回执
            Object oMsg = messageConverter.fromMessage(message);

            // 无法处理，确认返回
            if(!(oMsg instanceof MqVo)) {
                logger.error("无法处理{} {}", msgId, new String(message.getBody(), "utf-8"));

                // 成功的回执，生产者“消息确认回调”中，查看处理结果，没有处理结果，认为失败，记录失败次数。
//                channel.basicAck(deliveryTag, false);
                return;
            }

            vo = (MqVo)oMsg;
            rabbitMetaMessage = (RabbitMetaMessage)redisTemplate.opsForHash().get(vo.getCacheKey(), msgId);
            // 无法处理，确认返回
            if(rabbitMetaMessage == null) // 没有消息了，不作任何处理，可能是消息重发，这前处理过了。
            {
                logger.error("缓存中已无消息{} {}", msgId, new String(message.getBody(), "utf-8"));

                // 成功的回执，生产者“消息确认回调”中，查看处理结果，没有处理结果，认为失败，记录失败次数。
//                channel.basicAck(deliveryTag, false);
            }
            MDC.put("transCode", "mq/recive/" + rabbitMetaMessage.getExchange()+"_" + rabbitMetaMessage.getRoutingKey());
            // 未处理，或上次进入死信队列
            if(rabbitMetaMessage.getDealStatus() == 0 || rabbitMetaMessage.getDealStatus()==3) {
                try{
                    toDo(vo, rabbitMetaMessage);
                }catch (Exception e){// 可能是业务异常，也可能是缓存异常，如果是缓存异常，还会抛出异常
                    logger.error("处理异常 {}", msgId);
                    rabbitMetaMessage.setDealStatus(2);
                    rabbitMetaMessage.setDealDate(Calendar.getInstance().getTime());
                    rabbitMetaMessage.setDealResult("处理异常 " + e.getMessage());
                    redisTemplate.opsForHash().put(vo.getCacheKey(), msgId, rabbitMetaMessage);
                }

            }else {
                logger.debug("已处理{} {}", msgId, rabbitMetaMessage.getDealResult());
            }
            // 如果消费成功，将Redis中统计消息消费次数的缓存删除
            rabbitConsumerCache.del(msgId);
            // 成功的回执
//            channel.basicAck(deliveryTag, false);

        } catch (Exception e) { // 处理异常原因：访问缓存，或代码异常，具体的业务异常不会走到这的
            logger.error("RabbitMQ 消息消费失败，" + e.getMessage(), e);

            // 无法处理
            if(null == rabbitMetaMessage) {
                logger.error("无法处理{} {}", msgId, new String(message.getBody(), "utf-8"));
                // 成功的回执
//                channel.basicAck(deliveryTag, false);
                actResult = true;
                return;
            }

            if (consumerCount >= MQConstants.MAX_CONSUMER_COUNT) {
                actResult = true;
                // 入死信队列
                // channel.basicReject(deliveryTag, false);
                // 认为处理失败
                logger.error("多次异常,不再处理 {}，原因:{} ", msgId, e.getMessage());
                rabbitMetaMessage.setDealStatus(2);
                rabbitMetaMessage.setDealDate(Calendar.getInstance().getTime());
                rabbitMetaMessage.setDealResult("处理多次异常，原因: " + e.getMessage());
                redisTemplate.opsForHash().put(vo.getCacheKey(), msgId, rabbitMetaMessage);
            } else {
                logger.error("异常重新进入队列{}，原因:{} ", msgId, e.getMessage());
                actResult = false;
                // 重回到队列，重新消费,按照2的指数级递增，已经处理失败，再处理有什么意思？？？？
                /*Thread.sleep((long) (Math.pow(MQConstants.BASE_NUM, consumerCount)*1000));
                channel.basicNack(deliveryTag, false, true);*/
            }
        } finally {
            if(actResult){
                logger.info("确认返回 {}", msgId);
                // 成功的回执
                channel.basicAck(deliveryTag, false);
            }else {
                // 重回到队列，重新消费,按照2的指数级递增，已经处理失败，再处理有什么意思？？？？
                if(consumerCount < 0) {
                    logger.error("redis缓存异常{}", msgId);
                    long tt[] = {2l,3l,4l,5l, 6l,10l,10l,10l,10l,10l};
                    Double idx = Math.random() * 10;
                    consumerCount = tt[idx.intValue()];
                }
                logger.info("{}秒后，重新回到队列 {}", Math.pow(MQConstants.BASE_NUM, consumerCount), msgId);
                Thread.sleep((long) (Math.pow(MQConstants.BASE_NUM, consumerCount)*1000));
                channel.basicNack(deliveryTag, false, true);
            }
        }

    }

}
