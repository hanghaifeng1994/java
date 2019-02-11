package com.learnyeai.base.action.login;

import com.learnyeai.base.model.ShAppletSetting;
import com.learnyeai.base.service.ShAppletSettingWyService;
import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.consts.ConfigEnum;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.learnai.consts.ReportErrorKey;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.tools.common.JsonMapper;
import com.learnyeai.tools.http.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 获取小程序openid
 * 输入head
 *  APP_ID，小程序的appid
 *  APLT_ID
 *  UUID 小程序登录的code
 *
 *  输出
 *      OPEN_ID
 *      session_key
 *      UUID
 *      APLT_SET_ID 小程序配置id
 * Created by zpz on 2017/11/29.
 */

@Service
public class Weye_AppletGetOpenId implements IAresSerivce {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ShAppletSettingWyService appletSettingService;

    private static final String SNS_URL = "https://api.weixin.qq.com/sns/jscode2session";

    @Override
    public int execute(IBusinessContext iBaseBusinessContext) {
        // 判断是否是设备登录
        if(CtxCommonUtils.getClientOs() != ConfigEnum.CLIENT_OS.WA){
            return NEXT;
        }
        com.learnyeai.learnai.support.IBusinessContext ctx = (com.learnyeai.learnai.support.IBusinessContext) iBaseBusinessContext;

        String appId = CtxCommonUtils.getAppId(ctx.getParamMap());
        String apltId = CtxCommonUtils.getApltId(ctx.getParamMap());

        if(StringUtils.isBlank(appId) || StringUtils.isBlank(apltId)){
            throw new AresRuntimeException(ReportErrorKey.common_parameter_empty);
//            throw new AresRuntimeException("merchant_applet_not_exist", "商户小程序不存在");
        }

        ShAppletSetting appletSetting = appletSettingService.queryByApltId_appid(apltId, appId);
        String appSecrete = appletSetting.getAppSecret();
        String uuid = CtxCommonUtils.getUUID(ctx.getParamMap());

        //正常返回的JSON数据包
/*真实：实际不存在UNIONID
{"session_key":"eJMmK3ZcJ8HF3JyiNadp5g==","expires_in":7200,"openid":"om9Yh0YId-Z8d7MB6cXvjbq1m5rg"}

文档:
{
      "openid": "OPENID",
      "session_key": "SESSIONKEY",
      "unionid": "UNIONID"
}

//错误时返回JSON数据包(示例为Code无效)
{
    "errcode": 40029,
    "errmsg": "invalid code"
}*/


        logger.debug("jsCode{}", uuid);
        String result = HttpUtil.doGet(SNS_URL+
                "?grant_type=authorization_code&js_code=" + uuid + "&appid=" + appId + "&secret=" + appSecrete);

        logger.debug(result);
        Map<Object, Object> rstMap = JsonMapper.jsonToMap(result);
        if(rstMap.containsKey("errcode")){
            logger.error("获取openid失败");
            throw new RuntimeException();
        }
        String session_key = rstMap.get("session_key").toString();
        String openid = rstMap.get("openid").toString();

        ctx.getReqHead().put("UUID", openid);
        ctx.getParamMap().put("UUID", openid);
        ctx.setParam("OPEN_ID", openid);
        ctx.setParam("APLT_SET_ID", appletSetting.getApltSetId());
        ctx.setParam("MCHT_ID", appletSetting.getMchtId());
        ctx.getParamMap().put("session_key", rstMap.get("session_key"));

        ThreadContext.put(ThreadContextUtil.SESSION_ID_KEY, openid);

        return NEXT;
    }


}
