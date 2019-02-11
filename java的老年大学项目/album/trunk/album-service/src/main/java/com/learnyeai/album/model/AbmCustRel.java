package com.learnyeai.album.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 相册人员关联表
 *
 * @author yl
 */
public class AbmCustRel extends BaseEntity {

    /**
    * 客户id
    */
    @Id
    @Column(name = "CUST_ID")
    private String custId;
    /**
    * 相册id
    */
    @Id
    @Column(name = "ABM_ID")
    private String abmId;

    /**
     * 开始时间
     */
    @Column(name = "VISIT_START_DATE")
    private Date visitStartDate;
    /**
     * 结束时间
     */
    @Column(name = "VISIT_END_DATE")
    private Date visitEndDate;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getAbmId() {
        return abmId;
    }

    public void setAbmId(String abmId) {
        this.abmId = abmId;
    }
    public Date getVisitStartDate() {
        return visitStartDate;
    }

    public void setVisitStartDate(Date visitStartDate) {
        this.visitStartDate = visitStartDate;
    }
    public Date getVisitEndDate() {
        return visitEndDate;
    }

    public void setVisitEndDate(Date visitEndDate) {
        this.visitEndDate = visitEndDate;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public static class TF {

        public static String TABLE_NAME = "ABM_CUST_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String custId = "CUST_ID";  // 客户id
        public static String abmId = "ABM_ID";  // 相册id
        public static String visitStartDate = "VISIT_START_DATE";  // 开始时间
        public static String visitEndDate = "VISIT_END_DATE";  // 结束时间
        public static String createDate = "CREATE_DATE";  // 创建时间

    }
}
