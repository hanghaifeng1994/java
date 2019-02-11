package com.learnyeai.news.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 站点-资讯
 *
 * @author yl
 */
public class NewsNewsSiteRel extends BaseEntity {

    /**
    * 站点
    */
    @Id
    @Column(name = "SITE_ID")
    private String siteId;

    /**
     * 资讯id
     */
    @Column(name = "ART_ID")
    private String artId;
    /**
     * 别名
     */
    @Column(name = "NEWS_AS_TITLE")
    private String newsAsTitle;
    /**
     * 管理状态
     */
    @Column(name = "NEWS_MANAGE_STATUS")
    private String newsManageStatus;
    /**
     * 发布状态
     */
    @Column(name = "NEWS_PUB_STATUS")
    private String newsPubStatus;
    /**
     * 发布时间
     */
    @Column(name = "NEWS_PUB_DATE")
    private Date newsPubDate;
    /**
     * 创建站点
     */
    @Column(name = "NEWS_CRT_SITE_ID")
    private String newsCrtSiteId;
    /**
     * 商户id
     */
    @Column(name = "MCHT_ID")
    private String mchtId;
    /**
     * 商户方案id
     */
    @Column(name = "MCHT_SCHM_ID")
    private String mchtSchmId;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getArtId() {
        return artId;
    }

    public void setArtId(String artId) {
        this.artId = artId;
    }
    public String getNewsAsTitle() {
        return newsAsTitle;
    }

    public void setNewsAsTitle(String newsAsTitle) {
        this.newsAsTitle = newsAsTitle;
    }
    public String getNewsManageStatus() {
        return newsManageStatus;
    }

    public void setNewsManageStatus(String newsManageStatus) {
        this.newsManageStatus = newsManageStatus;
    }
    public String getNewsPubStatus() {
        return newsPubStatus;
    }

    public void setNewsPubStatus(String newsPubStatus) {
        this.newsPubStatus = newsPubStatus;
    }
    public Date getNewsPubDate() {
        return newsPubDate;
    }

    public void setNewsPubDate(Date newsPubDate) {
        this.newsPubDate = newsPubDate;
    }
    public String getNewsCrtSiteId() {
        return newsCrtSiteId;
    }

    public void setNewsCrtSiteId(String newsCrtSiteId) {
        this.newsCrtSiteId = newsCrtSiteId;
    }
    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }
    public String getMchtSchmId() {
        return mchtSchmId;
    }

    public void setMchtSchmId(String mchtSchmId) {
        this.mchtSchmId = mchtSchmId;
    }

    public static class TF {

        public static String TABLE_NAME = "NEWS_NEWS_SITE_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String siteId = "SITE_ID";  // 站点
        public static String artId = "ART_ID";  // 资讯id
        public static String newsAsTitle = "NEWS_AS_TITLE";  // 别名
        public static String newsManageStatus = "NEWS_MANAGE_STATUS";  // 管理状态
        public static String newsPubStatus = "NEWS_PUB_STATUS";  // 发布状态
        public static String newsPubDate = "NEWS_PUB_DATE";  // 发布时间
        public static String newsCrtSiteId = "NEWS_CRT_SITE_ID";  // 创建站点
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
