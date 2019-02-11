package com.learnyeai.schoolclass.mq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learnyeai.mq.CourseMq;
import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.listener.AbstractMessageListener;
import com.learnyeai.schoolclass.service.ClzUserClazzCourseWyService;

@Component
public class CourseQueueReceiver extends AbstractMessageListener {
	@Autowired
	private ClzUserClazzCourseWyService clzUserClazzCourseWyService;

	@Override
	public boolean receiveMessage(MqVo msg, Object[] result) {
		CourseMq obj = (CourseMq) msg;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = clzUserClazzCourseWyService.saveQueueUserClazzCourse(obj.getStudyUserId(), obj.getCsId(),
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