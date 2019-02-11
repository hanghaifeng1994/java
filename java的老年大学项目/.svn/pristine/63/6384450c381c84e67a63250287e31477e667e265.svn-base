package com.learnyeai.schoolclass.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 站点-班级分类
 *
 * @author twang
 */
public class ClzSiteCategoryRel extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 站点id
     */
    @Column(name = "SITE_ID")
    private String siteId;
    /**
     * 班级分类id
     */
    @Column(name = "CAT_ID")
    private String catId;
    /**
     * 显示状态
     */
    @Column(name = "SHOW_STATUS")
    private String showStatus;
    /**
     * 创建站点
     */
    @Column(name = "CAT_CRT_SITE_ID")
    private String catCrtSiteId;

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
    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }
    public String getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus;
    }
    public String getCatCrtSiteId() {
        return catCrtSiteId;
    }

    public void setCatCrtSiteId(String catCrtSiteId) {
        this.catCrtSiteId = catCrtSiteId;
    }

    public static class TF {

        public static String TABLE_NAME = "CLZ_SITE_CATEGORY_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // ID
        public static String siteId = "SITE_ID";  // 站点id
        public static String catId = "CAT_ID";  // 班级分类id
        public static String showStatus = "SHOW_STATUS";  // 显示状态
        public static String catCrtSiteId = "CAT_CRT_SITE_ID";  // 创建站点

    }
}
