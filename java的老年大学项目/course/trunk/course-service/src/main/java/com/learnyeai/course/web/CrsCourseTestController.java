package com.learnyeai.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.course.model.CrsCourseTest;
import com.learnyeai.course.service.CrsCourseTestWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsCourseTestController.BASE_URL)
public class CrsCourseTestController extends BaseController<CrsCourseTest> {
	public static final String BASE_URL = "/CrsCourseTest/";

	@Autowired
	private CrsCourseTestWyService crsCourseTestWyService;

	@Override
	protected BaseService<CrsCourseTest> getService() {
		return crsCourseTestWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		CrsCourseTest ch = crsCourseTestWyService.convert2Bean(ctx.getParamMap());
		if ("addTest".equals(method)) {
			return crsCourseTestWyService.addTest(ch);
		}
		if ("delTest".equals(method)) {
			return crsCourseTestWyService.delTest(ch);
		}
		if ("testList".equals(method)) {
			return crsCourseTestWyService.testList(ch);
		}
		return super.execute(ctx);
	}
}
