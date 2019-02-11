package com.learnyeai.base.service;

import com.learnyeai.base.model.CfgApplet;
import com.learnyeai.base.mapper.CfgAppletMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class CfgAppletWyService extends WeyeBaseService<CfgApplet> {

    @Resource
    private CfgAppletMapper cfgAppletMapper;

    @Override
    public BaseMapper<CfgApplet> getMapper() {
        return cfgAppletMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
}
