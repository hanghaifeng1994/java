package com.learnyeai.schoolclass.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.schoolclass.model.ClzClazzTest;
import com.learnyeai.schoolclass.service.ClzClazzTestWyService;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ClzClazzTestController.BASE_URL)
public class ClzClazzTestController extends BaseController<ClzClazzTest> {
	public static final String BASE_URL = "/ClzClazzTest/";

	@Autowired
	private ClzClazzTestWyService clzClazzTestWyService;

	@Override
	protected BaseService<ClzClazzTest> getService() {
		return clzClazzTestWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		ClzClazzTest ch = clzClazzTestWyService.convert2Bean(ctx.getParamMap());
		if ("addTest".equals(method)) {
			return clzClazzTestWyService.addTest(ch);
		}
		if ("delTest".equals(method)) {
			return clzClazzTestWyService.delTest(ch);
		}
		if ("testList".equals(method)) {
			return clzClazzTestWyService.testList(ch);
		}
		return super.execute(ctx);
	}
}
