package com.learnyeai.testing.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.testing.model.TestingPaperQuestion;
import com.learnyeai.testing.service.TestingPaperQuestionWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingPaperQuestionController.BASE_URL)
public class TestingPaperQuestionController extends BaseController<TestingPaperQuestion> {
    public static final String BASE_URL = "/TestingPaperQuestion/";

    @Autowired
    private TestingPaperQuestionWyService testingPaperQuestionWyService;

    @Override
    protected BaseService<TestingPaperQuestion> getService() {
        return testingPaperQuestionWyService;
    }
}
