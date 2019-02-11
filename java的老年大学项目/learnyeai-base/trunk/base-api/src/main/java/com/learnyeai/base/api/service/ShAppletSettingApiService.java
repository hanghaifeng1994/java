package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.ShAppletSettingClient;
import com.learnyeai.base.api.vo.ShAppletSettingVo;
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
public class ShAppletSettingApiService extends BaseClientService<ShAppletSettingVo> {
    @Autowired
    private ShAppletSettingClient shAppletSettingClient;

    @Override
    public BaseFeignClient<ShAppletSettingVo> getFeignClient() {
        return shAppletSettingClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "apltSetId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
