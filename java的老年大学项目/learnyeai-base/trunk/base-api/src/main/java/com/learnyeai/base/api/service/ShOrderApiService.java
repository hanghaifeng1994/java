package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.ShOrderClient;
import com.learnyeai.base.api.vo.ShOrderVo;
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
public class ShOrderApiService extends BaseClientService<ShOrderVo> {
    @Autowired
    private ShOrderClient shOrderClient;

    @Override
    public BaseFeignClient<ShOrderVo> getFeignClient() {
        return shOrderClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "ordId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
