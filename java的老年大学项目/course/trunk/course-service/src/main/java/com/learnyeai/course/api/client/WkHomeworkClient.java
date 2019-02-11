package com.learnyeai.course.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.course.api.vo.WkHomeworkVo;

/**
 * 作业
 *
 * @author twang
 */
@FeignClient(name = "${HOMEWORK-SERVICE-NAME}", path = "${HOMEWORK-SERVICE-CONTEXT-PATH}/WkHomework")
public interface WkHomeworkClient extends BaseFeignClient<WkHomeworkVo> {
	@RequestMapping(value = "/queryHomeworkApi", method = RequestMethod.GET)
	public WkHomeworkVo queryHomeworkApi(@RequestParam("hwId") String hwId);
}
