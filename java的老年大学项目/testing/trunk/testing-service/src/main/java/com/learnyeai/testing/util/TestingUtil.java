package com.learnyeai.testing.util;

import com.learnyeai.mq.TestingConstans;
import com.learnyeai.mq.TestingMq;
import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;

public class TestingUtil {
	public static RabbitMetaMessage toParseCourseRabbitMetaMessage(TestingMq mq) {
		/** 生成一个发送对象 */
		RabbitMetaMessage rabbitMetaMessage = new RabbitMetaMessage();
		/** 设置交换机 */
		rabbitMetaMessage.setExchange(TestingConstans.TESTING_COURSE_EXCHANGE);
		/** 指定routing key */
		rabbitMetaMessage.setRoutingKey(TestingConstans.TESTING_COURSE_KEY);
		/** 设置需要传递的消息体,可以是任意对象 */
		MqVo vo = mq;
		rabbitMetaMessage.setPayload(vo);
		return rabbitMetaMessage;
	}

	public static RabbitMetaMessage toParseScRabbitMetaMessage(TestingMq mq) {
		/** 生成一个发送对象 */
		RabbitMetaMessage rabbitMetaMessage = new RabbitMetaMessage();
		/** 设置交换机 */
		rabbitMetaMessage.setExchange(TestingConstans.TESTING_SC_EXCHANGE);
		/** 指定routing key */
		rabbitMetaMessage.setRoutingKey(TestingConstans.TESTING_SC_KEY);
		/** 设置需要传递的消息体,可以是任意对象 */
		MqVo vo = mq;
		rabbitMetaMessage.setPayload(vo);
		return rabbitMetaMessage;
	}

}
