package com.learnyeai.course.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 课程作业
 *
 * @author twang
 */
public class CrsCourseHomework extends BaseEntity {

	/**
	 * ID
	 */
	@Id
	@Column(name = "CW_ID")
	private String cwId;

	/**
	 * 课程id
	 */
	@Column(name = "CS_ID")
	private String csId;
	/**
	 * 作业id
	 */
	@Column(name = "HW_ID")
	private String hwId;

	@Transient
	private String hwTitle;

	public String getCwId() {
		return cwId;
	}

	public void setCwId(String cwId) {
		this.cwId = cwId;
	}

	public String getCsId() {
		return csId;
	}

	public void setCsId(String csId) {
		this.csId = csId;
	}

	public String getHwId() {
		return hwId;
	}

	public void setHwId(String hwId) {
		this.hwId = hwId;
	}

	public static class TF {

		public static String TABLE_NAME = "CRS_COURSE_HOMEWORK"; // 表名

		// public static String TABLE_SCHEMA = ConfigUtils.getValue(""); // 库名

		public static String cwId = "CW_ID"; // ID
		public static String csId = "CS_ID"; // 课程id
		public static String hwId = "HW_ID"; // 作业id

	}

	public String getHwTitle() {
		return hwTitle;
	}

	public void setHwTitle(String hwTitle) {
		this.hwTitle = hwTitle;
	}
}
