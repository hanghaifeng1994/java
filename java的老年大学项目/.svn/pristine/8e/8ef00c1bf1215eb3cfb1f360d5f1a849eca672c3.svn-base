package com.learnyeai.schoolclass.service;

import com.learnyeai.schoolclass.model.ClzSiteClazz;
import com.learnyeai.schoolclass.mapper.ClzSiteClazzMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author twang
 */
@Service
public class ClzSiteClazzWyService extends WeyeBaseService<ClzSiteClazz> {

    @Resource
    private ClzSiteClazzMapper clzSiteClazzMapper;

    @Override
    public BaseMapper<ClzSiteClazz> getMapper() {
        return clzSiteClazzMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
