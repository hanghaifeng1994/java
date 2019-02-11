package com.learnyeai.resultbill.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.resultbill.model.BilCredit;
import com.learnyeai.resultbill.service.BilCreditWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class BilCreditController extends BaseController<BilCredit> {

    @Autowired
    private BilCreditWyService bilCreditWyService;

    @Override
    protected BaseService<BilCredit> getService() {
        return bilCreditWyService;
    }
}
