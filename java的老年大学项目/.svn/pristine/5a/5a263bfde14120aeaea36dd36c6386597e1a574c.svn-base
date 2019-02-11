package com.learnyeai.mq;

import java.util.Date;

import com.learnyeai.rabbitmq.bean.MqVo;

public class TestingMq extends MqVo {

	private static final long serialVersionUID = 2047887013883445938L;

	public TestingMq() {
	}

	public TestingMq(String studentUserId, String tsId, double score, Integer testNum, Date qualifiedDate,
			Date updateDate) {
		super();
		this.studentUserId = studentUserId;
		this.tsId = tsId;
		this.score = score;
		this.testNum = testNum;
		this.qualifiedDate = qualifiedDate;
		this.updateDate = updateDate;
	}

	private String studentUserId;
	/**
	 * 测验
	 */
	private String tsId;
	/**
	 * 得分
	 */
	private double score;
	/**
	 * 测验总次数
	 */
	private Integer testNum;
	/**
	 * 合格时间
	 */
	private Date qualifiedDate;

	private Date updateDate;

	public String getStudentUserId() {
		return studentUserId;
	}

	public void setStudentUserId(String studentUserId) {
		this.studentUserId = studentUserId;
	}

	public String getTsId() {
		return tsId;
	}

	public void setTsId(String tsId) {
		this.tsId = tsId;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Integer getTestNum() {
		return testNum;
	}

	public void setTestNum(Integer testNum) {
		this.testNum = testNum;
	}

	public Date getQualifiedDate() {
		return qualifiedDate;
	}

	public void setQualifiedDate(Date qualifiedDate) {
		this.qualifiedDate = qualifiedDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
