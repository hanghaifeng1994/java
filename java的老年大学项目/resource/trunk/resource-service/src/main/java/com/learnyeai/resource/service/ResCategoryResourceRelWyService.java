package com.learnyeai.resource.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.resource.mapper.ResCategoryResourceRelMapper;
import com.learnyeai.resource.model.ResCategoryResourceRel;

/**
 *
 * @author twang
 */
@Service
public class ResCategoryResourceRelWyService extends WeyeBaseService<ResCategoryResourceRel> {

    @Resource
    private ResCategoryResourceRelMapper resCategoryResourceRelMapper;

    @Override
    public BaseMapper<ResCategoryResourceRel> getMapper() {
        return resCategoryResourceRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
