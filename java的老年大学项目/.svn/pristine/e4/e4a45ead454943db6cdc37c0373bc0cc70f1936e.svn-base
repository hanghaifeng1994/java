package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.CfgSchemeClient;
import com.learnyeai.base.api.vo.CfgSchemeVo;
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
public class CfgSchemeApiService extends BaseClientService<CfgSchemeVo> {
    @Autowired
    private CfgSchemeClient cfgSchemeClient;

    @Override
    public BaseFeignClient<CfgSchemeVo> getFeignClient() {
        return cfgSchemeClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "schmId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
