package com.learnyeai.testing.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.testing.model.TestingSitePool;
import com.learnyeai.testing.service.TestingSitePoolWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingSitePoolController.BASE_URL)
public class TestingSitePoolController extends BaseController<TestingSitePool> {
    public static final String BASE_URL = "/TestingSitePool/";

    @Autowired
    private TestingSitePoolWyService testingSitePoolWyService;

    @Override
    protected BaseService<TestingSitePool> getService() {
        return testingSitePoolWyService;
    }
}
