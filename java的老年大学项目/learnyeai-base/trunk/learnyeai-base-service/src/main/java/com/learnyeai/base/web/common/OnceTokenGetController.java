package com.learnyeai.base.web.common;

import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.support.IController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 
 * @ClassName: OnceTokenGetController
 * @Description: 一次性验证码获取，可用于防重复提交
 * @author: LQ
 * @date: 2015年7月20日
 * 
 */

@Component
public class OnceTokenGetController implements IController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
    private IAresSerivce onceTokenGetOp;
	
//	@RequestMapping("/common/onceTokenGet.do")
	@ResponseBody
	public Map execute(IBusinessContext ctx) {
		logger.info("----------OnceTokenGetController----------start----------");
		String transCode = "/common/onceTokenGet";
        MDC.put(AppR.MDC_TRANS_CODE, transCode);
		boolean rst = false;
		try {
			onceTokenGetOp.execute(ctx);
			
			rst = true;

			return CtxReportUtil.showSuccessResult(ctx, ctx.getParamMap());
		} catch (AresRuntimeException e) {
            logger.error("OnceTokenGetController fail");
            return CtxReportUtil.showErrorResult(e, ctx);
        } catch (Exception e) {
			logger.warn("common.system_error", e);
			return CtxReportUtil.showErrorResult(e, ctx);
		} finally { 
            logger.info("OnceTokenGetController end:{}", rst);
        }
	}
}
