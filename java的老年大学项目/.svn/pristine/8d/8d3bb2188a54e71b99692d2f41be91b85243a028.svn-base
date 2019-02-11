package com.learnyeai.orderform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.orderform.model.OrdOrderformDetail;
import com.learnyeai.orderform.service.OrdOrderformDetailWyService;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + OrdOrderformDetailController.BASE_URL)
public class OrdOrderformDetailController extends BaseController<OrdOrderformDetail> {
    public static final String BASE_URL = "/OrdOrderformDetail/";

    @Autowired
    private OrdOrderformDetailWyService ordOrderformDetailWyService;

    @Override
    protected BaseService<OrdOrderformDetail> getService() {
        return ordOrderformDetailWyService;
    }
    
}
