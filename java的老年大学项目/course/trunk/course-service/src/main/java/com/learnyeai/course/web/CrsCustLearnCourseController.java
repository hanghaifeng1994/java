package com.learnyeai.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.course.model.CrsCustLearnCourse;
import com.learnyeai.course.service.CrsCustLearnCourseWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsCustLearnCourseController.BASE_URL)
public class CrsCustLearnCourseController extends BaseController<CrsCustLearnCourse> {
	public static final String BASE_URL = "/CrsCustLearnCourse/";

	@Autowired
	private CrsCustLearnCourseWyService crsCustLearnCourseWyService;

	@Override
	protected BaseService<CrsCustLearnCourse> getService() {
		return crsCustLearnCourseWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		CrsCustLearnCourse lc = crsCustLearnCourseWyService.convert2Bean(ctx.getParamMap());
		if ("addUserCourse".equals(method)) {// 用户批量选课和取消选课
			return crsCustLearnCourseWyService.addUserCourse(lc);
		}

		if ("queryUserPage".equals(method)) {// 课程最近学习人员
			return rtnPageList4Report(crsCustLearnCourseWyService.queryUserPage(lc));
		}

		if ("queryMyCoursePage".equals(method)) {// 我学习的课程列表
			return rtnPageList4Report(crsCustLearnCourseWyService.queryMyCoursePage(lc));
		}
		
		if ("queryUserCoursePage".equals(method)) {// 我学习的课程列表
			return rtnPageList4Report(crsCustLearnCourseWyService.queryUserCoursePage(lc, (String)ctx.getParamMap().get("orderType"), (String)ctx.getParamMap().get("courseinfo")));
		}
		return super.execute(ctx);
	}
}
