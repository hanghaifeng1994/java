package com.learnyeai.testing.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.testing.model.TestingPaper;
import com.learnyeai.testing.service.TestingPaperWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingPaperController.BASE_URL)
public class TestingPaperController extends BaseController<TestingPaper> {
    public static final String BASE_URL = "/TestingPaper/";

    @Autowired
    private TestingPaperWyService testingPaperWyService;

    @Override
    protected BaseService<TestingPaper> getService() {
        return testingPaperWyService;
    }
}
