package com.learnyeai.schoolclass.mq;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learnyeai.mq.OrderformConstans;

@Configuration
public class OrderformQueueReceiverConfig {

	@Bean(name = "orderformQueueContainer")
	public SimpleMessageListenerContainer orderformQueueContainer(ConnectionFactory connectionFactory,
			OrderformQueueReceiver orderformQueueReceiver) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
		container.setQueueNames(OrderformConstans.ORDERFORM_QUEUE);
		container.setExposeListenerChannel(true);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		container.setMessageListener(orderformQueueReceiver);
		/** 设置消费者能处理未应答消息的最大个数 */
		container.setPrefetchCount(10);
		container.setConcurrentConsumers(1);
		container.setMaxConcurrentConsumers(10);
		return container;
	}

}
