package com.learnyeai.homework.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.learnyeai.learnai.support.BaseEntity;

/**
 * 作业批阅记录
 *
 * @author twang
 */
public class WkHomeworkMarkHistory extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "MH_ID")
    private String mhId;

    /**
     * 用户作业id
     */
    @Column(name = "UH_ID")
    private String uhId;
    /**
     * 评星
     */
    @Column(name = "UH_STAR_NUM")
    private Double uhStarNum;
    /**
     * 得分
     */
    @Column(name = "UH_SCORE")
    private Double uhScore;
    /**
     * 0未评分、1已评分
     */
    @Column(name = "UH_SCORE_STATUS")
    private String uhScoreStatus;
    /**
     * 评分时间
     */
    @Column(name = "UH_SCORE_DATE")
    private Date uhScoreDate;
    /**
     * 评分人id
     */
    @Column(name = "UH_SCORE_USER_ID")
    private String uhScoreUserId;
    /**
     * 评分内容
     */
    @Column(name = "UH_SCORE_CONTENT")
    private String uhScoreContent;

    public String getMhId() {
        return mhId;
    }

    public void setMhId(String mhId) {
        this.mhId = mhId;
    }
    public String getUhId() {
        return uhId;
    }

    public void setUhId(String uhId) {
        this.uhId = uhId;
    }
    public Double getUhStarNum() {
        return uhStarNum;
    }

    public void setUhStarNum(Double uhStarNum) {
        this.uhStarNum = uhStarNum;
    }
    public Double getUhScore() {
        return uhScore;
    }

    public void setUhScore(Double uhScore) {
        this.uhScore = uhScore;
    }
    public String getUhScoreStatus() {
        return uhScoreStatus;
    }

    public void setUhScoreStatus(String uhScoreStatus) {
        this.uhScoreStatus = uhScoreStatus;
    }
    public Date getUhScoreDate() {
        return uhScoreDate;
    }

    public void setUhScoreDate(Date uhScoreDate) {
        this.uhScoreDate = uhScoreDate;
    }
    public String getUhScoreUserId() {
        return uhScoreUserId;
    }

    public void setUhScoreUserId(String uhScoreUserId) {
        this.uhScoreUserId = uhScoreUserId;
    }
    public String getUhScoreContent() {
        return uhScoreContent;
    }

    public void setUhScoreContent(String uhScoreContent) {
        this.uhScoreContent = uhScoreContent;
    }

    public static class TF {

        public static String TABLE_NAME = "WK_HOMEWORK_MARK_HISTORY";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String mhId = "MH_ID";  // id
        public static String uhId = "UH_ID";  // 用户作业id
        public static String uhStarNum = "UH_STAR_NUM";  // 评星
        public static String uhScore = "UH_SCORE";  // 得分
        public static String uhScoreStatus = "UH_SCORE_STATUS";  // 0未评分、1已评分
        public static String uhScoreDate = "UH_SCORE_DATE";  // 评分时间
        public static String uhScoreUserId = "UH_SCORE_USER_ID";  // 评分人id
        public static String uhScoreContent = "UH_SCORE_CONTENT";  // 评分内容

    }
}
