package com.learnyeai.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.course.model.CsrCourseTutorRel;
import com.learnyeai.course.service.CsrCourseTutorRelWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CsrCourseTutorRelController.BASE_URL)
public class CsrCourseTutorRelController extends BaseController<CsrCourseTutorRel> {
	public static final String BASE_URL = "/CsrCourseTutorRel/";

	@Autowired
	private CsrCourseTutorRelWyService csrCourseTutorRelWyService;

	@Override
	protected BaseService<CsrCourseTutorRel> getService() {
		return csrCourseTutorRelWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		CsrCourseTutorRel ct = csrCourseTutorRelWyService.convert2Bean(ctx.getParamMap());
		if ("addTutor".equals(method)) {
			// 根据parentId 查询出所有父类id
			return csrCourseTutorRelWyService.addTutor(ct);
		}
		if ("delTutor".equals(method)) {
			return csrCourseTutorRelWyService.delTutor(ct);
		}
		return super.execute(ctx);
	}
}
