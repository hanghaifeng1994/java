package com.learnyeai.activity.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.activity.model.ActCategoryActivity;
import com.learnyeai.activity.service.ActCategoryActivityWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class ActCategoryActivityController extends BaseController<ActCategoryActivity> {

    @Autowired
    private ActCategoryActivityWyService actCategoryActivityWyService;

    @Override
    protected BaseService<ActCategoryActivity> getService() {
        return actCategoryActivityWyService;
    }
}
