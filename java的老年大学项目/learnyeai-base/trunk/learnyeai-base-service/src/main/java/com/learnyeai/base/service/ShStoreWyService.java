package com.learnyeai.base.service;

import com.learnyeai.base.model.ShStore;
import com.learnyeai.base.mapper.ShStoreMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class ShStoreWyService extends WeyeBaseService<ShStore> {

    @Resource
    private ShStoreMapper shStoreMapper;

    @Override
    public BaseMapper<ShStore> getMapper() {
        return shStoreMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
}
