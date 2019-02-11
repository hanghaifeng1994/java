package com.learnyeai.base.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.base.model.CfgFunction;
import com.learnyeai.base.service.CfgFunctionWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zhangpz
 */
@Component
public class CfgFunctionController extends BaseController<CfgFunction> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CfgFunctionWyService cfgFunctionWyService;

    @Override
    protected Object doDispached(IBusinessContext context, String method) {
        Object rst = null;
        if(method.equals("queryMngFuncTree"))
            rst = queryMngFuncTree(context);
        else if(method.equals("queryFrontFuncTree"))
            rst = queryFrontFuncTree(context);

        return rst;
    }

    @Override
    protected BaseService<CfgFunction> getService() {
        return cfgFunctionWyService;
    }

    public Object queryMngFuncTree(IBusinessContext ctx){
        CfgFunction func = new CfgFunction();
        func.setFuncType("1");
        return cfgFunctionWyService.querySortTree(func);
    }

    public Object queryFrontFuncTree(IBusinessContext ctx){
        CfgFunction func = new CfgFunction();
        func.setFuncType("2");
        return cfgFunctionWyService.querySortTree(func);
    }
}
