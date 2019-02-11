package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.ShMerchantSchemeClient;
import com.learnyeai.base.api.vo.ShMerchantSchemeVo;
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
public class ShMerchantSchemeApiService extends BaseClientService<ShMerchantSchemeVo> {
    @Autowired
    private ShMerchantSchemeClient shMerchantSchemeClient;

    @Override
    public BaseFeignClient<ShMerchantSchemeVo> getFeignClient() {
        return shMerchantSchemeClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "mchtSchmId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
