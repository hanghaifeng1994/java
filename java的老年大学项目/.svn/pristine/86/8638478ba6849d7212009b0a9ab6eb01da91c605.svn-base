package com.learnyeai.testing.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.testing.model.TestingStudentTest;
import com.learnyeai.testing.model.TestingStudentTest;
import com.learnyeai.testing.service.TestingStudentTestWyService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingStudentTestController.BASE_URL)
public class TestingStudentTestController extends BaseController<TestingStudentTest> {
	public static final String BASE_URL = "/TestingStudentTest/";

	@Autowired
	private TestingStudentTestWyService testingStudentTestWyService;

	@Override
	protected BaseService<TestingStudentTest> getService() {
		return testingStudentTestWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		TestingStudentTest obj = testingStudentTestWyService.convert2Bean(ctx.getParamMap());

		if ("queryUserTestings".equals(method)) {
			return testingStudentTestWyService.queryUserTestings(obj, (String) ctx.getParamMap().get("testinginfo"));
		}

		if ("queryShowPage".equals(method)) {
			return rtnPageList4Report(
					testingStudentTestWyService.queryShowPage(obj, (String) ctx.getParamMap().get("testinginfo")));
		}
		return super.execute(ctx);
	}
}
