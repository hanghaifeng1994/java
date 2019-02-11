package com.learnyeai.homework.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.homework.model.WkHomeworkMarkHistory;
import com.learnyeai.homework.service.WkHomeworkMarkHistoryWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + WkHomeworkMarkHistoryController.BASE_URL)
public class WkHomeworkMarkHistoryController extends BaseController<WkHomeworkMarkHistory> {
    public static final String BASE_URL = "/WkHomeworkMarkHistory/";

    @Autowired
    private WkHomeworkMarkHistoryWyService wkHomeworkMarkHistoryWyService;

    @Override
    protected BaseService<WkHomeworkMarkHistory> getService() {
        return wkHomeworkMarkHistoryWyService;
    }
}
