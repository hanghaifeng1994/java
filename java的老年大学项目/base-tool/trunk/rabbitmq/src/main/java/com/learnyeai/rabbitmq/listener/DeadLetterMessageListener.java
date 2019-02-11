package com.learnyeai.rabbitmq.listener;

import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.util.RabbitConsumerCache;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * Created by zpz on 2018/6/13.
 */
@Component
public class DeadLetterMessageListener implements ChannelAwareMessageListener {
    private Logger logger = LoggerFactory.getLogger(DeadLetterMessageListener.class);

    @Autowired
    private Jackson2JsonMessageConverter messageConverter;

    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RabbitConsumerCache rabbitConsumerCache;

    /**
     * Callback for processing a received Rabbit message.
     * <p>Implementors are supposed to process the given Message,
     * typically sending reply messages through the given Session.
     * @param message the received AMQP message (never <code>null</code>)
     * @param channel the underlying Rabbit Channel (never <code>null</code>)
     * @throws Exception Any.
     */
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        // 进入死信队列后，记录一下，失败次数。不作任何处理，生产者会定时发送
        MessageProperties messageProperties = message.getMessageProperties();
        Long deliveryTag = messageProperties.getDeliveryTag();

        /** 执行业务，根据执行情况进行消息的ack */
        String msgId = message.getMessageProperties().getMessageId();
        RabbitMetaMessage rabbitMetaMessage = null;
        MqVo vo = null;
        logger.info("死信队列 {}", msgId);

        try {
            Object oMsg = messageConverter.fromMessage(message);
            if (!(oMsg instanceof MqVo)) {
                // 无法处理
                logger.error("无法处理{} {}", msgId, new String(message.getBody(), "utf-8"));

                // 成功的回执
//                    channel.basicAck(deliveryTag, false);
                return;
            }

            vo = (MqVo) oMsg;
            rabbitMetaMessage = (RabbitMetaMessage) redisTemplate.opsForHash().get(vo.getCacheKey(), msgId);
            if (null == rabbitMetaMessage) {
                logger.error("无法处理{} {}", msgId, new String(message.getBody(), "utf-8"));
                return;
            }

            logger.info("消息{} {}_{}", msgId, rabbitMetaMessage.getExchange(), rabbitMetaMessage.getRoutingKey());
            // 未处理
            if (rabbitMetaMessage.getDealStatus() == 0) {
                rabbitMetaMessage.setDealStatus(3);
                rabbitMetaMessage.setDealDate(Calendar.getInstance().getTime());
                rabbitMetaMessage.setDealResult("进入了死信队列");

                redisTemplate.opsForHash().put(vo.getCacheKey(), msgId, rabbitMetaMessage);
            } else {
                logger.info("已处理{} {}", msgId, rabbitMetaMessage.getDealResult());
            }

            // 如果消费成功，将Redis中统计消息消费次数的缓存删除
            rabbitConsumerCache.del(msgId);
            // 成功的回执
//                channel.basicAck(deliveryTag, false);

        } catch (Exception e) {
            logger.error("RabbitMQ 消息消费失败，" + e.getMessage(), e);
        } finally {
            // 成功的回执
            channel.basicAck(deliveryTag, false);
        }
    }
}
