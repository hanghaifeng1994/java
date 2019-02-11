package com.learnyeai.course.service;

import com.learnyeai.course.model.CrsSiteCatalogRel;
import com.learnyeai.course.mapper.CrsSiteCatalogRelMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author twang
 */
@Service
public class CrsSiteCatalogRelWyService extends WeyeBaseService<CrsSiteCatalogRel> {

    @Resource
    private CrsSiteCatalogRelMapper crsSiteCatalogRelMapper;

    @Override
    public BaseMapper<CrsSiteCatalogRel> getMapper() {
        return crsSiteCatalogRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
