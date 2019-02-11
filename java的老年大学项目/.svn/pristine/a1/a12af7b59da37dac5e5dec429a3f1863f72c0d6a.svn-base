package com.learnyeai.testing.mapper;

import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
import com.learnyeai.testing.model.CommonStar;
import com.learnyeai.testing.model.TestingAnswerPaperQuestion;

import java.util.List;
import java.util.Map;

/**
 * @Description: 答卷的题目答题情况和判分情况
 * @author twang
 */
@MyBatisDao
public interface TestingAnswerPaperQuestionMapper extends BaseMapper<TestingAnswerPaperQuestion> {
	public Double computeScore(String awId);

	List<CommonStar> starCount(TestingAnswerPaperQuestion question);

	Double getAvgScore(TestingAnswerPaperQuestion question);

	int queryCzTestNum(String czId);

	Double getTsAvgScore(Map<String,Object> params);
}
