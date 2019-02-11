package cn.com.weye.modules.sh.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;
import java.util.Date;

/**
 * 小程序配置
 *
 * @author zpzxskxsk@126.com
 */
public class ShAppletSetting extends BBaseEntity {

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
     * 
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
     * 模板小程序扩展信息
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
    /**
     * 删除标记
     */
    private String delFlag;

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
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public static class TF {

        public static String TABLE_NAME = "SH_APPLET_SETTING";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String apltSetId = "APLT_SET_ID";  // 小程序配置id
        public static String appId = "APP_ID";  // AppId
        public static String appSecret = "APP_SECRET";  // AppSecret
        public static String appName = "APP_NAME";  // 小程序名称
        public static String appSigns = "APP_SIGNS";  // 小程序标志，是核销的客户小程序，还是核销导购小程序
        public static String appAuthRefreshToken = "APP_AUTH_REFRESH_TOKEN";  // 接口调用凭据刷新令牌
        public static String appAuthInfo = "APP_AUTH_INFO";  // 
        public static String wechatMerchantName = "WECHAT_MERCHANT_NAME";  // 商户名称
        public static String wechatMerchantNum = "WECHAT_MERCHANT_NUM";  // 商户号
        public static String wechatMerchantPasswod = "WECHAT__MERCHANT_PASSWOD";  // 商户密钥
        public static String publicNumName = "PUBLIC_NUM_NAME";  // 公众号名称
        public static String publicNumAppid = "PUBLIC_NUM_APPID";  // 公众号appid
        public static String publicNumAppsecrete = "PUBLIC_NUM_APPSECRETE";  // 公众号appsecrete
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String apltId = "APLT_ID";  // 小程序ID
        public static String apltVerId = "APLT_VER_ID";  // 小程序版本id
        public static String appExtJson = "APP_EXT_JSON";  // 模板小程序扩展信息
        public static String appCodeUploadStatus = "APP_CODE_UPLOAD_STATUS";  // 上传代码状态：0未上传、1上传中、2成功、3失败
        public static String appAuditId = "APP_AUDIT_ID";  // 审核id
        public static String appAuditStatus = "APP_AUDIT_STATUS";  // 审核状态：0未提交、1提交中、2审核中、3成功、4失败
        public static String appPubStatus = "APP_PUB_STATUS";  // 发布状态：0未发布、1发布中、2发布成功、2发布失败
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String delFlag = "DEL_FLAG";  // 删除标记

    }
}
