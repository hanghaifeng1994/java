package com.learnyeai.audit.api.vo;


import com.learnyeai.core.support.BaseVo;
import com.learnyeai.learnai.support.BaseEntity;

import java.util.Date;

/**
 * 审核日志
 *
 * @author yl
 */
public class AdtAuditLogVo extends BaseEntity {

    /**
    * id
    */
    private String adId;

    /**
     * 对象id
     */
    private String objId;
    /**
     * 对象日志id
     */
    private String objLogId;
    /**
     * 业务类型
     */
    private String serviceType;
    /**
     * 审核状态
     */
    private String adStatus;
    /**
     * 审核人id
     */
    private String adUserId;
    /**
     * 审核人名称
     */
    private String adUserName;
    /**
     * 审核意见
     */
    private String adContent;
    /**
     * 审核日期
     */
    private Date adDate;
    /**
     * 商户id
     */
    private String mchtId;
    /**
     * 商户方案id
     */
    private String mchtSchmId;

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }
    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }
    public String getObjLogId() {
        return objLogId;
    }

    public void setObjLogId(String objLogId) {
        this.objLogId = objLogId;
    }
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getAdStatus() {
        return adStatus;
    }

    public void setAdStatus(String adStatus) {
        this.adStatus = adStatus;
    }
    public String getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(String adUserId) {
        this.adUserId = adUserId;
    }
    public String getAdUserName() {
        return adUserName;
    }

    public void setAdUserName(String adUserName) {
        this.adUserName = adUserName;
    }
    public String getAdContent() {
        return adContent;
    }

    public void setAdContent(String adContent) {
        this.adContent = adContent;
    }
    public Date getAdDate() {
        return adDate;
    }

    public void setAdDate(Date adDate) {
        this.adDate = adDate;
    }
    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }
    public String getMchtSchmId() {
        return mchtSchmId;
    }

    public void setMchtSchmId(String mchtSchmId) {
        this.mchtSchmId = mchtSchmId;
    }

    public static class TF {
        public static String adId = "adId";  // id
        public static String objId = "objId";  // 对象id
        public static String objLogId = "objLogId";  // 对象日志id
        public static String serviceType = "serviceType";  // 业务类型
        public static String adStatus = "adStatus";  // 审核状态
        public static String adUserId = "adUserId";  // 审核人id
        public static String adUserName = "adUserName";  // 审核人名称
        public static String adContent = "adContent";  // 审核意见
        public static String adDate = "adDate";  // 审核日期
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id

    }

}
