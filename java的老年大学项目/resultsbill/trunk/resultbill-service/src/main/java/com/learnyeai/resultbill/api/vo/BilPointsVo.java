package com.learnyeai.resultbill.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 积分帐单
 *
 * @author yl
 */
public class BilPointsVo extends BaseVo {

    /**
    * id
    */
    private String pntId;

    /**
     * 积分数
     */
    private Integer pointsNum;
    /**
     * 1 加、2 减
     */
    private String incomeType;
    /**
     * 标签
     */
    private String tag;
    /**
     * 备注
     */
    private String remark;
    /**
     * 用户id
     */
    private String custId;
    /**
     * 业务类型
     */
    private String serviceType;
    /**
     * 对象id
     */
    private String objId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 商户id
     */
    private String mchtId;
    /**
     * 商户方案id
     */
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

    public static class CF {
        public static String pntId = "pntId";  // id
        public static String pointsNum = "pointsNum";  // 积分数
        public static String incomeType = "incomeType";  // 1 加、2 减
        public static String tag = "tag";  // 标签
        public static String remark = "remark";  // 备注
        public static String custId = "custId";  // 用户id
        public static String serviceType = "serviceType";  // 业务类型
        public static String objId = "objId";  // 对象id
        public static String createDate = "createDate";  // 创建时间
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id

    }

}
