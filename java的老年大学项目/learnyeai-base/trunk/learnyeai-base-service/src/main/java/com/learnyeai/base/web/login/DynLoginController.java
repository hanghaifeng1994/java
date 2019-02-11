package com.learnyeai.base.web.login;

import com.learnyeai.core.consts.ConfigEnum;
import com.learnyeai.core.flow.IAresFlowDispatch;
import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by zpz on 2017/11/20.
 */
@Component
public class DynLoginController implements IController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("dynLoginFlow")
    private IAresFlowDispatch flow;

    @Override
    public Object execute(IBusinessContext ctx) {
        logger.debug("动态验证码登录");
        ctx.getParamMap().putAll(ctx.getReqHead());

        ConfigEnum.CLIENT_OS clientOs = CtxCommonUtils.getClientOs();
        flow.execute(ctx);
        /*if(clientOs == ConfigEnum.CLIENT_OS.WA) {
            flow.execute(ctx);
        }else if(clientOs == ConfigEnum.CLIENT_OS.O){

        }else {

        }*/

        logger.debug("result map:{}",ctx.getParamMap());
        logger.debug("l ogin end");
        // 限制输出
        return ctx.getParamMap();
    }
}
