package com.learnyeai.news.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 资讯栏目
 *
 * @author yl
 */
public class NewsCategory extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "CAT_ID")
    private String catId;

    /**
     * 名称
     */
    @Column(name = "CAT_NAME")
    private String catName;
    /**
     * 封面
     */
    @Column(name = "CAT_PHOTO")
    private String catPhoto;
    /**
     * 排序
     */
    @Column(name = "CAT_SORT")
    private Integer catSort;
    /**
     * 1文章、2链接、3公共(不可以添加子栏目、内容)
     */
    @Column(name = "CAT_TYPE")
    private String catType;
    /**
     * 业务模块
     */
    @Column(name = "CAT_MODULE")
    private String catModule;
    /**
     * 链接地址
     */
    @Column(name = "CAT_HREF")
    private String catHref;
    /**
     * 跳转目标
     */
    @Column(name = "CAT_TARGET")
    private String catTarget;
    /**
     * 栏目描述
     */
    @Column(name = "CAT_DESCRIPTION")
    private String catDescription;
    /**
     * 关键字
     */
    @Column(name = "CAT_KEYWORDS")
    private String catKeywords;
    /**
     * 是否在导航中显示
     */
    @Column(name = "CAT_IN_MENU")
    private String catInMenu;
    /**
     * 是否在分类页中显示
     */
    @Column(name = "CAT_IN_LIST")
    private String catInList;
    /**
     * 是否允许评论
     */
    @Column(name = "CAT_ALLOW_COMMENT")
    private String catAllowComment;
    /**
     * 是否需要审核
     */
    @Column(name = "CAT_IS_AUDIT")
    private String catIsAudit;
    /**
     * 级别
     */
    @Column(name = "CAT_LEVEL")
    private Integer catLevel;
    /**
     * 父id
     */
    @Column(name = "PARENT_ID")
    private String parentId;
    /**
     * 所有父id
     */
    @Column(name = "PARENT_IDS")
    private String parentIds;
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
    public String getCatPhoto() {
        return catPhoto;
    }

    public void setCatPhoto(String catPhoto) {
        this.catPhoto = catPhoto;
    }
    public Integer getCatSort() {
        return catSort;
    }

    public void setCatSort(Integer catSort) {
        this.catSort = catSort;
    }
    public String getCatType() {
        return catType;
    }

    public void setCatType(String catType) {
        this.catType = catType;
    }
    public String getCatModule() {
        return catModule;
    }

    public void setCatModule(String catModule) {
        this.catModule = catModule;
    }
    public String getCatHref() {
        return catHref;
    }

    public void setCatHref(String catHref) {
        this.catHref = catHref;
    }
    public String getCatTarget() {
        return catTarget;
    }

    public void setCatTarget(String catTarget) {
        this.catTarget = catTarget;
    }
    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }
    public String getCatKeywords() {
        return catKeywords;
    }

    public void setCatKeywords(String catKeywords) {
        this.catKeywords = catKeywords;
    }
    public String getCatInMenu() {
        return catInMenu;
    }

    public void setCatInMenu(String catInMenu) {
        this.catInMenu = catInMenu;
    }
    public String getCatInList() {
        return catInList;
    }

    public void setCatInList(String catInList) {
        this.catInList = catInList;
    }
    public String getCatAllowComment() {
        return catAllowComment;
    }

    public void setCatAllowComment(String catAllowComment) {
        this.catAllowComment = catAllowComment;
    }
    public String getCatIsAudit() {
        return catIsAudit;
    }

    public void setCatIsAudit(String catIsAudit) {
        this.catIsAudit = catIsAudit;
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

        public static String TABLE_NAME = "NEWS_CATEGORY";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String catId = "CAT_ID";  // id
        public static String catName = "CAT_NAME";  // 名称
        public static String catPhoto = "CAT_PHOTO";  // 封面
        public static String catSort = "CAT_SORT";  // 排序
        public static String catType = "CAT_TYPE";  // 1文章、2链接、3公共(不可以添加子栏目、内容)
        public static String catModule = "CAT_MODULE";  // 业务模块
        public static String catHref = "CAT_HREF";  // 链接地址
        public static String catTarget = "CAT_TARGET";  // 跳转目标
        public static String catDescription = "CAT_DESCRIPTION";  // 栏目描述
        public static String catKeywords = "CAT_KEYWORDS";  // 关键字
        public static String catInMenu = "CAT_IN_MENU";  // 是否在导航中显示
        public static String catInList = "CAT_IN_LIST";  // 是否在分类页中显示
        public static String catAllowComment = "CAT_ALLOW_COMMENT";  // 是否允许评论
        public static String catIsAudit = "CAT_IS_AUDIT";  // 是否需要审核
        public static String catLevel = "CAT_LEVEL";  // 级别
        public static String parentId = "PARENT_ID";  // 父id
        public static String parentIds = "PARENT_IDS";  // 所有父id
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
