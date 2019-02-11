/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.entity.ccc;

import org.hibernate.validator.constraints.Length;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.DataExtEntity;

/**
 * cccEntity
 * @author ccc
 * @version 2016-09-13
 */
public class Ccc extends DataExtEntity<Ccc> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	
	public Ccc() {
		super();
	}

	public Ccc(String id){
		super(id);
	}
	@Override
	public String getTableName()
	{
		return ConfigUtils.getValue("schema.interPlat") + ".aa";
	}


	@Length(min=0, max=20, message="name长度必须介于 0 和 20 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}