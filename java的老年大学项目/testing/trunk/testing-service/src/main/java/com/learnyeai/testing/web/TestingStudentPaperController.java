package com.learnyeai.testing.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.testing.model.TestingStudentPaper;
import com.learnyeai.testing.service.TestingStudentPaperWyService;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + TestingStudentPaperController.BASE_URL)
public class TestingStudentPaperController extends BaseController<TestingStudentPaper> {
	public static final String BASE_URL = "/TestingStudentPaper/";

	@Autowired
	private TestingStudentPaperWyService testingStudentPaperWyService;

	@Override
	protected BaseService<TestingStudentPaper> getService() {
		return testingStudentPaperWyService;
	}
	
	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		TestingStudentPaper obj = testingStudentPaperWyService.convert2Bean(ctx.getParamMap());

		if ("queryStudentPaper".equals(method)) {
			return testingStudentPaperWyService.queryStudentPaper(obj);
		}

		if ("savePaperQuestion".equals(method)) {
			return testingStudentPaperWyService.savePaperQuestion((String) ctx.getParamMap().get("paperNo"),
					(String) ctx.getParamMap().get("answerData"));
		}

		if ("saveStudentPaper".equals(method)) {
			Map<String, Object> map = null;
			try {
				map = testingStudentPaperWyService.saveStudentPaper((String) ctx.getParamMap().get("paperNo"));
				return map;
			} catch (Exception e) {
				map = new HashMap<String, Object>();
				map.put("status", 1);
				map.put("msg", e.getMessage());
				return map;
			}
		}
		return super.execute(ctx);
	}
}
