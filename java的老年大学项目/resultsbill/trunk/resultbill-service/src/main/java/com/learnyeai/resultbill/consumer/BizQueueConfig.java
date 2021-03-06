package com.learnyeai.resultbill.consumer;

import com.learnyeai.mq.ResultbillConstans;
import com.learnyeai.rabbitmq.util.DeadQueueDefine;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class BizQueueConfig {
    @Autowired
    private DeadQueueDefine deadQueueDefine;
	
	/**
     * 1 首先声明要使用哪个交换机
     */
	@Bean
    public DirectExchange businessExchange() {
        return new DirectExchange(ResultbillConstans.RESULTBILL_EXCHANGE);
    }

	 /**
     * 2 queue的名称bizQueue，以及一些参数配置
     */
   @Bean
   public Queue bizQueue() {
	   Map<String, Object> arguments = new HashMap<String, Object>();
	   /**配置的死信队列*/
	   arguments.put("x-dead-letter-exchange", deadQueueDefine.getExchange());
	   arguments.put("x-dead-letter-routing-key", deadQueueDefine.getKey());
	   /**消息被确认前的最大等待时间，默认为无限大 */
	   //arguments.put("x-message-ttl", 60000);
	   /**消息队列的最大大长度，默认永不过期*/
	   //arguments.put("x-max-length", 300);
	   return new Queue(ResultbillConstans.RESULTBILL_QUEUE,true,false,false,arguments);
   }
   
   /**
    * 3 绑定bizQueue到相应的key
    * 
    */
   @Bean
   public Binding bizBinding() {
       return BindingBuilder.bind(bizQueue()).to(businessExchange())
               .with(ResultbillConstans.RESULTBILL_KEY);
   }
    
   /**
    * 4 最后声明一个listener，用来监听
    */
   @Bean(name = "bizListenerContainer")
   public SimpleMessageListenerContainer bizListenerContainer(ConnectionFactory connectionFactory, 
   		BizMessageListener bizMessageListener) {
   	
       SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
       container.setQueues(bizQueue());
       container.setExposeListenerChannel(true);
       container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
       container.setMessageListener(bizMessageListener);
       /** 设置消费者能处理未应答消息的最大个数 */
       container.setPrefetchCount(10);
       container.setConcurrentConsumers(1);
       container.setMaxConcurrentConsumers(10);
       return container;
   }

}
