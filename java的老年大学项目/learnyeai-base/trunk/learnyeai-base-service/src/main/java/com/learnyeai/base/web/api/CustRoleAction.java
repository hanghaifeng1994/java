package com.learnyeai.base.web.api;

import com.learnyeai.base.model.CustRole;
import com.learnyeai.base.service.CustRoleWyService;
import com.learnyeai.learnai.support.ApiBaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * @author zhangpz
 */
@RestController
@RequestMapping("${adminPath}" + CustRoleAction.BASE_URL)
public class CustRoleAction extends ApiBaseController<CustRole> {
    public static final String BASE_URL = "/CustRole/";

    @Autowired
    private CustRoleWyService custRoleWyService;

    @Override
    protected BaseService<CustRole> getBaseService() {
        return custRoleWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }

    @RequestMapping("/queryUserRoleNames/{custId}")
    public List<String> queryUserRoleNames(@PathVariable String custId){
        return custRoleWyService.queryUserRoleEnames(custId);
    }
}
