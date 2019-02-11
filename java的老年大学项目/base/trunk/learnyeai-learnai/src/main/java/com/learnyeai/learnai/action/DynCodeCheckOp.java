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

import java.util.Date;

/**
 * 动态口令验证
 * 
 * @author LQ
 * 
 */
@Component
public class DynCodeCheckOp implements IAresSerivce {
	private Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 传值
	 * DYN_CODE 短信验证码
	 */
	@Override
	public int execute(IBusinessContext context) {
		com.learnyeai.learnai.support.IBusinessContext ctx = (com.learnyeai.learnai.support.IBusinessContext) context;
		String code = ctx.getParam("DYN_CODE");
		if(code==null||code.length()<=0){
			CtxReportUtil.showAresError((com.learnyeai.learnai.support.IBusinessContext) ctx, ReportErrorKey.common_parameter_empty,"DYN_CODE");
			return EXIT;
		}

        // 获取6位随机验证码
        String dynCode = "";
        long curTime = new Date().getTime();
		// 有效时间
//		Long lastTime = ctx.getSessionObject(SessR.DYN_TIME);
		Session session = ThreadContextUtil.getSessionRequired();
		Object time =session.getAttribute(SessR.DYN_TIME);
		Long lastTime = Long.parseLong(time==null?"0":time.toString());
		if (lastTime == null || (curTime - lastTime) > SessR.DYN_TIME_OUT) {
			CtxReportUtil.showAresError(ctx, ReportErrorKey.common_dyn_code_timeout);
			return EXIT;
		} else {
			//			dynCode = ctx.getSessionObject(SessR.DYN_CODE);
			Object dcode = session.getAttribute(SessR.DYN_CODE);
			dynCode = dcode==null?"":dcode.toString();
			if(!code.equals(dynCode)){
				CtxReportUtil.showAresError(ctx, ReportErrorKey.common_dyn_code_unsame);
				return EXIT;
			}
			/*ctx.saveSessionObject(SessR.DYN_CODE, "");
			ctx.saveSessionObject(SessR.DYN_TIME, 0L);*/

			//只能校验一次
			/*session.setAttribute(SessR.DYN_CODE, "");
			session.setAttribute(SessR.DYN_TIME, 0L);*/
		}
        
		return NEXT;
	}
}
