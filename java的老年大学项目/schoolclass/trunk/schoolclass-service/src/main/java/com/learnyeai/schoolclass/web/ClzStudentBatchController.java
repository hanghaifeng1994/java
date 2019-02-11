package com.learnyeai.schoolclass.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.schoolclass.model.ClzStudentBatch;
import com.learnyeai.schoolclass.service.ClzStudentBatchWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ClzStudentBatchController.BASE_URL)
public class ClzStudentBatchController extends BaseController<ClzStudentBatch> {
    public static final String BASE_URL = "/ClzStudentBatch/";

    @Autowired
    private ClzStudentBatchWyService clzStudentBatchWyService;

    @Override
    protected BaseService<ClzStudentBatch> getService() {
        return clzStudentBatchWyService;
    }
}
