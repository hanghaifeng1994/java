package com.learnyeai.course.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.util.Date;
import java.util.List;

/**
 * 站点课程关联表
 *
 * @author twang
 */
public class CrsSiteCourseRel extends BaseEntity {

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
     * 课程id
     */
    @Column(name = "CS_ID")
    private String csId;
    /**
     * 别名
     */
    @Column(name = "CS_AS_NAME")
    private String csAsName;
    /**
     * 管理状态
     */
    @Column(name = "CS_MANAGE_STATUS")
    private String csManageStatus;
    /**
     * 发布状态
     */
    @Column(name = "CS_PUB_STATUS")
    private String csPubStatus;
    /**
     * 发布时间
     */
    @Column(name = "CS_PUB_DATE")
    private Date csPubDate;
    /**
     * 推荐状态
     */
    @Column(name = "CS_TJ_STATUS")
    private String csTjStatus;
    /**
     * 推荐时间
     */
    @Column(name = "CS_TJ_DATE")
    private Date csTjDate;
    /**
     * 创建站点
     */
    @Column(name = "CS_CRT_SITE_ID")
    private String csCrtSiteId;
    
    @Transient
	private List<String> siteIds;//站点id列表

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
    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId;
    }
    public String getCsAsName() {
        return csAsName;
    }

    public void setCsAsName(String csAsName) {
        this.csAsName = csAsName;
    }
    public String getCsManageStatus() {
        return csManageStatus;
    }

    public void setCsManageStatus(String csManageStatus) {
        this.csManageStatus = csManageStatus;
    }
    public String getCsPubStatus() {
        return csPubStatus;
    }

    public void setCsPubStatus(String csPubStatus) {
        this.csPubStatus = csPubStatus;
    }
    public Date getCsPubDate() {
        return csPubDate;
    }

    public void setCsPubDate(Date csPubDate) {
        this.csPubDate = csPubDate;
    }
    public String getCsTjStatus() {
        return csTjStatus;
    }

    public void setCsTjStatus(String csTjStatus) {
        this.csTjStatus = csTjStatus;
    }
    public Date getCsTjDate() {
        return csTjDate;
    }

    public void setCsTjDate(Date csTjDate) {
        this.csTjDate = csTjDate;
    }
    public String getCsCrtSiteId() {
        return csCrtSiteId;
    }

    public void setCsCrtSiteId(String csCrtSiteId) {
        this.csCrtSiteId = csCrtSiteId;
    }

    public static class TF {

        public static String TABLE_NAME = "CRS_SITE_COURSE_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // ID
        public static String siteId = "SITE_ID";  // 站点
        public static String csId = "CS_ID";  // 课程id
        public static String csAsName = "CS_AS_NAME";  // 别名
        public static String csManageStatus = "CS_MANAGE_STATUS";  // 管理状态
        public static String csPubStatus = "CS_PUB_STATUS";  // 发布状态
        public static String csPubDate = "CS_PUB_DATE";  // 发布时间
        public static String csTjStatus = "CS_TJ_STATUS";  // 推荐状态
        public static String csTjDate = "CS_TJ_DATE";  // 推荐时间
        public static String csCrtSiteId = "CS_CRT_SITE_ID";  // 创建站点

    }

	public List<String> getSiteIds() {
		return siteIds;
	}

	public void setSiteIds(List<String> siteIds) {
		this.siteIds = siteIds;
	}
}
