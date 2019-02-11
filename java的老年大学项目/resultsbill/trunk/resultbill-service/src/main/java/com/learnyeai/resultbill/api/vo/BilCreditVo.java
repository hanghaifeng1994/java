package com.learnyeai.resultbill.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 学分帐单
 *
 * @author yl
 */
public class BilCreditVo extends BaseVo {

    /**
    * id
    */
    private String creditId;

    /**
     * 学分
     */
    private Integer creditNum;
    /**
     * 收入类型
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

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }
    public Integer getCreditNum() {
        return creditNum;
    }

    public void setCreditNum(Integer creditNum) {
        this.creditNum = creditNum;
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
        public static String creditId = "creditId";  // id
        public static String creditNum = "creditNum";  // 学分
        public static String incomeType = "incomeType";  // 收入类型
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
