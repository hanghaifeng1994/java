package com.learnyeai.course.mq;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learnyeai.mq.TestingConstans;

@Configuration
public class TestingCourseQueueReceiverConfig {

	@Bean(name = "testingCourseQueueContainer")
	public SimpleMessageListenerContainer testingCourseQueueContainer(ConnectionFactory connectionFactory,
			TestingCourseQueueReceiver testingCourseQueueReceiver) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
		container.setQueueNames(TestingConstans.TESTING_COURSE_QUEUE);
		container.setExposeListenerChannel(true);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		container.setMessageListener(testingCourseQueueReceiver);
		/** 设置消费者能处理未应答消息的最大个数 */
		container.setPrefetchCount(10);
		container.setConcurrentConsumers(1);
		container.setMaxConcurrentConsumers(10);
		return container;
	}
}
