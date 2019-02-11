package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.ShStoreClient;
import com.learnyeai.base.api.vo.ShStoreVo;
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
public class ShStoreApiService extends BaseClientService<ShStoreVo> {
    @Autowired
    private ShStoreClient shStoreClient;

    @Override
    public BaseFeignClient<ShStoreVo> getFeignClient() {
        return shStoreClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "storeId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
