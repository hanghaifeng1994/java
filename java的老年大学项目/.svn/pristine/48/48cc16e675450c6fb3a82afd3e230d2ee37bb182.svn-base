package com.learnyeai.studygroup.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * 站点-学习小组
 *
 * @author yl
 */
public class SgpSiteCategory extends BaseEntity {

    /**
    * 站点id
    */
    @Id
    @Column(name = "SITE_ID")
    private String siteId;
    /**
    * 学习小组分类id
    */
    @Id
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
    @Transient
    List<SgpSiteCategory> list;

    public List<SgpSiteCategory> getList() {
        return list;
    }

    public void setList(List<SgpSiteCategory> list) {
        this.list = list;
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

        public static String TABLE_NAME = "SGP_SITE_CATEGORY";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String siteId = "SITE_ID";  // 站点id
        public static String catId = "CAT_ID";  // 学习小组分类id
        public static String showStatus = "SHOW_STATUS";  // 显示状态
        public static String catCrtSiteId = "CAT_CRT_SITE_ID";  // 创建站点

    }
}
