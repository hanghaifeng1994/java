package com.learnyeai.base.service;

import com.learnyeai.base.model.CfgScheme;
import com.learnyeai.base.mapper.CfgSchemeMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class CfgSchemeWyService extends WeyeBaseService<CfgScheme> {

    @Resource
    private CfgSchemeMapper cfgSchemeMapper;

    @Override
    public BaseMapper<CfgScheme> getMapper() {
        return cfgSchemeMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
}
