package com.learnyeai.activity.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 站点-活动分类
 *
 * @author yl
 */
public class ActSiteCategoryRel extends BaseEntity {

    /**
    * 站点id
    */
    @Id
    @Column(name = "SITE_ID")
    private String siteId;

    /**
     * 活动分类id
     */
    @Column(name = "CAT_ID")
    private String catId;
    /**
     * 显示状态
     */
    @Column(name = "SHOW_STATUS")
    private String showStatus;

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

    public static class TF {

        public static String TABLE_NAME = "ACT_SITE_CATEGORY_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String siteId = "SITE_ID";  // 站点id
        public static String catId = "CAT_ID";  // 活动分类id
        public static String showStatus = "SHOW_STATUS";  // 显示状态

    }
}
