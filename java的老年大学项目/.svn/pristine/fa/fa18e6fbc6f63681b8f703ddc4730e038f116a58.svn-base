package com.learnyeai.common.utils;

import com.learnyeai.core.support.ThreadContext;

/**
 * 微业线程上下文工具类
 * Created by zpz on 2018/8/7.
 */
public class WeyeThreadContextUtils {
    public static final String CTX_CUR_SITE = "_current_site";
    public static final String CTX_CUR_PLATFORM = "_current_platform";
    public static final String CTX_CUR_MERCHANT = "_current_merchant";
    public static final String CTX_CUR_MERCHANT_SCHEME = "_current_merchant_scheme";


    // 商户
    public static String getMerchantId(){
        Object id = ThreadContext.get(CTX_CUR_MERCHANT);
        if(null == id)
            return null;

        return id.toString();
    }

    // 商户方案
    public static String getMerchantSchemeId(){

        Object id = ThreadContext.get(CTX_CUR_MERCHANT_SCHEME);
        if(null == id)
            return null;

        return id.toString();
    }


    // 平台
    public static String getPlatformId(){

        Object id = ThreadContext.get(CTX_CUR_PLATFORM);
        if(null == id)
            return null;
        return id.toString();
    }

    // 站点
    public static String getSiteId(){

        Object id = ThreadContext.get(CTX_CUR_SITE);
        if(null == id)
            return null;

        return id.toString();
    }

}
