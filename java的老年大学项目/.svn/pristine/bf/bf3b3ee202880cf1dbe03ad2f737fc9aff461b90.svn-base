package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.ShMerchantSchemePackageClient;
import com.learnyeai.base.api.vo.ShMerchantSchemePackageVo;
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
public class ShMerchantSchemePackageApiService extends BaseClientService<ShMerchantSchemePackageVo> {
    @Autowired
    private ShMerchantSchemePackageClient shMerchantSchemePackageClient;

    @Override
    public BaseFeignClient<ShMerchantSchemePackageVo> getFeignClient() {
        return shMerchantSchemePackageClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "mspId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
