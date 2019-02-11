package com.learnyeai.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.course.model.CrsCourseHomework;
import com.learnyeai.course.service.CrsCourseHomeworkWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsCourseHomeworkController.BASE_URL)
public class CrsCourseHomeworkController extends BaseController<CrsCourseHomework> {
    public static final String BASE_URL = "/CrsCourseHomework/";

    @Autowired
    private CrsCourseHomeworkWyService crsCourseHomeworkWyService;

    @Override
    protected BaseService<CrsCourseHomework> getService() {
        return crsCourseHomeworkWyService;
    }
    
    @Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		CrsCourseHomework ch = crsCourseHomeworkWyService.convert2Bean(ctx.getParamMap());
		if ("addHomework".equals(method)) {
			return crsCourseHomeworkWyService.addHomework(ch);
		}
		if ("delHomework".equals(method)) {
			return crsCourseHomeworkWyService.delHomework(ch);
		}
		if ("homeworkList".equals(method)) {
			return crsCourseHomeworkWyService.homeworkList(ch);
		}
		return super.execute(ctx);
	}
}
