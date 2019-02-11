package com.learnyeai.mq;

import java.util.Date;

import com.learnyeai.rabbitmq.bean.MqVo;

public class ResourceMq extends MqVo {
	private static final long serialVersionUID = -5263915492669975446L;

	public ResourceMq() {
	}

	public ResourceMq(String studyUserId, String resId, Long studyTime, Date updateDate) {
		super();
		this.studyUserId = studyUserId;
		this.resId = resId;
		this.studyTime = studyTime;
		this.updateDate = updateDate;
	}

	/**
	 * 学习人id
	 */
	private String studyUserId;

	/**
	 * 资源id
	 */
	private String resId;
	/**
	 * 学习时长
	 */
	private Long studyTime;
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

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public Long getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(Long studyTime) {
		this.studyTime = studyTime;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
