package com.learnyeai.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.course.model.CrsChapter;
import com.learnyeai.course.service.CrsChapterWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsChapterController.BASE_URL)
public class CrsChapterController extends BaseController<CrsChapter> {
	public static final String BASE_URL = "/CrsChapter/";

	@Autowired
	private CrsChapterWyService crsChapterWyService;

	@Override
	protected BaseService<CrsChapter> getService() {
		return crsChapterWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		CrsChapter cc = crsChapterWyService.convert2Bean(ctx.getParamMap());
		if ("save".equals(method)) {
			return crsChapterWyService.saveOrUpdate(cc);
		}
		if ("deleteById".equals(method)) {
			return crsChapterWyService.delChapter(cc);
		}
		if ("queryById".equals(method)) {
			return crsChapterWyService.queryById(cc);
		}
		if ("chapterList".equals(method)) {
			return crsChapterWyService.chapterList(cc);
		}
		if ("treeList".equals(method)) {
			return crsChapterWyService.treeList(cc);
		}
		return super.execute(ctx);
	}
}
