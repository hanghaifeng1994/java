package com.learnyeai.testing.mapper;

import com.learnyeai.testing.model.TestingPaper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
/**
 * @Description: 根据组卷规则的出的测验试卷
 * @author twang
 */
@MyBatisDao
public interface TestingPaperMapper extends BaseMapper<TestingPaper> {
	/**
	 * 通过组卷规则查询最大卷号
	 * 
	 * @param paperRuleId
	 * @return
	 */
	public Integer queryMaxPaperNum(String paperRuleId);
}
