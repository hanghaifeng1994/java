package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.CfgAppletClient;
import com.learnyeai.base.api.vo.CfgAppletVo;
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
public class CfgAppletApiService extends BaseClientService<CfgAppletVo> {
    @Autowired
    private CfgAppletClient cfgAppletClient;

    @Override
    public BaseFeignClient<CfgAppletVo> getFeignClient() {
        return cfgAppletClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "apltId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
