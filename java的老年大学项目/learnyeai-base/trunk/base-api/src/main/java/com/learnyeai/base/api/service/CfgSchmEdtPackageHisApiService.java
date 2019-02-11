package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.CfgSchmEdtPackageHisClient;
import com.learnyeai.base.api.vo.CfgSchmEdtPackageHisVo;
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
public class CfgSchmEdtPackageHisApiService extends BaseClientService<CfgSchmEdtPackageHisVo> {
    @Autowired
    private CfgSchmEdtPackageHisClient cfgSchmEdtPackageHisClient;

    @Override
    public BaseFeignClient<CfgSchmEdtPackageHisVo> getFeignClient() {
        return cfgSchmEdtPackageHisClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "edtPkgHisId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
