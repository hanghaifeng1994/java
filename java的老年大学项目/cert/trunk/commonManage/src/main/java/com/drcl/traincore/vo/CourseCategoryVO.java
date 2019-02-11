package com.drcl.traincore.vo;

public class CourseCategoryVO {

	private long id;
	private String name;
	private long childsCount;
	
	public CourseCategoryVO(long id,String name,long childsCount){
		this.id = id;
		this.name = name;
		this.childsCount = childsCount;
	}

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

	public void setChildsCount(long childsCount) {
		this.childsCount = childsCount;
	}

	public long getChildsCount() {
		return childsCount;
	}
}
