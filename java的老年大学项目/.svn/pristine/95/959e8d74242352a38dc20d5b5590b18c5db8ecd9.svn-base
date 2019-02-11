package com.learnyeai.schoolclass.api.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.learnai.support.BaseClientService;
import com.learnyeai.schoolclass.api.client.CtUserCertClient;
import com.learnyeai.schoolclass.api.vo.CtUserCertVo;

/**
 *
 * @author twang
 */
@Service
public class CtUserCertApiService extends BaseClientService<CtUserCertVo> {
	@Autowired
	private CtUserCertClient ctUserCertClient;

	@Override
	public BaseFeignClient<CtUserCertVo> getFeignClient() {
		return ctUserCertClient;
	}

	@Override
	public Object getId(Map params) {
		String idKey = "ucId";
		if (params.containsKey(idKey)) {
			return params.get(idKey);
		}
		return null;
	}

	public Map<String, Object> saveUserCertApi(CtUserCertVo ctUserCertVo) {
		return ctUserCertClient.saveUserCertApi(ctUserCertVo);
	}
}
