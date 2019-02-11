package com.learnyeai.learnai.action;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.consts.ReportErrorKey;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 手机有效性校验
 * 
 * @author XieLina
 * 
 */
@Component
public class MobileCheckOp implements IAresSerivce {
	private Logger logger = LoggerFactory.getLogger(getClass());

/**
	 * 传值
	 * FIND_CODE 手机有效性校验
	 */

	public int execute(IBusinessContext context) {
		com.learnyeai.learnai.support.IBusinessContext ctx = (com.learnyeai.learnai.support.IBusinessContext) context;
        String code = ctx.getParam("LOGIN_NAME");
		if(code==null||code.length()<=0){
			CtxReportUtil.showAresError(ctx, ReportErrorKey.common_parameter_empty,"LOGIN_NAME");
			return EXIT;
		}
		Session session = ThreadContextUtil.getSessionRequired();
		Object dcode = session.getAttribute(SessR.DYN_NO);
		if(!code.equals(dcode)){
			CtxReportUtil.showAresError(ctx, ReportErrorKey.mobile_not_same);
			return EXIT;
		}
		ctx.setParam("loginName", code);
		return NEXT;
	}
}
