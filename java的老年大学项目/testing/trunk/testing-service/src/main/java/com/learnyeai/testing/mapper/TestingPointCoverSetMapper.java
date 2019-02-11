package com.learnyeai.testing.mapper;

import com.learnyeai.testing.model.TestingPointCoverSet;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
/**
 * @Description: 每种题型，在不同知识点出题分别情况
 * @author twang
 */
@MyBatisDao
public interface TestingPointCoverSetMapper extends BaseMapper<TestingPointCoverSet> {
}
