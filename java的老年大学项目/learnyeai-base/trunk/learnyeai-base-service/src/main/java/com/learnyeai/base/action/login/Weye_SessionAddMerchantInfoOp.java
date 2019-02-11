package com.learnyeai.base.action.login;

import com.learnyeai.base.api.vo.ShMerchantVo;
import com.learnyeai.base.model.ShMerchant;
import com.learnyeai.base.service.ShAppletSettingWyService;
import com.learnyeai.base.service.ShMerchantSchemeWyService;
import com.learnyeai.base.service.ShMerchantWyService;
import com.learnyeai.base.service.ShOrderWyService;
import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.context.ThreadContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 保存商户、商户版本、程序信息信息到session
 * 输入商户方案id、appid、mchtSchmId
 * Created by zpz on 2017/11/18.
 */

@Service
public class Weye_SessionAddMerchantInfoOp implements IAresSerivce {

    @Autowired
    private ShMerchantWyService merchantService;
    @Autowired
    private ShMerchantSchemeWyService merchantSchemeService;
    @Autowired
    private ShAppletSettingWyService appletSettingService;
    @Autowired
    private ShOrderWyService shOrderService;

    @Override
    public int execute(IBusinessContext iBaseBusinessContext) {

        com.learnyeai.learnai.support.IBusinessContext ctx = (com.learnyeai.learnai.support.IBusinessContext) iBaseBusinessContext;
        // 商户id必存在
        String mchtId = ctx.getParam(ShMerchantVo.CF.mchtId);

        // 商户
        ShMerchant merchant = merchantService.queryById(mchtId);
//        ThreadContextUtil.getSession(false).setAttribute(WeyeSessUtils.MERCHANT_INFO, merchant);
//        WeyeCons.LOGIN_TYPE eloginType = WeyeSessUtils.getLoginType();
        // APP_TYPE：1客户小程序、2员工小程序、3员工后管登录
        /*if(eloginType == WeyeCons.LOGIN_TYPE.STAFF_MNG){

        }else*/ {
            // uuid做为openid输出
            /*ctx.setParam("openId", CtxHeadUtil.getUUID(ctx));

            String setId = MapUtil.getMapValue(ctx.getReqHead(), ShAppletSetting.TF.appId, null);
            Map appletSetting = appletSettingService.queryById(setId);
            String mchtSchmId = ShAppletSetting.getMchtSchmId(appletSetting);
            // 商户方案
            Map merchantScheme = merchantSchemeService.queryById(mchtSchmId);

            ThreadContext.getSession(false).setAttribute(WeyeSessUtils.MERCHANT_SCHEME_INFO, merchantScheme);
            ThreadContext.getSession(false).setAttribute(WeyeSessUtils.APPLET_INFO, appletSetting);*/
        }

        return NEXT;
    }
}
