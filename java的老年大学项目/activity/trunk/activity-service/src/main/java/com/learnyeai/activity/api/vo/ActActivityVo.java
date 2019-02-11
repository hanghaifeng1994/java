package com.learnyeai.activity.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 活动
 *
 * @author yl
 */
public class ActActivityVo extends BaseVo {

    /**
    * id
    */
    private String actId;

    /**
     * 活动标题
     */
    private String actTitle;
    /**
     * 简介
     */
    private String actInfo;
    /**
     * 活动内容
     */
    private String actContent;
    /**
     * 封面
     */
    private String actPhoto;
    /**
     * 活动区域id
     */
    private String actAreaId;
    /**
     * 活动类型1宣传活动、2评比类活动
     */
    private String actType;
    /**
     * 活动开始时间
     */
    private Date actStartDate;
    /**
     * 活动结束时间
     */
    private Date actEndDate;
    /**
     * 指导老师id
     */
    private String actTutorUserId;
    /**
     * 状态：0未提交、1审核中、2审核通过、3审核失败、4不需要审核
     */
    private String actStatus;
    /**
     * 发布状态
     */
    private String actPubStatus;
    /**
     * 审核id
     */
    private String actAuditId;
    /**
     * 报名人数
     */
    private Integer actSignupNum;
    /**
     * 活动图片
     */
    private String actImgs;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 站点
     */
    private String siteId;
    /**
     * 商户id
     */
    private String mchtId;
    /**
     * 商户方案id
     */
    private String mchtSchmId;

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

    public static class CF {
        public static String actId = "actId";  // id
        public static String actTitle = "actTitle";  // 活动标题
        public static String actInfo = "actInfo";  // 简介
        public static String actContent = "actContent";  // 活动内容
        public static String actPhoto = "actPhoto";  // 封面
        public static String actAreaId = "actAreaId";  // 活动区域id
        public static String actType = "actType";  // 活动类型1宣传活动、2评比类活动
        public static String actStartDate = "actStartDate";  // 活动开始时间
        public static String actEndDate = "actEndDate";  // 活动结束时间
        public static String actTutorUserId = "actTutorUserId";  // 指导老师id
        public static String actStatus = "actStatus";  // 状态：0未提交、1审核中、2审核通过、3审核失败、4不需要审核
        public static String actPubStatus = "actPubStatus";  // 发布状态
        public static String actAuditId = "actAuditId";  // 审核id
        public static String actSignupNum = "actSignupNum";  // 报名人数
        public static String actImgs = "actImgs";  // 活动图片
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String delFlag = "delFlag";  // 删除标记
        public static String siteId = "siteId";  // 站点
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id

    }

}
