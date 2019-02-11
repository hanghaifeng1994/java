package com.learnyeai.course.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.course.api.service.StdCustLearnResourceApiService;
import com.learnyeai.course.api.vo.StdCustLearnResourceVo;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("/course/resource")
public class ResourceTestAction {

	@Autowired
	private StdCustLearnResourceApiService stdCustLearnResourceApiService;

	@RequestMapping(value = "/queryUserResourceApi", method = RequestMethod.GET)
	public StdCustLearnResourceVo queryUserResourceApi(String userId, String resId) {
		return stdCustLearnResourceApiService.queryUserResourceApi(userId, resId);
	}
}
