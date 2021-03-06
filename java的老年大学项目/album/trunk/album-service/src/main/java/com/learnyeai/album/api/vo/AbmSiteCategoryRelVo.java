package com.learnyeai.album.api.vo;

import com.learnyeai.core.support.BaseVo;

/**
 * 站点-相册分类
 *
 * @author yl
 */
public class AbmSiteCategoryRelVo extends BaseVo {

    /**
    * 站点id
    */
    private String siteId;
    /**
    * 相册分类id
    */
    private String catId;

    /**
     * 显示状态
     */
    private String showStatus;
    /**
     * 排序
     */
    private Integer catSort;
    /**
     * 创建站点
     */
    private String catCrtSiteId;

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
    public String getCatCrtSiteId() {
        return catCrtSiteId;
    }

    public void setCatCrtSiteId(String catCrtSiteId) {
        this.catCrtSiteId = catCrtSiteId;
    }

    public static class CF {
        public static String siteId = "siteId";  // 站点id
        public static String catId = "catId";  // 相册分类id
        public static String showStatus = "showStatus";  // 显示状态
        public static String catSort = "catSort";  // 排序
        public static String catCrtSiteId = "catCrtSiteId";  // 创建站点

    }

}
