package com.learnyeai.schoolclass.api.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.learnai.support.BaseClientService;
import com.learnyeai.schoolclass.api.client.OrdOrderformClient;
import com.learnyeai.schoolclass.api.vo.OrdOrderformVo;

/**
 *
 * @author twang
 */
@Service
public class OrdOrderformApiService extends BaseClientService<OrdOrderformVo> {
	@Autowired
	private OrdOrderformClient ordOrderformClient;

	@Override
	public BaseFeignClient<OrdOrderformVo> getFeignClient() {
		return ordOrderformClient;
	}

	@Override
	public Object getId(Map params) {
		String idKey = "orderId";
		if (params.containsKey(idKey)) {
			return params.get(idKey);
		}
		return null;
	}

	public Map<String, Object> savePersonSignupOrderform(String jsonData) {
		return ordOrderformClient.savePersonSignupOrderform(jsonData);
	}
}
