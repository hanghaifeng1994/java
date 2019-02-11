package com.learnyeai.course.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.course.api.vo.TestingTestVo;

/**
 * 测验
 *
 * @author twang
 */
@FeignClient(name = "${TESTING-SERVICE-NAME}", path = "${TESTING-SERVICE-CONTEXT-PATH}/TestingTest")
public interface TestingTestClient extends BaseFeignClient<TestingTestVo> {
	@RequestMapping(value = "/queryTestApi", method = RequestMethod.GET)
	public TestingTestVo queryTestApi(@RequestParam("tsId") String tsId);

}
