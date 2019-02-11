package com.learnyeai.interact.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 评论
 *
 * @author yl
 */
public class ItaComment extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "CMT_ID")
    private String cmtId;

    /**
     * 对象id
     */
    @Column(name = "OBJ_ID")
    private String objId;
    /**
     * 类型
     */
    @Column(name = "TYPE")
    private String type;
    /**
     * 内容
     */
    @Column(name = "CONTENT")
    private String content;
    /**
     * 评论时间
     */
    @Column(name = "CMT_DATE")
    private Date cmtDate;
    /**
     * 评论人名称
     */
    @Column(name = "CMT_USER_NAME")
    private String cmtUserName;
    /**
     * 评星
     */
    @Column(name = "STAR_NUM")
    private Integer starNum;
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
     * 更新时间
     */
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
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
     * 站点id
     */
    @Column(name = "SITE_ID")
    private String siteId;
    /**
     * 用户身份1专家2学员
     */
    @Column(name = "USER_AUTH")
    private String userAuth;

    @Transient
    private String  photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCmtId() {
        return cmtId;
    }

    public void setCmtId(String cmtId) {
        this.cmtId = cmtId;
    }
    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Date getCmtDate() {
        return cmtDate;
    }

    public void setCmtDate(Date cmtDate) {
        this.cmtDate = cmtDate;
    }
    public String getCmtUserName() {
        return cmtUserName;
    }

    public void setCmtUserName(String cmtUserName) {
        this.cmtUserName = cmtUserName;
    }
    public Integer getStarNum() {
        return starNum;
    }

    public void setStarNum(Integer starNum) {
        this.starNum = starNum;
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
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(String userAuth) {
        this.userAuth = userAuth;
    }

    public static class TF {

        public static String TABLE_NAME = "ITA_COMMENT";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String cmtId = "CMT_ID";  // id
        public static String objId = "OBJ_ID";  // 对象id
        public static String type = "TYPE";  // 类型
        public static String content = "CONTENT";  // 内容
        public static String cmtDate = "CMT_DATE";  // 评论时间
        public static String cmtUserName = "CMT_USER_NAME";  // 评论人名称
        public static String starNum = "STAR_NUM";  // 评星
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id
        public static String siteId = "SITE_ID";  // 站点id
        public static String userAuth = "USER_AUTH";  // 用户身份1专家2学员

    }
}
