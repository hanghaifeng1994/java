package com.learnyeai.orderform.api.service;

import com.learnyeai.orderform.api.vo.OrdOrderformVo;
import com.learnyeai.orderform.api.client.OrdOrderformClient;

import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.learnai.support.BaseClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 *
 * @author twang
 */
@Service
public class OrdOrderformApiService extends BaseClientService<OrdOrderformVo> {
    @Autowired
    private OrdOrderformClient ordOrderformClient;

    @Override
    public BaseFeignClient<OrdOrderformVo> getFeignClient() {
        return ordOrderformClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "orderId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
