package com.learnyeai.cert.api.service;

import com.learnyeai.cert.api.vo.CtUserCertVo;
import com.learnyeai.cert.api.client.CtUserCertClient;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.learnai.support.BaseClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

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
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
