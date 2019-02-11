package com.learnyeai.news.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.common.support.WeyeBaseService;

import com.learnyeai.news.model.NewsSiteCategoryRel;
import com.learnyeai.news.service.NewsSiteCategoryRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class NewsSiteCategoryRelController extends BaseController<NewsSiteCategoryRel> {

    @Autowired
    private NewsSiteCategoryRelWyService newsSiteCategoryRelWyService;

    @Override
    protected WeyeBaseService<NewsSiteCategoryRel> getService() {
        return newsSiteCategoryRelWyService;
    }
}
