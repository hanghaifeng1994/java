package com.learnyeai.base.service;

import com.learnyeai.base.model.CfgModule;
import com.learnyeai.base.mapper.CfgModuleMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class CfgModuleWyService extends WeyeBaseService<CfgModule> {

    @Resource
    private CfgModuleMapper cfgModuleMapper;

    @Override
    public BaseMapper<CfgModule> getMapper() {
        return cfgModuleMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
}
