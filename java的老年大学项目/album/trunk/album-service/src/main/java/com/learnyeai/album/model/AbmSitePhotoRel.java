package com.learnyeai.album.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 站点-相册
 *
 * @author yl
 */
public class AbmSitePhotoRel extends BaseEntity {

    /**
    * 站点id
    */
    @Id
    @Column(name = "SITE_ID")
    private String siteId;
    /**
    * 相册id
    */
    @Id
    @Column(name = "ABM_ID")
    private String abmId;

    /**
     * 别名
     */
    @Column(name = "ABM_AS_NAME")
    private String abmAsName;
    /**
     * 管理状态
     */
    @Column(name = "ABM_MANAGE_STATUS")
    private String abmManageStatus;
    /**
     * 发布状态
     */
    @Column(name = "ABM_PUB_STATUS")
    private String abmPubStatus;
    /**
     * 发布时间
     */
    @Column(name = "ABM_PUB_DATE")
    private Date abmPubDate;
    /**
     * 权重
     */
    @Column(name = "ABM_WEIGHT")
    private Integer abmWeight;
    /**
     * 创建站点
     */
    @Column(name = "ABM_CRT_SITE_ID")
    private String abmCrtSiteId;

    @Transient
    private String catId;

    @Transient
    private String[] catIds;

    @Transient
    private String[] siteIds;

    public String[] getSiteIds() {
        return siteIds;
    }

    public void setSiteIds(String[] siteIds) {
        this.siteIds = siteIds;
    }

    public String[] getCatIds() {
        return catIds;
    }

    public void setCatIds(String[] catIds) {
        this.catIds = catIds;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getAbmId() {
        return abmId;
    }

    public void setAbmId(String abmId) {
        this.abmId = abmId;
    }
    public String getAbmAsName() {
        return abmAsName;
    }

    public void setAbmAsName(String abmAsName) {
        this.abmAsName = abmAsName;
    }
    public String getAbmManageStatus() {
        return abmManageStatus;
    }

    public void setAbmManageStatus(String abmManageStatus) {
        this.abmManageStatus = abmManageStatus;
    }
    public String getAbmPubStatus() {
        return abmPubStatus;
    }

    public void setAbmPubStatus(String abmPubStatus) {
        this.abmPubStatus = abmPubStatus;
    }
    public Date getAbmPubDate() {
        return abmPubDate;
    }

    public void setAbmPubDate(Date abmPubDate) {
        this.abmPubDate = abmPubDate;
    }
    public Integer getAbmWeight() {
        return abmWeight;
    }

    public void setAbmWeight(Integer abmWeight) {
        this.abmWeight = abmWeight;
    }
    public String getAbmCrtSiteId() {
        return abmCrtSiteId;
    }

    public void setAbmCrtSiteId(String abmCrtSiteId) {
        this.abmCrtSiteId = abmCrtSiteId;
    }

    public static class TF {

        public static String TABLE_NAME = "ABM_SITE_PHOTO_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String siteId = "SITE_ID";  // 站点id
        public static String abmId = "ABM_ID";  // 相册id
        public static String abmAsName = "ABM_AS_NAME";  // 别名
        public static String abmManageStatus = "ABM_MANAGE_STATUS";  // 管理状态
        public static String abmPubStatus = "ABM_PUB_STATUS";  // 发布状态
        public static String abmPubDate = "ABM_PUB_DATE";  // 发布时间
        public static String abmWeight = "ABM_WEIGHT";  // 权重
        public static String abmCrtSiteId = "ABM_CRT_SITE_ID";  // 创建站点

    }
}
