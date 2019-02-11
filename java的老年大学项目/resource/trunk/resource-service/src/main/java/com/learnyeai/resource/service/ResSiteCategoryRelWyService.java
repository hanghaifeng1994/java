package com.learnyeai.resource.service;

import com.learnyeai.resource.model.ResSiteCategoryRel;
import com.learnyeai.resource.mapper.ResSiteCategoryRelMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author twang
 */
@Service
public class ResSiteCategoryRelWyService extends WeyeBaseService<ResSiteCategoryRel> {

    @Resource
    private ResSiteCategoryRelMapper resSiteCategoryRelMapper;

    @Override
    public BaseMapper<ResSiteCategoryRel> getMapper() {
        return resSiteCategoryRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
