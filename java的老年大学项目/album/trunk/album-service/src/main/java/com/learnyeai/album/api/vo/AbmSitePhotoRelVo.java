package com.learnyeai.album.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 站点-相册
 *
 * @author yl
 */
public class AbmSitePhotoRelVo extends BaseVo {

    /**
    * 站点id
    */
    private String siteId;
    /**
    * 相册id
    */
    private String abmId;

    /**
     * 别名
     */
    private String abmAsName;
    /**
     * 管理状态
     */
    private String abmManageStatus;
    /**
     * 发布状态
     */
    private String abmPubStatus;
    /**
     * 发布时间
     */
    private Date abmPubDate;
    /**
     * 权重
     */
    private Integer abmWeight;
    /**
     * 创建站点
     */
    private String abmCrtSiteId;

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

    public static class CF {
        public static String siteId = "siteId";  // 站点id
        public static String abmId = "abmId";  // 相册id
        public static String abmAsName = "abmAsName";  // 别名
        public static String abmManageStatus = "abmManageStatus";  // 管理状态
        public static String abmPubStatus = "abmPubStatus";  // 发布状态
        public static String abmPubDate = "abmPubDate";  // 发布时间
        public static String abmWeight = "abmWeight";  // 权重
        public static String abmCrtSiteId = "abmCrtSiteId";  // 创建站点

    }

}
