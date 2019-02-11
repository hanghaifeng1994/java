package com.learnyeai.testing.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 将平台下面的题库自动下发到所有平台的站点。如果创建题库是选择了主站id，那么只自动下放到本平台其他子站。
 *
 * @author twang
 */
public class TestingSitePool extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 题库id
     */
    @Column(name = "QP_ID")
    private String qpId;
    /**
     * 使用站点id
     */
    @Column(name = "SITE_ID")
    private String siteId;
    /**
     * 创建站点
     */
    @Column(name = "TS_CRT_SITE_ID")
    private String tsCrtSiteId;
    /**
     * 创建平台id
     */
    @Column(name = "TS_CRT_PLATFORM_ID")
    private String tsCrtPlatformId;
    /**
     * 本站点是否禁用 1启用 2禁用
     */
    @Column(name = "DISABLE")
    private String disable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getQpId() {
        return qpId;
    }

    public void setQpId(String qpId) {
        this.qpId = qpId;
    }
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getTsCrtSiteId() {
        return tsCrtSiteId;
    }

    public void setTsCrtSiteId(String tsCrtSiteId) {
        this.tsCrtSiteId = tsCrtSiteId;
    }
    public String getTsCrtPlatformId() {
        return tsCrtPlatformId;
    }

    public void setTsCrtPlatformId(String tsCrtPlatformId) {
        this.tsCrtPlatformId = tsCrtPlatformId;
    }
    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }

    public static class TF {

        public static String TABLE_NAME = "TESTING_SITE_POOL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // ID
        public static String qpId = "QP_ID";  // 题库id
        public static String siteId = "SITE_ID";  // 使用站点id
        public static String tsCrtSiteId = "TS_CRT_SITE_ID";  // 创建站点
        public static String tsCrtPlatformId = "TS_CRT_PLATFORM_ID";  // 创建平台id
        public static String disable = "DISABLE";  // 本站点是否禁用 1启用 2禁用

    }
}
