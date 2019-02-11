package com.learnyeai.schoolclass.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.learnyeai.learnai.support.BaseEntity;

/**
 * 学员-班级-课程
 *
 * @author twang
 */
public class ClzUserClazzCourse extends BaseEntity {
	@Transient
	public static int MUST_COURSE = 2;// 2必修课
	@Transient
	public static int SEL_COURSE = 1;// 1选修课

	/**
	 * 学生班级课程id
	 */
	@Id
	@Column(name = "UCC_ID")
	private String uccId;

	/**
	 * 学生id
	 */
	@Column(name = "CUST_ID")
	private String custId;
	/**
	 * 班级id
	 */
	@Column(name = "CZ_ID")
	private String czId;
	/**
	 * 课程id
	 */
	@Column(name = "CS_ID")
	private String csId;
	/**
	 * 状态：0报名中、1报名成功
	 */
	@Column(name = "NORMAL")
	private String normal;
	/**
	 * 1选修课、2必修课
	 */
	@Column(name = "CS_TYPE")
	private Integer csType;
	/**
	 * 学时
	 */
	@Column(name = "CS_STUDYLENGTH")
	private BigDecimal csStudylength;
	/**
	 * 金额
	 */
	@Column(name = "CS_AMOUNT")
	private BigDecimal csAmount;
	/**
	 * 是否完成
	 */
	@Column(name = "LCS_FINISHED")
	private String lcsFinished;
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_DATE")
	private Date createDate;
	/**
	 * 完成时间
	 */
	@Column(name = "FINISHED_DATE")
	private Date finishedDate;
	/**
	 * 站点
	 */
	@Column(name = "SITE_ID")
	private String siteId;

	@Transient
	private String csName;
	/**
	 * 当前章节id
	 */
	@Transient
	private String curCptId;
	/**
	 * 学习时间
	 */
	@Transient
	private Long lcsStudyTime;
	/**
	 * 学习进度
	 */
	@Transient
	private BigDecimal lcsProcess;
	/**
	 * 作业成绩
	 */
	@Transient
	private BigDecimal lcsHomeworkScore;
	/**
	 * 测验成绩
	 */
	@Transient
	private BigDecimal lcsExamScore;
	/**
	 * 总成绩
	 */
	@Transient
	private BigDecimal lcsScore;
	/**
	 * 0未学完、1已学完
	 */
	@Transient
	private String lcsStudyFinished;
	/**
	 * 0未学完、1已学完
	 */
	@Transient
	private String lcsHomeworkeFinished;
	/**
	 * 0未学完、1已学完
	 */
	@Transient
	private String lcsExameFinished;
	/**
	 * 0未学完、1已学完
	 */
	@Transient
	private String lcsScoreFinished;

	public String getUccId() {
		return uccId;
	}

	public void setUccId(String uccId) {
		this.uccId = uccId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCzId() {
		return czId;
	}

	public void setCzId(String czId) {
		this.czId = czId;
	}

	public String getCsId() {
		return csId;
	}

	public void setCsId(String csId) {
		this.csId = csId;
	}

	public String getNormal() {
		return normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}

	public Integer getCsType() {
		return csType;
	}

	public void setCsType(Integer csType) {
		this.csType = csType;
	}

	public BigDecimal getCsStudylength() {
		return csStudylength;
	}

	public void setCsStudylength(BigDecimal csStudylength) {
		this.csStudylength = csStudylength;
	}

	public BigDecimal getCsAmount() {
		return csAmount;
	}

	public void setCsAmount(BigDecimal csAmount) {
		this.csAmount = csAmount;
	}

	public String getLcsFinished() {
		return lcsFinished;
	}

	public void setLcsFinished(String lcsFinished) {
		this.lcsFinished = lcsFinished;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getFinishedDate() {
		return finishedDate;
	}

	public void setFinishedDate(Date finishedDate) {
		this.finishedDate = finishedDate;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public static class TF {

		public static String TABLE_NAME = "CLZ_USER_CLAZZ_COURSE"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String uccId = "UCC_ID"; // 学生班级课程id
		public static String custId = "CUST_ID"; // 学生id
		public static String czId = "CZ_ID"; // 班级id
		public static String csId = "CS_ID"; // 课程id
		public static String normal = "NORMAL"; // 状态：0报名中、1报名成功
		public static String csType = "CS_TYPE"; // 1选修课、2必修课
		public static String csStudylength = "CS_STUDYLENGTH"; // 学时
		public static String csAmount = "CS_AMOUNT"; // 金额
		public static String lcsFinished = "LCS_FINISHED"; // 是否完成
		public static String createDate = "CREATE_DATE"; // 创建时间
		public static String finishedDate = "FINISHED_DATE"; // 完成时间
		public static String siteId = "SITE_ID"; // 站点

	}

	public String getCsName() {
		return csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public String getCurCptId() {
		return curCptId;
	}

	public void setCurCptId(String curCptId) {
		this.curCptId = curCptId;
	}

	public Long getLcsStudyTime() {
		return lcsStudyTime;
	}

	public void setLcsStudyTime(Long lcsStudyTime) {
		this.lcsStudyTime = lcsStudyTime;
	}

	public BigDecimal getLcsProcess() {
		return lcsProcess;
	}

	public void setLcsProcess(BigDecimal lcsProcess) {
		this.lcsProcess = lcsProcess;
	}

	public BigDecimal getLcsHomeworkScore() {
		return lcsHomeworkScore;
	}

	public void setLcsHomeworkScore(BigDecimal lcsHomeworkScore) {
		this.lcsHomeworkScore = lcsHomeworkScore;
	}

	public BigDecimal getLcsExamScore() {
		return lcsExamScore;
	}

	public void setLcsExamScore(BigDecimal lcsExamScore) {
		this.lcsExamScore = lcsExamScore;
	}

	public BigDecimal getLcsScore() {
		return lcsScore;
	}

	public void setLcsScore(BigDecimal lcsScore) {
		this.lcsScore = lcsScore;
	}

	public String getLcsStudyFinished() {
		return lcsStudyFinished;
	}

	public void setLcsStudyFinished(String lcsStudyFinished) {
		this.lcsStudyFinished = lcsStudyFinished;
	}

	public String getLcsHomeworkeFinished() {
		return lcsHomeworkeFinished;
	}

	public void setLcsHomeworkeFinished(String lcsHomeworkeFinished) {
		this.lcsHomeworkeFinished = lcsHomeworkeFinished;
	}

	public String getLcsExameFinished() {
		return lcsExameFinished;
	}

	public void setLcsExameFinished(String lcsExameFinished) {
		this.lcsExameFinished = lcsExameFinished;
	}

	public String getLcsScoreFinished() {
		return lcsScoreFinished;
	}

	public void setLcsScoreFinished(String lcsScoreFinished) {
		this.lcsScoreFinished = lcsScoreFinished;
	}
}
