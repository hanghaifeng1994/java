package com.learnyeai.resultbill.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.resultbill.model.BilPointsRule;
import com.learnyeai.resultbill.service.BilPointsRuleWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class BilPointsRuleController extends BaseController<BilPointsRule> {

    @Autowired
    private BilPointsRuleWyService bilPointsRuleWyService;

    @Override
    protected BaseService<BilPointsRule> getService() {
        return bilPointsRuleWyService;
    }
}
