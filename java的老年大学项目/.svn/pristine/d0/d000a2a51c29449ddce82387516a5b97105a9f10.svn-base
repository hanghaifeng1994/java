package com.learnyeai.base.service;

import com.learnyeai.base.model.CfgSchmEdtPackageHis;
import com.learnyeai.base.mapper.CfgSchmEdtPackageHisMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class CfgSchmEdtPackageHisWyService extends WeyeBaseService<CfgSchmEdtPackageHis> {

    @Resource
    private CfgSchmEdtPackageHisMapper cfgSchmEdtPackageHisMapper;

    @Override
    public BaseMapper<CfgSchmEdtPackageHis> getMapper() {
        return cfgSchmEdtPackageHisMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
