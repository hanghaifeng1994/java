package com.learnyeai.schoolclass.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.math.BigDecimal;

/**
 * 班级课程
 *
 * @author twang
 */
public class ClzClazzCourse extends BaseEntity {

	/**
	 * 班级课程id
	 */
	@Id
	@Column(name = "CC_ID")
	private String ccId;

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
	 * 删除标记
	 */
	@Column(name = "DEL_FLAG")
	private String delFlag;
	/**
	 * 站点
	 */
	@Column(name = "SITE_ID")
	private String siteId;

	@Transient
	private String csName;

	public String getCcId() {
		return ccId;
	}

	public void setCcId(String ccId) {
		this.ccId = ccId;
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

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public static class TF {

		public static String TABLE_NAME = "CLZ_CLAZZ_COURSE"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String ccId = "CC_ID"; // 班级课程id
		public static String czId = "CZ_ID"; // 班级id
		public static String csId = "CS_ID"; // 课程id
		public static String csType = "CS_TYPE"; // 1选修课、2必修课
		public static String csStudylength = "CS_STUDYLENGTH"; // 学时
		public static String csAmount = "CS_AMOUNT"; // 金额
		public static String delFlag = "DEL_FLAG"; // 删除标记
		public static String siteId = "SITE_ID"; // 站点

	}

	public String getCsName() {
		return csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}
}
