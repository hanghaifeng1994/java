package com.learnyeai.activity.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * 活动
 *
 * @author yl
 */
public class ActActivity extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "ACT_ID")
    private String actId;

    /**
     * 活动标题
     */
    @Column(name = "ACT_TITLE")
    private String actTitle;
    /**
     * 简介
     */
    @Column(name = "ACT_INFO")
    private String actInfo;
    /**
     * 活动内容
     */
    @Column(name = "ACT_CONTENT")
    private String actContent;
    /**
     * 封面
     */
    @Column(name = "ACT_PHOTO")
    private String actPhoto;
    /**
     * 活动区域id
     */
    @Column(name = "ACT_AREA_ID")
    private String actAreaId;
    /**
     * 活动类型1宣传活动、2评比类活动
     */
    @Column(name = "ACT_TYPE")
    private String actType;
    /**
     * 活动开始时间
     */
    @Column(name = "ACT_START_DATE")
    private Date actStartDate;
    /**
     * 活动结束时间
     */
    @Column(name = "ACT_END_DATE")
    private Date actEndDate;
    /**
     * 指导老师id
     */
    @Column(name = "ACT_TUTOR_USER_ID")
    private String actTutorUserId;
    /**
     * 状态：0未提交、1审核中、2审核通过、3审核失败、4不需要审核
     */
    @Column(name = "ACT_STATUS")
    private String actStatus;
    /**
     * 发布状态
     */
    @Column(name = "ACT_PUB_STATUS")
    private String actPubStatus;
    /**
     * 审核id
     */
    @Column(name = "ACT_AUDIT_ID")
    private String actAuditId;
    /**
     * 报名人数
     */
    @Column(name = "ACT_SIGNUP_NUM")
    private Integer actSignupNum;
    /**
     * 活动图片
     */
    @Column(name = "ACT_IMGS")
    private String actImgs;
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
     * 更新人
     */
    @Column(name = "UPDATE_BY")
    private String updateBy;
    /**
     * 更新时间
     */
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
    /**
     * 删除标记
     */
    @Column(name = "DEL_FLAG")
    private String delFlag;
    /**
     * 站点
     */
    @Column(name = "SITE_ID")
    private String siteId;
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
    @Transient
    private String catId;
    @Transient
    private String catName;
    @Transient
    private String lowerSiteId;
    @Transient
    private Date startDate;
    @Transient
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getLowerSiteId() {
        return lowerSiteId;
    }

    public void setLowerSiteId(String lowerSiteId) {
        this.lowerSiteId = lowerSiteId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }
    public String getActTitle() {
        return actTitle;
    }

    public void setActTitle(String actTitle) {
        this.actTitle = actTitle;
    }
    public String getActInfo() {
        return actInfo;
    }

    public void setActInfo(String actInfo) {
        this.actInfo = actInfo;
    }
    public String getActContent() {
        return actContent;
    }

    public void setActContent(String actContent) {
        this.actContent = actContent;
    }
    public String getActPhoto() {
        return actPhoto;
    }

    public void setActPhoto(String actPhoto) {
        this.actPhoto = actPhoto;
    }
    public String getActAreaId() {
        return actAreaId;
    }

    public void setActAreaId(String actAreaId) {
        this.actAreaId = actAreaId;
    }
    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
    }
    public Date getActStartDate() {
        return actStartDate;
    }

    public void setActStartDate(Date actStartDate) {
        this.actStartDate = actStartDate;
    }
    public Date getActEndDate() {
        return actEndDate;
    }

    public void setActEndDate(Date actEndDate) {
        this.actEndDate = actEndDate;
    }
    public String getActTutorUserId() {
        return actTutorUserId;
    }

    public void setActTutorUserId(String actTutorUserId) {
        this.actTutorUserId = actTutorUserId;
    }
    public String getActStatus() {
        return actStatus;
    }

    public void setActStatus(String actStatus) {
        this.actStatus = actStatus;
    }
    public String getActPubStatus() {
        return actPubStatus;
    }

    public void setActPubStatus(String actPubStatus) {
        this.actPubStatus = actPubStatus;
    }
    public String getActAuditId() {
        return actAuditId;
    }

    public void setActAuditId(String actAuditId) {
        this.actAuditId = actAuditId;
    }
    public Integer getActSignupNum() {
        return actSignupNum;
    }

    public void setActSignupNum(Integer actSignupNum) {
        this.actSignupNum = actSignupNum;
    }
    public String getActImgs() {
        return actImgs;
    }

    public void setActImgs(String actImgs) {
        this.actImgs = actImgs;
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
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
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

        public static String TABLE_NAME = "ACT_ACTIVITY";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String actId = "ACT_ID";  // id
        public static String actTitle = "ACT_TITLE";  // 活动标题
        public static String actInfo = "ACT_INFO";  // 简介
        public static String actContent = "ACT_CONTENT";  // 活动内容
        public static String actPhoto = "ACT_PHOTO";  // 封面
        public static String actAreaId = "ACT_AREA_ID";  // 活动区域id
        public static String actType = "ACT_TYPE";  // 活动类型1宣传活动、2评比类活动
        public static String actStartDate = "ACT_START_DATE";  // 活动开始时间
        public static String actEndDate = "ACT_END_DATE";  // 活动结束时间
        public static String actTutorUserId = "ACT_TUTOR_USER_ID";  // 指导老师id
        public static String actStatus = "ACT_STATUS";  // 状态：0未提交、1审核中、2审核通过、3审核失败、4不需要审核
        public static String actPubStatus = "ACT_PUB_STATUS";  // 发布状态
        public static String actAuditId = "ACT_AUDIT_ID";  // 审核id
        public static String actSignupNum = "ACT_SIGNUP_NUM";  // 报名人数
        public static String actImgs = "ACT_IMGS";  // 活动图片
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String delFlag = "DEL_FLAG";  // 删除标记
        public static String siteId = "SITE_ID";  // 站点
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
