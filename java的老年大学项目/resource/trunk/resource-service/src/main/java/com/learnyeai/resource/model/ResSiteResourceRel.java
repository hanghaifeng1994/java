package com.learnyeai.resource.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 站点资源关联表
 *
 * @author twang
 */
public class ResSiteResourceRel extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 站点
     */
    @Column(name = "SITE_ID")
    private String siteId;
    /**
     * 资源id
     */
    @Column(name = "RES_ID")
    private String resId;
    /**
     * 别名
     */
    @Column(name = "RES_AS_NAME")
    private String resAsName;
    /**
     * 管理状态
     */
    @Column(name = "RES_MANAGE_STATUS")
    private String resManageStatus;
    /**
     * 发布状态
     */
    @Column(name = "RES_PUB_STATUS")
    private String resPubStatus;
    /**
     * 发布时间
     */
    @Column(name = "RES_PUB_DATE")
    private Date resPubDate;
    /**
     * 创建站点
     */
    @Column(name = "RES_CRT_SITE_ID")
    private String resCrtSiteId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }
    public String getResAsName() {
        return resAsName;
    }

    public void setResAsName(String resAsName) {
        this.resAsName = resAsName;
    }
    public String getResManageStatus() {
        return resManageStatus;
    }

    public void setResManageStatus(String resManageStatus) {
        this.resManageStatus = resManageStatus;
    }
    public String getResPubStatus() {
        return resPubStatus;
    }

    public void setResPubStatus(String resPubStatus) {
        this.resPubStatus = resPubStatus;
    }
    public Date getResPubDate() {
        return resPubDate;
    }

    public void setResPubDate(Date resPubDate) {
        this.resPubDate = resPubDate;
    }
    public String getResCrtSiteId() {
        return resCrtSiteId;
    }

    public void setResCrtSiteId(String resCrtSiteId) {
        this.resCrtSiteId = resCrtSiteId;
    }

    public static class TF {

        public static String TABLE_NAME = "RES_SITE_RESOURCE_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // ID
        public static String siteId = "SITE_ID";  // 站点
        public static String resId = "RES_ID";  // 资源id
        public static String resAsName = "RES_AS_NAME";  // 别名
        public static String resManageStatus = "RES_MANAGE_STATUS";  // 管理状态
        public static String resPubStatus = "RES_PUB_STATUS";  // 发布状态
        public static String resPubDate = "RES_PUB_DATE";  // 发布时间
        public static String resCrtSiteId = "RES_CRT_SITE_ID";  // 创建站点

    }
}
