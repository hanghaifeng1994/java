package com.drcl.traincore.vo;

import java.util.ArrayList;
import java.util.List;

public class ProgramesVO {
	
	private long id;
	private String name;
	private long startDate;
	private long closeDate;
	private List<ClazzVO> clazzs = new ArrayList<ClazzVO>();
	
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
	public long getStartDate() {
		return startDate;
	}
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}
	public long getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(long closeDate) {
		this.closeDate = closeDate;
	}
	public List<ClazzVO> getClazzs() {
		return clazzs;
	}
	public void setClazzs(List<ClazzVO> clazzs) {
		this.clazzs = clazzs;
	}
	
}
