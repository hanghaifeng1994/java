package com.learnyeai.base.api.util;

import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.vo.*;
import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.core.utils.SpringContextUtils;


/**
 * 当前基础信息工具类
 * Created by zpz on 2018/8/3.
 */
public class CurrentBaseInfoUtil {
    private static BaseInfoDao baseInfoDao;
    private static BaseInfoDao getBaseInfoDao(){
        if(null == baseInfoDao){
            baseInfoDao = SpringContextUtils.getBean(BaseInfoDao.class);
        }
        return baseInfoDao;
    }

    // 商户
    public static ShMerchantVo getMerchant(){
        Object id = WeyeThreadContextUtils.getMerchantId();
        if(null == id)
            return null;

        return getBaseInfoDao().queryMerchant(id.toString());
    }
    // 商户方案
    public static ShMerchantSchemeVo getMerchantScheme(){

        Object id = WeyeThreadContextUtils.getMerchantSchemeId();
        if(null == id)
            return null;

        return getBaseInfoDao().queryMerchantScheme(id.toString());
    }

    // 平台
    public static PtsetPlatformVo getPlatform(){

        Object id = WeyeThreadContextUtils.getPlatformId();
        if(null == id)
            return null;

        return getBaseInfoDao().queryPlatform(id.toString());
    }

    // 站点
    public static PtsetSiteVo getSite(){

        Object id = WeyeThreadContextUtils.getSiteId();
        if(null == id)
            return null;

        return getBaseInfoDao().querySite(id.toString());
    }

    // 主站点id
    public static String getMainSiteId(){

        Object id = WeyeThreadContextUtils.getSiteId();
        if(null == id)
            return null;

        PtsetPlatformVo o = getBaseInfoDao().queryPlatform(id.toString());
        return o.getSiteId();
    }

}
