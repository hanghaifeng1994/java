package com.learnyeai.schoolclass.api.service;

import com.learnyeai.schoolclass.api.vo.ClzClazzTestVo;
import com.learnyeai.schoolclass.api.client.ClzClazzTestClient;

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
public class ClzClazzTestApiService extends BaseClientService<ClzClazzTestVo> {
    @Autowired
    private ClzClazzTestClient clzClazzTestClient;

    @Override
    public BaseFeignClient<ClzClazzTestVo> getFeignClient() {
        return clzClazzTestClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "ctId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
}
