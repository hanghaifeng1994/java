package com.learnyeai.course.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.learnyeai.mq.CourseConstans;
import com.learnyeai.mq.CourseMq;
import com.learnyeai.mq.ResourceConstans;
import com.learnyeai.mq.ResourceMq;
import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;

public class CourseUtil {
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

	public static RabbitMetaMessage toParseRabbitMetaMessage(CourseMq mq) {
		/** 生成一个发送对象 */
		RabbitMetaMessage rabbitMetaMessage = new RabbitMetaMessage();
		/** 设置交换机 */
		rabbitMetaMessage.setExchange(CourseConstans.COURSE_EXCHANGE);
		/** 指定routing key */
		rabbitMetaMessage.setRoutingKey(CourseConstans.COURSE_KEY);
		/** 设置需要传递的消息体,可以是任意对象 */
		MqVo vo = mq;
		rabbitMetaMessage.setPayload(vo);
		return rabbitMetaMessage;
	}
}
