package com.learnyeai.setting.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.setting.model.SetAbout;
import com.learnyeai.setting.service.SetAboutWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author zhangpz
 */
@Component
public class SetAboutController extends BaseController<SetAbout> {

    @Autowired
    private SetAboutWyService setAboutWyService;

    @Override
    protected BaseService<SetAbout> getService() {
        return setAboutWyService;
    }

    @Override
    protected Object doDispached(IBusinessContext context, String method) {
        Object rst = null;
        if(method.equals("getSiteAbout")){
            rst = getSiteAbout(context);
        }

        return rst;
    }

    // 获取站点关于
    public Object getSiteAbout(IBusinessContext ctx){
        List<SetAbout> list = setAboutWyService.queryList(null, ctx.getParamMap());
        if(list.size() > 0){
            return list.get(0);
        }

        return new SetAbout();
    }

}
