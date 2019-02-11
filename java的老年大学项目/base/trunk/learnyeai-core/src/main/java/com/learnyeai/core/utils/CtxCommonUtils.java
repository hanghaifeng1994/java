package com.learnyeai.core.utils;

import com.learnyeai.core.consts.ConfigEnum;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.tools.common.MapUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义interface、service常量及帮助函数
 * Created by zpz on 2018/5/12.
 */
public class CtxCommonUtils {
    // 接口报文头
    public static final String SESSION_TOKEN = "SESSION_TOKEN";
    public static final String UUID = "UUID";
    public static final String CLIENT_OS = "CLIENT_OS";
    public static final String APLT_ID = "APLT_ID";
    public static final String APP_ID = "APP_ID";
    public static final String OPEN_ID = "OPEN_ID";
    public static final String REQ_TIME = "REQ_TIME";

    // 分页、排序
    public static final String SORT = "sorts";// 排序
    public static final String PAGE_NO = "page";// 页码
    public static final String PAGE_SIZE = "rows"; // 页数

    public static Map<String, String> getSorts(Map params) {
        HashMap optMap = new HashMap();
        if(params.containsKey(SORT) && params.get(SORT) != null) {
            String ssSort = params.get(SORT).toString();
            ssSort = ssSort.trim();
            if(ssSort.length() == 0) {
                return optMap;
            }

            String[] arr = ssSort.split("&");
            String[] var4 = arr;
            int var5 = arr.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String ss = var4[var6];
                if(ss != null || ss.length() != 0) {
                    String[] keyVal = ss.split("=");
                    if(keyVal.length == 2) {
                        optMap.put(keyVal[0], keyVal[1]);
                    }
                }
            }
        }

        return optMap;
    }

    public static String getSessionToken(Map params) {
        return MapUtil.singleNodeText(params,SESSION_TOKEN);
    }

    public static String getUUID(Map params) {
        return MapUtil.singleNodeText(params,UUID);
    }

    public static String getClientOs(Map params) {
        return MapUtil.singleNodeText(params,CLIENT_OS);
    }

    public static String getApltId(Map params) {
        return MapUtil.singleNodeText(params,APLT_ID);
    }

    public static String getAppId(Map params) {
        return MapUtil.singleNodeText(params,APP_ID);
    }

    // threadcontext help
    private static final String CLIENT_OS_KEY = CtxCommonUtils.class.getName() + "_CLIENT_TYPE_KEY";

    public static void setClientOs(String clientOs) {
        String type = clientOs;
        ConfigEnum.CLIENT_OS c = null;
        try{
            c = ConfigEnum.CLIENT_OS.valueOf(clientOs);
        }catch (Exception e){
        }

        if(null == c)
            c = ConfigEnum.CLIENT_OS.O;
        ThreadContext.put(CLIENT_OS_KEY, c);
    }

    public static ConfigEnum.CLIENT_OS getClientOs() {
        return ThreadContext.getValue(CLIENT_OS_KEY, ConfigEnum.CLIENT_OS.class);
    }

}
