package com.learnyeai.testing.mapper;

import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
import com.learnyeai.testing.model.TestingPaperRule;

/**
 * @Description: 测验对应的组卷规则表，每一个组卷规则表,都属于一个测验外键
 * @author twang
 */
@MyBatisDao
public interface TestingPaperRuleMapper extends BaseMapper<TestingPaperRule> {
	/**
	 * 查询未使用过的组卷规则
	 * 
	 * @param tsId
	 * @return
	 */
	public TestingPaperRule queryUnUsedOne(String tsId);

	/**
	 * 查询最大版本号
	 * 
	 * @param tsId
	 * @return
	 */
	public Integer queryMaxVersion(String tsId);
	
	/**
	 * 所有测验的规则是不是新版本改为否
	 * @param tsId
	 * @return
	 */
	public Integer updateNewVersion(String tsId);
}
