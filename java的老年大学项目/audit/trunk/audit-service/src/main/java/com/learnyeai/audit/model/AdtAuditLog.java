package com.learnyeai.audit.model;
import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 审核日志
 *
 * @author yl
 */
/*@Entity
@Table(name="adt_audit_log")*/
public class AdtAuditLog extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "AD_ID")
    private String adId;

    /**
     * 对象id
     */
    @Column(name = "OBJ_ID")
    private String objId;
    /**
     * 对象日志id
     */
    @Column(name = "OBJ_LOG_ID")
    private String objLogId;
    /**
     * 业务类型
     */
    @Column(name = "SERVICE_TYPE")
    private String serviceType;
    /**
     * 审核状态
     */
    @Column(name = "AD_STATUS")
    private String adStatus;
    /**
     * 审核人id
     */
    @Column(name = "AD_USER_ID")
    private String adUserId;
    /**
     * 审核人名称
     */
    @Column(name = "AD_USER_NAME")
    private String adUserName;
    /**
     * 审核意见
     */
    @Column(name = "AD_CONTENT")
    private String adContent;
    /**
     * 审核日期
     */
    @Column(name = "AD_DATE")
    private Date adDate;
    /**
     * 商户id
     */
    @Column(name = "MCHT_ID")
    private String mchtId;
    /**
     * 商户方案id
     */
    @Column(name = "MCHT_SCHM_ID")
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

        public static String TABLE_NAME = "ADT_AUDIT_LOG";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String adId = "AD_ID";  // id
        public static String objId = "OBJ_ID";  // 对象id
        public static String objLogId = "OBJ_LOG_ID";  // 对象日志id
        public static String serviceType = "SERVICE_TYPE";  // 业务类型
        public static String adStatus = "AD_STATUS";  // 审核状态
        public static String adUserId = "AD_USER_ID";  // 审核人id
        public static String adUserName = "AD_USER_NAME";  // 审核人名称
        public static String adContent = "AD_CONTENT";  // 审核意见
        public static String adDate = "AD_DATE";  // 审核日期
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
