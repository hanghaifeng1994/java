package com.learnyeai.course.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.course.model.CrsCourse;
import com.learnyeai.course.service.CrsCourseWyService;
import com.learnyeai.learnai.support.ApiBaseController;
import com.learnyeai.learnai.support.BaseService;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsCourseAction.BASE_URL)
public class CrsCourseAction extends ApiBaseController<CrsCourse> {
	public static final String BASE_URL = "/CrsCourse/";

	@Autowired
	private CrsCourseWyService crsCourseWyService;

	@Override
	protected BaseService<CrsCourse> getBaseService() {
		return crsCourseWyService;
	}

	@Override
	public String getBaseUrl() {
		return BASE_URL;
	}

	@RequestMapping(value = "/queryCoursesApi", method = RequestMethod.GET)
	public List<CrsCourse> queryCoursesApi(String csIds) {
		return crsCourseWyService.queryCoursesApi(csIds);
	}
	
	@RequestMapping(value = "/queryCourseApi", method = RequestMethod.GET)
	public CrsCourse queryCourseApi(String csId) {
		return crsCourseWyService.get(csId);
	}
}
