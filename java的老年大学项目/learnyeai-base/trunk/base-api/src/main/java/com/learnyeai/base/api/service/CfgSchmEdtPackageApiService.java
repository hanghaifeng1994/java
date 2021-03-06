package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.CfgSchmEdtPackageClient;
import com.learnyeai.base.api.vo.CfgSchmEdtPackageVo;
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
public class CfgSchmEdtPackageApiService extends BaseClientService<CfgSchmEdtPackageVo> {
    @Autowired
    private CfgSchmEdtPackageClient cfgSchmEdtPackageClient;

    @Override
    public BaseFeignClient<CfgSchmEdtPackageVo> getFeignClient() {
        return cfgSchmEdtPackageClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "edtPkgId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
