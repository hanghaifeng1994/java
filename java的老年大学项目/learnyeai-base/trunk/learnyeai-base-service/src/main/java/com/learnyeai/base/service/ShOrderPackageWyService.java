package com.learnyeai.base.service;

import com.learnyeai.base.model.ShOrderPackage;
import com.learnyeai.base.mapper.ShOrderPackageMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class ShOrderPackageWyService extends WeyeBaseService<ShOrderPackage> {

    @Resource
    private ShOrderPackageMapper shOrderPackageMapper;

    @Override
    public BaseMapper<ShOrderPackage> getMapper() {
        return shOrderPackageMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
