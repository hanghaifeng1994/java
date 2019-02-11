package com.learnyeai.base.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 用户管理站点
 *
 * @author zhangpz
 */
public class CustMngSite extends BaseEntity {

    /**
    * 用户id
    */
    @Id
    @Column(name = "CUST_ID")
    private String custId;
    /**
    * 站点id
    */
    @Id
    @Column(name = "SITE_ID")
    private String siteId;


    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public static class TF {

        public static String TABLE_NAME = "CUST_MNG_SITE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String custId = "CUST_ID";  // 用户id
        public static String siteId = "SITE_ID";  // 站点id

    }
}
