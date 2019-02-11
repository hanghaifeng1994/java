package com.learnyeai.album.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 相册
 *
 * @author yl
 */
public class AbmAlbumVo extends BaseVo {

    /**
    * id
    */
    private String abmId;

    /**
     * 名称
     */
    private String abmName;
    /**
     * 封面
     */
    private String abmPhoto;
    /**
     * 权重
     */
    private Integer abmWeight;
    /**
     * 备注
     */
    private String remarks;
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
    /**
     * 状态0未提交1提交中2审核成功3审核失败
     */
    private String abmStatus;
    /**
     * 审核状态
     */
    private String auditId;
    /**
     * 推荐位置
     */
    private String posid;

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

    public static class CF {
        public static String abmId = "abmId";  // id
        public static String abmName = "abmName";  // 名称
        public static String abmPhoto = "abmPhoto";  // 封面
        public static String abmWeight = "abmWeight";  // 权重
        public static String remarks = "remarks";  // 备注
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String delFlag = "delFlag";  // 删除标记
        public static String siteId = "siteId";  // 站点
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id
        public static String abmStatus = "abmStatus";  // 状态0未提交1提交中2审核成功3审核失败
        public static String auditId = "auditId";  // 审核状态
        public static String posid = "posid";  // 推荐位置

    }

}
