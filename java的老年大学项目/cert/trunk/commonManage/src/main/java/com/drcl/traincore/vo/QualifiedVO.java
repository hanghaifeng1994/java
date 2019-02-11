package com.drcl.traincore.vo;

public class QualifiedVO {
	private long id;
	private String name;
	private long qualified;
	private long unqualified;
	private long daikao;
	
	public QualifiedVO() {
		super();
	}
	public QualifiedVO(String name, long qualified, long unqualified) {
		super();
		this.name = name;
		this.qualified = qualified;
		this.unqualified = unqualified;
	}
	public QualifiedVO(long id,String name, long qualified, long unqualified,long daikao ) {
		super();
		this.id = id;
		this.name = name;
		this.qualified = qualified;
		this.unqualified = unqualified;
		this.daikao = daikao;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDaikao() {
		return daikao;
	}
	public void setDaikao(long daikao) {
		this.daikao = daikao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getQualified() {
		return qualified;
	}
	public void setQualified(long qualified) {
		this.qualified = qualified;
	}
	public long getUnqualified() {
		return unqualified;
	}
	public void setUnqualified(long unqualified) {
		this.unqualified = unqualified;
	}
}
