package com.learnyeai.base.api.vo;

import com.learnyeai.core.support.BaseVo;

import java.util.Date;

/**
 * 小程序配置
 *
 * @author zhangpz
 */
public class ShAppletSettingVo extends BaseVo {

    /**
    * 小程序配置id
    */
    private String apltSetId;

    /**
     * AppId
     */
    private String appId;
    /**
     * AppSecret
     */
    private String appSecret;
    /**
     * 小程序名称
     */
    private String appName;
    /**
     * 小程序标志，是核销的客户小程序，还是核销导购小程序
     */
    private String appSigns;
    /**
     * 接口调用凭据刷新令牌
     */
    private String appAuthRefreshToken;
    /**
     * 授权信息
     */
    private String appAuthInfo;
    /**
     * 商户名称
     */
    private String wechatMerchantName;
    /**
     * 商户号
     */
    private String wechatMerchantNum;
    /**
     * 商户密钥
     */
    private String wechatMerchantPasswod;
    /**
     * 公众号名称
     */
    private String publicNumName;
    /**
     * 公众号appid
     */
    private String publicNumAppid;
    /**
     * 公众号appsecrete
     */
    private String publicNumAppsecrete;
    /**
     * 商户方案id
     */
    private String mchtSchmId;
    /**
     * 商户id
     */
    private String mchtId;
    /**
     * 小程序ID
     */
    private String apltId;
    /**
     * 小程序版本id
     */
    private String apltVerId;
    /**
     * 模板小程序扩展信息，不包含APPID，使用时再做拼json串
     */
    private String appExtJson;
    /**
     * 上传代码状态：0未上传、1上传中、2成功、3失败
     */
    private String appCodeUploadStatus;
    /**
     * 审核id
     */
    private String appAuditId;
    /**
     * 审核状态：0未提交、1提交中、2审核中、3成功、4失败
     */
    private String appAuditStatus;
    /**
     * 发布状态：0未发布、1发布中、2发布成功、2发布失败
     */
    private String appPubStatus;
    /**
     * 版本回退状态：0未回退、1回退成功、2回退失败
     */
    private String appRevertStatus;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateDate;

    public String getApltSetId() {
        return apltSetId;
    }

    public void setApltSetId(String apltSetId) {
        this.apltSetId = apltSetId;
    }
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
    public String getAppSigns() {
        return appSigns;
    }

    public void setAppSigns(String appSigns) {
        this.appSigns = appSigns;
    }
    public String getAppAuthRefreshToken() {
        return appAuthRefreshToken;
    }

    public void setAppAuthRefreshToken(String appAuthRefreshToken) {
        this.appAuthRefreshToken = appAuthRefreshToken;
    }
    public String getAppAuthInfo() {
        return appAuthInfo;
    }

    public void setAppAuthInfo(String appAuthInfo) {
        this.appAuthInfo = appAuthInfo;
    }
    public String getWechatMerchantName() {
        return wechatMerchantName;
    }

    public void setWechatMerchantName(String wechatMerchantName) {
        this.wechatMerchantName = wechatMerchantName;
    }
    public String getWechatMerchantNum() {
        return wechatMerchantNum;
    }

    public void setWechatMerchantNum(String wechatMerchantNum) {
        this.wechatMerchantNum = wechatMerchantNum;
    }
    public String getWechatMerchantPasswod() {
        return wechatMerchantPasswod;
    }

    public void setWechatMerchantPasswod(String wechatMerchantPasswod) {
        this.wechatMerchantPasswod = wechatMerchantPasswod;
    }
    public String getPublicNumName() {
        return publicNumName;
    }

    public void setPublicNumName(String publicNumName) {
        this.publicNumName = publicNumName;
    }
    public String getPublicNumAppid() {
        return publicNumAppid;
    }

    public void setPublicNumAppid(String publicNumAppid) {
        this.publicNumAppid = publicNumAppid;
    }
    public String getPublicNumAppsecrete() {
        return publicNumAppsecrete;
    }

    public void setPublicNumAppsecrete(String publicNumAppsecrete) {
        this.publicNumAppsecrete = publicNumAppsecrete;
    }
    public String getMchtSchmId() {
        return mchtSchmId;
    }

    public void setMchtSchmId(String mchtSchmId) {
        this.mchtSchmId = mchtSchmId;
    }
    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }
    public String getApltId() {
        return apltId;
    }

    public void setApltId(String apltId) {
        this.apltId = apltId;
    }
    public String getApltVerId() {
        return apltVerId;
    }

    public void setApltVerId(String apltVerId) {
        this.apltVerId = apltVerId;
    }
    public String getAppExtJson() {
        return appExtJson;
    }

    public void setAppExtJson(String appExtJson) {
        this.appExtJson = appExtJson;
    }
    public String getAppCodeUploadStatus() {
        return appCodeUploadStatus;
    }

    public void setAppCodeUploadStatus(String appCodeUploadStatus) {
        this.appCodeUploadStatus = appCodeUploadStatus;
    }
    public String getAppAuditId() {
        return appAuditId;
    }

    public void setAppAuditId(String appAuditId) {
        this.appAuditId = appAuditId;
    }
    public String getAppAuditStatus() {
        return appAuditStatus;
    }

    public void setAppAuditStatus(String appAuditStatus) {
        this.appAuditStatus = appAuditStatus;
    }
    public String getAppPubStatus() {
        return appPubStatus;
    }

    public void setAppPubStatus(String appPubStatus) {
        this.appPubStatus = appPubStatus;
    }
    public String getAppRevertStatus() {
        return appRevertStatus;
    }

    public void setAppRevertStatus(String appRevertStatus) {
        this.appRevertStatus = appRevertStatus;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public static class CF {
        public static String apltSetId = "apltSetId";  // 小程序配置id
        public static String appId = "appId";  // AppId
        public static String appSecret = "appSecret";  // AppSecret
        public static String appName = "appName";  // 小程序名称
        public static String appSigns = "appSigns";  // 小程序标志，是核销的客户小程序，还是核销导购小程序
        public static String appAuthRefreshToken = "appAuthRefreshToken";  // 接口调用凭据刷新令牌
        public static String appAuthInfo = "appAuthInfo";  // 授权信息
        public static String wechatMerchantName = "wechatMerchantName";  // 商户名称
        public static String wechatMerchantNum = "wechatMerchantNum";  // 商户号
        public static String wechatMerchantPasswod = "wechatMerchantPasswod";  // 商户密钥
        public static String publicNumName = "publicNumName";  // 公众号名称
        public static String publicNumAppid = "publicNumAppid";  // 公众号appid
        public static String publicNumAppsecrete = "publicNumAppsecrete";  // 公众号appsecrete
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id
        public static String mchtId = "mchtId";  // 商户id
        public static String apltId = "apltId";  // 小程序ID
        public static String apltVerId = "apltVerId";  // 小程序版本id
        public static String appExtJson = "appExtJson";  // 模板小程序扩展信息，不包含APPID，使用时再做拼json串
        public static String appCodeUploadStatus = "appCodeUploadStatus";  // 上传代码状态：0未上传、1上传中、2成功、3失败
        public static String appAuditId = "appAuditId";  // 审核id
        public static String appAuditStatus = "appAuditStatus";  // 审核状态：0未提交、1提交中、2审核中、3成功、4失败
        public static String appPubStatus = "appPubStatus";  // 发布状态：0未发布、1发布中、2发布成功、2发布失败
        public static String appRevertStatus = "appRevertStatus";  // 版本回退状态：0未回退、1回退成功、2回退失败
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String delFlag = "delFlag";  // 删除标记

    }

}
