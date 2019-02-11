package com.learnyeai.schoolclass.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.schoolclass.model.ClzUserClazzCourse;
import com.learnyeai.schoolclass.service.ClzUserClazzCourseWyService;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ClzUserClazzCourseController.BASE_URL)
public class ClzUserClazzCourseController extends BaseController<ClzUserClazzCourse> {
	public static final String BASE_URL = "/ClzUserClazzCourse/";

	@Autowired
	private ClzUserClazzCourseWyService clzUserClazzCourseWyService;

	@Override
	protected BaseService<ClzUserClazzCourse> getService() {
		return clzUserClazzCourseWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		ClzUserClazzCourse ucc = clzUserClazzCourseWyService.convert2Bean(ctx.getParamMap());
		if ("queryUserClazzCoursePage".equals(method)) {
			return rtnPageList4Report(clzUserClazzCourseWyService.queryUserClazzCoursePage(ucc));
		}
		return super.execute(ctx);
	}

}
