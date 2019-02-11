package com.learnyeai.mq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learnyeai.rabbitmq.util.DeadQueueDefine;

@Configuration
public class TestingRabbitConfig {
	@Autowired
	private DeadQueueDefine deadQueueDefine;

	@Bean
	public Queue testingCourseQueue() {
		Map<String, Object> arguments = new HashMap<String, Object>();
		/** 配置的死信队列 */
		arguments.put("x-dead-letter-exchange", deadQueueDefine.getExchange());
		arguments.put("x-dead-letter-routing-key", deadQueueDefine.getKey());
		/** 消息被确认前的最大等待时间，默认为无限大 */
		// arguments.put("x-message-ttl", 60000);
		/** 消息队列的最大大长度，默认永不过期 */
		// arguments.put("x-max-length", 300);
		return new Queue(TestingConstans.TESTING_COURSE_QUEUE, true, false, false, arguments);
	}

	@Bean
	public DirectExchange testingCourseExchange() {
		return new DirectExchange(TestingConstans.TESTING_COURSE_EXCHANGE);
	}

	@Bean
	public Binding bindingExchangeTestingCourse() {
		return BindingBuilder.bind(testingCourseQueue()).to(testingCourseExchange()).with(TestingConstans.TESTING_COURSE_KEY);
	}
	
	@Bean
	public Queue testingScQueue() {
		Map<String, Object> arguments = new HashMap<String, Object>();
		/** 配置的死信队列 */
		arguments.put("x-dead-letter-exchange", deadQueueDefine.getExchange());
		arguments.put("x-dead-letter-routing-key", deadQueueDefine.getKey());
		/** 消息被确认前的最大等待时间，默认为无限大 */
		// arguments.put("x-message-ttl", 60000);
		/** 消息队列的最大大长度，默认永不过期 */
		// arguments.put("x-max-length", 300);
		return new Queue(TestingConstans.TESTING_SC_QUEUE, true, false, false, arguments);
	}

	@Bean
	public DirectExchange testingScExchange() {
		return new DirectExchange(TestingConstans.TESTING_SC_EXCHANGE);
	}

	@Bean
	public Binding bindingExchangeTestingSc() {
		return BindingBuilder.bind(testingScQueue()).to(testingScExchange()).with(TestingConstans.TESTING_SC_KEY);
	}
}
