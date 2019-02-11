package com.learnyeai.schoolclass.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 班级报名批次
 *
 * @author twang
 */
public class ClzClazzBatchVo extends BaseVo {

    /**
    * id
    */
    private String batchId;

    /**
     * 班级id
     */
    private String czId;
    /**
     * 批次名称
     */
    private String batchName;
    /**
     * 0:个人报名 1:后台集体报名 2:前台集体报名
     */
    private Integer batchType;
    /**
     * 报名人
     */
    private String custId;
    /**
     * 报名时间
     */
    private Date singupDate;
    /**
     * 订单id
     */
    private String orderformId;
    /**
     * 状态 0:非正式 1:正式
     */
    private String normal;

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

    public static class TF {
        public static String batchId = "batchId";  // id
        public static String czId = "czId";  // 班级id
        public static String batchName = "batchName";  // 批次名称
        public static String batchType = "batchType";  // 0:个人报名 1:后台集体报名 2:前台集体报名
        public static String custId = "custId";  // 报名人
        public static String singupDate = "singupDate";  // 报名时间
        public static String orderformId = "orderformId";  // 订单id
        public static String normal = "normal";  // 状态 0:非正式 1:正式
        public static String delFlag = "delFlag";  // 删除标记

    }

}
