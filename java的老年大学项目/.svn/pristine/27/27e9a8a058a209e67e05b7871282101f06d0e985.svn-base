package com.learnyeai.base.service;

import com.learnyeai.base.model.TimeExpiresBk;
import com.learnyeai.base.mapper.TimeExpiresBkMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class TimeExpiresBkWyService extends WeyeBaseService<TimeExpiresBk> {

    @Resource
    private TimeExpiresBkMapper timeExpiresBkMapper;

    @Override
    public BaseMapper<TimeExpiresBk> getMapper() {
        return timeExpiresBkMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
