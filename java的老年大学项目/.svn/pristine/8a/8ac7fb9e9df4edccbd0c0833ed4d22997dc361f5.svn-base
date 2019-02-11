package com.learnyeai.base.web.login;

import com.learnyeai.core.flow.IAresFlowDispatch;
import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 小程序登录
 * Created by zpz on 2018/5/10.
 */
@Component
public class AppletLoginController implements IController {
    @Autowired
    @Qualifier("appletLoginFlow")
    private IAresFlowDispatch flow;

    @Override
    public Object execute(IBusinessContext ctx) {
        ctx.getParamMap().putAll(ctx.getReqHead());
        String uuid = CtxCommonUtils.getUUID(ctx.getParamMap());
        ctx.setParam("OPEN_ID", uuid);
//        ctx.setParam("APLT_SET_ID", "8f3d7b19c0dc43479f5af955579c0dcf");

        flow.execute(ctx);

        return null;
    }
}
