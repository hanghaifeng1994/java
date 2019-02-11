package com.drcl.traincore.vo;

import java.util.ArrayList;
import java.util.List;

public class ClazzAreaSchoolVO {
	private long id;
	private String name;
	private long pid;
	private List<ClazzAreaSchoolVO> childen = new ArrayList<ClazzAreaSchoolVO>();
	private String clazzId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public List<ClazzAreaSchoolVO> getChilden() {
		return childen;
	}
	public void setChilden(List<ClazzAreaSchoolVO> childen) {
		this.childen = childen;
	}
	public String getClazzId() {
		return clazzId;
	}
	public void setClazzId(String clazzId) {
		this.clazzId = clazzId;
	}
	
}
