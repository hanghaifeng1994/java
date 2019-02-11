package com.learnyeai.orderform.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.learnyeai.mq.OrderformConstans;
import com.learnyeai.mq.OrderformMq;
import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;

public class OrderformUtil {
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

	public static RabbitMetaMessage toParseRabbitMetaMessage(OrderformMq mq) {
		/** 生成一个发送对象 */
		RabbitMetaMessage rabbitMetaMessage = new RabbitMetaMessage();
		/** 设置交换机 */
		rabbitMetaMessage.setExchange(OrderformConstans.ORDERFORM_EXCHANGE);
		/** 指定routing key */
		rabbitMetaMessage.setRoutingKey(OrderformConstans.ORDERFORM_KEY);
		/** 设置需要传递的消息体,可以是任意对象 */
		MqVo vo = mq;
		rabbitMetaMessage.setPayload(vo);
		return rabbitMetaMessage;
	}
}
