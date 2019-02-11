package com.learnyeai.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.course.mapper.CrsCatalogCourseRelMapper;
import com.learnyeai.course.model.CrsCatalogCourseRel;
import com.learnyeai.learnai.support.BaseMapper;

/**
 *
 * @author twang
 */
@Service
public class CrsCatalogCourseRelWyService extends WeyeBaseService<CrsCatalogCourseRel> {

    @Resource
    private CrsCatalogCourseRelMapper crsCatalogCourseRelMapper;

    @Override
    public BaseMapper<CrsCatalogCourseRel> getMapper() {
        return crsCatalogCourseRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    
   
}
