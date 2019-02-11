package com.learnyeai.base.action.common;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.net.INetTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 短信内容发送
 * 
 * @author LQ
 * 
 */
@Component
public class SmsSendOp implements IAresSerivce {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	@Qualifier("netTools4HttpXml")
	private INetTools netTools;

	@Override
	public int execute(IBusinessContext context) {
		com.learnyeai.learnai.support.IBusinessContext ctx = (com.learnyeai.learnai.support.IBusinessContext) context;
		logger.debug("--run---");
		String transCode = "http/smsSend";
		 
		if(StringUtils.isEmpty(ctx.getParam("mobile"))){
			ctx.setParam("mobile", (String)ctx.getSessionObject(SessR.MOBILE_NO));
		}else{
			ctx.setParam("mobile",ctx.getParam("mobile"));
		}
		
        netTools.execute(ctx, transCode);
		return NEXT;
	}
}
