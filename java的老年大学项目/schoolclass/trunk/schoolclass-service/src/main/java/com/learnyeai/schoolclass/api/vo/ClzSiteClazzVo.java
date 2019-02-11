package com.learnyeai.schoolclass.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 站点-班级
 *
 * @author twang
 */
public class ClzSiteClazzVo extends BaseVo {

    /**
    * 站点
    */
    private String siteId;
    /**
    * 班级id
    */
    private String czId;

    /**
     * 别名
     */
    private String czAsName;
    /**
     * 管理状态
     */
    private String czManageStatus;
    /**
     * 发布状态
     */
    private String czPubStatus;
    /**
     * 发布时间
     */
    private Date czPubDate;
    /**
     * 创建站点
     */
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
        public static String siteId = "siteId";  // 站点
        public static String czId = "czId";  // 班级id
        public static String czAsName = "czAsName";  // 别名
        public static String czManageStatus = "czManageStatus";  // 管理状态
        public static String czPubStatus = "czPubStatus";  // 发布状态
        public static String czPubDate = "czPubDate";  // 发布时间
        public static String czCrtSiteId = "czCrtSiteId";  // 创建站点

    }

}
