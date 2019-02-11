package com.learnyeai.schoolclass.api.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.schoolclass.api.vo.OrdOrderformVo;

/**
 * 订单
 *
 * @author twang
 */
@FeignClient(name = "${ORDERFORM-SERVICE-NAME}", path = "${ORDERFORM-SERVICE-CONTEXT-PATH}/OrdOrderform")
public interface OrdOrderformClient extends BaseFeignClient<OrdOrderformVo> {

	@RequestMapping(value = "savePersonSignupOrderform", method = RequestMethod.GET, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Map<String, Object> savePersonSignupOrderform(@RequestBody String jsonData);

}
