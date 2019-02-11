package com.learnyeai.testing.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 题目
 *
 * @author twang
 */
public class QuestionVo implements Serializable {
	private static final long serialVersionUID = -4876497533218656962L;

	public QuestionVo() {

	}

	public QuestionVo(String questionId, String stemContent, String answerDesc, BigDecimal queScore, Integer orderNum,
			String itemTypeId) {
		super();
		this.questionId = questionId;
		this.stemContent = stemContent;
		this.answerDesc = answerDesc;
		this.queScore = queScore;
		this.orderNum = orderNum;
		this.itemTypeId = itemTypeId;
	}

	/**
	 * 实际题目
	 */
	private String questionId;
	/**
	 * 题干内容
	 */
	private String stemContent;
	/**
	 * 答案描述
	 */
	private String answerDesc;

	/**
	 * 单题分值
	 */
	private BigDecimal queScore;
	/**
	 * 题目排序
	 */
	private Integer orderNum;
	/**
	 * 题型
	 */
	private String itemTypeId;

	private List<OptionVo> options = new ArrayList<OptionVo>();

	/**
	 * 已答选项
	 */
	private String itemIds;

	/**
	 * 是否已答题
	 */
	private String answered = "0";

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
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

	public BigDecimal getQueScore() {
		return queScore;
	}

	public void setQueScore(BigDecimal queScore) {
		this.queScore = queScore;
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

	public String getAnswered() {
		if (StringUtils.isBlank(itemIds))
			return "0";
		return "1";
	}

	public void setAnswered(String answered) {
		this.answered = answered;
	}

	public List<OptionVo> getOptions() {
		return options;
	}

	public void setOptions(List<OptionVo> options) {
		this.options = options;
	}

	public String getItemIds() {
		return itemIds;
	}

	public void setItemIds(String itemIds) {
		this.itemIds = itemIds;
	}

}
