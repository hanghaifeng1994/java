package com.learnyeai.testing.web.api;

import com.learnyeai.testing.model.TestingAnswerPaperQuestion;
import com.learnyeai.testing.service.TestingAnswerPaperQuestionWyService;
import com.learnyeai.learnai.support.ApiBaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author twang
 */
@Component
public class TestingAnswerPaperQuestionAction extends ApiBaseController<TestingAnswerPaperQuestion> {
    public static final String BASE_URL = "/TestingAnswerPaperQuestion/";

    @Autowired
    private TestingAnswerPaperQuestionWyService testingAnswerPaperQuestionWyService;

    @Override
    protected BaseService<TestingAnswerPaperQuestion> getBaseService() {
        return testingAnswerPaperQuestionWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }
}
