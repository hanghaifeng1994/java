package com.learnyeai.album.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 图片组
 *
 * @author yl
 */
public class AbmPhotoGroup extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "GP_ID")
    private String gpId;

    /**
     * 标题
     */
    @Column(name = "GP_TITLE")
    private String gpTitle;
    /**
     * 封面
     */
    @Column(name = "GP_PHOTO")
    private String gpPhoto;
    /**
     * 图片路径
     */
    @Column(name = "GP_IMGS")
    private String gpImgs;
    /**
     * 图片名称
     */
    @Column(name = "GP_IMG_NAMES")
    private String gpImgNames;
    /**
     * 内容
     */
    @Column(name = "GP_CONTENT")
    private String gpContent;
    /**
     * 相册id
     */
    @Column(name = "ABM_ID")
    private String abmId;
    /**
     * 客户名称
     */
    @Column(name = "GP_ADD_USERNAME")
    private String gpAddUsername;
    /**
     * 0未提交、1审核中、2审核通过、3审核失败
     */
    @Column(name = "GP_STATUS")
    private String gpStatus;
    /**
     * 审核id
     */
    @Column(name = "AUDIT_ID")
    private String auditId;
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

    public String getGpId() {
        return gpId;
    }

    public void setGpId(String gpId) {
        this.gpId = gpId;
    }
    public String getGpTitle() {
        return gpTitle;
    }

    public void setGpTitle(String gpTitle) {
        this.gpTitle = gpTitle;
    }
    public String getGpPhoto() {
        return gpPhoto;
    }

    public void setGpPhoto(String gpPhoto) {
        this.gpPhoto = gpPhoto;
    }
    public String getGpImgs() {
        return gpImgs;
    }

    public void setGpImgs(String gpImgs) {
        this.gpImgs = gpImgs;
    }
    public String getGpImgNames() {
        return gpImgNames;
    }

    public void setGpImgNames(String gpImgNames) {
        this.gpImgNames = gpImgNames;
    }
    public String getGpContent() {
        return gpContent;
    }

    public void setGpContent(String gpContent) {
        this.gpContent = gpContent;
    }
    public String getAbmId() {
        return abmId;
    }

    public void setAbmId(String abmId) {
        this.abmId = abmId;
    }
    public String getGpAddUsername() {
        return gpAddUsername;
    }

    public void setGpAddUsername(String gpAddUsername) {
        this.gpAddUsername = gpAddUsername;
    }
    public String getGpStatus() {
        return gpStatus;
    }

    public void setGpStatus(String gpStatus) {
        this.gpStatus = gpStatus;
    }
    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
        this.auditId = auditId;
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

        public static String TABLE_NAME = "ABM_PHOTO_GROUP";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String gpId = "GP_ID";  // id
        public static String gpTitle = "GP_TITLE";  // 标题
        public static String gpPhoto = "GP_PHOTO";  // 封面
        public static String gpImgs = "GP_IMGS";  // 图片路径
        public static String gpImgNames = "GP_IMG_NAMES";  // 图片名称
        public static String gpContent = "GP_CONTENT";  // 内容
        public static String abmId = "ABM_ID";  // 相册id
        public static String gpAddUsername = "GP_ADD_USERNAME";  // 客户名称
        public static String gpStatus = "GP_STATUS";  // 0未提交、1审核中、2审核通过、3审核失败
        public static String auditId = "AUDIT_ID";  // 审核id
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
