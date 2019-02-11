package com.learnyeai.activity.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 活动作品
 *
 * @author yl
 */
public class ActActivityWorks extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "WKS_ID")
    private String wksId;

    /**
     * 活动id
     */
    @Column(name = "ACT_ID")
    private String actId;
    /**
     * 作品编号
     */
    @Column(name = "WKS_CODE")
    private String wksCode;
    /**
     * 封面
     */
    @Column(name = "WKS_PHOTO")
    private String wksPhoto;
    /**
     * audio image doc text video stream
     */
    @Column(name = "WKS_TYPE")
    private String wksType;
    /**
     * 附件ids
     */
    @Column(name = "WKS_FILE_IDS")
    private String wksFileIds;
    /**
     * 附件名称
     */
    @Column(name = "WKS_FILE_NAMES")
    private String wksFileNames;
    /**
     * 上传人id
     */
    @Column(name = "WKS_USER_ID")
    private String wksUserId;
    /**
     * 上传人名称
     */
    @Column(name = "WKS_USER_NAME")
    private String wksUserName;
    /**
     * 上传时间
     */
    @Column(name = "WKS_UPLOAD_DATE")
    private Date wksUploadDate;
    /**
     * 0未提交、1已审核中、2审核通过、3审核失败
     */
    @Column(name = "WKS_STATUS")
    private String wksStatus;
    /**
     * 审核id
     */
    @Column(name = "WKS_AUDIT_ID")
    private String wksAuditId;
    /**
     * 投票数
     */
    @Column(name = "WKS_VOTE_NUM")
    private Integer wksVoteNum;
    /**
     * 平均分
     */
    @Column(name = "WKS_AVG_SCORE")
    private Integer wksAvgScore;
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
    private String actName;

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getWksId() {
        return wksId;
    }

    public void setWksId(String wksId) {
        this.wksId = wksId;
    }
    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }
    public String getWksCode() {
        return wksCode;
    }

    public void setWksCode(String wksCode) {
        this.wksCode = wksCode;
    }
    public String getWksPhoto() {
        return wksPhoto;
    }

    public void setWksPhoto(String wksPhoto) {
        this.wksPhoto = wksPhoto;
    }
    public String getWksType() {
        return wksType;
    }

    public void setWksType(String wksType) {
        this.wksType = wksType;
    }
    public String getWksFileIds() {
        return wksFileIds;
    }

    public void setWksFileIds(String wksFileIds) {
        this.wksFileIds = wksFileIds;
    }
    public String getWksFileNames() {
        return wksFileNames;
    }

    public void setWksFileNames(String wksFileNames) {
        this.wksFileNames = wksFileNames;
    }
    public String getWksUserId() {
        return wksUserId;
    }

    public void setWksUserId(String wksUserId) {
        this.wksUserId = wksUserId;
    }
    public String getWksUserName() {
        return wksUserName;
    }

    public void setWksUserName(String wksUserName) {
        this.wksUserName = wksUserName;
    }
    public Date getWksUploadDate() {
        return wksUploadDate;
    }

    public void setWksUploadDate(Date wksUploadDate) {
        this.wksUploadDate = wksUploadDate;
    }
    public String getWksStatus() {
        return wksStatus;
    }

    public void setWksStatus(String wksStatus) {
        this.wksStatus = wksStatus;
    }
    public String getWksAuditId() {
        return wksAuditId;
    }

    public void setWksAuditId(String wksAuditId) {
        this.wksAuditId = wksAuditId;
    }
    public Integer getWksVoteNum() {
        return wksVoteNum;
    }

    public void setWksVoteNum(Integer wksVoteNum) {
        this.wksVoteNum = wksVoteNum;
    }
    public Integer getWksAvgScore() {
        return wksAvgScore;
    }

    public void setWksAvgScore(Integer wksAvgScore) {
        this.wksAvgScore = wksAvgScore;
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

        public static String TABLE_NAME = "ACT_ACTIVITY_WORKS";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String wksId = "WKS_ID";  // id
        public static String actId = "ACT_ID";  // 活动id
        public static String wksCode = "WKS_CODE";  // 作品编号
        public static String wksPhoto = "WKS_PHOTO";  // 封面
        public static String wksType = "WKS_TYPE";  // audio image doc text video stream
        public static String wksFileIds = "WKS_FILE_IDS";  // 附件ids
        public static String wksFileNames = "WKS_FILE_NAMES";  // 附件名称
        public static String wksUserId = "WKS_USER_ID";  // 上传人id
        public static String wksUserName = "WKS_USER_NAME";  // 上传人名称
        public static String wksUploadDate = "WKS_UPLOAD_DATE";  // 上传时间
        public static String wksStatus = "WKS_STATUS";  // 0未提交、1已审核中、2审核通过、3审核失败
        public static String wksAuditId = "WKS_AUDIT_ID";  // 审核id
        public static String wksVoteNum = "WKS_VOTE_NUM";  // 投票数
        public static String wksAvgScore = "WKS_AVG_SCORE";  // 平均分
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String delFlag = "DEL_FLAG";  // 删除标记
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
