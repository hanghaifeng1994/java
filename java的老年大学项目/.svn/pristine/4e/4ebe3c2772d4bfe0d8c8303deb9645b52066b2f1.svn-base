package com.learnyeai.course.service;

import com.learnyeai.course.model.CrsPtrescsCourseRel;
import com.learnyeai.course.mapper.CrsPtrescsCourseRelMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author twang
 */
@Service
public class CrsPtrescsCourseRelWyService extends WeyeBaseService<CrsPtrescsCourseRel> {

    @Resource
    private CrsPtrescsCourseRelMapper crsPtrescsCourseRelMapper;

    @Override
    public BaseMapper<CrsPtrescsCourseRel> getMapper() {
        return crsPtrescsCourseRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
