package com.learnyeai.course.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 站点课程关联表
 *
 * @author twang
 */
public class CrsSiteCourseRelVo extends BaseVo {

    /**
    * ID
    */
    private String id;

    /**
     * 站点
     */
    private String siteId;
    /**
     * 课程id
     */
    private String csId;
    /**
     * 别名
     */
    private String csAsName;
    /**
     * 管理状态
     */
    private String csManageStatus;
    /**
     * 发布状态
     */
    private String csPubStatus;
    /**
     * 发布时间
     */
    private Date csPubDate;
    /**
     * 推荐状态
     */
    private String csTjStatus;
    /**
     * 推荐时间
     */
    private Date csTjDate;
    /**
     * 创建站点
     */
    private String csCrtSiteId;

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
        public static String id = "id";  // ID
        public static String siteId = "siteId";  // 站点
        public static String csId = "csId";  // 课程id
        public static String csAsName = "csAsName";  // 别名
        public static String csManageStatus = "csManageStatus";  // 管理状态
        public static String csPubStatus = "csPubStatus";  // 发布状态
        public static String csPubDate = "csPubDate";  // 发布时间
        public static String csTjStatus = "csTjStatus";  // 推荐状态
        public static String csTjDate = "csTjDate";  // 推荐时间
        public static String csCrtSiteId = "csCrtSiteId";  // 创建站点

    }

}
