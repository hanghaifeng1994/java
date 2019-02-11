package com.learnyeai.base.service;

import com.learnyeai.base.model.CfgSchmEdtPackage;
import com.learnyeai.base.mapper.CfgSchmEdtPackageMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class CfgSchmEdtPackageWyService extends WeyeBaseService<CfgSchmEdtPackage> {

    @Resource
    private CfgSchmEdtPackageMapper cfgSchmEdtPackageMapper;

    @Override
    public BaseMapper<CfgSchmEdtPackage> getMapper() {
        return cfgSchmEdtPackageMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
