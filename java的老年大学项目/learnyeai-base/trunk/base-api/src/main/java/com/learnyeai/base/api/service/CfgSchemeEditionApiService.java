package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.CfgSchemeEditionClient;
import com.learnyeai.base.api.vo.CfgSchemeEditionVo;
import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.learnai.support.BaseClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 * @author zhangpz
 */
@Service
public class CfgSchemeEditionApiService extends BaseClientService<CfgSchemeEditionVo> {
    @Autowired
    private CfgSchemeEditionClient cfgSchemeEditionClient;

    @Override
    public BaseFeignClient<CfgSchemeEditionVo> getFeignClient() {
        return cfgSchemeEditionClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "schmEdtId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
