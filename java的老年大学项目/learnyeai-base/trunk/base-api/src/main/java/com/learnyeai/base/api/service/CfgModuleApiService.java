package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.CfgModuleClient;
import com.learnyeai.base.api.vo.CfgModuleVo;
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
public class CfgModuleApiService extends BaseClientService<CfgModuleVo> {
    @Autowired
    private CfgModuleClient cfgModuleClient;

    @Override
    public BaseFeignClient<CfgModuleVo> getFeignClient() {
        return cfgModuleClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "mdlId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
