package com.learnyeai.course.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.course.model.CrsCustLearnChapter;
import com.learnyeai.course.service.CrsCustLearnChapterWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + CrsCustLearnChapterController.BASE_URL)
public class CrsCustLearnChapterController extends BaseController<CrsCustLearnChapter> {
    public static final String BASE_URL = "/CrsCustLearnChapter/";

    @Autowired
    private CrsCustLearnChapterWyService crsCustLearnChapterWyService;

    @Override
    protected BaseService<CrsCustLearnChapter> getService() {
        return crsCustLearnChapterWyService;
    }
}
