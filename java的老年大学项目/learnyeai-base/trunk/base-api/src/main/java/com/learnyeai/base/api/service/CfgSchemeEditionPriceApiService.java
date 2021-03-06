package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.CfgSchemeEditionPriceClient;
import com.learnyeai.base.api.vo.CfgSchemeEditionPriceVo;
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
public class CfgSchemeEditionPriceApiService extends BaseClientService<CfgSchemeEditionPriceVo> {
    @Autowired
    private CfgSchemeEditionPriceClient cfgSchemeEditionPriceClient;

    @Override
    public BaseFeignClient<CfgSchemeEditionPriceVo> getFeignClient() {
        return cfgSchemeEditionPriceClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "edtPrcId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
