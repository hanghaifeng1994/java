package com.drcl.traincore.vo;

import java.util.List;

import com.google.common.collect.Lists;

public class TeachplanStatisticsVO {

	private Long teachPlanId;//教学计划id
	private String programName;//培训项目名称
	private String teachPlanName;//教学计划名称
	private int coursesize;//课程数量
	private int clazzTotal;//班级数量小计
	private int studentTotal;//正式学员数量小计
	private int youngTotal;//青年学员数小计
	private int adultTotal;//中年学员数小计
	private int oldTotal;//老年学员数小计
	private int manTotal;//男学员数小计
	private int womanTotal;//女学员数小计
	
	private List<ClazzStatisticsVO> clazzStatisticsVOs = Lists.newArrayList();

	public int getCoursesize() {
		return coursesize;
	}

	public void setCoursesize(int coursesize) {
		this.coursesize = coursesize;
	}

	public Long getTeachPlanId() {
		return teachPlanId;
	}

	public void setTeachPlanId(Long teachPlanId) {
		this.teachPlanId = teachPlanId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getTeachPlanName() {
		return teachPlanName;
	}

	public void setTeachPlanName(String teachPlanName) {
		this.teachPlanName = teachPlanName;
	}

	public List<ClazzStatisticsVO> getClazzStatisticsVOs() {
		return clazzStatisticsVOs;
	}

	public void setClazzStatisticsVOs(List<ClazzStatisticsVO> clazzStatisticsVOs) {
		this.clazzStatisticsVOs = clazzStatisticsVOs;
	}

	public int getClazzTotal() {
		return clazzTotal;
	}

	public void setClazzTotal(int clazzTotal) {
		this.clazzTotal = clazzTotal;
	}

	public int getStudentTotal() {
		return studentTotal;
	}

	public void setStudentTotal(int studentTotal) {
		this.studentTotal = studentTotal;
	}

	public int getYoungTotal() {
		return youngTotal;
	}

	public void setYoungTotal(int youngTotal) {
		this.youngTotal = youngTotal;
	}

	public int getAdultTotal() {
		return adultTotal;
	}

	public void setAdultTotal(int adultTotal) {
		this.adultTotal = adultTotal;
	}

	public int getManTotal() {
		return manTotal;
	}

	public void setManTotal(int manTotal) {
		this.manTotal = manTotal;
	}

	public int getWomanTotal() {
		return womanTotal;
	}

	public void setWomanTotal(int womanTotal) {
		this.womanTotal = womanTotal;
	}

	public int getOldTotal() {
		return oldTotal;
	}

	public void setOldTotal(int oldTotal) {
		this.oldTotal = oldTotal;
	}
}
