package com.learnyeai.base.web.user;

import com.learnyeai.base.api.util.BaseCons;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.service.CustInfoWyService;
import com.learnyeai.base.service.CustOtherWyService;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 客户重置密码
 * Created by zpz on 2018/9/5.
 */
@Component
public class UserResetPasswordController implements IController{
    @Autowired
    private CustOtherWyService custOtherWyService;
    @Autowired
    private CustInfoWyService custInfoWyService;
    @Override
    public Object execute(IBusinessContext ctx) {
        CustInfo cust = custOtherWyService.checkUserExists(ctx.getParamMap());
//        检查用户状态
        String userStatus = cust.getUserStatus();
        if(!BaseCons.CUST_INFO_STATUS.N.getVal().equals(userStatus)){
            throw AresRuntimeException.build("cust.forgetPassword.disable").iniMessage("用户已冻结");
        }
        String type = cust.getCustType();
        if(!BaseCons.CUST_INFO_TYPE.KH.getVal().equals(type)){
            throw AresRuntimeException.build("cust.forgetPassword.usertype").iniMessage("用户不能重置密码");
        }
        custInfoWyService.resetPassword(cust.getCustId(), ctx.getParam("password"));
        return null;
    }
}
