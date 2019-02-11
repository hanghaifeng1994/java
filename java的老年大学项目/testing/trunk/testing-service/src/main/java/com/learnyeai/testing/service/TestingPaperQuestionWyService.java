package com.learnyeai.testing.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.testing.mapper.TestingPaperQuestionMapper;
import com.learnyeai.testing.model.TestingPaperQuestion;
import com.learnyeai.testing.model.TestingQuestion;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class TestingPaperQuestionWyService extends WeyeBaseService<TestingPaperQuestion> {

    @Resource
    private TestingPaperQuestionMapper testingPaperQuestionMapper;
    
    @Resource
	private TestingQuestionWyService testingQuestionWyService;

    @Override
    public BaseMapper<TestingPaperQuestion> getMapper() {
        return testingPaperQuestionMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    
    /**
     * 通过试卷id和题型查询试卷试题详细
     * @param paperId
     * @param itemTypeId
     * @return
     */
    public List<TestingPaperQuestion> queryByPaperIdAndItemTypeId(String paperId, String itemTypeId) {
    	TestingPaperQuestion paperQuestion = new TestingPaperQuestion();
		paperQuestion.setPaperId(paperId);
		paperQuestion.setItemTypeId(itemTypeId);
		Map<String, Object> questionOrderParam = new HashMap<String, Object>();
		questionOrderParam.put("sorts", "orderNum=1");
		List<TestingPaperQuestion> paperQuestions = super.queryList(paperQuestion, questionOrderParam);
		for(TestingPaperQuestion obj : paperQuestions) {
			TestingQuestion question = testingQuestionWyService.get(obj.getQuestionId());
			obj.setStemContent(question.getStemContent());
			obj.setAnswerDesc(question.getAnswerDesc());
		}
		return paperQuestions;
    }
    
    @Override
	protected Weekend<TestingPaperQuestion> genSqlExample(TestingPaperQuestion t, Map params) {
		Weekend<TestingPaperQuestion> w = super.genSqlExample(t, params);
		WeekendCriteria<TestingPaperQuestion, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getPaperId())) {
			c.andEqualTo(TestingPaperQuestion::getPaperId, t.getPaperId());
		}
		if (StringUtils.isNotBlank(t.getItemTypeId())) {
			c.andEqualTo(TestingPaperQuestion::getItemTypeId, t.getItemTypeId());
		}
		if (StringUtils.isNotBlank(t.getPointCoverSetId())) {
			c.andEqualTo(TestingPaperQuestion::getPointCoverSetId, t.getPointCoverSetId());
		}
		w.and(c);
		return w;
	}
}
