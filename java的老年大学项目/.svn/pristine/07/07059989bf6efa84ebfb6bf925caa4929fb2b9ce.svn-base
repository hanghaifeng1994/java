package com.learnyeai.activity.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 站点-活动
 *
 * @author yl
 */
public class ActSiteActivityRel extends BaseEntity {

    /**
    * 站点id
    */
    @Id
    @Column(name = "SITE_ID")
    private String siteId;

    /**
     * 活动id
     */
    @Column(name = "ACT_ID")
    private String actId;
    /**
     * 活动别名
     */
    @Column(name = "ACT_AS_NAME")
    private String actAsName;
    /**
     * 管理状态0不能管理 1可管理
     */
    @Column(name = "ACT_MANAGE_STATUS")
    private String actManageStatus;
    /**
     * 发布状态
     */
    @Column(name = "ACT_PUB_STATUS")
    private String actPubStatus;
    /**
     * 发布时间
     */
    @Column(name = "ACT_PUB_DATE")
    private Date actPubDate;
    /**
     * 创建站点id
     */
    @Column(name = "ACT_CRT_SITE_ID")
    private String actCrtSiteId;

    @Transient
    private String catId;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }
    public String getActAsName() {
        return actAsName;
    }

    public void setActAsName(String actAsName) {
        this.actAsName = actAsName;
    }
    public String getActManageStatus() {
        return actManageStatus;
    }

    public void setActManageStatus(String actManageStatus) {
        this.actManageStatus = actManageStatus;
    }
    public String getActPubStatus() {
        return actPubStatus;
    }

    public void setActPubStatus(String actPubStatus) {
        this.actPubStatus = actPubStatus;
    }
    public Date getActPubDate() {
        return actPubDate;
    }

    public void setActPubDate(Date actPubDate) {
        this.actPubDate = actPubDate;
    }
    public String getActCrtSiteId() {
        return actCrtSiteId;
    }

    public void setActCrtSiteId(String actCrtSiteId) {
        this.actCrtSiteId = actCrtSiteId;
    }

    public static class TF {

        public static String TABLE_NAME = "ACT_SITE_ACTIVITY_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String siteId = "SITE_ID";  // 站点id
        public static String actId = "ACT_ID";  // 活动id
        public static String actAsName = "ACT_AS_NAME";  // 活动别名
        public static String actManageStatus = "ACT_MANAGE_STATUS";  // 管理状态0不能管理 1可管理
        public static String actPubStatus = "ACT_PUB_STATUS";  // 发布状态
        public static String actPubDate = "ACT_PUB_DATE";  // 发布时间
        public static String actCrtSiteId = "ACT_CRT_SITE_ID";  // 创建站点id

    }
}
