package com.learnyeai.testing.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 测验对应的组卷规则表，每一个组卷规则表,都属于一个测验外键
 *
 * @author twang
 */
public class TestingPaperRuleVo extends BaseVo {

    /**
    * id
    */
    private String paperRuleId;

    /**
     * 题目选项乱序
     */
    private String optionRand;
    /**
     * 题目乱序
     */
    private String questionRand;
    /**
     * 出卷数量
     */
    private Integer queNum;
    /**
     * 总分
     */
    private BigDecimal totalScore;
    /**
     * 题库
     */
    private String qpId;
    /**
     * 版本号
     */
    private Integer version;
    /**
     * 是否当前版本号
     */
    private String isNewversion;
    /**
     * 组卷版本号
     */
    private Integer paperVersion;
    /**
     * 用于测验
     */
    private String tsId;
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
     * 创建站点id
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
     * 创建平台
     */
    private String platformId;

    public String getPaperRuleId() {
        return paperRuleId;
    }

    public void setPaperRuleId(String paperRuleId) {
        this.paperRuleId = paperRuleId;
    }
    public String getOptionRand() {
        return optionRand;
    }

    public void setOptionRand(String optionRand) {
        this.optionRand = optionRand;
    }
    public String getQuestionRand() {
        return questionRand;
    }

    public void setQuestionRand(String questionRand) {
        this.questionRand = questionRand;
    }
    public Integer getQueNum() {
        return queNum;
    }

    public void setQueNum(Integer queNum) {
        this.queNum = queNum;
    }
    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }
    public String getQpId() {
        return qpId;
    }

    public void setQpId(String qpId) {
        this.qpId = qpId;
    }
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    public String getIsNewversion() {
        return isNewversion;
    }

    public void setIsNewversion(String isNewversion) {
        this.isNewversion = isNewversion;
    }
    public Integer getPaperVersion() {
        return paperVersion;
    }

    public void setPaperVersion(Integer paperVersion) {
        this.paperVersion = paperVersion;
    }
    public String getTsId() {
        return tsId;
    }

    public void setTsId(String tsId) {
        this.tsId = tsId;
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
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public static class TF {
        public static String paperRuleId = "paperRuleId";  // id
        public static String optionRand = "optionRand";  // 题目选项乱序
        public static String questionRand = "questionRand";  // 题目乱序
        public static String queNum = "queNum";  // 出卷数量
        public static String totalScore = "totalScore";  // 总分
        public static String qpId = "qpId";  // 题库
        public static String version = "version";  // 版本号
        public static String isNewversion = "isNewversion";  // 是否当前版本号
        public static String paperVersion = "paperVersion";  // 组卷版本号
        public static String tsId = "tsId";  // 用于测验
        public static String delFlag = "delFlag";  // 删除标识
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String siteId = "siteId";  // 创建站点id
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id
        public static String platformId = "platformId";  // 创建平台

    }

}
