package com.learnyeai.schoolclass.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.schoolclass.api.vo.CrsCustLearnCourseVo;

/**
 * 客户学习课程
 *
 * @author twang
 */
@FeignClient(name = "${COURSE-SERVICE-NAME}", path = "${COURSE-SERVICE-CONTEXT-PATH}/CrsCustLearnCourse")
public interface CrsCustLearnCourseClient extends BaseFeignClient<CrsCustLearnCourseVo> {

	@RequestMapping(value = "queryUserCoursesApi", method = RequestMethod.GET)
	public List<CrsCustLearnCourseVo> queryUserCoursesApi(@RequestParam("studyUserId") String studyUserId,
			@RequestParam("csIds") String csIds);

	@RequestMapping(value = "saveUserCourseApi", method = RequestMethod.GET)
	public boolean saveUserCourseApi(@RequestParam("userIds") String userIds, @RequestParam("csIds") String csIds,
			@RequestParam("siteId") String siteId);
}
