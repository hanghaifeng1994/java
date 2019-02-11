package com.learnyeai.news.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 站点-栏目
 *
 * @author yl
 */
public class NewsSiteCategoryRel extends BaseEntity {

    /**
    * 站点id
    */
    @Id
    @Column(name = "SITE_ID")
    private String siteId;

    /**
     * 栏目id
     */
    @Column(name = "CAT_ID")
    private String catId;
    /**
     * 0未显示、1显示
     */
    @Column(name = "SHOW_STATUS")
    private String showStatus;
    /**
     * 排序
     */
    @Column(name = "CAT_SORT")
    private Integer catSort;
    /**
     * 创建站点
     */
    @Column(name = "CAT_CRT_SITE")
    private String catCrtSite;

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
    public Integer getCatSort() {
        return catSort;
    }

    public void setCatSort(Integer catSort) {
        this.catSort = catSort;
    }
    public String getCatCrtSite() {
        return catCrtSite;
    }

    public void setCatCrtSite(String catCrtSite) {
        this.catCrtSite = catCrtSite;
    }

    public static class TF {

        public static String TABLE_NAME = "NEWS_SITE_CATEGORY_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String siteId = "SITE_ID";  // 站点id
        public static String catId = "CAT_ID";  // 栏目id
        public static String showStatus = "SHOW_STATUS";  // 0未显示、1显示
        public static String catSort = "CAT_SORT";  // 排序
        public static String catCrtSite = "CAT_CRT_SITE";  // 创建站点

    }
}
