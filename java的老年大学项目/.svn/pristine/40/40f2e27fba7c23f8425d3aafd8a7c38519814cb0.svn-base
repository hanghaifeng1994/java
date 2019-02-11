package com.learnyeai.base.service;

import com.learnyeai.base.model.TimeExpires;
import com.learnyeai.base.mapper.TimeExpiresMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class TimeExpiresWyService extends WeyeBaseService<TimeExpires> {

    @Resource
    private TimeExpiresMapper timeExpiresMapper;

    @Override
    public BaseMapper<TimeExpires> getMapper() {
        return timeExpiresMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
