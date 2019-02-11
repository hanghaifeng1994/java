package com.learnyeai.news.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 资讯
 *
 * @author yl
 */
public class NewsArticle extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ARTICLE_ID")
    private String articleId;

    /**
     * 标题
     */
    @Column(name = "TITLE")
    private String title;
    /**
     * 链接
     */
    @Column(name = "LINK")
    private String link;
    /**
     * 标题颜色
     */
    @Column(name = "COLOR")
    private String color;
    /**
     * 封面
     */
    @Column(name = "PHOTO")
    private String photo;
    /**
     * 关键字
     */
    @Column(name = "KEYWORDS")
    private String keywords;
    /**
     * 描述、摘要
     */
    @Column(name = "DESCRIPTION")
    private String description;
    /**
     * 权重
     */
    @Column(name = "WEIGHT")
    private Integer weight;
    /**
     * 权重日期
     */
    @Column(name = "WEIGHT_DATE")
    private Date weightDate;
    /**
     * 位置标识
     */
    @Column(name = "POSID")
    private String posid;
    /**
     * 来源
     */
    @Column(name = "COPYFROM")
    private String copyfrom;
    /**
     * 作者
     */
    @Column(name = "AUTHOR")
    private String author;
    /**
     * 是否允许评论
     */
    @Column(name = "ALLOW_COMMENT")
    private String allowComment;
    /**
     * 内容
     */
    @Column(name = "CONTENT")
    private String content;
    /**
     * 相关文章
     */
    @Column(name = "RELATION")
    private String relation;
    /**
     * 附件ids
     */
    @Column(name = "FILE_IDS")
    private String fileIds;
    /**
     * 附件名称
     */
    @Column(name = "FILE_ID_NAMES")
    private String fileIdNames;
    /**
     * 状态：0未提交、1审核中、2审核通过、3审核失败
     */
    @Column(name = "STATUS")
    private String status;
    /**
     * 0未发布、1已发布
     */
    @Column(name = "PUB_STATUS")
    private String pubStatus;
    /**
     * 审核id
     */
    @Column(name = "AUDIT_ID")
    private String auditId;
    /**
     * 是否加精
     */
    @Column(name = "ARTICLE_BIT")
    private String articleBit;
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
     * 栏目id
     */
    @Transient
    private String catId;
    /**
     * 管理状态
     */
    @Transient
    private String newsManageStatus;
    @Transient
    private String[] catIds;

    public String[] getCatIds() {
        return catIds;
    }

    public void setCatIds(String[] catIds) {
        this.catIds = catIds;
    }

    public String getNewsManageStatus() {
        return newsManageStatus;
    }

    public void setNewsManageStatus(String newsManageStatus) {
        this.newsManageStatus = newsManageStatus;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public Date getWeightDate() {
        return weightDate;
    }

    public void setWeightDate(Date weightDate) {
        this.weightDate = weightDate;
    }
    public String getPosid() {
        return posid;
    }

    public void setPosid(String posid) {
        this.posid = posid;
    }
    public String getCopyfrom() {
        return copyfrom;
    }

    public void setCopyfrom(String copyfrom) {
        this.copyfrom = copyfrom;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(String allowComment) {
        this.allowComment = allowComment;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
    public String getFileIds() {
        return fileIds;
    }

    public void setFileIds(String fileIds) {
        this.fileIds = fileIds;
    }
    public String getFileIdNames() {
        return fileIdNames;
    }

    public void setFileIdNames(String fileIdNames) {
        this.fileIdNames = fileIdNames;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getPubStatus() {
        return pubStatus;
    }

    public void setPubStatus(String pubStatus) {
        this.pubStatus = pubStatus;
    }
    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
        this.auditId = auditId;
    }
    public String getArticleBit() {
        return articleBit;
    }

    public void setArticleBit(String articleBit) {
        this.articleBit = articleBit;
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

        public static String TABLE_NAME = "NEWS_ARTICLE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String articleId = "ARTICLE_ID";  // ID
        public static String title = "TITLE";  // 标题
        public static String link = "LINK";  // 链接
        public static String color = "COLOR";  // 标题颜色
        public static String photo = "PHOTO";  // 封面
        public static String keywords = "KEYWORDS";  // 关键字
        public static String description = "DESCRIPTION";  // 描述、摘要
        public static String weight = "WEIGHT";  // 权重
        public static String weightDate = "WEIGHT_DATE";  // 权重日期
        public static String posid = "POSID";  // 位置标识
        public static String copyfrom = "COPYFROM";  // 来源
        public static String author = "AUTHOR";  // 作者
        public static String allowComment = "ALLOW_COMMENT";  // 是否允许评论
        public static String content = "CONTENT";  // 内容
        public static String relation = "RELATION";  // 相关文章
        public static String fileIds = "FILE_IDS";  // 附件ids
        public static String fileIdNames = "FILE_ID_NAMES";  // 附件名称
        public static String status = "STATUS";  // 状态：0未提交、1审核中、2审核通过、3审核失败
        public static String pubStatus = "PUB_STATUS";  // 0未发布、1已发布
        public static String auditId = "AUDIT_ID";  // 审核id
        public static String articleBit = "ARTICLE_BIT";  // 是否加精
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
