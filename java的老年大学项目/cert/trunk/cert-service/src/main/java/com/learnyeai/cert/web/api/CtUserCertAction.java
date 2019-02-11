package com.learnyeai.cert.web.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.cert.api.vo.CtUserCertVo;
import com.learnyeai.cert.model.CtUserCert;
import com.learnyeai.cert.service.CtUserCertWyService;
import com.learnyeai.learnai.support.ApiBaseController;
import com.learnyeai.learnai.support.BaseService;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CtUserCertAction.BASE_URL)
public class CtUserCertAction extends ApiBaseController<CtUserCert> {
	public static final String BASE_URL = "/CtUserCert/";

	@Autowired
	private CtUserCertWyService ctUserCertWyService;

	@Override
	protected BaseService<CtUserCert> getBaseService() {
		return ctUserCertWyService;
	}

	@Override
	public String getBaseUrl() {
		return BASE_URL;
	}

	@RequestMapping(value = "/saveUserCertApi")
	public Map<String, Object> saveUserCertApi(CtUserCertVo ctUserCertVo) {
		return ctUserCertWyService.saveUserCertApi(ctUserCertVo);
	}
}
