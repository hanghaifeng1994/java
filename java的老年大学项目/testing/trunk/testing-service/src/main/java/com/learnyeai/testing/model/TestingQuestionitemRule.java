package com.learnyeai.testing.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.learnyeai.learnai.support.BaseEntity;

/**
 * 组卷规则的题型出题规则
 *
 * @author twang
 */
public class TestingQuestionitemRule extends BaseEntity {

	/**
	 * id
	 */
	@Id
	@Column(name = "QUESTIONITEM_RULE_ID")
	private String questionitemRuleId;

	/**
	 * 所属组卷规则
	 */
	@Column(name = "PAPER_RULE_ID")
	private String paperRuleId;
	/**
	 * 题型
	 */
	@Column(name = "ITEM_TYPE_ID")
	private String itemTypeId;
	/**
	 * 题型排序
	 */
	@Column(name = "ORDER_NUM")
	private Integer orderNum;
	/**
	 * 出题数量
	 */
	@Column(name = "QUE_NUM")
	private Integer queNum;
	/**
	 * 单题分值
	 */
	@Column(name = "QUE_SCORE")
	private BigDecimal queScore;

	/**
     * 题型名称
     */
	@Transient
    private String name;
    /**
     * 题型code(ms/dx/pd/tk)
     */
	@Transient
    private String itemType;
    
	/**
	 * 试题
	 */
	@Transient
	private List<TestingPaperQuestion> questions = new ArrayList<TestingPaperQuestion>();

	public String getQuestionitemRuleId() {
		return questionitemRuleId;
	}

	public void setQuestionitemRuleId(String questionitemRuleId) {
		this.questionitemRuleId = questionitemRuleId;
	}

	public String getPaperRuleId() {
		return paperRuleId;
	}

	public void setPaperRuleId(String paperRuleId) {
		this.paperRuleId = paperRuleId;
	}

	public String getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(String itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getQueNum() {
		return queNum;
	}

	public void setQueNum(Integer queNum) {
		this.queNum = queNum;
	}

	public BigDecimal getQueScore() {
		return queScore;
	}

	public void setQueScore(BigDecimal queScore) {
		this.queScore = queScore;
	}

	public static class TF {

		public static String TABLE_NAME = "TESTING_QUESTIONITEM_RULE"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String questionitemRuleId = "QUESTIONITEM_RULE_ID"; // id
		public static String paperRuleId = "PAPER_RULE_ID"; // 所属组卷规则
		public static String itemTypeId = "ITEM_TYPE_ID"; // 题型
		public static String orderNum = "ORDER_NUM"; // 题型排序
		public static String queNum = "QUE_NUM"; // 出题数量
		public static String queScore = "QUE_SCORE"; // 单题分值

	}

	public List<TestingPaperQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<TestingPaperQuestion> questions) {
		this.questions = questions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
}
