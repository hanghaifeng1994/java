/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test.entity;

import org.hibernate.validator.constraints.Length;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.DataExtEntity;

/**
 * 主子表生成Entity
 * @author ThinkGem
 * @version 2016-09-19
 */
public class TestDataChild extends DataExtEntity<TestDataChild> {
	
	private static final long serialVersionUID = 1L;
	private TestDataMain testDataMain;		// 业务主表 父类
	private String name;		// 名称
	
	public TestDataChild() {
		super();
	}

	public TestDataChild(String id){
		super(id);
	}
	@Override
	public String getTableName()
	{
		return ConfigUtils.getValue("schema.configPlat") + ".test_data_child";
	}


	public TestDataChild(TestDataMain testDataMain){
		this.testDataMain = testDataMain;
	}

	@Length(min=0, max=64, message="业务主表长度必须介于 0 和 64 之间")
	public TestDataMain getTestDataMain() {
		return testDataMain;
	}

	public void setTestDataMain(TestDataMain testDataMain) {
		this.testDataMain = testDataMain;
	}
	
	@Length(min=0, max=100, message="名称长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}