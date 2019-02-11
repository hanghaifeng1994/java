package com.learnyeai.testing.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.testing.model.TestingQuestionPool;
import com.learnyeai.testing.service.TestingQuestionPoolWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingQuestionPoolController.BASE_URL)
public class TestingQuestionPoolController extends BaseController<TestingQuestionPool> {
    public static final String BASE_URL = "/TestingQuestionPool/";

    @Autowired
    private TestingQuestionPoolWyService testingQuestionPoolWyService;

    @Override
    protected BaseService<TestingQuestionPool> getService() {
        return testingQuestionPoolWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        if("save".equals(method)){
           return testingQuestionPoolWyService.saveData(ctx);
        }
        if("sendLowerPage".equals(method)){
            List<TestingQuestionPool> list= testingQuestionPoolWyService.sendLowerPage(ctx);
            MyPage page=new MyPage(list);
            return rtnPageList4Report(page);
        }
        return super.execute(ctx);
    }
}
