package com.learnyeai.resultbill.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 积分帐单
 *
 * @author yl
 */
public class BilPoints extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "PNT_ID")
    private String pntId;

    /**
     * 积分数
     */
    @Column(name = "POINTS_NUM")
    private Integer pointsNum;
    /**
     * 1 加、2 减
     */
    @Column(name = "INCOME_TYPE")
    private String incomeType;
    /**
     * 标签
     */
    @Column(name = "TAG")
    private String tag;
    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;
    /**
     * 用户id
     */
    @Column(name = "CUST_ID")
    private String custId;
    /**
     * 业务类型
     */
    @Column(name = "SERVICE_TYPE")
    private String serviceType;
    /**
     * 对象id
     */
    @Column(name = "OBJ_ID")
    private String objId;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;
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

    public String getPntId() {
        return pntId;
    }

    public void setPntId(String pntId) {
        this.pntId = pntId;
    }
    public Integer getPointsNum() {
        return pointsNum;
    }

    public void setPointsNum(Integer pointsNum) {
        this.pointsNum = pointsNum;
    }
    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

        public static String TABLE_NAME = "BIL_POINTS";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String pntId = "PNT_ID";  // id
        public static String pointsNum = "POINTS_NUM";  // 积分数
        public static String incomeType = "INCOME_TYPE";  // 1 加、2 减
        public static String tag = "TAG";  // 标签
        public static String remark = "REMARK";  // 备注
        public static String custId = "CUST_ID";  // 用户id
        public static String serviceType = "SERVICE_TYPE";  // 业务类型
        public static String objId = "OBJ_ID";  // 对象id
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
