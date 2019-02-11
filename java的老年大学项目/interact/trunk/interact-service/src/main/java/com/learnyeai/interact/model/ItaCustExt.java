package com.learnyeai.interact.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 用户扩展
 *
 * @author yl
 */
public class ItaCustExt extends BaseEntity {

    /**
    * 客户id
    */
    @Id
    @Column(name = "CUST_ID")
    private String custId;

    /**
     * 我评论数
     */
    @Column(name = "COMMENT_NUM")
    private Integer commentNum;
    /**
     * 我收到的点赞数
     */
    @Column(name = "LIKED_NUM")
    private Integer likedNum;
    /**
     * 我的收藏数
     */
    @Column(name = "COLLECTION_NUM")
    private Integer collectionNum;
    /**
     * 我得到的星总数
     */
    @Column(name = "STAR_NUM")
    private Integer starNum;
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

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }
    public Integer getLikedNum() {
        return likedNum;
    }

    public void setLikedNum(Integer likedNum) {
        this.likedNum = likedNum;
    }
    public Integer getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(Integer collectionNum) {
        this.collectionNum = collectionNum;
    }
    public Integer getStarNum() {
        return starNum;
    }

    public void setStarNum(Integer starNum) {
        this.starNum = starNum;
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

        public static String TABLE_NAME = "ITA_CUST_EXT";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String custId = "CUST_ID";  // 客户id
        public static String commentNum = "COMMENT_NUM";  // 我评论数
        public static String likedNum = "LIKED_NUM";  // 我收到的点赞数
        public static String collectionNum = "COLLECTION_NUM";  // 我的收藏数
        public static String starNum = "STAR_NUM";  // 我得到的星总数
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
