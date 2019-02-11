package com.learnyeai.base.service;

import com.learnyeai.base.model.CfgSchemeEdition;
import com.learnyeai.base.mapper.CfgSchemeEditionMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class CfgSchemeEditionWyService extends WeyeBaseService<CfgSchemeEdition> {

    @Resource
    private CfgSchemeEditionMapper cfgSchemeEditionMapper;

    @Override
    public BaseMapper<CfgSchemeEdition> getMapper() {
        return cfgSchemeEditionMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
}
