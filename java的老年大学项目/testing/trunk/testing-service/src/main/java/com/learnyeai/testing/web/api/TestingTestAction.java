package com.learnyeai.testing.web.api;

import com.learnyeai.testing.service.TestingAnswerPaperQuestionWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.learnai.support.ApiBaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.testing.model.TestingTest;
import com.learnyeai.testing.service.TestingTestWyService;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingTestAction.BASE_URL)
public class TestingTestAction extends ApiBaseController<TestingTest> {
	public static final String BASE_URL = "/TestingTest/";

	@Autowired
	private TestingTestWyService testingTestWyService;
	@Autowired
	private TestingAnswerPaperQuestionWyService testingAnswerPaperQuestionWyService;

	@Override
	protected BaseService<TestingTest> getBaseService() {
		return testingTestWyService;
	}

	@Override
	public String getBaseUrl() {
		return BASE_URL;
	}

	@RequestMapping(value = "/queryTestApi", method = RequestMethod.GET)
	public TestingTest queryTestApi(String tsId) {
		return testingTestWyService.get(tsId);
	}

	@RequestMapping(value = "/queryCzTestNum", method = RequestMethod.GET)
	public int queryCzTestNum(String czId){
		//通过班级去TESTING_ANSWER_PAPER_QUESTION 答卷详情中查看有多少张卷子
		return  testingAnswerPaperQuestionWyService.queryCzTestNum(czId);
	}
}
