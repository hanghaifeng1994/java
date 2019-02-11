package com.learnyeai.cert.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 站点-证书
 *
 * @author twang
 */
public class CtSiteCertRel extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 站点
     */
    @Column(name = "SITE_ID")
    private String siteId;
    /**
     * 证书id
     */
    @Column(name = "CT_ID")
    private String ctId;
    /**
     * 创建站点
     */
    @Column(name = "CT_CRT_SITE_ID")
    private String ctCrtSiteId;

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
    public String getCtId() {
        return ctId;
    }

    public void setCtId(String ctId) {
        this.ctId = ctId;
    }
    public String getCtCrtSiteId() {
        return ctCrtSiteId;
    }

    public void setCtCrtSiteId(String ctCrtSiteId) {
        this.ctCrtSiteId = ctCrtSiteId;
    }

    public static class TF {

        public static String TABLE_NAME = "CT_SITE_CERT_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // ID
        public static String siteId = "SITE_ID";  // 站点
        public static String ctId = "CT_ID";  // 证书id
        public static String ctCrtSiteId = "CT_CRT_SITE_ID";  // 创建站点

    }
}
