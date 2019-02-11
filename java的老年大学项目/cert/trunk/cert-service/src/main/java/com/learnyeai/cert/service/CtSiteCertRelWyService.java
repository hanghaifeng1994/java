package com.learnyeai.cert.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.learnyeai.cert.mapper.CtSiteCertRelMapper;
import com.learnyeai.cert.model.CtSiteCertRel;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;

/**
 *
 * @author twang
 */
@Service
public class CtSiteCertRelWyService extends WeyeBaseService<CtSiteCertRel> {

    @Resource
    private CtSiteCertRelMapper ctSiteCertRelMapper;

    @Override
    public BaseMapper<CtSiteCertRel> getMapper() {
        return ctSiteCertRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
