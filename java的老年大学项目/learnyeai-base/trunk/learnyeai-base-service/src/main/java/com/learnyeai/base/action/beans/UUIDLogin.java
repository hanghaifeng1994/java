package com.learnyeai.base.action.beans;

import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.utils.BaseReportErrorKey;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.web.IloginSessionCreate;
import com.learnyeai.learnai.web.IuuidLogin;
import com.learnyeai.learnai.web.IuuidLoginCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * uuid登录
 * Created by zpz on 2017/11/23.
 */
@Service
public class UUIDLogin implements IuuidLogin {
    @Autowired
    IloginSessionCreate loginSessionCreateOp;
    @Autowired
    IuuidLoginCheck uuidLoginCheck;

    @Override
    public void login(IBusinessContext ctx) {

        // 防止污染上下文，重建上下文
        IBusinessContext checkCtx = ctx.copy();

        checkCtx.getParamMap().putAll(ctx.getReqHead());
        String status = uuidLoginCheck.checkLogin(checkCtx);

        if(!status.equals("1"))
        {
            ThreadContextUtil.resetSession();
            throw new AresRuntimeException(BaseReportErrorKey.RTN_RE_LOGIN);
        }

        String custId = checkCtx.getParam(CustInfoVo.CF.custId);

        loginSessionCreateOp.execute(checkCtx);
    }
}
