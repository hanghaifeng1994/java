package com.learnyeai.schoolclass.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.schoolclass.model.ClzClazzBatch;
import com.learnyeai.schoolclass.service.ClzClazzBatchWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ClzClazzBatchController.BASE_URL)
public class ClzClazzBatchController extends BaseController<ClzClazzBatch> {
    public static final String BASE_URL = "/ClzClazzBatch/";

    @Autowired
    private ClzClazzBatchWyService clzClazzBatchWyService;

    @Override
    protected BaseService<ClzClazzBatch> getService() {
        return clzClazzBatchWyService;
    }
}
