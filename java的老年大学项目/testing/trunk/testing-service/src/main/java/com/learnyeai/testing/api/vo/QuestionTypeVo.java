package com.learnyeai.testing.api.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 题型
 *
 * @author twang
 */
public class QuestionTypeVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6469884633735296998L;

	public QuestionTypeVo() {

	}

	public QuestionTypeVo(String itemTypeId, String itemType, String name, Integer orderNum, Integer queNum) {
		super();
		this.itemTypeId = itemTypeId;
		this.itemType = itemType;
		this.name = name;
		this.orderNum = orderNum;
		this.queNum = queNum;
	}

	/**
	 * 题型ID
	 */
	private String itemTypeId;

	private String itemType;

	/**
	 * 题型名称
	 */
	private String name;

	/**
	 * 题型排序
	 */
	private Integer orderNum;
	/**
	 * 出题数量
	 */
	private Integer queNum;

	private List<QuestionVo> questions = new ArrayList<QuestionVo>();

	public String getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(String itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<QuestionVo> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionVo> questions) {
		this.questions = questions;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

}
