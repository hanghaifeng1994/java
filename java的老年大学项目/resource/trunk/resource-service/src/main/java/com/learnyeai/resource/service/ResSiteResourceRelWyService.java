package com.learnyeai.resource.service;

import com.learnyeai.resource.model.ResSiteResourceRel;
import com.learnyeai.resource.mapper.ResSiteResourceRelMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author twang
 */
@Service
public class ResSiteResourceRelWyService extends WeyeBaseService<ResSiteResourceRel> {

    @Resource
    private ResSiteResourceRelMapper resSiteResourceRelMapper;

    @Override
    public BaseMapper<ResSiteResourceRel> getMapper() {
        return resSiteResourceRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    
    @Override
    public ResSiteResourceRel queryOne(ResSiteResourceRel t) {
    	return super.queryOne(t);
    }
}
