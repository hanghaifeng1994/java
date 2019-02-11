package com.learnyeai.album.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * 相册
 *
 * @author yl
 */
public class AbmAlbum extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "ABM_ID")
    private String abmId;

    /**
     * 名称
     */
    @Column(name = "ABM_NAME")
    private String abmName;
    /**
     * 封面
     */
    @Column(name = "ABM_PHOTO")
    private String abmPhoto;
    /**
     * 权重
     */
    @Column(name = "ABM_WEIGHT")
    private Integer abmWeight;
    /**
     * 备注
     */
    @Column(name = "REMARKS")
    private String remarks;
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
    /**
     * 状态0未提交1提交中2审核成功3审核失败
     */
    @Column(name = "ABM_STATUS")
    private String abmStatus;
    /**
     * 审核状态
     */
    @Column(name = "AUDIT_ID")
    private String auditId;
    /**
     * 推荐位置
     */
    @Column(name = "POSID")
    private String posid;
    /**
     * 可用的站点
     */
    @Transient
    private String useSiteId;
    @Transient
    private String catId;
    @Transient
    private List<AbmPhoto> photoList;
    /**
     * 创建人名称
     */
    @Transient
    private String name;
    /**
     * 0批量推荐 1 批量取消推荐
     */
    @Transient
    private String flag;

    public String getName() {
        return name;
    }
    @Transient
    public Date startDate;
    @Transient
    public Date endDate;
    @Transient
    private String catName;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<AbmPhoto> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<AbmPhoto> photoList) {
        this.photoList = photoList;
    }

    public String getUseSiteId() {
        return useSiteId;
    }

    public void setUseSiteId(String useSiteId) {
        this.useSiteId = useSiteId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getAbmId() {
        return abmId;
    }

    public void setAbmId(String abmId) {
        this.abmId = abmId;
    }
    public String getAbmName() {
        return abmName;
    }

    public void setAbmName(String abmName) {
        this.abmName = abmName;
    }
    public String getAbmPhoto() {
        return abmPhoto;
    }

    public void setAbmPhoto(String abmPhoto) {
        this.abmPhoto = abmPhoto;
    }
    public Integer getAbmWeight() {
        return abmWeight;
    }

    public void setAbmWeight(Integer abmWeight) {
        this.abmWeight = abmWeight;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
    public String getAbmStatus() {
        return abmStatus;
    }

    public void setAbmStatus(String abmStatus) {
        this.abmStatus = abmStatus;
    }
    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
        this.auditId = auditId;
    }
    public String getPosid() {
        return posid;
    }

    public void setPosid(String posid) {
        this.posid = posid;
    }

    public static class TF {

        public static String TABLE_NAME = "ABM_ALBUM";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String abmId = "ABM_ID";  // id
        public static String abmName = "ABM_NAME";  // 名称
        public static String abmPhoto = "ABM_PHOTO";  // 封面
        public static String abmWeight = "ABM_WEIGHT";  // 权重
        public static String remarks = "REMARKS";  // 备注
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String delFlag = "DEL_FLAG";  // 删除标记
        public static String siteId = "SITE_ID";  // 站点
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id
        public static String abmStatus = "ABM_STATUS";  // 状态0未提交1提交中2审核成功3审核失败
        public static String auditId = "AUDIT_ID";  // 审核状态
        public static String posid = "POSID";  // 推荐位置

    }
}
