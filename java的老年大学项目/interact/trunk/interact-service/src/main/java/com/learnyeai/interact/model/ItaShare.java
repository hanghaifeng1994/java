package com.learnyeai.interact.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 分享记录
 *
 * @author yl
 */
public class ItaShare extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 对象id
     */
    @Column(name = "OBJ_ID")
    private String objId;
    /**
     * 业务类型
     */
    @Column(name = "SERVICE_TYPE")
    private String serviceType;
    /**
     * 标题
     */
    @Column(name = "TITLE")
    private String title;
    /**
     * 链接
     */
    @Column(name = "URL")
    private String url;
    /**
     * qq、微信、微博
     */
    @Column(name = "SHARE_MODE")
    private String shareMode;
    /**
     * 分享时间
     */
    @Column(name = "SHARE_DATE")
    private Date shareDate;
    /**
     * 分享人id
     */
    @Column(name = "CUST_ID")
    private String custId;
    /**
     * 分享人名称
     */
    @Column(name = "CUST_NAME")
    private String custName;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getShareMode() {
        return shareMode;
    }

    public void setShareMode(String shareMode) {
        this.shareMode = shareMode;
    }
    public Date getShareDate() {
        return shareDate;
    }

    public void setShareDate(Date shareDate) {
        this.shareDate = shareDate;
    }
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
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

        public static String TABLE_NAME = "ITA_SHARE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String id = "ID";  // id
        public static String objId = "OBJ_ID";  // 对象id
        public static String serviceType = "SERVICE_TYPE";  // 业务类型
        public static String title = "TITLE";  // 标题
        public static String url = "URL";  // 链接
        public static String shareMode = "SHARE_MODE";  // qq、微信、微博
        public static String shareDate = "SHARE_DATE";  // 分享时间
        public static String custId = "CUST_ID";  // 分享人id
        public static String custName = "CUST_NAME";  // 分享人名称
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
