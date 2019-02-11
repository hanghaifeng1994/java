package com.learnyeai.rabbitmq.sender;

import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.util.MQConstants;
import com.learnyeai.rabbitmq.util.RabbitProductCache;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.tools.common.JsonMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * RabbitMQ消息发送者
 *
 */

@Component
public class RabbitSender {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	Logger logger =  LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RabbitProductCache rabbitProductCache;
	
    /**
     * 发送MQ消息，第一次发消息时调用此接口，后来再发送调用另一接口
     * @param rabbitMetaMessage Rabbit元信息对象，用于存储交换器、队列名、消息体
     * @return 消息ID
     * @throws JsonProcessingException
     */
    public String send(RabbitMetaMessage rabbitMetaMessage) throws WeyeRabbitException {
        MDC.put("transCode", "mq/send/send");
        final String msgId = UUID.randomUUID().toString();
        Date curDate = Calendar.getInstance().getTime();
        rabbitMetaMessage.setCreateDate(curDate);
        // 后管设置重新处理时，修改此字段
        rabbitMetaMessage.setLastSendDate(curDate);
        return sendMsg(rabbitMetaMessage, msgId);
    }
    
    public String sendMsg(RabbitMetaMessage rabbitMetaMessage,String msgId) throws WeyeRabbitException {
        MDC.put("transCode", "mq/send/" + rabbitMetaMessage.getExchange() + "_" + rabbitMetaMessage.getRoutingKey());
        String msgJson = null;
        if(rabbitMetaMessage.getPayload() instanceof MqVo) {
            MqVo payload = (MqVo)rabbitMetaMessage.getPayload();
            payload.setCacheKey(rabbitProductCache.getCacheKey());
            rabbitMetaMessage.setPayloadClass(payload.getClass().getName());

            msgJson = JsonMapper.getInstance().toJson(rabbitMetaMessage.getPayload());
            rabbitMetaMessage.setPayload(msgJson);
        }else if(rabbitMetaMessage.getPayload() instanceof String){
            if(rabbitMetaMessage.getPayloadClass() == null){
                throw new WeyeRabbitException("消息payload类型错误");
            }
            msgJson = rabbitMetaMessage.getPayload().toString();
        }else {
            throw new WeyeRabbitException("消息payload类型错误");
        }

        logger.info("消息内容: {}", msgJson);
        if(null == msgJson){
            throw new WeyeRabbitException("发送消息失败");
        }

        rabbitMetaMessage.setReturnCallback(false);
        rabbitMetaMessage.setMsgId(msgId);
        rabbitMetaMessage.setMsgStatus(0);

        rabbitMetaMessage.setDealStatus(0);
        rabbitMetaMessage.setDealResult(null);
        rabbitMetaMessage.setDealDate(null);

        // 放缓存，只要放入缓存成功，后面失败也没问题，会定时发消息
        if(!rabbitProductCache.add(rabbitMetaMessage)){
            throw new WeyeRabbitException("保存消息到redis失败");
        }

        logger.info("发送消息，消息ID:{}", msgId);
        try {
            MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
                @Override
                public Message postProcessMessage(Message message) throws AmqpException {
                    message.getMessageProperties().setMessageId(msgId);
                    // 设置消息持久化
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    return message;
                }
            };

            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setContentType("application/json");
//            messageProperties.setHeader("__TypeId__", rabbitMetaMessage.getPayload().getClass().getName());
            messageProperties.setHeader("__TypeId__", rabbitMetaMessage.getPayloadClass());
            Message message = new Message(msgJson.getBytes("utf-8"),messageProperties);
            rabbitTemplate.convertAndSend(rabbitMetaMessage.getExchange(), rabbitMetaMessage.getRoutingKey(),
                    message, messagePostProcessor, new CorrelationData(msgId));

            return msgId;
        } catch (AmqpException e) {
            logger.error("发送RabbitMQ消息失败！稍后再定时发送 {}", msgId);
        } catch (UnsupportedEncodingException e) {
            logger.error("不可能的错误,字符串转字节出错 {} {}", msgId, e.getMessage());
        }
        return msgId;
    }

    /**
     * 重新发送
     * @param msgId
     * @param rabbitMetaMessage
     */
    public void reSendMsg(String msgId, RabbitMetaMessage rabbitMetaMessage) {

        class ReSendThread implements Callable {

            String msgId;
            RabbitMetaMessage rabbitMetaMessage;

            public ReSendThread(String msgId, RabbitMetaMessage rabbitMetaMessage) {
                this.msgId = msgId;
                this.rabbitMetaMessage = rabbitMetaMessage;
            }

            @Override
            public Boolean call() throws Exception {
                //重发消息
                try {
                    sendMsg(this.rabbitMetaMessage, this.msgId);
                }catch (Exception e){
                    logger.error("发送消息失败, {}", e.getMessage());
                    return false;
                }
                return true;
            }
        }

        Retryer<Boolean> retryer = RetryerBuilder
                .<Boolean>newBuilder()
                //抛出runtime异常、checked异常时都会重试，但是抛出error不会重试。
                .retryIfException()
                .retryIfResult(Predicates.equalTo(false))
                //重试策略  100ms*2^n 最多10s
                .withWaitStrategy(WaitStrategies.exponentialWait(MQConstants.MUTIPLIER_TIME,
                        MQConstants.MAX_RETRY_TIME, TimeUnit.SECONDS))
//                .withStopStrategy(StopStrategies.neverStop())
                .withStopStrategy(StopStrategies.stopAfterAttempt(MQConstants.MAX_RETRY_COUNT))
                .build();

        ReSendThread reSendThread = new ReSendThread(msgId, rabbitMetaMessage);
        logger.info("重发消息，msgId:{}", msgId);
        try {
            boolean isOk = retryer.call(reSendThread);
            //未发送成功，定时器会再次发送
            if(!isOk) {
                logger.error("重发消息异常 {}", msgId);
                // 死住队列不处理任务业务
                // rabbitSender.sendMsgToDeadQueue(rabbitMetaMessage.getPayload());
            }
        } catch (Exception e) {
            logger.error("重发消息异常 " + msgId, e);
        }
    }
    
}
