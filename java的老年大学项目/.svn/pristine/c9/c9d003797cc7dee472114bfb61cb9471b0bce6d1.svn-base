package com.learnyeai.base.action.login;

import com.learnyeai.base.model.CustLgnInfo;
import com.learnyeai.base.service.CustLgnInfoWyService;
import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 保存信息
 * 输入：loginInfoKey
 * Created by zpz on 2018/5/3.
 */
@Component
public class loginInfoSaveOp implements IAresSerivce {
    @Resource
    private CustLgnInfoWyService lgnInfoService;

    @Override
    public int execute(IBusinessContext ctx) {

        CustLgnInfo loginMap = LoginInfoGetOp.getLoginInfo(ctx);
        if(null == loginMap)
            return NEXT;
        // 检验成功，保存登录信息
        //登录信息
        // 登录正常，登录错误次数修改为0
        loginMap.setLgnErrNum(0);
        //登录状态（0未登录，1已登录）
        loginMap.setIsOnline("1");
        this.lgnInfoService.save(loginMap);

        return NEXT;
    }
}
