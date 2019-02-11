package com.learnyeai.base.web.api;

import com.learnyeai.base.model.CfgFunction;
import com.learnyeai.base.service.CfgFunctionWyService;
import com.learnyeai.learnai.support.ApiBaseController;
import com.learnyeai.learnai.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhangpz
 */
@RestController
@RequestMapping("${adminPath}" + CfgFunctionAction.BASE_URL)
public class CfgFunctionAction extends ApiBaseController<CfgFunction> {
    public static final String BASE_URL = "/CfgFunction/";

    @Autowired
    private CfgFunctionWyService cfgFunctionWyService;

    @Override
    protected BaseService<CfgFunction> getBaseService() {
        return cfgFunctionWyService;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }

    /**
     * 查询所有的资源权限，url与权限都不为空
     * @return
     */
    @RequestMapping("/queryAllUrl2Perms")
    public Map<String,String> queryAllUrl2Perms(){
        return cfgFunctionWyService.queryAllUrl2Perms();
    }
    /**
     * 查询用户权限
     * @param custId
     * @return
     */
    @RequestMapping("/queryUserPermNames/{custId}")
    public Collection<String> queryUserPermNames(@PathVariable String custId){
        return cfgFunctionWyService.queryUserPermNames(custId);
    }
}
