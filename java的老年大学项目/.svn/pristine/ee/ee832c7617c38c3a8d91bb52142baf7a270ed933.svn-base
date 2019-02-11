package com.learnyeai.testing.service;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.testing.mapper.TestingPaperMapper;
import com.learnyeai.testing.model.TestingPaper;
import com.learnyeai.testing.model.TestingPaperQuestion;
import com.learnyeai.testing.model.TestingPaperRule;
import com.learnyeai.testing.model.TestingQuestion;
import com.learnyeai.testing.model.TestingQuestionitemRule;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class TestingPaperWyService extends WeyeBaseService<TestingPaper> {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private TestingPaperMapper testingPaperMapper;

	@Autowired
	private TestingQuestionWyService testingQuestionWyService;

	@Autowired
	private TestingPaperQuestionWyService testingPaperQuestionWyService;

	@Autowired
	private TestingPaperRuleWyService testingPaperRuleWyService;

	@Override
	public BaseMapper<TestingPaper> getMapper() {
		return testingPaperMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	public Integer queryMaxPaperNum(String paperRuleId) {
		return testingPaperMapper.queryMaxPaperNum(paperRuleId);
	}

	@Transactional
	public boolean saveGenPaper(TestingPaperRule testingPaperRule, List<TestingQuestionitemRule> itemRules, int num)
			throws Exception {
		String paperRuleId = testingPaperRule.getPaperRuleId();
		Integer paperNum = testingPaperMapper.queryMaxPaperNum(paperRuleId);
		for (int i = 0; i < num; i++) {
			// 生成试卷
			TestingPaper paper = new TestingPaper();
			paper.setPaperRuleId(paperRuleId);
			paper.setDisabled("0");
			paper.setUsered("1");
			paper.setPaperNum(0);
			paper.setPaperNum(paperNum == null ? 1 : paperNum + 1);
			super.save(paper);
			// 生成试题
			int itemOrderNum = 1;
			for (TestingQuestionitemRule itemRule : itemRules) {
				List<TestingQuestion> questions = testingQuestionWyService
						.queryByQpIdAndType(testingPaperRule.getQpId(), itemRule.getItemTypeId());// 所有符合要求的试题
				if (questions == null || itemRule.getQueNum() > questions.size()) {
					logger.warn("组卷题型设置的题型数目大于题库中的试题数目，不能生成席卷!questionitemRuleId=" + itemRule.getQuestionitemRuleId());
					throw new RuntimeException("组卷题型设置的题型数目大于题库中的试题数目!");
				}
				for (int j = 0; j < itemRule.getQueNum(); j++) {
					TestingQuestion question = randomQuesioon(questions);
					TestingPaperQuestion paperQuestion = new TestingPaperQuestion();
					paperQuestion.setItemTypeId(itemRule.getItemTypeId());
					paperQuestion.setPaperId(paper.getPaperId());
					paperQuestion.setQuestionId(question.getQuestionId());
					paperQuestion.setQueScore(itemRule.getQueScore());
					paperQuestion.setQuestionitemRuleId(itemRule.getQuestionitemRuleId());
					paperQuestion.setOrderNum(itemOrderNum++);
					testingPaperQuestionWyService.save(paperQuestion);
				}
			}
		}
		return true;
	}

	private TestingQuestion randomQuesioon(List<TestingQuestion> questions) {
		Random r = new Random();
		TestingQuestion question = questions.get(r.nextInt(questions.size()));
		questions.remove(question);
		return question;
	}
	
	@Cacheable(cacheNames = "testing_testingpaperlist", key = "#paperRuleId")
	public List<TestingPaper> queryTestingPapers(String paperRuleId){
		TestingPaper paperObj = new TestingPaper();
		paperObj.setPaperRuleId(paperRuleId);
		paperObj.setDisabled("0");
		List<TestingPaper> list = super.queryList(paperObj, null);
		/*RedisUtil redis = RedisUtilFactory.getUtil("testing_testingpaperlist", List.class);
		redis.set(paperRuleId, list);*/
		return list;
	}
	
	@CacheEvict(cacheNames = "testing_testingpaperlist", key = "#paperRuleId")
	public void removeTestingPapers(String paperRuleId) {
	}

	@Override
	protected Weekend<TestingPaper> genSqlExample(TestingPaper t, Map params) {
		Weekend<TestingPaper> w = super.genSqlExample(t, params);
		WeekendCriteria<TestingPaper, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getPaperRuleId())) {
			c.andEqualTo(TestingPaper::getPaperRuleId, t.getPaperRuleId());
		}
		if (StringUtils.isNotBlank(t.getDisabled())) {
			c.andEqualTo(TestingPaper::getDisabled, t.getDisabled());
		}
		w.and(c);
		return w;
	}

}
