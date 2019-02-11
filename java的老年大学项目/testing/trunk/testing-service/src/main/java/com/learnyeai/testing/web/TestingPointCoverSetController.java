package com.learnyeai.testing.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.testing.model.TestingPointCoverSet;
import com.learnyeai.testing.service.TestingPointCoverSetWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingPointCoverSetController.BASE_URL)
public class TestingPointCoverSetController extends BaseController<TestingPointCoverSet> {
    public static final String BASE_URL = "/TestingPointCoverSet/";

    @Autowired
    private TestingPointCoverSetWyService testingPointCoverSetWyService;

    @Override
    protected BaseService<TestingPointCoverSet> getService() {
        return testingPointCoverSetWyService;
    }
}
