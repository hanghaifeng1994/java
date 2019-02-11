package com.learnyeai.resultbill.service;

import com.learnyeai.resultbill.model.BilPointsRule;
import com.learnyeai.resultbill.mapper.BilPointsRuleMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author yl
 */
@Service
public class BilPointsRuleWyService extends WeyeBaseService<BilPointsRule> {

    @Resource
    private BilPointsRuleMapper bilPointsRuleMapper;

    @Override
    public BaseMapper<BilPointsRule> getMapper() {
        return bilPointsRuleMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
