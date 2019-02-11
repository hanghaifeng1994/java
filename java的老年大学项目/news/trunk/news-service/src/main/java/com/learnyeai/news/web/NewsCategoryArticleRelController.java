package com.learnyeai.news.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.common.support.WeyeBaseService;

import com.learnyeai.news.model.NewsCategoryArticleRel;
import com.learnyeai.news.service.NewsCategoryArticleRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class NewsCategoryArticleRelController extends BaseController<NewsCategoryArticleRel> {

    @Autowired
    private NewsCategoryArticleRelWyService newsCategoryArticleRelWyService;

    @Override
    protected WeyeBaseService<NewsCategoryArticleRel> getService() {
        return newsCategoryArticleRelWyService;
    }
}
