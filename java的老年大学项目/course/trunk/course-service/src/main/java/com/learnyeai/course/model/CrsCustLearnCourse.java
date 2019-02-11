package com.learnyeai.course.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户学习课程
 *
 * @author twang
 */
public class CrsCustLearnCourse extends BaseEntity {

	/**
	 * id
	 */
	@Id
	@Column(name = "LCS_ID")
	private String lcsId;

	/**
	 * 学习人id
	 */
	@Column(name = "STUDY_USER_ID")
	private String studyUserId;
	/**
	 * 课程id
	 */
	@Column(name = "CS_ID")
	private String csId;
	/**
	 * 0未选课、1已选课
	 */
	@Column(name = "LCS_NORMAL")
	private String lcsNormal;
	/**
	 * 当前章节id
	 */
	@Column(name = "CUR_CPT_ID")
	private String curCptId;
	/**
	 * 0未学完、1已学完
	 */
	@Column(name = "LCS_STUDY_TIME")
	private Long lcsStudyTime;
	/**
	 * 学习进度
	 */
	@Column(name = "LCS_PROCESS")
	private BigDecimal lcsProcess;
	/**
	 * 作业成绩
	 */
	@Column(name = "LCS_HOMEWORK_SCORE")
	private BigDecimal lcsHomeworkScore;
	/**
	 * 测验成绩
	 */
	@Column(name = "LCS_EXAM_SCORE")
	private BigDecimal lcsExamScore;
	/**
	 * 总成绩
	 */
	@Column(name = "LCS_SCORE")
	private BigDecimal lcsScore;
	/**
	 * 0未学完、1已学完
	 */
	@Column(name = "LCS_STUDY_FINISHED")
	private String lcsStudyFinished;
	/**
	 * 0未学完、1已学完
	 */
	@Column(name = "LCS_HOMEWORKE_FINISHED")
	private String lcsHomeworkeFinished;
	/**
	 * 0未学完、1已学完
	 */
	@Column(name = "LCS_EXAME_FINISHED")
	private String lcsExameFinished;
	/**
	 * 0未学完、1已学完
	 */
	@Column(name = "LCS_SCORE_FINISHED")
	private String lcsScoreFinished;
	/**
	 * 0未学完、1已学完
	 */
	@Column(name = "LCS_FINISHED")
	private String lcsFinished;
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

	@Transient
	private String csName;

	@Transient
	private String studyStatus;
	
	public String getLcsId() {
		return lcsId;
	}

	public void setLcsId(String lcsId) {
		this.lcsId = lcsId;
	}

	public String getStudyUserId() {
		return studyUserId;
	}

	public void setStudyUserId(String studyUserId) {
		this.studyUserId = studyUserId;
	}

	public String getCsId() {
		return csId;
	}

	public void setCsId(String csId) {
		this.csId = csId;
	}

	public String getLcsNormal() {
		return lcsNormal;
	}

	public void setLcsNormal(String lcsNormal) {
		this.lcsNormal = lcsNormal;
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

	public static class TF {

		public static String TABLE_NAME = "CRS_CUST_LEARN_COURSE"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String lcsId = "LCS_ID"; // id
		public static String studyUserId = "STUDY_USER_ID"; // 学习人id
		public static String csId = "CS_ID"; // 课程id
		public static String lcsNormal = "LCS_NORMAL"; // 0未选课、1已选课
		public static String curCptId = "CUR_CPT_ID"; // 当前章节id
		public static String lcsStudyTime = "LCS_STUDY_TIME"; // 0未学完、1已学完
		public static String lcsProcess = "LCS_PROCESS"; // 学习进度
		public static String lcsHomeworkScore = "LCS_HOMEWORK_SCORE"; // 作业成绩
		public static String lcsExamScore = "LCS_EXAM_SCORE"; // 测验成绩
		public static String lcsScore = "LCS_SCORE"; // 总成绩
		public static String lcsStudyFinished = "LCS_STUDY_FINISHED"; // 0未学完、1已学完
		public static String lcsHomeworkeFinished = "LCS_HOMEWORKE_FINISHED"; // 0未学完、1已学完
		public static String lcsExameFinished = "LCS_EXAME_FINISHED"; // 0未学完、1已学完
		public static String lcsScoreFinished = "LCS_SCORE_FINISHED"; // 0未学完、1已学完
		public static String lcsFinished = "LCS_FINISHED"; // 0未学完、1已学完
		public static String createDate = "CREATE_DATE"; // 创建时间
		public static String updateDate = "UPDATE_DATE"; // 更新时间
		public static String siteId = "SITE_ID"; // 站点
		public static String mchtId = "MCHT_ID"; // 商户id
		public static String mchtSchmId = "MCHT_SCHM_ID"; // 商户方案id

	}

	public String getCsName() {
		return csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public String getStudyStatus() {
		if(lcsProcess!=null&&lcsProcess.floatValue()>=100f) {
			return "复习";
		}else {
			return "继续学习";
		}
	}

	public void setStudyStatus(String studyStatus) {
		this.studyStatus = studyStatus;
	}
}
