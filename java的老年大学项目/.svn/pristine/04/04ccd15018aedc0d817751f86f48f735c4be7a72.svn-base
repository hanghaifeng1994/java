package com.learnyeai.testing.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.testing.model.TestingQuestionOption;
import com.learnyeai.testing.service.TestingQuestionOptionWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingQuestionOptionController.BASE_URL)
public class TestingQuestionOptionController extends BaseController<TestingQuestionOption> {
    public static final String BASE_URL = "/TestingQuestionOption/";

    @Autowired
    private TestingQuestionOptionWyService testingQuestionOptionWyService;

    @Override
    protected BaseService<TestingQuestionOption> getService() {
        return testingQuestionOptionWyService;
    }
}
