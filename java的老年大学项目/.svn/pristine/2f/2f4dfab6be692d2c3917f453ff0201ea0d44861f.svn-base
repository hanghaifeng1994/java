package com.learnyeai.studygroup.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 站点-学习小组关联表
 *
 * @author yl
 */
public class SgpSiteStudygroupRel extends BaseEntity {

    /**
    * 站点id
    */
    @Id
    @Column(name = "SITE_ID")
    private String siteId;
    /**
    * 学习小组id
    */
    @Id
    @Column(name = "SGP_ID")
    private String sgpId;

    /**
     * 管理状态
     */
    @Column(name = "MANAGE_STATUS")
    private String manageStatus;
    /**
     * 发布状态
     */
    @Column(name = "PUB_STATUS")
    private String pubStatus;
    /**
     * 发布时间
     */
    @Column(name = "PUB_DATE")
    private Date pubDate;
    /**
     * 创建站点
     */
    @Column(name = "CRT_SITE_ID")
    private String crtSiteId;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getSgpId() {
        return sgpId;
    }

    public void setSgpId(String sgpId) {
        this.sgpId = sgpId;
    }
    public String getManageStatus() {
        return manageStatus;
    }

    public void setManageStatus(String manageStatus) {
        this.manageStatus = manageStatus;
    }
    public String getPubStatus() {
        return pubStatus;
    }

    public void setPubStatus(String pubStatus) {
        this.pubStatus = pubStatus;
    }
    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
    public String getCrtSiteId() {
        return crtSiteId;
    }

    public void setCrtSiteId(String crtSiteId) {
        this.crtSiteId = crtSiteId;
    }

    public static class TF {

        public static String TABLE_NAME = "SGP_SITE_STUDYGROUP_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String siteId = "SITE_ID";  // 站点id
        public static String sgpId = "SGP_ID";  // 学习小组id
        public static String manageStatus = "MANAGE_STATUS";  // 管理状态
        public static String pubStatus = "PUB_STATUS";  // 发布状态
        public static String pubDate = "PUB_DATE";  // 发布时间
        public static String crtSiteId = "CRT_SITE_ID";  // 创建站点

    }
}
