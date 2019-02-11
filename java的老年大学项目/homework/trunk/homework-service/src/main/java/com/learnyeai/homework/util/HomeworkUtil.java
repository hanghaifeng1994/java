package com.learnyeai.homework.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.learnyeai.mq.HomeworkMq;
import com.learnyeai.mq.HomeworkConstans;
import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;

public class HomeworkUtil {
	public static List<String> convertSiteIds(String ids) {
		List<String> siteIds = new ArrayList<String>();
		if (StringUtils.isNotBlank(ids)) {
			for (String siteId : ids.split(",")) {
				siteIds.add(siteId);
			}
		} else {
			return null;
		}
		return siteIds;
	}

	public static RabbitMetaMessage toParseRabbitMetaMessage(HomeworkMq mq) {
		/** 生成一个发送对象 */
		RabbitMetaMessage rabbitMetaMessage = new RabbitMetaMessage();
		/** 设置交换机 */
		rabbitMetaMessage.setExchange(HomeworkConstans.HOMEWORK_COURSE_EXCHANGE);
		/** 指定routing key */
		rabbitMetaMessage.setRoutingKey(HomeworkConstans.HOMEWORK_COURSE_KEY);
		/** 设置需要传递的消息体,可以是任意对象 */
		MqVo vo = mq;
		rabbitMetaMessage.setPayload(vo);
		return rabbitMetaMessage;
	}
}
