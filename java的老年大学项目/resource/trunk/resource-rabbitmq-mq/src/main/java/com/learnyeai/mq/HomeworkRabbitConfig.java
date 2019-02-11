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
public class HomeworkRabbitConfig {
	@Autowired
	private DeadQueueDefine deadQueueDefine;

	@Bean
	public Queue homeworkCourseQueue() {
		Map<String, Object> arguments = new HashMap<String, Object>();
		/** 配置的死信队列 */
		arguments.put("x-dead-letter-exchange", deadQueueDefine.getExchange());
		arguments.put("x-dead-letter-routing-key", deadQueueDefine.getKey());
		/** 消息被确认前的最大等待时间，默认为无限大 */
		// arguments.put("x-message-ttl", 60000);
		/** 消息队列的最大大长度，默认永不过期 */
		// arguments.put("x-max-length", 300);
		return new Queue(HomeworkConstans.HOMEWORK_COURSE_QUEUE, true, false, false, arguments);
	}

	@Bean
	public DirectExchange homeworkCourseExchange() {
		return new DirectExchange(HomeworkConstans.HOMEWORK_COURSE_EXCHANGE);
	}

	@Bean
	public Binding bindingExchangeHomeworkCourse() {
		return BindingBuilder.bind(homeworkCourseQueue()).to(homeworkCourseExchange()).with(HomeworkConstans.HOMEWORK_COURSE_KEY);
	}
	
	@Bean
	public Queue homeworkScQueue() {
		Map<String, Object> arguments = new HashMap<String, Object>();
		/** 配置的死信队列 */
		arguments.put("x-dead-letter-exchange", deadQueueDefine.getExchange());
		arguments.put("x-dead-letter-routing-key", deadQueueDefine.getKey());
		/** 消息被确认前的最大等待时间，默认为无限大 */
		// arguments.put("x-message-ttl", 60000);
		/** 消息队列的最大大长度，默认永不过期 */
		// arguments.put("x-max-length", 300);
		return new Queue(HomeworkConstans.HOMEWORK_SC_QUEUE, true, false, false, arguments);
	}

	@Bean
	public DirectExchange homeworkScExchange() {
		return new DirectExchange(HomeworkConstans.HOMEWORK_SC_EXCHANGE);
	}

	@Bean
	public Binding bindingExchangeHomeworkSc() {
		return BindingBuilder.bind(homeworkScQueue()).to(homeworkScExchange()).with(HomeworkConstans.HOMEWORK_SC_KEY);
	}
}
