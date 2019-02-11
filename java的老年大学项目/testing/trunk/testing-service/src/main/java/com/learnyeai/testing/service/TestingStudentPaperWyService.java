package com.learnyeai.testing.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.CurrentUserInfoDao;
import com.learnyeai.testing.api.vo.OptionVo;
import com.learnyeai.testing.api.vo.QuestionTypeVo;
import com.learnyeai.testing.api.vo.QuestionVo;
import com.learnyeai.testing.mapper.TestingStudentPaperMapper;
import com.learnyeai.testing.model.TestingAnswerPaperQuestion;
import com.learnyeai.testing.model.TestingPaper;
import com.learnyeai.testing.model.TestingPaperQuestion;
import com.learnyeai.testing.model.TestingPaperRule;
import com.learnyeai.testing.model.TestingQuestionOption;
import com.learnyeai.testing.model.TestingQuestionitemRule;
import com.learnyeai.testing.model.TestingStudentPaper;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class TestingStudentPaperWyService extends WeyeBaseService<TestingStudentPaper> {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private TestingStudentPaperMapper testingStudentPaperMapper;

	@Autowired
	private TestingPaperRuleWyService testingPaperRuleWyService;

	@Autowired
	private TestingPaperWyService testingPaperWyService;

	@Autowired
	private TestingQuestionOptionWyService testingQuestionOptionWyService;

	@Autowired
	private TestingPaperQuestionWyService testingPaperQuestionWyService;

	@Autowired
	private TestingQuestionitemRuleWyService testingQuestionitemRuleWyService;

	@Autowired
	private TestingAnswerPaperQuestionWyService testingAnswerPaperQuestionWyService;

	@Autowired
	private TestingStudentTestWyService testingStudentTestWyService;

	@Resource
	private CurrentUserInfoDao currentUserInfoDao;

	@Override
	public BaseMapper<TestingStudentPaper> getMapper() {
		return testingStudentPaperMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	@Transactional
	public TestingStudentPaper queryStudentPaper(TestingStudentPaper obj) {
		String studentUserId = obj.getStudentUserId();
		String tsId = obj.getTsId();
		logger.info("开始生成学员试卷.用户id={}|测验id={}", studentUserId, tsId);
		TestingStudentPaper t = new TestingStudentPaper();
		t.setStatus("0");
		t.setStudentUserId(studentUserId);
		t.setTsId(tsId);
		String paperNo = "";
		TestingStudentPaper studentPaper = super.queryOne(t);
		if(studentPaper==null) {
			t.setStatus("1");
			studentPaper = super.queryOne(t);
		}
		if (studentPaper == null) {// 没有生成新的卷子
			logger.info("没有查到正大考试的试卷，生成一张新的卷子.");
			TestingPaperRule paperRule = new TestingPaperRule();
			paperRule.setTsId(tsId);
			paperRule.setIsNewversion("1");
			paperRule = testingPaperRuleWyService.queryOne(paperRule);
			if (paperRule == null) {
				logger.info("没有给测验设置组卷规则，生成试卷失败!");
				return null;
			}
			String paperRuleId = paperRule.getPaperRuleId();

			// 随机一套卷子
			List<TestingPaper> testingPapers = testingPaperWyService.queryTestingPapers(paperRule.getPaperRuleId());
			if (testingPapers == null || testingPapers.size() < 1) {
				logger.info("该测验下面没有试卷可用，生成试卷失败!");
				return null;
			}
			TestingPaper paper = randomPaper(testingPapers);
			String paperId = paper.getPaperId();

			Integer maxTestNum = testingStudentPaperMapper.queryTestNum(obj);
			int examNum = maxTestNum == null ? 1 : maxTestNum + 1;
			// 卷号
			paperNo = studentUserId + "_" + tsId + "_" + examNum;
			studentPaper = new TestingStudentPaper();
			studentPaper.setStudentUserId(studentUserId);
			studentPaper.setStudentName(currentUserInfoDao.getCustName());
			studentPaper.setTsId(tsId);
			studentPaper.setPaperId(paper.getPaperId());
			studentPaper.setPaperNo(paperNo);
			studentPaper.setPaperRuleId(paperRule.getPaperRuleId());
			studentPaper.setExamNum(examNum);
			studentPaper.setHasSubject("0");// 暂时没有
			studentPaper.setStatus("0");
			studentPaper.setStartTime(new Date());
			super.save(studentPaper);
			logger.info("生成学员试卷完成，下面开始生成试卷题目。");
			TestingQuestionitemRule questionitemRule = new TestingQuestionitemRule();
			questionitemRule.setPaperRuleId(paperRuleId);
			List<TestingQuestionitemRule> testingQuestionitemRules = testingQuestionitemRuleWyService
					.queryManageList(questionitemRule);
			List<QuestionTypeVo> questionCats = new ArrayList<QuestionTypeVo>();
			QuestionTypeVo questionType = null;
			for (TestingQuestionitemRule itemRule : testingQuestionitemRules) {
				logger.info("开始生成题型为{}的题目。", itemRule.getItemType());
				questionType = new QuestionTypeVo(itemRule.getItemTypeId(), itemRule.getItemType(), itemRule.getName(),
						itemRule.getOrderNum(), itemRule.getQueNum());
				String itemTypeId = itemRule.getItemTypeId();
				List<TestingPaperQuestion> paperQuestions = testingPaperQuestionWyService
						.queryByPaperIdAndItemTypeId(paperId, itemTypeId);
				if ("1".equals(paperRule.getQuestionRand())) {// 题目乱序
					Collections.shuffle(paperQuestions);
				}
				List<QuestionVo> questions = new ArrayList<QuestionVo>();
				QuestionVo questionVo = null;
				int orderNum = 1;
				for (TestingPaperQuestion question : paperQuestions) {
					questionVo = new QuestionVo(question.getQuestionId(), question.getStemContent(),
							question.getAnswerDesc(), question.getQueScore(), orderNum, itemTypeId);
					Map<String, Object> optionOrderParam = new HashMap<String, Object>();
					optionOrderParam.put("sorts", "orderNum=1");
					TestingQuestionOption questionOption = new TestingQuestionOption();
					questionOption.setQuestionId(question.getQuestionId());
					List<TestingQuestionOption> questionOptions = testingQuestionOptionWyService
							.queryList(questionOption, optionOrderParam);
					if ("1".equals(paperRule.getOptionRand())) {// 选项乱序
						Collections.shuffle(questionOptions);
					}
					List<OptionVo> options = new ArrayList<OptionVo>();
					OptionVo optonVo = null;
					String itemIds = "";
					int optionOrderNum = 1;
					for (TestingQuestionOption option : questionOptions) {
						itemIds += "," + option.getItemId();
						optonVo = new OptionVo(option.getItemId(), option.getOptionContent(), optionOrderNum++, "0");
						options.add(optonVo);
					}
					questionVo.setOptions(options);
					questions.add(questionVo);

					TestingAnswerPaperQuestion answerPaperQuestion = new TestingAnswerPaperQuestion();
					answerPaperQuestion.setAwId(studentPaper.getAwId());
					answerPaperQuestion.setQuestionId(question.getQuestionId());
					answerPaperQuestion.setScore(question.getQueScore());
					if (StringUtils.isNotBlank(itemIds)) {
						answerPaperQuestion.setItemIds(itemIds.substring(1));
					}
					answerPaperQuestion.setItemTypeId(itemTypeId);
					answerPaperQuestion.setOrderNum(orderNum++);
					testingAnswerPaperQuestionWyService.save(answerPaperQuestion);
				}
				logger.info("完成生成题型为{}的题目。数量={}", itemRule.getItemType(), questions.size());
				questionType.setQuestions(questions);
				questionCats.add(questionType);
			}
			studentPaper.setQuestionCats(questionCats);
			logger.info("生成试卷放入缓存,paperNo={}", paperNo);
			RedisUtil redis = RedisUtilFactory.getUtil("testing_studentpaper");
			redis.set(paperNo, studentPaper);
			return studentPaper;
		} else {
			logger.info("查到正在考试的试卷，开始还原试卷.paperNo={}" + paperNo);
			paperNo = studentPaper.getPaperNo();
		}
		return queryByPaperNo(paperNo);
	}

	public TestingStudentPaper queryByPaperNo(String paperNo) {
		logger.info("开始还原试卷.从缓存中查询试卷,paperNo={}" + paperNo);
		RedisUtil redis = RedisUtilFactory.getUtil("testing_studentpaper");
		TestingStudentPaper studentPaper = (TestingStudentPaper) redis.get(paperNo);
		if (studentPaper != null) {
			logger.info("成功从缓存中还原试卷,paperNo={}" + paperNo);
			return studentPaper;
		}
		logger.info("未从缓存中还原试卷,开始从数据库中查询,paperNo={}" + paperNo);
		String[] p = paperNo.split("_");
		String studentUserId = p[0];
		String tsId = p[1];
		Integer examNum = Integer.valueOf(p[2]);
		TestingStudentPaper t = new TestingStudentPaper();
		t.setStudentUserId(studentUserId);
		t.setTsId(tsId);
		t.setExamNum(examNum);
		studentPaper = super.queryOne(t);
		if (studentPaper == null)
			return null;

		TestingPaperRule paperRule = new TestingPaperRule();
		paperRule.setTsId(tsId);
		paperRule.setIsNewversion("1");
		paperRule = testingPaperRuleWyService.queryOne(paperRule);
		if (paperRule == null)
			return null;
		String paperRuleId = paperRule.getPaperRuleId();

		TestingQuestionitemRule questionitemRule = new TestingQuestionitemRule();
		questionitemRule.setPaperRuleId(paperRuleId);
		List<TestingQuestionitemRule> testingQuestionitemRules = testingQuestionitemRuleWyService
				.queryManageList(questionitemRule);
		List<QuestionTypeVo> questionCats = new ArrayList<QuestionTypeVo>();
		QuestionTypeVo questionType = null;
		for (TestingQuestionitemRule itemRule : testingQuestionitemRules) {
			questionType = new QuestionTypeVo(itemRule.getItemTypeId(), itemRule.getItemType(), itemRule.getName(),
					itemRule.getOrderNum(), itemRule.getQueNum());
			String itemTypeId = itemRule.getItemTypeId();
			List<QuestionVo> questions = testingAnswerPaperQuestionWyService
					.queryByPaperIdAndItemTypeId(studentPaper.getAwId(), itemTypeId);
			questionType.setQuestions(questions);
			questionCats.add(questionType);
		}
		studentPaper.setQuestionCats(questionCats);
		// 放入缓存
		redis.set(paperNo, studentPaper);
		return studentPaper;
	}

	private TestingPaper randomPaper(List<TestingPaper> testingPapers) {
		Random r = new Random();
		return testingPapers.get(r.nextInt(testingPapers.size()));
	}

	@Transactional
	public Map<String, Object> savePaperQuestion(String paperNo, String answerData) {
		Map<String, Object> map = new HashMap<String, Object>();
		logger.info("提交答题.paperNo={}|answerData={}", paperNo, answerData);
		TestingStudentPaper t = new TestingStudentPaper();
		t.setPaperNo(paperNo);
		TestingStudentPaper studentPaper = super.queryOne(t);
		String awId = studentPaper.getAwId();
		if ("3".equals(studentPaper.getStatus())) {
			logger.info("试卷已提交，不能再答题!");
			map.put("status", 1);
			map.put("msg", "试卷已提交，不能再答题!");
			return map;
		}
		JSONArray data = JSONArray.parseArray(answerData);
		for (int i = 0; i < data.size(); i++) {
			JSONObject object = data.getJSONObject(i);
			String questionId = object.getString("questionId");
			String answerIdValue = object.getString("answerIdValue");
			String answerContentValue = object.getString("answerContentValue");
			TestingAnswerPaperQuestion answerPaperQuestion = new TestingAnswerPaperQuestion();
			answerPaperQuestion.setAwId(awId);
			answerPaperQuestion.setQuestionId(questionId);
			answerPaperQuestion = testingAnswerPaperQuestionWyService.queryOne(answerPaperQuestion);
			if (answerPaperQuestion == null) {
				logger.info("试卷中没有找到该试题，答题错误,awId={}|questionId={}!", awId, questionId);
				map.put("status", 1);
				map.put("msg", "试卷中没有找到该试题，答题错误!");
				return map;
			}
			answerPaperQuestion.setAnswerIdValue(answerIdValue);
			answerPaperQuestion.setAnswerContentValue(answerContentValue);
			boolean isAnswred = testingAnswerPaperQuestionWyService.isAnswered(questionId, answerIdValue);
			answerPaperQuestion.setOkStatus(isAnswred ? "1" : "0");
			testingAnswerPaperQuestionWyService.updateBySelect(answerPaperQuestion);
		}
		if("0".equals(studentPaper.getStatus())) {
			studentPaper.setStatus("1");
			super.updateBySelect(studentPaper);
		}
		logger.debug("清除试卷缓存开始");
		RedisUtil redis = RedisUtilFactory.getUtil("testing_studentpaper");
		redis.remove(paperNo);
		
		map.put("status", 0);
		map.put("msg", "答题成功!");
		return map;
	}

	@Transactional
	public Map<String, Object> saveStudentPaper(String paperNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		logger.info("开始交卷.paperNo={}", paperNo);
		TestingStudentPaper t = new TestingStudentPaper();
		t.setPaperNo(paperNo);
		TestingStudentPaper studentPaper = super.queryOne(t);
		String awId = studentPaper.getAwId();
		if ("3".equals(studentPaper.getStatus())) {
			logger.info("试卷已交卷，不能再重复交卷!");
			map.put("status", 1);
			map.put("msg", "试卷已交卷，不能再重复交卷!");
			return map;
		}
		double score = testingAnswerPaperQuestionWyService.computeScore(awId);
		logger.info("交卷.paperNo={}|score={}", paperNo,score);
		studentPaper.setScore(new BigDecimal(score));
		studentPaper.setKgScore(new BigDecimal(score));
		studentPaper.setStatus("3");
		Date nowDate = new Date();
		studentPaper.setEndTime(nowDate);
		studentPaper.setSubmitTime(nowDate);
		long examSecs = (nowDate.getTime() - studentPaper.getStartTime().getTime()) / 1000;
		studentPaper.setExamSecs(examSecs);
		super.updateBySelect(studentPaper);
		testingStudentTestWyService.saveStudentTestScore(studentPaper);
		map.put("status", 0);
		map.put("score", score);
		map.put("msg", "交卷成功!");
		return map;
	}

	public double queryMaxScore(String studentUserId, String tsId) {
		return testingStudentPaperMapper.queryMaxScore(studentUserId, tsId);
	}

	public double querySumScore(String studentUserId, String tsId) {
		return testingStudentPaperMapper.querySumScore(studentUserId, tsId);
	}

	@Override
	protected Weekend<TestingStudentPaper> genSqlExample(TestingStudentPaper t, Map params) {
		Weekend<TestingStudentPaper> w = super.genSqlExample(t, params);
		WeekendCriteria<TestingStudentPaper, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getStudentUserId())) {
			c.andEqualTo(TestingStudentPaper::getStudentUserId, t.getStudentUserId());
		}
		if (StringUtils.isNotBlank(t.getTsId())) {
			c.andEqualTo(TestingStudentPaper::getTsId, t.getTsId());
		}
		if (StringUtils.isNotBlank(t.getPaperId())) {
			c.andEqualTo(TestingStudentPaper::getPaperId, t.getPaperId());
		}
		if (StringUtils.isNotBlank(t.getPaperNo())) {
			c.andEqualTo(TestingStudentPaper::getPaperNo, t.getPaperNo());
		}
		if (StringUtils.isNotBlank(t.getStatus())) {
			c.andEqualTo(TestingStudentPaper::getStatus, t.getStatus());
		}
		w.and(c);
		return w;
	}
}
