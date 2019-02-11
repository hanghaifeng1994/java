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
 * 检查Android客户端是否被篡改
 * Created by xln on 2015/8/23.
 */
@Component
public class PrevTamperCodeCheckController implements IController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IAresSerivce prevTamperCodeCheckOp;

    @ResponseBody
    public Map execute(IBusinessContext ctx) {
        logger.info("----------PrevTamperCodeCheckController----------start----------");
        String transCode = "/common/prevTamperCodeCheck";
        MDC.put(AppR.MDC_TRANS_CODE, transCode);
        boolean rst = false;
        try {
            prevTamperCodeCheckOp.execute(ctx);

            rst = true;
            return CtxReportUtil.showSuccessResult(ctx, ctx.getParamMap());
        } catch (AresRuntimeException e) {
            logger.error("PrevTamperCodeCheckController fail");
            return CtxReportUtil.showErrorResult(e, ctx);
        }  catch (Exception e) {
            logger.warn("common.system_error", e);
            return CtxReportUtil.showErrorResult(e, ctx);
        } finally {
            logger.info("PrevTamperCodeCheckController end:{}", rst);
        }
    }
}
