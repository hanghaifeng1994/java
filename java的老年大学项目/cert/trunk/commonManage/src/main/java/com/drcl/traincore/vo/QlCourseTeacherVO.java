package com.drcl.traincore.vo;

public class QlCourseTeacherVO {
	private Long courseId;//课程id
	private String courseCode;//课程代码
	private String courseName;//课程名称
	private int courseType; // 培训课程类型:必修课，选修课，公共课
	private String mainTeacherId;// 主讲老师id
	private String mainTeacherName;// 主讲老师姓名

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseType() {
		return courseType;
	}

	public void setCourseType(int courseType) {
		this.courseType = courseType;
	}

	public String getMainTeacherName() {
		return mainTeacherName;
	}

	public void setMainTeacherName(String mainTeacherName) {
		this.mainTeacherName = mainTeacherName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getMainTeacherId() {
		return mainTeacherId;
	}

	public void setMainTeacherId(String mainTeacherId) {
		this.mainTeacherId = mainTeacherId;
	}
}
