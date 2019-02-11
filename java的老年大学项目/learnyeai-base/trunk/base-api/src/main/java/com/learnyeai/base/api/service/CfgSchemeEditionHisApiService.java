package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.CfgSchemeEditionHisClient;
import com.learnyeai.base.api.vo.CfgSchemeEditionHisVo;
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
public class CfgSchemeEditionHisApiService extends BaseClientService<CfgSchemeEditionHisVo> {
    @Autowired
    private CfgSchemeEditionHisClient cfgSchemeEditionHisClient;

    @Override
    public BaseFeignClient<CfgSchemeEditionHisVo> getFeignClient() {
        return cfgSchemeEditionHisClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "schmEdtHisId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
