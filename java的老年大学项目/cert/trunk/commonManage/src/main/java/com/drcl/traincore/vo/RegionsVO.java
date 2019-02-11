package com.drcl.traincore.vo;

import java.io.Serializable;

/**
 * 能力提升工程 首页区域排名
 * @author cyhaung
 *
 */
public class RegionsVO implements Serializable{
	public RegionsVO(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	private static final long serialVersionUID = -3460715703896877148L;
	
	private String code;
	private String name;
	private long finshNums;
	private long totalNums;
	private int percent;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getFinshNums() {
		return finshNums;
	}
	public void setFinshNums(long finshNums) {
		this.finshNums = finshNums;
	}
	public long getTotalNums() {
		return totalNums;
	}
	public void setTotalNums(long totalNums) {
		this.totalNums = totalNums;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
