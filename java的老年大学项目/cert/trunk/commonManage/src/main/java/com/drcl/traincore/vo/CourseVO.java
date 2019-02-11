package com.drcl.traincore.vo;

public class CourseVO {

	private Long id;
	private String name;
	private int courseModel;
		
	private String code;//课程代码
	private double hours;//课程学时
	private String studyLength;//学习时间
	private String studyPercent;//学习覆盖百分比
	private String score;//学习成绩
	
	//新增调课徐所需字段	 
	private int pro;
	private long most;// 报名设置数
	private String CourseName;
	private long choosed;//已选课数量
	private long result;//剩余课程
	
	public long getResult() {
		return result;
	}

	public void setResult(long result) {
		this.result = result;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public String getStudyLength() {
		return studyLength;
	}

	public void setStudyLength(String studyLength) {
		this.studyLength = studyLength;
	}

	public String getStudyPercent() {
		return studyPercent;
	}

	public void setStudyPercent(String studyPercent) {
		this.studyPercent = studyPercent;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String status;//课程状态
	public int getCourseModel() {
		return courseModel;
	}

	public void setCourseModel(int courseModel) {
		this.courseModel = courseModel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
