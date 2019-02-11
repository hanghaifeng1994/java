package com.learnyeai.testing.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.testing.model.TestingItemTypes;
import com.learnyeai.testing.service.TestingItemTypesWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingItemTypesController.BASE_URL)
public class TestingItemTypesController extends BaseController<TestingItemTypes> {
    public static final String BASE_URL = "/TestingItemTypes/";

    @Autowired
    private TestingItemTypesWyService testingItemTypesWyService;

    @Override
    protected BaseService<TestingItemTypes> getService() {
        return testingItemTypesWyService;
    }
}
