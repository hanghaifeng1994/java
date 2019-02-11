package com.learnyeai.course.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.course.api.vo.ResResourceVo;
import com.learnyeai.course.api.vo.StdCustLearnResourceVo;

/**
 * 客户学习资源
 *
 * @author twang
 */
@FeignClient(name = "${RESOURCE-SERVICE-NAME}", path = "${RESOURCE-SERVICE-CONTEXT-PATH}/StdCustLearnResource")
public interface StdCustLearnResourceClient extends BaseFeignClient<StdCustLearnResourceVo> {

	@RequestMapping(value = "/saveUserResourceApi", method = RequestMethod.GET)
	public boolean saveUserResourceApi(@RequestParam("userIds") String userIds, @RequestParam("resIds") String resIds,
			@RequestParam("siteId") String siteId, @RequestParam("source") int source);

	@RequestMapping(value = "/queryUserResourcesApi", method = RequestMethod.GET)
	public List<StdCustLearnResourceVo> queryUserResourcesApi(@RequestParam("userId") String userId,
			@RequestParam("resIds") String resIds);

	@RequestMapping(value = "/queryUserResourceApi", method = RequestMethod.GET)
	public StdCustLearnResourceVo queryUserResourceApi(@RequestParam("userId") String userId,
			@RequestParam("resId") String resId);

	@RequestMapping(value = "/queryResourceApi", method = RequestMethod.GET)
	public ResResourceVo queryResourceApi(@RequestParam("resId") String resId);
}
