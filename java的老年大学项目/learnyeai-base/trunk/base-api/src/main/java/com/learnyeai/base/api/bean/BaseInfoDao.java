package com.learnyeai.base.api.bean;

import com.learnyeai.base.api.vo.*;
import com.learnyeai.common.support.BaseUserDao;

import java.util.List;

/**
 * Created by zpz on 2018/8/4.
 */
public interface BaseInfoDao extends BaseUserDao {
    CustInfoVo queryCustInfo(String custId);
    //方案
    CfgSchemeVo queryScheme(String schmId);
    // 方案版本
    CfgSchemeEditionVo querySchemeEdition(String schmEdtId);
    // 商户
    ShMerchantVo queryMerchant(String mchtId);
    // 商户方案
    ShMerchantSchemeVo queryMerchantScheme(String mchtSchmId);
    // 平台
    PtsetPlatformVo queryPlatform(String ptId);
    // 站点
    PtsetSiteVo querySite(String siteId);
    // 根据平台查询站点列表
    List<PtsetSiteVo> querySitesByPt(String ptId);
}
