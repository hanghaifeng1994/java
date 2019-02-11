package com.learnyeai.base.api.bean;

import com.learnyeai.base.api.vo.*;
import com.learnyeai.common.support.BaseUser;

import java.util.List;

/**
 * 基础信息实现类-供通用微服务使用
 * Created by zpz on 2018/8/4.
 */
public class ClientBaseInfoDaoImpl implements BaseInfoDao {

    private ClientBaseInfoGet clientBaseInfo;

    public ClientBaseInfoDaoImpl(ClientBaseInfoGet clientBaseInfo) {
        this.clientBaseInfo = clientBaseInfo;
    }

    @Override
    public CustInfoVo queryCustInfo(String custId) {
        return clientBaseInfo.queryCustInfo(custId);
    }

    @Override
    public CfgSchemeVo queryScheme(String schmId) {
        return clientBaseInfo.queryScheme(schmId);
    }

    @Override
    public CfgSchemeEditionVo querySchemeEdition(String schmEdtId) {
        return clientBaseInfo.querySchemeEdition(schmEdtId);
    }

    @Override
    public ShMerchantVo queryMerchant(String mchtId) {
        return clientBaseInfo.queryMerchant(mchtId);
    }

    @Override
    public ShMerchantSchemeVo queryMerchantScheme(String mchtSchmId) {
        return clientBaseInfo.queryMerchantScheme(mchtSchmId);
    }

    @Override
    public PtsetPlatformVo queryPlatform(String ptId) {
        return clientBaseInfo.queryPlatform(ptId);
    }

    @Override
    public PtsetSiteVo querySite(String siteId) {
        return clientBaseInfo.querySite(siteId);
    }

    @Override
    public List<PtsetSiteVo> querySitesByPt(String ptId) {
        return clientBaseInfo.querySitesByPt(ptId);
    }

    @Override
    public BaseUser queryUserById(String userId) {
        CustInfoVo cust = clientBaseInfo.queryCustInfo(userId);
        BaseUser u = new BaseUser();
        u.setUserId(cust.getCustId());
        u.setUserName(cust.getCustName());
        u.setBirthday(cust.getBirthday());
        u.setSex(cust.getSex());
        u.setEmail(cust.getEmail());
        u.setMobile(cust.getPhoto());
        return u;
    }

    @Override
    public boolean userExists(String userId) {
        CustInfoVo cust = clientBaseInfo.queryCustInfo(userId);
        return cust == null?false : true;
    }
}
