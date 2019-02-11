package com.learnyeai.mq;

import java.util.Date;

import com.learnyeai.rabbitmq.bean.MqVo;

public class CourseMq extends MqVo {
	private static final long serialVersionUID = -5263915492669975446L;

	public CourseMq() {
	}

	public CourseMq(String studyUserId, String csId, Date updateDate) {
		super();
		this.studyUserId = studyUserId;
		this.csId = csId;
		this.updateDate = updateDate;
	}

	/**
	 * 学习人id
	 */
	private String studyUserId;

	/**
	 * 课程id
	 */
	private String csId;

	/**
	 * 更新时间
	 */
	private Date updateDate;

	public String getStudyUserId() {
		return studyUserId;
	}

	public void setStudyUserId(String studyUserId) {
		this.studyUserId = studyUserId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCsId() {
		return csId;
	}

	public void setCsId(String csId) {
		this.csId = csId;
	}

}
