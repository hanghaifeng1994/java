package com.learnyeai.course.mq;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learnyeai.course.service.CrsCustLearnCourseWyService;
import com.learnyeai.mq.HomeworkMq;
import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.listener.AbstractMessageListener;

@Component
public class HomeworkCourseQueueReceiver extends AbstractMessageListener {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private CrsCustLearnCourseWyService crsCustLearnCourseWyService;

	@Override
	public boolean receiveMessage(MqVo msg, Object[] result) {
		HomeworkMq obj = (HomeworkMq) msg;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = crsCustLearnCourseWyService.saveHomeworkQueueCustLearnCourse(obj.getStudentUserId(), obj.getHwId(),
					obj.getScore(), obj.getUpdateDate());
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