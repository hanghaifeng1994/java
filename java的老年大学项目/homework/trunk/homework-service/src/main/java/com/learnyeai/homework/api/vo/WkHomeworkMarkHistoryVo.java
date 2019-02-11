package com.learnyeai.homework.api.vo;

import java.util.Date;

import com.learnyeai.core.support.BaseVo;

/**
 * 作业批阅记录
 *
 * @author twang
 */
public class WkHomeworkMarkHistoryVo extends BaseVo {

    /**
    * id
    */
    private String mhId;

    /**
     * 用户作业id
     */
    private String uhId;
    /**
     * 评星
     */
    private Double uhStarNum;
    /**
     * 得分
     */
    private Double uhScore;
    /**
     * 0未评分、1已评分
     */
    private String uhScoreStatus;
    /**
     * 评分时间
     */
    private Date uhScoreDate;
    /**
     * 评分人id
     */
    private String uhScoreUserId;
    /**
     * 评分内容
     */
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
        public static String mhId = "mhId";  // id
        public static String uhId = "uhId";  // 用户作业id
        public static String uhStarNum = "uhStarNum";  // 评星
        public static String uhScore = "uhScore";  // 得分
        public static String uhScoreStatus = "uhScoreStatus";  // 0未评分、1已评分
        public static String uhScoreDate = "uhScoreDate";  // 评分时间
        public static String uhScoreUserId = "uhScoreUserId";  // 评分人id
        public static String uhScoreContent = "uhScoreContent";  // 评分内容

    }

}
