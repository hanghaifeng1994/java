package com.learnyeai.base.web.common;

import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.net.INetTools;
import com.learnyeai.learnai.support.IController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * 8583报文测试
 * Created by hejie on 2015/8/27.
 */

@Component
public class Test8583Controller implements IController {
    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    @Qualifier("netTools4SocketISO8583")
    INetTools netTools;

    public Map execute(IBusinessContext ctx) {
        logger.info("----------Test8583Controller----------start----------");
        boolean rst = false;
        String transCode = "8583";
        MDC.put(AppR.MDC_TRANS_CODE, transCode);
        try {
            netTools.execute(ctx,transCode);
            rst = true;
            return CtxReportUtil.showSuccessResult(ctx, ctx.getParamMap());
        } catch (AresRuntimeException e) {
            logger.error("Test8583Controller fail");
            return CtxReportUtil.showErrorResult(e, ctx);
        }  catch (Exception e) {
            logger.warn("common.test8583_error", e);
            return CtxReportUtil.showErrorResult(e, ctx);
        } finally {
            logger.info("Test8583Controller end:{}", rst);
        }
    }
}
