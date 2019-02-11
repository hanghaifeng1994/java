/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.dao;

import com.thinkgem.jeesite.common.persistence.TreeDao;
import cn.com.weye.core.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.test.entity.TestTreeZpz;

/**
 * 测试树生成zpzDAO接口
 * @author 张配忠
 * @version 2016-08-11
 */
@MyBatisDao
public interface TestTreeZpzDao extends TreeDao<TestTreeZpz> {
	
}