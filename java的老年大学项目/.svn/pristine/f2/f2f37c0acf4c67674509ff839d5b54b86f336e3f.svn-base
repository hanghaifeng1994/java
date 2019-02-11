package com.learnyeai.schoolclass.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.schoolclass.model.ClzBatchCourse;
import com.learnyeai.schoolclass.service.ClzBatchCourseWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ClzBatchCourseController.BASE_URL)
public class ClzBatchCourseController extends BaseController<ClzBatchCourse> {
    public static final String BASE_URL = "/ClzBatchCourse/";

    @Autowired
    private ClzBatchCourseWyService clzBatchCourseWyService;

    @Override
    protected BaseService<ClzBatchCourse> getService() {
        return clzBatchCourseWyService;
    }
}
