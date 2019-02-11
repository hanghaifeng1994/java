/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.TreeEntity;

/**
 * 测试树生成zpzEntity
 * @author 张配忠
 * @version 2016-08-11
 */
public class TestTreeZpz extends TreeEntity<TestTreeZpz> {
	
	private static final long serialVersionUID = 1L;
	private TestTreeZpz parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private String name;		// 名称
	
	public TestTreeZpz() {
		super();
	}

	public TestTreeZpz(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="父级编号不能为空")
	public TestTreeZpz getParent() {
		return parent;
	}

	public void setParent(TestTreeZpz parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=2000, message="所有父级编号长度必须介于 1 和 2000 之间")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	@Length(min=1, max=100, message="名称长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}