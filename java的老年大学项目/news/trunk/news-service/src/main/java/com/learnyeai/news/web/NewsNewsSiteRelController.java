package com.learnyeai.news.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.common.support.WeyeBaseService;

import com.learnyeai.news.model.NewsNewsSiteRel;
import com.learnyeai.news.service.NewsNewsSiteRelWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class NewsNewsSiteRelController extends BaseController<NewsNewsSiteRel> {

    @Autowired
    private NewsNewsSiteRelWyService newsNewsSiteRelWyService;

    @Override
    protected WeyeBaseService<NewsNewsSiteRel> getService() {
        return newsNewsSiteRelWyService;
    }
}
