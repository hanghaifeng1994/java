package com.learnyeai.rabbitmq.consumer.demo.listener;

import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.listener.AbstractMessageListener;
import com.learnyeai.rabbitmq.consumer.demo.mq.DemoMq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class BizMessageListener extends AbstractMessageListener {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean receiveMessage(MqVo mqVo, Object[] objects) {
		DemoMq vo = (DemoMq)mqVo;
		logger.info("get message success:"+vo.getTitle());
		return true;
	}

}
