package com.learnyeai.testing.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 测验对应的组卷规则表，每一个组卷规则表,都属于一个测验外键
 *
 * @author twang
 */
public class TestingPaperRule extends BaseEntity {

    /**
    * id
    */
    @Id
    @Column(name = "PAPER_RULE_ID")
    private String paperRuleId;

    /**
     * 题目选项乱序
     */
    @Column(name = "OPTION_RAND")
    private String optionRand;
    /**
     * 题目乱序
     */
    @Column(name = "QUESTION_RAND")
    private String questionRand;
    /**
     * 出卷数量
     */
    @Column(name = "QUE_NUM")
    private Integer queNum;
    /**
     * 总分
     */
    @Column(name = "TOTAL_SCORE")
    private BigDecimal totalScore;
    /**
     * 题库
     */
    @Column(name = "QP_ID")
    private String qpId;
    /**
     * 版本号
     */
    @Column(name = "VERSION")
    private Integer version;
    /**
     * 是否当前版本号
     */
    @Column(name = "IS_NEWVERSION")
    private String isNewversion;
    /**
     * 组卷版本号
     */
    @Column(name = "PAPER_VERSION")
    private Integer paperVersion;
    /**
     * 用于测验
     */
    @Column(name = "TS_ID")
    private String tsId;
    /**
     * 删除标识
     */
    @Column(name = "DEL_FLAG")
    private String delFlag;
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
     * 创建站点id
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
     * 创建平台
     */
    @Column(name = "PLATFORM_ID")
    private String platformId;
    
    /**
     * 题库名称
     */
    @Transient
    private String qpName;

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
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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

        public static String TABLE_NAME = "TESTING_PAPER_RULE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String paperRuleId = "PAPER_RULE_ID";  // id
        public static String optionRand = "OPTION_RAND";  // 题目选项乱序
        public static String questionRand = "QUESTION_RAND";  // 题目乱序
        public static String queNum = "QUE_NUM";  // 出卷数量
        public static String totalScore = "TOTAL_SCORE";  // 总分
        public static String qpId = "QP_ID";  // 题库
        public static String version = "VERSION";  // 版本号
        public static String isNewversion = "IS_NEWVERSION";  // 是否当前版本号
        public static String paperVersion = "PAPER_VERSION";  // 组卷版本号
        public static String tsId = "TS_ID";  // 用于测验
        public static String delFlag = "DEL_FLAG";  // 删除标识
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String siteId = "SITE_ID";  // 创建站点id
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id
        public static String platformId = "PLATFORM_ID";  // 创建平台

    }

	public String getQpName() {
		return qpName;
	}

	public void setQpName(String qpName) {
		this.qpName = qpName;
	}
}
