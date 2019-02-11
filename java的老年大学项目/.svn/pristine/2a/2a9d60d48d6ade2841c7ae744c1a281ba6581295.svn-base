package com.learnyeai.testing.model;

import javax.persistence.Column;
import javax.persistence.Id;

import com.learnyeai.learnai.support.BaseEntity;

/**
 * 根据组卷规则的出的测验试卷
 *
 * @author twang
 */
public class TestingPaper extends BaseEntity {

	/**
	 * ID
	 */
	@Id
	@Column(name = "PAPER_ID")
	private String paperId;

	/**
	 * 所属组卷规则
	 */
	@Column(name = "PAPER_RULE_ID")
	private String paperRuleId;
	/**
	 * 是否已用
	 */
	@Column(name = "USERED")
	private String usered;
	/**
	 * 是否禁用
	 */
	@Column(name = "DISABLED")
	private String disabled;
	/**
	 * 卷号
	 */
	@Column(name = "PAPER_NUM")
	private Integer paperNum;

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getPaperRuleId() {
		return paperRuleId;
	}

	public void setPaperRuleId(String paperRuleId) {
		this.paperRuleId = paperRuleId;
	}

	public String getUsered() {
		return usered;
	}

	public void setUsered(String usered) {
		this.usered = usered;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public Integer getPaperNum() {
		return paperNum;
	}

	public void setPaperNum(Integer paperNum) {
		this.paperNum = paperNum;
	}

	public static class TF {

		public static String TABLE_NAME = "TESTING_PAPER"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String paperId = "PAPER_ID"; // ID
		public static String paperRuleId = "PAPER_RULE_ID"; // 所属组卷规则
		public static String usered = "USERED"; // 是否已用
		public static String disabled = "DISABLED"; // 是否禁用
		public static String paperNum = "PAPER_NUM"; // 卷号

	}

}
