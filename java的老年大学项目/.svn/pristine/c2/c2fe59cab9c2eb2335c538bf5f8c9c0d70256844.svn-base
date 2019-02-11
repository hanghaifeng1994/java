package com.learnyeai.testing.api.vo;

import com.learnyeai.learnai.support.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 班级-测验
 *
 * @author twang
 */
public class ClzClazzTestVo extends BaseEntity {

	/**
	 * ID
	 */
	@Id
	@Column(name = "CT_ID")
	private String ctId;

	/**
	 * 班级id
	 */
	@Column(name = "CZ_ID")
	private String czId;
	/**
	 * 测验id
	 */
	@Column(name = "TS_ID")
	private String tsId;

	/**
	 * 测验名称
	 */
	@Transient
	private String name;

	public String getCtId() {
		return ctId;
	}

	public void setCtId(String ctId) {
		this.ctId = ctId;
	}

	public String getCzId() {
		return czId;
	}

	public void setCzId(String czId) {
		this.czId = czId;
	}

	public String getTsId() {
		return tsId;
	}

	public void setTsId(String tsId) {
		this.tsId = tsId;
	}

	public static class TF {

		public static String TABLE_NAME = "CLZ_CLAZZ_TEST"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String ctId = "CT_ID"; // ID
		public static String czId = "CZ_ID"; // 班级id
		public static String tsId = "TS_ID"; // 测验id

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
