package com.learnyeai.testing.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.testing.model.TestingQuestion;
import com.learnyeai.testing.service.TestingQuestionWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingQuestionController.BASE_URL)
public class TestingQuestionController extends BaseController<TestingQuestion> {
    public static final String BASE_URL = "/TestingQuestion/";

    @Autowired
    private TestingQuestionWyService testingQuestionWyService;

    @Override
    protected BaseService<TestingQuestion> getService() {
        return testingQuestionWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        if("queryById".equals(method)){
//            返回题目详情带选项
         return    testingQuestionWyService.queryByIdExt(ctx);
        }
        if("queryPageExt".equals(method)){
           MyPage page= testingQuestionWyService.queryPageExt(ctx);
           return super.rtnPageList4Report(page);
        }
        if("save".equals(method)){
            return testingQuestionWyService.saveData(ctx);
        }
        if("delete".equals(method)){
            return testingQuestionWyService.deleteData(ctx);
        }
        if("queryItemTypes".equals(method)){
            return testingQuestionWyService.queryItemTypes((String)ctx.getParam("qpId"));
        }
        return super.execute(ctx);
    }

}
