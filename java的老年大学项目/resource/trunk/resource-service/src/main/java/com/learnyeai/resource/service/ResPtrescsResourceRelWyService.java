package com.learnyeai.resource.service;

import com.learnyeai.resource.model.ResPtrescsResourceRel;
import com.learnyeai.resource.mapper.ResPtrescsResourceRelMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author twang
 */
@Service
public class ResPtrescsResourceRelWyService extends WeyeBaseService<ResPtrescsResourceRel> {

    @Resource
    private ResPtrescsResourceRelMapper resPtrescsResourceRelMapper;

    @Override
    public BaseMapper<ResPtrescsResourceRel> getMapper() {
        return resPtrescsResourceRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
