package com.learnyeai.testing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.testing.model.TestingQuestionitemRule;
import com.learnyeai.testing.service.TestingQuestionitemRuleWyService;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingQuestionitemRuleController.BASE_URL)
public class TestingQuestionitemRuleController extends BaseController<TestingQuestionitemRule> {
    public static final String BASE_URL = "/TestingQuestionitemRule/";

    @Autowired
    private TestingQuestionitemRuleWyService testingQuestionitemRuleWyService;

    @Override
    protected BaseService<TestingQuestionitemRule> getService() {
        return testingQuestionitemRuleWyService;
    }
    
    @Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		TestingQuestionitemRule obj = testingQuestionitemRuleWyService.convert2Bean(ctx.getParamMap());
		if ("save".equals(method)) {
			return testingQuestionitemRuleWyService.saveOrUpdate(obj);
		}

		if ("queryManageList".equals(method)) {
			return testingQuestionitemRuleWyService.queryManageList(obj);
		}

		return super.execute(ctx);
	}
}
