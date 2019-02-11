package com.learnyeai.schoolclass.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 班级报名批次
 *
 * @author twang
 */
public class ClzClazzBatch extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "BATCH_ID")
    private String batchId;

    /**
     * 班级id
     */
    @Column(name = "CZ_ID")
    private String czId;
    /**
     * 批次名称
     */
    @Column(name = "BATCH_NAME")
    private String batchName;
    /**
     * 0:个人报名 1:后台集体报名 2:前台集体报名
     */
    @Column(name = "BATCH_TYPE")
    private Integer batchType;
    /**
     * 报名人
     */
    @Column(name = "CUST_ID")
    private String custId;
    /**
     * 报名时间
     */
    @Column(name = "SINGUP_DATE")
    private Date singupDate;
    /**
     * 订单id
     */
    @Column(name = "ORDERFORM_ID")
    private String orderformId;
    /**
     * 状态 0:非正式 1:正式
     */
    @Column(name = "NORMAL")
    private String normal;
    /**
     * 删除标记
     */
    @Column(name = "DEL_FLAG")
    private String delFlag;

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }
    public String getCzId() {
        return czId;
    }

    public void setCzId(String czId) {
        this.czId = czId;
    }
    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }
    public Integer getBatchType() {
        return batchType;
    }

    public void setBatchType(Integer batchType) {
        this.batchType = batchType;
    }
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public Date getSingupDate() {
        return singupDate;
    }

    public void setSingupDate(Date singupDate) {
        this.singupDate = singupDate;
    }
    public String getOrderformId() {
        return orderformId;
    }

    public void setOrderformId(String orderformId) {
        this.orderformId = orderformId;
    }
    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public static class TF {

        public static String TABLE_NAME = "CLZ_CLAZZ_BATCH";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String batchId = "BATCH_ID";  // id
        public static String czId = "CZ_ID";  // 班级id
        public static String batchName = "BATCH_NAME";  // 批次名称
        public static String batchType = "BATCH_TYPE";  // 0:个人报名 1:后台集体报名 2:前台集体报名
        public static String custId = "CUST_ID";  // 报名人
        public static String singupDate = "SINGUP_DATE";  // 报名时间
        public static String orderformId = "ORDERFORM_ID";  // 订单id
        public static String normal = "NORMAL";  // 状态 0:非正式 1:正式
        public static String delFlag = "DEL_FLAG";  // 删除标记

    }
}
