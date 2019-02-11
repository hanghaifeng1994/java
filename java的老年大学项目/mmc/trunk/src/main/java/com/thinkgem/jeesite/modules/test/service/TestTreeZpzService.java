/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.TreeService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.test.entity.TestTreeZpz;
import com.thinkgem.jeesite.modules.test.dao.TestTreeZpzDao;

/**
 * 测试树生成zpzService
 * @author 张配忠
 * @version 2016-08-11
 */
@Service
@Transactional(readOnly = true)
public class TestTreeZpzService extends TreeService<TestTreeZpzDao, TestTreeZpz> {

	public TestTreeZpz get(String id) {
		return super.get(id);
	}
	
	public List<TestTreeZpz> findList(TestTreeZpz testTreeZpz) {
		if (StringUtils.isNotBlank(testTreeZpz.getParentIds())){
			testTreeZpz.setParentIds(","+testTreeZpz.getParentIds()+",");
		}
		return super.findList(testTreeZpz);
	}
	
	@Transactional(readOnly = false)
	public void save(TestTreeZpz testTreeZpz) {
		super.save(testTreeZpz);
	}
	
	@Transactional(readOnly = false)
	public void delete(TestTreeZpz testTreeZpz) {
		super.delete(testTreeZpz);
	}
	
}