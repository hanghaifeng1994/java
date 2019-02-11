package com.learnyeai.dynamics.service;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.dynamics.model.DynData;
import com.learnyeai.dynamics.mapper.DynDataMapper;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author yl
 */
@Service
public class DynDataWyService extends WeyeBaseService<DynData> {

    @Resource
    private DynDataMapper dynDataMapper;

    @Override
    public BaseMapper<DynData> getMapper() {
        return dynDataMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
