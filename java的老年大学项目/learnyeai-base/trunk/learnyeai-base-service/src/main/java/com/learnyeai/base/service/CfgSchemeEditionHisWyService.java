package com.learnyeai.base.service;

import com.learnyeai.base.model.CfgSchemeEditionHis;
import com.learnyeai.base.mapper.CfgSchemeEditionHisMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class CfgSchemeEditionHisWyService extends WeyeBaseService<CfgSchemeEditionHis> {

    @Resource
    private CfgSchemeEditionHisMapper cfgSchemeEditionHisMapper;

    @Override
    public BaseMapper<CfgSchemeEditionHis> getMapper() {
        return cfgSchemeEditionHisMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
