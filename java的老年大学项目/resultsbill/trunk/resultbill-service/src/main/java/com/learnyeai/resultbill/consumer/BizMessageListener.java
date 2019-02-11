package com.learnyeai.resultbill.consumer;

import com.learnyeai.mq.RabbitMq;
import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.listener.AbstractMessageListener;
import com.learnyeai.resultbill.model.BilCredit;
import com.learnyeai.resultbill.model.BilPoints;
import com.learnyeai.resultbill.service.BilCreditWyService;
import com.learnyeai.resultbill.service.BilPointsWyService;
import com.learnyeai.tools.common.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component
public class BizMessageListener extends AbstractMessageListener {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	@Qualifier(value = "redisTemplateMq")
	private RedisTemplate<String, Object> redisTemplate;
	@Value("${bilpoints_type}")
	private String bilpoints;
	@Value("${bilcredit_type}")
	private String bilcredit;
	@Resource
	private BilPointsWyService bilPointsWyService;
	@Resource
	private BilCreditWyService bilCreditWyService;

	@Override
	public boolean receiveMessage(MqVo mqVo, Object[] objects) {
		logger.info("-----接收日志对象-----");
		RabbitMq mq=(RabbitMq)mqVo;
		String type=mq.getServiceType();
		//积分账单记录新增
		String str=JsonUtils.objectToJson(mq);
		if(bilpoints.equals(type)){
			BilPoints bp=JsonUtils.jsonToObject(str,BilPoints.class);
			bilPointsWyService.save(bp);
		}else if(bilcredit.equals(type)){
			BilCredit bc=JsonUtils.jsonToObject(str,BilCredit.class);
			bilCreditWyService.save(bc);
		}
		return true;
	}

}
