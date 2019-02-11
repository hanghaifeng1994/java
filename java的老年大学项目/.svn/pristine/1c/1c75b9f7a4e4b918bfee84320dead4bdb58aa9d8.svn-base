package com.learnyeai.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.course.model.CrsCourse;
import com.learnyeai.course.service.CrsCourseWyService;
import com.learnyeai.course.util.CourseUtil;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsCourseController.BASE_URL)
public class CrsCourseController extends BaseController<CrsCourse> {
	public static final String BASE_URL = "/CrsCourse/";

	@Autowired
	private CrsCourseWyService crsCourseWyService;

	@Override
	protected BaseService<CrsCourse> getService() {
		return crsCourseWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		CrsCourse cs = crsCourseWyService.convert2Bean(ctx.getParamMap());
		cs.setSiteIds(CourseUtil.convertSiteIds((String)ctx.getParamMap().get("sites")));
		if ("save".equals(method)) {
			// 根据parentId 查询出所有父类id
			return crsCourseWyService.saveOrUpdate(cs);
		}
		if ("deleteById".equals(method)) {
			return crsCourseWyService.deleteCourses(cs);
		}

		if ("queryManagePage".equals(method)) {
			return rtnPageList4Report(crsCourseWyService.queryManagePage(cs));
		}

		if ("queryShowPage".equals(method)) {
			return rtnPageList4Report(crsCourseWyService.queryShowPage(cs));
		}

		if ("queryMainPage".equals(method)) {// 主站下发的列表
			return rtnPageList4Report(crsCourseWyService.queryMainPage(cs));
		}

		if ("detail".equals(method)) {
			return crsCourseWyService.detail(cs.getCsId());
		}

		if ("queryById".equals(method)) {
			return crsCourseWyService.courseDetail(cs.getCsId(), (String)ctx.getParamMap().get("chapter"));
		}

		if ("publish".equals(method)) {
			return crsCourseWyService.publish(cs);
		}
		
		if ("tj".equals(method)) {
			return crsCourseWyService.tj(cs);
		}

		if ("check".equals(method)) {
			return crsCourseWyService.check(cs);
		}

		if ("submitCheck".equals(method)) {
			return crsCourseWyService.submitCheck(cs);
		}
		return super.execute(ctx);
	}
}
