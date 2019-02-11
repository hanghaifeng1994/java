package com.learnyeai.homework.api.vo;

import java.util.Date;

import com.learnyeai.core.support.BaseVo;

/**
 * 作业反馈
 *
 * @author twang
 */
public class WkUserHomeworkVo extends BaseVo {

    /**
    * id
    */
    private String uhId;

    /**
     * 作业id
     */
    private String hwId;
    /**
     * 内容
     */
    private String uhContent;
    /**
     * 0未提交、1已提交
     */
    private String uhStatus;
    /**
     * 交作业时间
     */
    private Date uhSubmitDate;
    /**
     * 交作业人id
     */
    private String custId;
    /**
     * 交作业人名称
     */
    private String custName;
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
     * 创建时间
     */
    private Date createDate;
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
     * 评分内容
     */
    private String uhScoreContent;

    public String getUhId() {
        return uhId;
    }

    public void setUhId(String uhId) {
        this.uhId = uhId;
    }
    public String getHwId() {
        return hwId;
    }

    public void setHwId(String hwId) {
        this.hwId = hwId;
    }
    public String getUhContent() {
        return uhContent;
    }

    public void setUhContent(String uhContent) {
        this.uhContent = uhContent;
    }
    public String getUhStatus() {
        return uhStatus;
    }

    public void setUhStatus(String uhStatus) {
        this.uhStatus = uhStatus;
    }
    public Date getUhSubmitDate() {
        return uhSubmitDate;
    }

    public void setUhSubmitDate(Date uhSubmitDate) {
        this.uhSubmitDate = uhSubmitDate;
    }
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
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
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
    public String getUhScoreContent() {
        return uhScoreContent;
    }

    public void setUhScoreContent(String uhScoreContent) {
        this.uhScoreContent = uhScoreContent;
    }

    public static class TF {
        public static String uhId = "uhId";  // id
        public static String hwId = "hwId";  // 作业id
        public static String uhContent = "uhContent";  // 内容
        public static String uhStatus = "uhStatus";  // 0未提交、1已提交
        public static String uhSubmitDate = "uhSubmitDate";  // 交作业时间
        public static String custId = "custId";  // 交作业人id
        public static String custName = "custName";  // 交作业人名称
        public static String uhStarNum = "uhStarNum";  // 评星
        public static String uhScore = "uhScore";  // 得分
        public static String uhScoreStatus = "uhScoreStatus";  // 0未评分、1已评分
        public static String uhScoreDate = "uhScoreDate";  // 评分时间
        public static String uhScoreUserId = "uhScoreUserId";  // 评分人id
        public static String createDate = "createDate";  // 创建时间
        public static String siteId = "siteId";  // 站点
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id
        public static String uhScoreContent = "uhScoreContent";  // 评分内容

    }

}
