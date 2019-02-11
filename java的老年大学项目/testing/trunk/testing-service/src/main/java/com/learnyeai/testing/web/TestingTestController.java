package com.learnyeai.testing.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.testing.model.TestingTest;
import com.learnyeai.testing.service.TestingTestWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingTestController.BASE_URL)
public class TestingTestController extends BaseController<TestingTest> {
    public static final String BASE_URL = "/TestingTest/";

    @Autowired
    private TestingTestWyService testingTestWyService;

    @Override
    protected BaseService<TestingTest> getService() {
        return testingTestWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        if("save".equals(method)){
          return   testingTestWyService.saveData(ctx);
        }
        if("delete".equals(method)){
            return  testingTestWyService.deleteData(ctx);
        }
        return super.execute(ctx);
    }
}
