package com.learnyeai.testing.service;

import com.learnyeai.testing.model.TestingSitePool;
import com.learnyeai.testing.mapper.TestingSitePoolMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author twang
 */
@Service
public class TestingSitePoolWyService extends WeyeBaseService<TestingSitePool> {

    @Resource
    private TestingSitePoolMapper testingSitePoolMapper;

    @Override
    public BaseMapper<TestingSitePool> getMapper() {
        return testingSitePoolMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
