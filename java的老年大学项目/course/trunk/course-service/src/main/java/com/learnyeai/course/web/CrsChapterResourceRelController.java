package com.learnyeai.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.course.model.CrsChapterResourceRel;
import com.learnyeai.course.service.CrsChapterResourceRelWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsChapterResourceRelController.BASE_URL)
public class CrsChapterResourceRelController extends BaseController<CrsChapterResourceRel> {
	public static final String BASE_URL = "/CrsChapterResourceRel/";

	@Autowired
	private CrsChapterResourceRelWyService crsChapterResourceRelWyService;

	@Override
	protected BaseService<CrsChapterResourceRel> getService() {
		return crsChapterResourceRelWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		CrsChapterResourceRel cc = crsChapterResourceRelWyService.convert2Bean(ctx.getParamMap());

		if ("addResource".equals(method)) {
			return crsChapterResourceRelWyService.addResource(cc);
		}
		if ("delResource".equals(method)) {
			return crsChapterResourceRelWyService.delResource(cc);
		}
		if ("queryResources".equals(method)) {
			return crsChapterResourceRelWyService.queryResources(cc);
		}
		return super.execute(ctx);
	}
}
