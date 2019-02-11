package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.CfgFunctionClient;
import com.learnyeai.base.api.vo.CfgFunctionVo;
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
public class CfgFunctionApiService extends BaseClientService<CfgFunctionVo> {
    @Autowired
    private CfgFunctionClient cfgFunctionClient;

    @Override
    public BaseFeignClient<CfgFunctionVo> getFeignClient() {
        return cfgFunctionClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "funcId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
