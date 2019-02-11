/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test.dao;

import com.thinkgem.jeesite.common.persistence.TreeDao;
import cn.com.weye.core.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.test.entity.TestTree;

/**
 * 树结构生成DAO接口
 * @author ThinkGem
 * @version 2016-09-14
 */
@MyBatisDao
public interface TestTreeDao extends TreeDao<TestTree> {
	
}