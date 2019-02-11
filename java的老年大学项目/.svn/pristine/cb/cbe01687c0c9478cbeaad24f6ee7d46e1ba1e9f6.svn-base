package com.learnyeai.base.web.common;

import com.learnyeai.core.config.ConfigUtils;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import cn.com.zhisou.resource.ResourceGlobal;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 获取系统配置
 */
@Component
public class SysConfigurationController implements IController {

    @Override
    public Object execute(IBusinessContext ctx) {

        Map pp = new HashMap();

        //资源服务器地址
//        ctx.setParam("RES_WEB_URL", ResourceGlobal.getServerBaseUrl());
        pp.put("RES_UPLOAD_URL", ResourceGlobal.getServerUploadUrl());

        // 基础服务地址
        String preFix = "syscfg.";
        int len = preFix.length();
        Set<String> keys = ConfigUtils.keySetStartWith(preFix);
        for (String key : keys){
            pp.put(key.substring(len), ConfigUtils.getValue(key));
        }

//        CtxHeadUtil.setReportDataDealType("1");
        return pp;
    }
}
