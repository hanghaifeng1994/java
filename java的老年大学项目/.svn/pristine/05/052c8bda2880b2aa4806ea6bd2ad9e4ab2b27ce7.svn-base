package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.CustRoleClient;
import com.learnyeai.base.api.vo.CustRoleVo;
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
public class CustRoleApiService extends BaseClientService<CustRoleVo> {
    @Autowired
    private CustRoleClient custRoleClient;

    @Override
    public BaseFeignClient<CustRoleVo> getFeignClient() {
        return custRoleClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "roleId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
