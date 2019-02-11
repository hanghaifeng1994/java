package com.learnyeai.schoolclass.mq;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.learnyeai.mq.TestingMq;
import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.listener.AbstractMessageListener;
import com.learnyeai.schoolclass.service.ClzStudentClazzWyService;

@Component
public class TestingScQueueReceiver extends AbstractMessageListener {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private ClzStudentClazzWyService clzStudentClazzWyService;

	@Override
	public boolean receiveMessage(MqVo msg, Object[] result) {
		TestingMq obj = (TestingMq) msg;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = clzStudentClazzWyService.saveTestingQueue(obj.getStudentUserId(), obj.getTsId(), obj.getScore(),
					obj.getUpdateDate());
			result[0] = map;
			if ("1".equals(map.get("status").toString()))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", 0);
			map.put("msg", e.getMessage());
			return false;
		}
	}

}