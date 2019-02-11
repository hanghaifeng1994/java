package com.learnyeai.testing.service;

import com.learnyeai.testing.model.TestingPointCoverSet;
import com.learnyeai.testing.mapper.TestingPointCoverSetMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author twang
 */
@Service
public class TestingPointCoverSetWyService extends WeyeBaseService<TestingPointCoverSet> {

    @Resource
    private TestingPointCoverSetMapper testingPointCoverSetMapper;

    @Override
    public BaseMapper<TestingPointCoverSet> getMapper() {
        return testingPointCoverSetMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
