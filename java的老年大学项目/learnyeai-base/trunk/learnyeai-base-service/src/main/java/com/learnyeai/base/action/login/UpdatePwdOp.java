package com.learnyeai.base.action.login;

/*
import cn.com.weyeyun.base.service.ShAppletSettingService;
import cn.com.weyeyun.core.flow.IAresSerivce;
import cn.com.weyeyun.interfacebase.consts.ReportErrorKey;
import cn.com.weyeyun.interfacebase.context.CtxReportUtil;
import cn.com.weyeyun.interfacebase.context.IBusinessContext;
import cn.com.weyeyun.interfacebase.error.AresRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * 修改密码
 * Created by XieLina on 2016/5/17 0017.
 *//*

@Component
public class UpdatePwdOp implements IAresSerivce {
    @Resource
    private CustInfoExtService custInfoExtService;
    @Autowired
    private ShAppletSettingService appletSettingService;

    @Override
    public int execute(IBusinessContext ctx) {
        Object userId ="";
        String code = ctx.getParam("LOGIN_NAME");
        if(!ctx.getReqHead().containsKey("APP_ID")){
            throw new AresRuntimeException();
        }
        String appid = ctx.getReqHead().get("APP_ID").toString();
        Map applet = appletSettingService.queryById(appid);
        String mchtSchmId = ShAppletSetting.getMchtSchmId(applet);
        Map userInfo = this.custInfoExtService.queryByLoginId(code, mchtSchmId);
        if(userInfo==null){
            CtxReportUtil.showAresError(ctx, ReportErrorKey.mobile_not_use);
            return EXIT;
        } else {
            userId = CustInfo.getCustId(userInfo);
        }
        //修改用户密码
        Map user = new HashMap();
        user.put("CUST_ID",userId);
        user.put("PASSWORD", DtHelps.entryptPassword(ctx.getParam("NEW_PWD")));
        this.custInfoExtService.save(user);
        return NEXT;
    }
}
*/
