package com.learnyeai.audit.consumer;

import com.learnyeai.audit.mapper.AdtAuditLogMapper;
import com.learnyeai.audit.model.AdtAuditLog;
import com.learnyeai.audit.service.AdtAuditLogWyService;
import com.learnyeai.mq.AuditlogMq;
import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.listener.AbstractMessageListener;
import com.learnyeai.tools.common.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class BizMessageListener extends AbstractMessageListener {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	AdtAuditLogWyService adtAuditLogWyService;
	@Autowired
	@Qualifier(value = "redisTemplateMq")
	private RedisTemplate<String, Object> redisTemplate;
	@Override
	public boolean receiveMessage(MqVo mqVo, Object[] objects) {
		AuditlogMq vo = (AuditlogMq)mqVo;
 		logger.info("get message success:");
		AdtAuditLog aal=parse(vo);
		adtAuditLogWyService.save(aal);
		objects[0]=aal.getAdId();
		return true;
	}
	//将消息对象转为日志对象
	public AdtAuditLog parse(AuditlogMq vo){
		AdtAuditLog aal=new AdtAuditLog();
		aal.setObjId(vo.getObjId());
		aal.setObjLogId(vo.getObjLogId());
		aal.setAdUserId(vo.getAdUserId());
		aal.setAdContent(vo.getAdContent());
		aal.setAdDate(vo.getAdTime());
		aal.setAdStatus(vo.getStatus());
		aal.setAdUserName(vo.getAdUserName());
		aal.setServiceType(vo.getServiceType());
		aal.setMchtId(vo.getMchtId());
		aal.setMchtSchmId(vo.getMchtSchmId());
		return  aal;
	}

}
