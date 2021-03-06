package com.learnyeai.course.mq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learnyeai.course.service.CrsCustLearnCourseWyService;
import com.learnyeai.mq.ResourceMq;
import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.listener.AbstractMessageListener;

@Component
public class ResourceLearnQueueReceiver extends AbstractMessageListener {
	@Autowired
	private CrsCustLearnCourseWyService crsCustLearnCourseWyService;

	@Override
	public boolean receiveMessage(MqVo msg, Object[] result) {
		ResourceMq obj = (ResourceMq) msg;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = crsCustLearnCourseWyService.saveQueueCustLearnCourse(obj.getStudyUserId(), obj.getResId(),
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