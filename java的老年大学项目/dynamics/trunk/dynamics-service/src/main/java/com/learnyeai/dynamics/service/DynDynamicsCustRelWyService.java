package com.learnyeai.dynamics.service;

import com.learnyeai.dynamics.model.DynDynamicsCustRel;
import com.learnyeai.dynamics.mapper.DynDynamicsCustRelMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author yl
 */
@Service
public class DynDynamicsCustRelWyService extends WeyeBaseService<DynDynamicsCustRel> {

    @Resource
    private DynDynamicsCustRelMapper dynDynamicsCustRelMapper;

    @Override
    public BaseMapper<DynDynamicsCustRel> getMapper() {
        return dynDynamicsCustRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
