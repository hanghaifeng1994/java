package com.learnyeai.schoolclass.api.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.schoolclass.api.vo.CtUserCertVo;

/**
 * 学员证书
 *
 * @author twang
 */
@FeignClient(name = "${CERT-SERVICE-NAME}", path = "${CERT-SERVICE-CONTEXT-PATH}/CtUserCert")
public interface CtUserCertClient extends BaseFeignClient<CtUserCertVo> {

	@RequestMapping(value = "saveUserCertApi", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Map<String, Object> saveUserCertApi(@RequestBody CtUserCertVo ctUserCertVo);
}
