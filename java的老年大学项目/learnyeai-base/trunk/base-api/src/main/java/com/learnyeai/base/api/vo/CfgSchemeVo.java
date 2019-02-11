package com.learnyeai.base.api.vo;

import com.learnyeai.core.support.BaseVo;

import java.util.Date;

/**
 * 行业方案
 *
 * @author zhangpz
 */
public class CfgSchemeVo extends BaseVo {

    /**
    * 行业方案id
    */
    private String schmId;

    /**
     * 行业方案名称
     */
    private String schmName;
    /**
     * 图片
     */
    private String schmPhoto;
    /**
     * 方案概要
     */
    private String schmBrief;
    /**
     * 方案描述
     */
    private String schmDesc;
    /**
     * 行业
     */
    private String schmIndustry;
    /**
     * 图片集
     */
    private String schmImgs;
    /**
     * 0未发布、1已发布
     */
    private String schmStatus;
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

    public String getSchmId() {
        return schmId;
    }

    public void setSchmId(String schmId) {
        this.schmId = schmId;
    }
    public String getSchmName() {
        return schmName;
    }

    public void setSchmName(String schmName) {
        this.schmName = schmName;
    }
    public String getSchmPhoto() {
        return schmPhoto;
    }

    public void setSchmPhoto(String schmPhoto) {
        this.schmPhoto = schmPhoto;
    }
    public String getSchmBrief() {
        return schmBrief;
    }

    public void setSchmBrief(String schmBrief) {
        this.schmBrief = schmBrief;
    }
    public String getSchmDesc() {
        return schmDesc;
    }

    public void setSchmDesc(String schmDesc) {
        this.schmDesc = schmDesc;
    }
    public String getSchmIndustry() {
        return schmIndustry;
    }

    public void setSchmIndustry(String schmIndustry) {
        this.schmIndustry = schmIndustry;
    }
    public String getSchmImgs() {
        return schmImgs;
    }

    public void setSchmImgs(String schmImgs) {
        this.schmImgs = schmImgs;
    }
    public String getSchmStatus() {
        return schmStatus;
    }

    public void setSchmStatus(String schmStatus) {
        this.schmStatus = schmStatus;
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

    public static class CF {
        public static String schmId = "schmId";  // 行业方案id
        public static String schmName = "schmName";  // 行业方案名称
        public static String schmPhoto = "schmPhoto";  // 图片
        public static String schmBrief = "schmBrief";  // 方案概要
        public static String schmDesc = "schmDesc";  // 方案描述
        public static String schmIndustry = "schmIndustry";  // 行业
        public static String schmImgs = "schmImgs";  // 图片集
        public static String schmStatus = "schmStatus";  // 0未发布、1已发布
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String delFlag = "delFlag";  // 删除标记

    }

}
