package com.learnyeai.common.utils;


import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.learnai.support.BusinessContext;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.net.INetTools;
import com.learnyeai.learnai.net.netConf.NetConst;

import java.util.Map;

/**
 * 基础服务http请求
 * Created by zpz on 2017/11/23.
 */
public class BaseChannelUtils {

    private static INetTools getNetTools(){
        INetTools tools = SpringContextUtils.getBean("netTools4Common");
        if(null == tools)
            throw new RuntimeException("工单渠道没有实现");
        return tools;
    }

    private static String initCommonParam(IBusinessContext context, String transCode){

        context.setParam(NetConst.TRAN_URL,transCode);

        return transCode;
    }

    /**
     * openid登录，因为各模块没有登录服务，当超时，调用基础服务进行登录
     * 需要appid apptype
     * @param context
     * @return
     */
    public static boolean uuidLogin(IBusinessContext context){
        IBusinessContext newContext = context.copy();
        String transCode = initCommonParam(newContext, "base/uuidLogin");
        return getNetTools().execute(newContext, transCode);
    }

    /**
     * 根据小程序id查询小程序信息
     * @param appId
     * @return
     */
    public static Map queryShAppletById(String appId){
        IBusinessContext newContext = new BusinessContext();
        newContext.setParam("APP_ID", appId);
        String transCode = initCommonParam(newContext, "base/common/shAppletBase/detail");
        boolean isOk = getNetTools().execute(newContext, transCode);
        if(!isOk)
            return null;
        return newContext.getParamMap();
    }

    /**
     * 小程序-根据商户方案id、方案标识查询小程序
     * @param mchtSchmId
     * @param appSigns
     * @return
     */
    public static Map queryShAppletBySchmId(String mchtSchmId, String appSigns){
        IBusinessContext newContext = new BusinessContext();
        newContext.setParam("MCHT_SCHM_ID", mchtSchmId);
        newContext.setParam("APP_SIGNS", appSigns);
        String transCode = initCommonParam(newContext, "base/common/shAppletBase/queryByShSchmId_appSings");
        boolean isOk = getNetTools().execute(newContext, transCode);
        if(!isOk)
            return null;
        return newContext.getParamMap();
    }

}
