package com.learnyeai.course.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.course.model.CrsCustLearnChapterRes;
import com.learnyeai.course.service.CrsCustLearnChapterResWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsCustLearnChapterResController.BASE_URL)
public class CrsCustLearnChapterResController extends BaseController<CrsCustLearnChapterRes> {
    public static final String BASE_URL = "/CrsCustLearnChapterRes/";

    @Autowired
    private CrsCustLearnChapterResWyService crsCustLearnChapterResWyService;

    @Override
    protected BaseService<CrsCustLearnChapterRes> getService() {
        return crsCustLearnChapterResWyService;
    }
}
