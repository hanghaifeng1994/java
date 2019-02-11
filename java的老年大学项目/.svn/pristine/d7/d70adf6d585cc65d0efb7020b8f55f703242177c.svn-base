package com.learnyeai.schoolclass.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.schoolclass.api.vo.CrsCourseVo;

/**
 * 课程
 *
 * @author twang
 */
@FeignClient(name = "${COURSE-SERVICE-NAME}", path = "${COURSE-SERVICE-CONTEXT-PATH}/CrsCourse")
public interface CrsCourseClient extends BaseFeignClient<CrsCourseVo> {

	@RequestMapping(value = "/queryCoursesApi", method = RequestMethod.GET)
	public List<CrsCourseVo> queryCoursesApi(@RequestParam("csIds") String csIds);

	@RequestMapping(value = "/queryCourseApi", method = RequestMethod.GET)
	public CrsCourseVo queryCourseApi(@RequestParam("csId") String csId);
}
