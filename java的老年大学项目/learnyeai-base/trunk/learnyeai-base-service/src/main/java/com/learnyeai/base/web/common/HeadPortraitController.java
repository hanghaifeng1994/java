package com.learnyeai.base.web.common;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.support.BusinessContext;
import com.learnyeai.learnai.context.CtxReportUtil;
import com.learnyeai.learnai.error.AresRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 头像上传
 * Created by hejie on 15.8.24.
 */


@Controller
public class HeadPortraitController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
//    private HeadPortraitOP headPortraitOP;

    @ResponseBody
    @RequestMapping("/common/headPortrait.do")
    public Map execute(HttpServletRequest request ) {
        logger.info("----------HeadPortraitController----------start----------");
        boolean rst = false;
        String transCode = "common/HeadPortraitUpload";
        MDC.put(AppR.MDC_TRANS_CODE, transCode);
        IBusinessContext ctx = null;
        try {
            ctx = new BusinessContext(request, null);
//            headPortraitOP.execute(ctx);
            rst = true;
            return ctx.getParamMap();
        } catch (AresRuntimeException e) {
            logger.error("HeadPortraitController fail");
            return CtxReportUtil.showErrorResult(e, ctx);
        }  catch (Exception e) {
            logger.warn("common.HeadPortraitUpload_error", e);
            return CtxReportUtil.showErrorResult(e, ctx);
        } finally {
            logger.info("HeadPortraitController end:{}", rst);
        }
    }
}
