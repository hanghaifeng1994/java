package com.learnyeai.base.service;

import com.learnyeai.base.model.ShOrder;
import com.learnyeai.base.mapper.ShOrderMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class ShOrderWyService extends WeyeBaseService<ShOrder> {

    @Resource
    private ShOrderMapper shOrderMapper;

    @Override
    public BaseMapper<ShOrder> getMapper() {
        return shOrderMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
