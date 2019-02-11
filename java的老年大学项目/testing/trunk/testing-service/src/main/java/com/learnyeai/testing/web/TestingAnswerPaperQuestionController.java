package com.learnyeai.testing.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.testing.model.TestingAnswerPaperQuestion;
import com.learnyeai.testing.service.TestingAnswerPaperQuestionWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingAnswerPaperQuestionController.BASE_URL)
public class TestingAnswerPaperQuestionController extends BaseController<TestingAnswerPaperQuestion> {
    public static final String BASE_URL = "/TestingAnswerPaperQuestion/";

    @Autowired
    private TestingAnswerPaperQuestionWyService testingAnswerPaperQuestionWyService;

    @Override
    protected BaseService<TestingAnswerPaperQuestion> getService() {
        return testingAnswerPaperQuestionWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx) {
        String transCode = ctx.getTransCode();
        String method = CtxHeadUtil.getControllerMethod();
        if("isAnswer".equals(method)){
            return testingAnswerPaperQuestionWyService.isAnswer(ctx);
        }
        if("answerPaper".equals(method)){
          return  testingAnswerPaperQuestionWyService.answerPaper(ctx);
        }
        if("dataCount".equals(method)){
            return  testingAnswerPaperQuestionWyService.dataCount(ctx);
        }
        if("ClzCompreEvalua".equals(method)){
            return testingAnswerPaperQuestionWyService.ClzCompreEvalua(ctx);
        }
        if("ClzComprePie".equals(method)){
           return testingAnswerPaperQuestionWyService.ClzComprePie(ctx);
        }
        return super.execute(ctx);
    }
}
