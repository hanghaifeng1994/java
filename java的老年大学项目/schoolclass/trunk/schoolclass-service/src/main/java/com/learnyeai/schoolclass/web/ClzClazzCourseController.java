package com.learnyeai.schoolclass.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.schoolclass.model.ClzClazzCourse;
import com.learnyeai.schoolclass.service.ClzClazzCourseWyService;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ClzClazzCourseController.BASE_URL)
public class ClzClazzCourseController extends BaseController<ClzClazzCourse> {
	public static final String BASE_URL = "/ClzClazzCourse/";

	@Autowired
	private ClzClazzCourseWyService clzClazzCourseWyService;

	@Override
	protected BaseService<ClzClazzCourse> getService() {
		return clzClazzCourseWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		ClzClazzCourse cc = clzClazzCourseWyService.convert2Bean(ctx.getParamMap());
		if ("save".equals(method)) {
			return clzClazzCourseWyService.saveOrUpdate(cc);
		}
		if ("deleteById".equals(method)) {
			return clzClazzCourseWyService.delClazzCourses(cc);
		}
		if ("queryShowPage".equals(method)) {
			return rtnPageList4Report(clzClazzCourseWyService.queryShowPage(cc));
		}
		return super.execute(ctx);
	}
}
