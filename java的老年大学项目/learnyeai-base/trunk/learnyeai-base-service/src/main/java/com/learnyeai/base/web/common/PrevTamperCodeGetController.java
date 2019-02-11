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

import java.util.Map;

/**
 * Created by xln on 2015/8/23.
 */
@Component
public class PrevTamperCodeGetController implements IController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IAresSerivce prevTamperCodeGetOp;

    public Map execute(IBusinessContext ctx) {
        logger.info("---------PrevTamperCodeGetController start-------------");
        boolean rst = false;
        String transCode = "common/prevTamperCodeGet";
        MDC.put(AppR.MDC_TRANS_CODE, transCode);
        try {
            prevTamperCodeGetOp.execute(ctx);

            rst = true;
            return CtxReportUtil.showSuccessResult(ctx, ctx.getParamMap());
        } catch (AresRuntimeException e) {
            logger.error("PrevTamperCodeGetController fail");
            return CtxReportUtil.showErrorResult(e, ctx);
        }  catch (Exception e) {
            logger.warn("common.system_error", e);
            return CtxReportUtil.showErrorResult(e, ctx);
        } finally {
            logger.info("PrevTamperCodeGetController end:{}", rst);
        }
    }
}
