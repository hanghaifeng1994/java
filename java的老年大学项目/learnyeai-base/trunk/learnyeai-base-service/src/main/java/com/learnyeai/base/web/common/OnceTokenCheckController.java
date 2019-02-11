package com.learnyeai.base.web.common;

import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.support.IController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 
 * @ClassName: OnceTokenCheckController
 * @Description: 一次性验证码校验，可用于防重复提交
 * @author: LQ
 * @date: 2015年7月20日
 * 
 */

@Component
public class OnceTokenCheckController implements IController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@ResponseBody
	public Map execute(IBusinessContext ctx) {
		logger.info("----------OnceTokenCheckController----------start----------");
		String transCode = "/common/onceTokenCheck";
        MDC.put(AppR.MDC_TRANS_CODE, transCode);
		boolean rst = false;
		try {
//			onceTokenCheckOp.execute(ctx);
			
			rst = true;
			return CtxReportUtil.showSuccessResult(ctx, ctx.getParamMap());
		} catch (AresRuntimeException e) {
            logger.error("OnceTokenCheckController fail");
            return CtxReportUtil.showErrorResult(e, ctx);
        }  catch (Exception e) {
			logger.warn("common.system_error", e);
			return CtxReportUtil.showErrorResult(e, ctx);
		} finally { 
            logger.info("OnceTokenCheckController end:{}", rst);
        }
	}
}
