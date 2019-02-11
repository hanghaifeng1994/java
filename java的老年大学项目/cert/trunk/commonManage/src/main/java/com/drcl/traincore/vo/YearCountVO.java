package com.drcl.traincore.vo;

public class YearCountVO {

	private String name; //阶段名称
	private String programName; //项目名称
	private Long programId; //项目id
	private String unitName; //单位名称
	private String unitCode; //单位代码
	private Long allStudents; //年度所有参加培训人数
	private Long finishedStudents; //年度完成人数
	private Long unfinishedStudents; //年度未完成人数
	private float finishRare; //年度完成率
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public Long getAllStudents() {
		return allStudents;
	}
	public void setAllStudents(Long allStudents) {
		this.allStudents = allStudents;
	}
	public Long getFinishedStudents() {
		return finishedStudents;
	}
	public void setFinishedStudents(Long finishedStudents) {
		this.finishedStudents = finishedStudents;
	}
	public Long getUnfinishedStudents() {
		return unfinishedStudents;
	}
	public void setUnfinishedStudents(Long unfinishedStudents) {
		this.unfinishedStudents = unfinishedStudents;
	}
	public float getFinishRare() {
		return finishRare;
	}
	public void setFinishRare(float finishRare) {
		this.finishRare = finishRare;
	}
	public Long getProgramId() {
		return programId;
	}
	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
