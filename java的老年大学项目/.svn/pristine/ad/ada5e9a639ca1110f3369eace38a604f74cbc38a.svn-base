package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.PtsetPlatformClient;
import com.learnyeai.base.api.vo.PtsetPlatformVo;
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
public class PtsetPlatformApiService extends BaseClientService<PtsetPlatformVo> {
    @Autowired
    private PtsetPlatformClient ptsetPlatformClient;

    @Override
    public BaseFeignClient<PtsetPlatformVo> getFeignClient() {
        return ptsetPlatformClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "ptId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
