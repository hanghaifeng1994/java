package com.learnyeai.schoolclass.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 站点-班级
 *
 * @author twang
 */
public class ClzSiteClazz extends BaseEntity {

    /**
    * 站点
    */
    @Id
    @Column(name = "SITE_ID")
    private String siteId;
    /**
    * 班级id
    */
    @Id
    @Column(name = "CZ_ID")
    private String czId;

    /**
     * 别名
     */
    @Column(name = "CZ_AS_NAME")
    private String czAsName;
    /**
     * 管理状态
     */
    @Column(name = "CZ_MANAGE_STATUS")
    private String czManageStatus;
    /**
     * 发布状态
     */
    @Column(name = "CZ_PUB_STATUS")
    private String czPubStatus;
    /**
     * 发布时间
     */
    @Column(name = "CZ_PUB_DATE")
    private Date czPubDate;
    /**
     * 创建站点
     */
    @Column(name = "CZ_CRT_SITE_ID")
    private String czCrtSiteId;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getCzId() {
        return czId;
    }

    public void setCzId(String czId) {
        this.czId = czId;
    }
    public String getCzAsName() {
        return czAsName;
    }

    public void setCzAsName(String czAsName) {
        this.czAsName = czAsName;
    }
    public String getCzManageStatus() {
        return czManageStatus;
    }

    public void setCzManageStatus(String czManageStatus) {
        this.czManageStatus = czManageStatus;
    }
    public String getCzPubStatus() {
        return czPubStatus;
    }

    public void setCzPubStatus(String czPubStatus) {
        this.czPubStatus = czPubStatus;
    }
    public Date getCzPubDate() {
        return czPubDate;
    }

    public void setCzPubDate(Date czPubDate) {
        this.czPubDate = czPubDate;
    }
    public String getCzCrtSiteId() {
        return czCrtSiteId;
    }

    public void setCzCrtSiteId(String czCrtSiteId) {
        this.czCrtSiteId = czCrtSiteId;
    }

    public static class TF {

        public static String TABLE_NAME = "CLZ_SITE_CLAZZ";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String siteId = "SITE_ID";  // 站点
        public static String czId = "CZ_ID";  // 班级id
        public static String czAsName = "CZ_AS_NAME";  // 别名
        public static String czManageStatus = "CZ_MANAGE_STATUS";  // 管理状态
        public static String czPubStatus = "CZ_PUB_STATUS";  // 发布状态
        public static String czPubDate = "CZ_PUB_DATE";  // 发布时间
        public static String czCrtSiteId = "CZ_CRT_SITE_ID";  // 创建站点

    }
}
