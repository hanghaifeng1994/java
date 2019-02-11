package com.learnyeai.course.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户学习课程
 *
 * @author twang
 */
public class CrsCustLearnCourseVo extends BaseVo {

	/**
	 * id
	 */
	private String lcsId;

	/**
	 * 学习人id
	 */
	private String studyUserId;
	/**
	 * 课程id
	 */
	private String csId;

	/**
	 * 名称
	 */
	private String csName;

	/**
	 * 0未选课、1已选课
	 */
	private String lcsNormal;
	/**
	 * 当前章节id
	 */
	private String curCptId;
	/**
	 * 0未学完、1已学完
	 */
	private Long lcsStudyTime;
	/**
	 * 学习进度
	 */
	private BigDecimal lcsProcess;
	/**
	 * 作业成绩
	 */
	private BigDecimal lcsHomeworkScore;
	/**
	 * 测验成绩
	 */
	private BigDecimal lcsExamScore;
	/**
	 * 总成绩
	 */
	private BigDecimal lcsScore;
	/**
	 * 0未学完、1已学完
	 */
	private String lcsStudyFinished;
	/**
	 * 0未学完、1已学完
	 */
	private String lcsHomeworkeFinished;
	/**
	 * 0未学完、1已学完
	 */
	private String lcsExameFinished;
	/**
	 * 0未学完、1已学完
	 */
	private String lcsScoreFinished;
	/**
	 * 0未学完、1已学完
	 */
	private String lcsFinished;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;
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
		public static String lcsId = "lcsId"; // id
		public static String studyUserId = "studyUserId"; // 学习人id
		public static String csId = "csId"; // 课程id
		public static String lcsNormal = "lcsNormal"; // 0未选课、1已选课
		public static String curCptId = "curCptId"; // 当前章节id
		public static String lcsStudyTime = "lcsStudyTime"; // 0未学完、1已学完
		public static String lcsProcess = "lcsProcess"; // 学习进度
		public static String lcsHomeworkScore = "lcsHomeworkScore"; // 作业成绩
		public static String lcsExamScore = "lcsExamScore"; // 测验成绩
		public static String lcsScore = "lcsScore"; // 总成绩
		public static String lcsStudyFinished = "lcsStudyFinished"; // 0未学完、1已学完
		public static String lcsHomeworkeFinished = "lcsHomeworkeFinished"; // 0未学完、1已学完
		public static String lcsExameFinished = "lcsExameFinished"; // 0未学完、1已学完
		public static String lcsScoreFinished = "lcsScoreFinished"; // 0未学完、1已学完
		public static String lcsFinished = "lcsFinished"; // 0未学完、1已学完
		public static String createDate = "createDate"; // 创建时间
		public static String updateDate = "updateDate"; // 更新时间
		public static String siteId = "siteId"; // 站点
		public static String mchtId = "mchtId"; // 商户id
		public static String mchtSchmId = "mchtSchmId"; // 商户方案id

	}

	public String getCsName() {
		return csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

}
