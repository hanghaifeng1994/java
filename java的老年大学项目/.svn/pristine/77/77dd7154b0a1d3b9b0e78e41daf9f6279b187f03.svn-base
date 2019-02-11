package com.learnyeai.interact.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * 
 *
 * @author yl
 */
public class ItaInteractionTimes extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "TM_ID")
    private String tmId;

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
     * 点赞数
     */
    @Column(name = "LK_NUM")
    private Integer lkNum;
    /**
     * 评论数
     */
    @Column(name = "CMT_NUM")
    private Integer cmtNum;
    /**
     * 评星次数
     */
    @Column(name = "MARK_TIMES")
    private Integer markTimes;
    /**
     * 评星总数
     */
    @Column(name = "STAR_NUM")
    private Integer starNum;
    /**
     * 评星平均数
     */
    @Column(name = "STAR_AVG_NUM")
    private Integer starAvgNum;
    /**
     * 收藏数
     */
    @Column(name = "FAV_NUM")
    private Integer favNum;
    /**
     * 浏览次数
     */
    @Column(name = "BROWSE_NUM")
    private Integer browseNum;
    /**
     * 浏览人数
     */
    @Column(name = "BROWSE_USER_NUM")
    private Integer browseUserNum;
    /**
     * 分享次数
     */
    @Column(name = "SHARE_NUM")
    private Integer shareNum;
    /**
     * 投票次数
     */
    @Column(name = "VOTE_NUM")
    private Integer voteNum;
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
    @Transient
    private List<ItaInteractionTimes> list;

    public List<ItaInteractionTimes> getList() {
        return list;
    }

    public void setList(List<ItaInteractionTimes> list) {
        this.list = list;
    }

    public String getTmId() {
        return tmId;
    }

    public void setTmId(String tmId) {
        this.tmId = tmId;
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
    public Integer getLkNum() {
        return lkNum;
    }

    public void setLkNum(Integer lkNum) {
        this.lkNum = lkNum;
    }
    public Integer getCmtNum() {
        return cmtNum;
    }

    public void setCmtNum(Integer cmtNum) {
        this.cmtNum = cmtNum;
    }
    public Integer getMarkTimes() {
        return markTimes;
    }

    public void setMarkTimes(Integer markTimes) {
        this.markTimes = markTimes;
    }
    public Integer getStarNum() {
        return starNum;
    }

    public void setStarNum(Integer starNum) {
        this.starNum = starNum;
    }
    public Integer getStarAvgNum() {
        return starAvgNum;
    }

    public void setStarAvgNum(Integer starAvgNum) {
        this.starAvgNum = starAvgNum;
    }
    public Integer getFavNum() {
        return favNum;
    }

    public void setFavNum(Integer favNum) {
        this.favNum = favNum;
    }
    public Integer getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }
    public Integer getBrowseUserNum() {
        return browseUserNum;
    }

    public void setBrowseUserNum(Integer browseUserNum) {
        this.browseUserNum = browseUserNum;
    }
    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }
    public Integer getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(Integer voteNum) {
        this.voteNum = voteNum;
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

        public static String TABLE_NAME = "ITA_INTERACTION_TIMES";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String tmId = "TM_ID";  // id
        public static String objId = "OBJ_ID";  // 对象id
        public static String type = "TYPE";  // 类型
        public static String lkNum = "LK_NUM";  // 点赞数
        public static String cmtNum = "CMT_NUM";  // 评论数
        public static String markTimes = "MARK_TIMES";  // 评星次数
        public static String starNum = "STAR_NUM";  // 评星总数
        public static String starAvgNum = "STAR_AVG_NUM";  // 评星平均数
        public static String favNum = "FAV_NUM";  // 收藏数
        public static String browseNum = "BROWSE_NUM";  // 浏览次数
        public static String browseUserNum = "BROWSE_USER_NUM";  // 浏览人数
        public static String shareNum = "SHARE_NUM";  // 分享次数
        public static String voteNum = "VOTE_NUM";  // 投票次数
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id

    }
}
