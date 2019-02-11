package com.learnyeai.rabbitmq.config;

import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.rabbitmq.listener.DeadLetterMessageListener;
import com.learnyeai.rabbitmq.util.DeadQueueDefine;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * <p><b>Description:</b> RabbitMQ交换机、队列的配置类.定义交换机、key、queue并做好绑定。
 * 同时定义每个队列的ttl，队列最大长度，Qos等等
 * 这里只绑定了死信队列。
 *
 * 进入死信队列后，记录一下，失败次数。不作任何处理，生产者会定时发送
 *
 */
@Configuration
@ComponentScan
@ConditionalOnBean(name = "deadQueueDefine")
public class DeadQueueConfig {

    public DeadQueueDefine getDeadQueueDefine() {
        return SpringContextUtils.getBean(DeadQueueDefine.class);
    }

    //========================== 声明交换机 ==========================
    /**
     * 死信交换机
     */
    @Bean
    public DirectExchange dlxExchange() {
        return new DirectExchange(getDeadQueueDefine().getExchange());
    }

 

    //========================== 声明队列 ===========================
    /**
     * 死信队列
     */
    @Bean
    public Queue dlxQueue() {
        return new Queue(getDeadQueueDefine().getqQueue(),true,false,false);
    }
    /**
     * 通过死信路由key绑定死信交换机和死信队列
     */
    @Bean
    public Binding dlxBinding() {
        return BindingBuilder.bind(dlxQueue()).to(dlxExchange())
                .with(getDeadQueueDefine().getKey());
    }
    
    /**
     * 死信队列的监听
     * @param connectionFactory RabbitMQ连接工厂
     * @param deadLetterMessageListener 死信的监听者
     * @return 监听容器对象
     */
    @Bean
    public SimpleMessageListenerContainer deadLetterListenerContainer(ConnectionFactory connectionFactory, 
    		DeadLetterMessageListener deadLetterMessageListener) {
    	
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(dlxQueue());
        container.setExposeListenerChannel(true);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener(deadLetterMessageListener);
        /** 设置消费者能处理消息的最大个数 */
        container.setPrefetchCount(100);
        return container;
    }
}
