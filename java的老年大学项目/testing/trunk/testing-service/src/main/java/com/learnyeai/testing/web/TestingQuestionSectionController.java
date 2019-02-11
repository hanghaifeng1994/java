package com.learnyeai.testing.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.testing.model.TestingQuestionPool;
import com.learnyeai.testing.model.TestingQuestionSection;
import com.learnyeai.testing.service.TestingQuestionPoolWyService;
import com.learnyeai.testing.service.TestingQuestionSectionWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Map;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingQuestionSectionController.BASE_URL)
public class TestingQuestionSectionController extends BaseController<TestingQuestionSection> {
    public static final String BASE_URL = "/TestingQuestionSection/";

    @Autowired
    private TestingQuestionSectionWyService testingQuestionSectionWyService;
    @Autowired
    private TestingQuestionPoolWyService testingQuestionPoolWyService;

    @Override
    protected BaseService<TestingQuestionSection> getService() {
        return testingQuestionSectionWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
       if("queryList".equals(method)){
           return    testingQuestionSectionWyService.queryListData(ctx);
       }
       if("save".equals(method)){
           return    testingQuestionSectionWyService.saveData(ctx);
       }
       if("delete".equals(method)){
           return testingQuestionSectionWyService.deleteData(ctx);
       }
       if("queryById".equals(method)){
           TestingQuestionSection section=  testingQuestionSectionWyService.convert2Bean(ctx.getParamMap());
           section = testingQuestionSectionWyService.queryById(section.getSectionId());
           String qpId=section.getQpId();
           TestingQuestionPool pool= testingQuestionPoolWyService.queryById(qpId);
           section.setPoolName(pool.getName());
           return section;
       }
        return  super.execute(ctx);
    }
}
