package com.learnyeai.schoolclass.mq;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.learnyeai.mq.OrderformMq;
import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.listener.AbstractMessageListener;
import com.learnyeai.schoolclass.service.ClzStudentClazzWyService;

@Component
public class OrderformQueueReceiver extends AbstractMessageListener {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private ClzStudentClazzWyService clzStudentClazzWyService;

	@Override
	public boolean receiveMessage(MqVo msg, Object[] result) {
		OrderformMq obj = (OrderformMq) msg;
		logger.debug("开始处理订单消息队列.orderNo={}", obj.getOrderNo());
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = clzStudentClazzWyService.saveOrderformQueue(obj.getUserId(), obj.getCzId(), obj.getBatchId(),
					obj.getOrderId());
			result[0] = map;
			logger.debug("处理订单消息队列结果.orderNo={},result={}", obj.getOrderNo(), map.get("status"));
			if ("1".equals(map.get("status").toString())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			logger.debug("处理订单消息队列异常.orderNo={}|msg={}", obj.getOrderNo(), e.getMessage());
			e.printStackTrace();
			map.put("status", 0);
			map.put("msg", e.getMessage());
			result[0] = map;
			return false;
		}
	}

}