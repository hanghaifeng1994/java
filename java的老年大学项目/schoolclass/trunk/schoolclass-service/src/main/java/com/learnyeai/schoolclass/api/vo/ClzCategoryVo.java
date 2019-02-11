package com.learnyeai.schoolclass.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 班级分类
 *
 * @author twang
 */
public class ClzCategoryVo extends BaseVo {

    /**
    * id
    */
    private String catId;

    /**
     * 分类名称
     */
    private String catName;
    /**
     * 级别
     */
    private Integer catLevel;
    /**
     * 父id
     */
    private String parentId;
    /**
     * 父ids
     */
    private String parentIds;
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
     * 
     */
    private String childData;
    /**
     * 是否证书分类0否1是
     */
    private String catCerted;

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
    public String getChildData() {
        return childData;
    }

    public void setChildData(String childData) {
        this.childData = childData;
    }
    public String getCatCerted() {
        return catCerted;
    }

    public void setCatCerted(String catCerted) {
        this.catCerted = catCerted;
    }

    public static class TF {
        public static String catId = "catId";  // id
        public static String catName = "catName";  // 分类名称
        public static String catLevel = "catLevel";  // 级别
        public static String parentId = "parentId";  // 父id
        public static String parentIds = "parentIds";  // 父ids
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String delFlag = "delFlag";  // 删除标记
        public static String siteId = "siteId";  // 站点
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id
        public static String childData = "childData";  // 
        public static String catCerted = "catCerted";  // 是否证书分类0否1是

    }

}
