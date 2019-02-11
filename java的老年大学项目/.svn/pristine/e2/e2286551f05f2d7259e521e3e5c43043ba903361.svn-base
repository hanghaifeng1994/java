package com.learnyeai.common.bean;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.web.IuuidLogin;
import com.learnyeai.common.utils.BaseChannelUtils;

/**
 * uuid登录
 * Created by zpz on 2017/11/23.
 */
public class UUIDLogin implements IuuidLogin {

    @Override
    public void login(IBusinessContext ctx) {
        // 防止污染上下文，重建上下文
        IBusinessContext checkCtx = ctx.copy();

        // 调用基础服务的uuid登录
        if(!BaseChannelUtils.uuidLogin(ctx))
            throw new AresRuntimeException();

    }
}
