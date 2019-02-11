package com.learnyeai.resultbill.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.resultbill.model.BilPoints;
import com.learnyeai.resultbill.service.BilPointsWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class BilPointsController extends BaseController<BilPoints> {

    @Autowired
    private BilPointsWyService bilPointsWyService;

    @Override
    protected BaseService<BilPoints> getService() {
        return bilPointsWyService;
    }

}
