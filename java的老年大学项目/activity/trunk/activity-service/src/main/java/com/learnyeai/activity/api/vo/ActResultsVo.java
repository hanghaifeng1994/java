package com.learnyeai.activity.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 活动成果
 *
 * @author yl
 */
public class ActResultsVo extends BaseVo {

    /**
    * id
    */
    private String rstId;

    /**
     * 活动id
     */
    private String actId;
    /**
     * 标题
     */
    private String rstTitle;
    /**
     * 内容
     */
    private String rstContent;
    /**
     * 封面
     */
    private String rstPhoto;
    /**
     * 附件ids
     */
    private String rstFileIds;
    /**
     * 附件名称
     */
    private String rstFileNames;
    /**
     * 提交人id
     */
    private String rstUserId;
    /**
     * 提交人名称
     */
    private String rstUserName;
    /**
     * 0未提交、1审核中、2审核通过、3审核不通过
     */
    private String rstStatus;
    /**
     * 审核id
     */
    private String rstAuditId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 商户id
     */
    private String mchtId;
    /**
     * 商户方案id
     */
    private String mchtSchmId;

    public String getRstId() {
        return rstId;
    }

    public void setRstId(String rstId) {
        this.rstId = rstId;
    }
    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }
    public String getRstTitle() {
        return rstTitle;
    }

    public void setRstTitle(String rstTitle) {
        this.rstTitle = rstTitle;
    }
    public String getRstContent() {
        return rstContent;
    }

    public void setRstContent(String rstContent) {
        this.rstContent = rstContent;
    }
    public String getRstPhoto() {
        return rstPhoto;
    }

    public void setRstPhoto(String rstPhoto) {
        this.rstPhoto = rstPhoto;
    }
    public String getRstFileIds() {
        return rstFileIds;
    }

    public void setRstFileIds(String rstFileIds) {
        this.rstFileIds = rstFileIds;
    }
    public String getRstFileNames() {
        return rstFileNames;
    }

    public void setRstFileNames(String rstFileNames) {
        this.rstFileNames = rstFileNames;
    }
    public String getRstUserId() {
        return rstUserId;
    }

    public void setRstUserId(String rstUserId) {
        this.rstUserId = rstUserId;
    }
    public String getRstUserName() {
        return rstUserName;
    }

    public void setRstUserName(String rstUserName) {
        this.rstUserName = rstUserName;
    }
    public String getRstStatus() {
        return rstStatus;
    }

    public void setRstStatus(String rstStatus) {
        this.rstStatus = rstStatus;
    }
    public String getRstAuditId() {
        return rstAuditId;
    }

    public void setRstAuditId(String rstAuditId) {
        this.rstAuditId = rstAuditId;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
        public static String rstId = "rstId";  // id
        public static String actId = "actId";  // 活动id
        public static String rstTitle = "rstTitle";  // 标题
        public static String rstContent = "rstContent";  // 内容
        public static String rstPhoto = "rstPhoto";  // 封面
        public static String rstFileIds = "rstFileIds";  // 附件ids
        public static String rstFileNames = "rstFileNames";  // 附件名称
        public static String rstUserId = "rstUserId";  // 提交人id
        public static String rstUserName = "rstUserName";  // 提交人名称
        public static String rstStatus = "rstStatus";  // 0未提交、1审核中、2审核通过、3审核不通过
        public static String rstAuditId = "rstAuditId";  // 审核id
        public static String createDate = "createDate";  // 创建时间
        public static String updateDate = "updateDate";  // 更新时间
        public static String delFlag = "delFlag";  // 删除标记
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id

    }

}
