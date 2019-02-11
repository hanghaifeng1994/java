package com.learnyeai.testing.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.learnyeai.learnai.support.BaseEntity;

/**
 * 试卷使用的题目关系
 *
 * @author twang
 */
public class TestingPaperQuestion extends BaseEntity {

	/**
	 * ID
	 */
	@Id
	@Column(name = "PQ_ID")
	private String pqId;

	/**
	 * 对应试卷
	 */
	@Column(name = "PAPER_ID")
	private String paperId;
	/**
	 * 实际题目
	 */
	@Column(name = "QUESTION_ID")
	private String questionId;
	/**
	 * 单题分值
	 */
	@Column(name = "QUE_SCORE")
	private BigDecimal queScore;
	/**
	 * 属于哪个题型出题规则记录（冗余）
	 */
	@Column(name = "QUESTIONITEM_RULE_ID")
	private String questionitemRuleId;
	/**
	 * 属于哪个知识点出题规则（冗余）
	 */
	@Column(name = "POINT_COVER_SET_ID")
	private String pointCoverSetId;
	/**
	 * 题目排序
	 */
	@Column(name = "ORDER_NUM")
	private Integer orderNum;
	/**
	 * 题型
	 */
	@Column(name = "ITEM_TYPE_ID")
	private String itemTypeId;

	/**
	 * 题目
	 */
	@Transient
	private String stemContent;
	/**
	 * 答案描述
	 */
	@Transient
	private String answerDesc;
	@Transient
	private List<TestingQuestionOption> options = new ArrayList<TestingQuestionOption>();

	public String getPqId() {
		return pqId;
	}

	public void setPqId(String pqId) {
		this.pqId = pqId;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public BigDecimal getQueScore() {
		return queScore;
	}

	public void setQueScore(BigDecimal queScore) {
		this.queScore = queScore;
	}

	public String getQuestionitemRuleId() {
		return questionitemRuleId;
	}

	public void setQuestionitemRuleId(String questionitemRuleId) {
		this.questionitemRuleId = questionitemRuleId;
	}

	public String getPointCoverSetId() {
		return pointCoverSetId;
	}

	public void setPointCoverSetId(String pointCoverSetId) {
		this.pointCoverSetId = pointCoverSetId;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(String itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public static class TF {

		public static String TABLE_NAME = "TESTING_PAPER_QUESTION"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String pqId = "PQ_ID"; // ID
		public static String paperId = "PAPER_ID"; // 对应试卷
		public static String questionId = "QUESTION_ID"; // 实际题目
		public static String queScore = "QUE_SCORE"; // 单题分值
		public static String questionitemRuleId = "QUESTIONITEM_RULE_ID"; // 属于哪个题型出题规则记录（冗余）
		public static String pointCoverSetId = "POINT_COVER_SET_ID"; // 属于哪个知识点出题规则（冗余）
		public static String orderNum = "ORDER_NUM"; // 题目排序
		public static String itemTypeId = "ITEM_TYPE_ID"; // 题型

	}

	public List<TestingQuestionOption> getOptions() {
		return options;
	}

	public void setOptions(List<TestingQuestionOption> options) {
		this.options = options;
	}

	public String getStemContent() {
		return stemContent;
	}

	public void setStemContent(String stemContent) {
		this.stemContent = stemContent;
	}

	public String getAnswerDesc() {
		return answerDesc;
	}

	public void setAnswerDesc(String answerDesc) {
		this.answerDesc = answerDesc;
	}
}
