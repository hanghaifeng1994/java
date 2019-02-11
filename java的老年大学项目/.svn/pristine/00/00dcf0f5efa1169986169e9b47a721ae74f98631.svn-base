package com.learnyeai.testing.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.learnyeai.learnai.support.BaseEntity;
import com.learnyeai.testing.api.vo.QuestionTypeVo;

/**
 * 学员某个卷子的对应记录
 *
 * @author twang
 */
public class TestingStudentPaper extends BaseEntity {

	/**
	 * ID
	 */
	@Id
	@Column(name = "AW_ID")
	private String awId;

	/**
	 * 答卷号(考生ID+测验id+试卷Id+考试次数)
	 */
	@Column(name = "PAPER_NO")
	private String paperNo;
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Date createTime;
	/**
	 * 1考试中 3:已交卷
	 */
	@Column(name = "STATUS")
	private String status;
	/**
	 * 得分
	 */
	@Column(name = "SCORE")
	private BigDecimal score;
	/**
	 * 考生姓名
	 */
	@Column(name = "STUDENT_NAME")
	private String studentName;
	/**
	 * 考试用户id
	 */
	@Column(name = "STUDENT_USER_ID")
	private String studentUserId;
	/**
	 * 交卷时间
	 */
	@Column(name = "SUBMIT_TIME")
	private Date submitTime;
	/**
	 * 考试用时(秒)
	 */
	@Column(name = "EXAM_SECS")
	private Long examSecs;
	/**
	 * 对应组卷规则（冗余）
	 */
	@Column(name = "PAPER_RULE_ID")
	private String paperRuleId;
	/**
	 * 对应试卷
	 */
	@Column(name = "PAPER_ID")
	private String paperId;
	/**
	 * 使用哪个测验
	 */
	@Column(name = "TS_ID")
	private String tsId;
	/**
	 * 第几次测验
	 */
	@Column(name = "EXAM_NUM")
	private Integer examNum;
	/**
	 * 客观题成绩
	 */
	@Column(name = "KG_SCORE")
	private BigDecimal kgScore;
	/**
	 * 主观题成绩
	 */
	@Column(name = "ZG_SCORE")
	private BigDecimal zgScore;
	/**
	 * 测验开始时间
	 */
	@Column(name = "START_TIME")
	private Date startTime;
	/**
	 * 测验结束时间
	 */
	@Column(name = "END_TIME")
	private Date endTime;
	/**
	 * 是否有主观题
	 */
	@Column(name = "HAS_SUBJECT")
	private String hasSubject;

	/**
	 * 题型
	 */
	@Transient
	private List<QuestionTypeVo> questionCats = new ArrayList<QuestionTypeVo>();

	public String getAwId() {
		return awId;
	}

	public void setAwId(String awId) {
		this.awId = awId;
	}

	public String getPaperNo() {
		return paperNo;
	}

	public void setPaperNo(String paperNo) {
		this.paperNo = paperNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentUserId() {
		return studentUserId;
	}

	public void setStudentUserId(String studentUserId) {
		this.studentUserId = studentUserId;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public Long getExamSecs() {
		return examSecs;
	}

	public void setExamSecs(Long examSecs) {
		this.examSecs = examSecs;
	}

	public String getPaperRuleId() {
		return paperRuleId;
	}

	public void setPaperRuleId(String paperRuleId) {
		this.paperRuleId = paperRuleId;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getTsId() {
		return tsId;
	}

	public void setTsId(String tsId) {
		this.tsId = tsId;
	}

	public Integer getExamNum() {
		return examNum;
	}

	public void setExamNum(Integer examNum) {
		this.examNum = examNum;
	}

	public BigDecimal getKgScore() {
		return kgScore;
	}

	public void setKgScore(BigDecimal kgScore) {
		this.kgScore = kgScore;
	}

	public BigDecimal getZgScore() {
		return zgScore;
	}

	public void setZgScore(BigDecimal zgScore) {
		this.zgScore = zgScore;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getHasSubject() {
		return hasSubject;
	}

	public void setHasSubject(String hasSubject) {
		this.hasSubject = hasSubject;
	}

	public static class TF {

		public static String TABLE_NAME = "TESTING_STUDENT_PAPER"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String awId = "AW_ID"; // ID
		public static String paperNo = "PAPER_NO"; // 答卷号(考生ID+测验id+试卷Id+考试次数)
		public static String createTime = "CREATE_TIME"; // 创建时间
		public static String status = "STATUS"; // TIMEOUT = 1; //超时 一天未提交 超时 public static final int EXAMING = 2; //考试中
												// public static final int SUCCESS = 3; //成功提交
		public static String score = "SCORE"; // 得分
		public static String studentName = "STUDENT_NAME"; // 考生姓名
		public static String studentUserId = "STUDENT_USER_ID"; // 考试用户id
		public static String submitTime = "SUBMIT_TIME"; // 交卷时间
		public static String examSecs = "EXAM_SECS"; // 考试用时(秒)
		public static String paperRuleId = "PAPER_RULE_ID"; // 对应组卷规则（冗余）
		public static String paperId = "PAPER_ID"; // 对应试卷
		public static String tsId = "TS_ID"; // 使用哪个测验
		public static String examNum = "EXAM_NUM"; // 第几次测验
		public static String kgScore = "KG_SCORE"; // 客观题成绩
		public static String zgScore = "ZG_SCORE"; // 主观题成绩
		public static String startTime = "START_TIME"; // 测验开始时间
		public static String endTime = "END_TIME"; // 测验结束时间
		public static String hasSubject = "HAS_SUBJECT"; // 是否有主观题

	}

	public List<QuestionTypeVo> getQuestionCats() {
		return questionCats;
	}

	public void setQuestionCats(List<QuestionTypeVo> questionCats) {
		this.questionCats = questionCats;
	}
}
