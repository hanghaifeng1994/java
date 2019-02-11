package com.learnyeai.rabbitmq.config;

import com.learnyeai.rabbitmq.listener.AbstractMessageResultListener;
import com.learnyeai.rabbitmq.result.MessageResultListenerMap;
import com.learnyeai.rabbitmq.result.MqResultDeal;
import com.learnyeai.rabbitmq.util.MQConstants;
import com.learnyeai.rabbitmq.util.RabbitProductCache;
import com.learnyeai.rabbitmq.sender.RabbitSender;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.tools.common.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * <p><b>Description:</b> RabbitTemplate配置工厂类
 * <p><b>Company:</b> 
 *
 * @author created by hongda at 11:33 on 2017-07-05
 * @version V0.1
 */
@Configuration
@ComponentScan
public class RabbitTemplateConfig {
	 private Logger logger = LoggerFactory.getLogger(getClass());
	 
	 @Autowired
     RabbitSender rabbitSender;

     @Autowired
     private RabbitProductCache rabbitProductCache;
     @Autowired
     private MqResultDeal mqResultDeal;
	 
     @Bean
     public RabbitTemplate customRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        // mandatory 必须设置为true，ReturnCallback才会调用
        rabbitTemplate.setMandatory(true);
        // 消息发送到RabbitMQ交换器后接收ack回调
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            MDC.put("transCode", "mq/send");
            //  如果缓存数据有问题，可以根据日志手动恢复
            logger.info("confirm回调，ack={} correlationData={} cause={}", ack, correlationData, cause);

            String cacheKey = correlationData.getId();
            // 如果有缓存异常，后期定时器会再处理
            // 如果缓存中没有数据，也不处理
            RabbitMetaMessage metaMessage = rabbitProductCache.get(cacheKey);
            if(null == metaMessage){
                logger.error("消息数据丢失{}", cacheKey);
                return;
            }
            MDC.put("transCode", "mq/send/" + metaMessage.getExchange() + "_" + metaMessage.getRoutingKey());

            logger.info("rabbitMetaMessage = {}", JsonMapper.getInstance().toJson(metaMessage));
            // 如果发送到交换器都没有成功（比如说删除了交换器），ack 返回值为 false
            // 如果发送到交换器成功，但是没有匹配的队列（比如说取消了绑定），ack 返回值为还是 true （这是一个坑，需要注意）
            // 不处理，在returncallback中会重新发消息
            if(metaMessage.isReturnCallback()){
                logger.error("进入returncallback后，又进入confirmcallback {}", cacheKey);
                return;
            }
            // 除无Exchange，以及网络中断外的其它异常
            if(!ack){
                logger.error("确认失败, {}", cacheKey);
                //重发消息
                send(cacheKey, metaMessage);
                return;
            }
            metaMessage.setMsgStatus(1);
            // 处理时，首先会保存状态
            rabbitProductCache.add(metaMessage);

            // 不处理，阻塞队列会处理，阻塞队列处理失败会有定时器处理
//            mqResultDeal.deal(metaMessage);
        });

        //消息发送到RabbitMQ交换器，但无相应Exchange时触发此回掉：重发消息
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            MDC.put("transCode", "mq/send");
            String cacheKey = message.getMessageProperties().getMessageId();

            logger.error("消息投递至交换机失败，没有找到任何匹配的队列！message:{},replyCode{},replyText:{},"
                    + "exchange:{},routingKey{}", message, replyCode, replyText, exchange, routingKey);

            RabbitMetaMessage metaMessage = rabbitProductCache.get(cacheKey);
            if(metaMessage == null){
                logger.error("returncallback 消息丢失 {}", new String(message.getBody()));
                return;
            }
            MDC.put("transCode", "mq/send/" + metaMessage.getExchange() + "_" + metaMessage.getRoutingKey());
            //重发消息
            send(cacheKey, metaMessage);
        });
        
        return rabbitTemplate;
    }

    private void send(String msgId, RabbitMetaMessage rabbitMetaMessage){
        // 重发次数限制
        if(rabbitMetaMessage.getReturnTimes() >= MQConstants.MAX_RETURN_COUNT) {
            logger.warn("重发次数超限，不再发送 {}", msgId);
            return;
        }

        try {
            logger.info("重发消息，休息 {} 秒", Math.pow(MQConstants.BASE_NUM, rabbitMetaMessage.getReturnTimes()));
            Double dd = Math.random() * 10 * 1000 + 1; // 10秒内的随机数
            Thread.sleep(dd.longValue());
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            //重发消息
            rabbitSender.reSendMsg(msgId, rabbitMetaMessage);
        }catch (Exception e){
            logger.error("重发消息失败{} {}", msgId, e.getMessage());
        }
        try{
            rabbitProductCache.rtn(msgId);

        }catch (Exception e){
            logger.error("修改缓存数据失败", e);
        }
    }

	 @Bean
	 public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
	    Jackson2JsonMessageConverter jsonMessageConverter = new Jackson2JsonMessageConverter();
	    return jsonMessageConverter;
	 }
}
