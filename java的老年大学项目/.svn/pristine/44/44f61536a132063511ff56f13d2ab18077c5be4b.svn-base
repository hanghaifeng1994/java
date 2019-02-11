package com.learnyeai.base.web.login;

import com.learnyeai.core.flow.IAresFlowDispatch;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 员工用户名密码登录，可以是后管，也可以是小程序
 * Created by zpz on 2017/11/20.
 */
@Component
public class PasswordLoginController implements IController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("passwordLoginFlow")
    private IAresFlowDispatch flow;

    @Override
    public Object execute(IBusinessContext ctx) {
        logger.debug("用户密码登录");
        ctx.getParamMap().putAll(ctx.getReqHead());
        // 登录
        // 登录成功后创建会话
        flow.execute(ctx);

        logger.debug("login end");
        // 限制输出
        return ctx.getParamMap();
    }
}
