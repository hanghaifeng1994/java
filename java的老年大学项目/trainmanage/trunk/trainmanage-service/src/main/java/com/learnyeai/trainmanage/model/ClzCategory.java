package com.learnyeai.trainmanage.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 
 *
 * @author yl
 */
public class ClzCategory extends BaseEntity {

    /**
    * 
    */
    @Id
    @Column(name = "CAT_ID")
    private String catId;

    /**
     * 
     */
    @Column(name = "CAT_NAME")
    private String catName;
    /**
     * 
     */
    @Column(name = "CAT_LEVEL")
    private Integer catLevel;
    /**
     * 
     */
    @Column(name = "PARENT_ID")
    private String parentId;
    /**
     * 
     */
    @Column(name = "PARENT_IDS")
    private String parentIds;
    /**
     * 
     */
    @Column(name = "CREATE_BY")
    private String createBy;
    /**
     * 
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;
    /**
     * 
     */
    @Column(name = "UPDATE_BY")
    private String updateBy;
    /**
     * 
     */
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
    /**
     * 
     */
    @Column(name = "DEL_FLAG")
    private String delFlag;
    /**
     * 
     */
    @Column(name = "SITE_ID")
    private String siteId;
    /**
     * 
     */
    @Column(name = "MCHT_ID")
    private String mchtId;
    /**
     * 
     */
    @Column(name = "MCHT_SCHM_ID")
    private String mchtSchmId;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
    public Integer getCatLevel() {
        return catLevel;
    }

    public void setCatLevel(Integer catLevel) {
        this.catLevel = catLevel;
    }
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
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

        public static String TABLE_NAME = "CLZ_CATEGORY";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String catId = "CAT_ID";  // 
        public static String catName = "CAT_NAME";  // 
        public static String catLevel = "CAT_LEVEL";  // 
        public static String parentId = "PARENT_ID";  // 
        public static String parentIds = "PARENT_IDS";  // 
        public static String createBy = "CREATE_BY";  // 
        public static String createDate = "CREATE_DATE";  // 
        public static String updateBy = "UPDATE_BY";  // 
        public static String updateDate = "UPDATE_DATE";  // 
        public static String delFlag = "DEL_FLAG";  // 
        public static String siteId = "SITE_ID";  // 
        public static String mchtId = "MCHT_ID";  // 
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 

    }
}
