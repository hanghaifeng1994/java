package com.learnyeai.mq;

import java.util.Date;

import com.learnyeai.rabbitmq.bean.MqVo;

public class HomeworkMq extends MqVo {

	private static final long serialVersionUID = -3033423634017599349L;

	public HomeworkMq() {
	}

	public HomeworkMq(String studentUserId, String hwId, double score, Date updateDate) {
		super();
		this.studentUserId = studentUserId;
		this.hwId = hwId;
		this.score = score;
		this.updateDate = updateDate;
	}

	private String studentUserId;
	/**
	 * 作业id
	 */
	private String hwId;
	/**
	 * 得分
	 */
	private double score;

	private Date updateDate;

	public String getStudentUserId() {
		return studentUserId;
	}

	public void setStudentUserId(String studentUserId) {
		this.studentUserId = studentUserId;
	}

	public String getHwId() {
		return hwId;
	}

	public void setHwId(String hwId) {
		this.hwId = hwId;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
