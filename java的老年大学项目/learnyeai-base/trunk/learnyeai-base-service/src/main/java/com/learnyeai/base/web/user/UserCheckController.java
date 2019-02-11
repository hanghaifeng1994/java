package com.learnyeai.base.web.user;

import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.service.CustOtherWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 检查用户是否存在，根据登录名、用户名和身份证
 * Created by zpz on 2018/9/5.
 */
@Component
public class UserCheckController implements IController{
    @Autowired
    private CustOtherWyService custOtherWyService;
    @Override
    public Object execute(IBusinessContext iBusinessContext) {
        CustInfo cust = custOtherWyService.checkUserExists(iBusinessContext.getParamMap());
        return cust;
    }
}
