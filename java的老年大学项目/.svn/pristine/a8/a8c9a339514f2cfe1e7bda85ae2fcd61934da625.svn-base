package com.learnyeai.course.web.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.course.model.CrsCustLearnCourse;
import com.learnyeai.course.service.CrsCustLearnCourseWyService;
import com.learnyeai.learnai.support.ApiBaseController;
import com.learnyeai.learnai.support.BaseService;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsCustLearnCourseAction.BASE_URL)
public class CrsCustLearnCourseAction extends ApiBaseController<CrsCustLearnCourse> {
	public static final String BASE_URL = "/CrsCustLearnCourse/";
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CrsCustLearnCourseWyService crsCustLearnCourseWyService;

	@Override
	protected BaseService<CrsCustLearnCourse> getBaseService() {
		return crsCustLearnCourseWyService;
	}

	@Override
	public String getBaseUrl() {
		return BASE_URL;
	}

	@RequestMapping(value = "/queryUserCoursesApi", method = RequestMethod.GET)
	public List<CrsCustLearnCourse> queryUserCoursesApi(String studyUserId, String csIds) {
		return crsCustLearnCourseWyService.queryUserCoursesApi(studyUserId, csIds);
	}

	@RequestMapping(value = "/saveUserCourseApi", method = RequestMethod.GET)
	public boolean saveUserCourseApi(String userIds, String csIds, String siteId) {
		try {
			return crsCustLearnCourseWyService.saveUserCourseApi(userIds, csIds, siteId, "1");
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}
}
