package com.learnyeai.base.action.login;

import com.learnyeai.base.api.vo.ShAppletSettingVo;
import com.learnyeai.base.api.vo.ShMerchantSchemeVo;
import com.learnyeai.base.model.ShAppletSetting;
import com.learnyeai.base.model.ShMerchantScheme;
import com.learnyeai.base.service.ShAppletSettingWyService;
import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.consts.ConfigEnum;
import com.learnyeai.core.exception.BusinessException;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 检查小程序是否存在
 * 输入: APP_ID，小程序id_商户小程序appid，如果存在MCHT_ID,判断是否是同一商户
 * 输出：MCHT_SCHM_ID 商户方案id
 *  商户 MCHT_ID
 *
 * Created by zpz on 2017/11/20.
 */
@Service
public class Weye_AppletCheckOp implements IAresSerivce {
    @Autowired
    private ShAppletSettingWyService appletSettingService;
    @Override
    public int execute(IBusinessContext ctx) {

        // 如果不是小程序，不做检查
        if(CtxCommonUtils.getClientOs() != ConfigEnum.CLIENT_OS.WA){
            return NEXT;
        }

        String appId = MapUtil.getMapValue(ctx.getParamMap(), "APP_ID", null);
        String apltId = MapUtil.getMapValue(ctx.getParamMap(), "APLT_ID", null);

        ShAppletSetting appletSetting = appletSettingService.queryByApltId_appid(apltId, appId);
        if(null == appletSetting){
            throw new BusinessException("applet_setting_not_exist", "小程序不存在");
        }

        // 检查是否是同一商户
        String mchtId = ctx.getParam(ShAppletSettingVo.CF.mchtId);
        if(StringUtils.isNotBlank(mchtId) && !mchtId.equals(appletSetting.getMchtId())){
            throw new BusinessException("merchant_not_exist", "不是同一商户");
        }

        ctx.getParamMap().put(ShMerchantSchemeVo.CF.mchtSchmId, appletSetting.getMchtSchmId() );
        ctx.getParamMap().put(ShMerchantSchemeVo.CF.mchtId, appletSetting.getMchtId() );
        return NEXT;
    }
}
