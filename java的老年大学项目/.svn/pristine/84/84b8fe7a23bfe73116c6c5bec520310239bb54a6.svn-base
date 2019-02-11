package com.learnyeai.mq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learnyeai.rabbitmq.util.DeadQueueDefine;

@Configuration
public class DefaultDeadQueueConfig {
	@Bean
	public DeadQueueDefine getDeadQueueDefine() {
		return new DeadQueueDefine() {
			@Override
			public String getExchange() {
				return "dead.exchange";
			}

			@Override
			public String getqQueue() {
				return "dead.queue";
			}

			@Override
			public String getKey() {
				return "dead.key";
			}
		};
	}
}
