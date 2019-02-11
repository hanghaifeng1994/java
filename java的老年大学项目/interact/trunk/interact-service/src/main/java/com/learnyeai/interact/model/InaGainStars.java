package com.learnyeai.interact.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 评星流水
 *
 * @author yl
 */
public class InaGainStars extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "GS_ID")
    private String gsId;

    /**
     * 评星
     */
    @Column(name = "STAR_NUM")
    private Integer starNum;
    /**
     * 1:加、2：减
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
     * 用户
     */
    @Column(name = "CUST_ID")
    private String custId;
    /**
     * 对象id
     */
    @Column(name = "OBJ_ID")
    private String objId;
    /**
     * 业务类型
     */
    @Column(name = "SERVICE_TYPE")
    private String serviceType;
    /**
     * 对方用户id
     */
    @Column(name = "OTHER_USER_ID")
    private String otherUserId;
    /**
     * 对方用户名称
     */
    @Column(name = "OTHER_USER_NAME")
    private String otherUserName;
    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    private String createBy;
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

    public String getGsId() {
        return gsId;
    }

    public void setGsId(String gsId) {
        this.gsId = gsId;
    }
    public Integer getStarNum() {
        return starNum;
    }

    public void setStarNum(Integer starNum) {
        this.starNum = starNum;
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
    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getOtherUserId() {
        return otherUserId;
    }

    public void setOtherUserId(String otherUserId) {
        this.otherUserId = otherUserId;
    }
    public String getOtherUserName() {
        return otherUserName;
    }

    public void setOtherUserName(String otherUserName) {
        this.otherUserName = otherUserName;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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

        public static String TABLE_NAME = "INA_GAIN_STARS";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String gsId = "GS_ID";  // id
        public static String starNum = "STAR_NUM";  // 评星
        public static String incomeType = "INCOME_TYPE";  // 1:加、2：减
        public static String tag = "TAG";  // 标签
        public static String remark = "REMARK";  // 备注
        public static String custId = "CUST_ID";  // 用户
        public static String objId = "OBJ_ID";  // 对象id
        public static String serviceType = "SERVICE_TYPE";  // 业务类型
        public static String otherUserId = "OTHER_USER_ID";  // 对方用户id
        public static String otherUserName = "OTHER_USER_NAME";  // 对方用户名称
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
