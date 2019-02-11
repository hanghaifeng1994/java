package com.learnyeai.setting.web;

import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import com.learnyeai.setting.model.SetAbout;
import com.learnyeai.setting.service.SetAboutWyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zpz on 2018/9/17.
 */
@Component
public class GetAboutController implements IController {
    @Autowired
    private SetAboutWyService setAboutWyService;

    @Override
    public Object execute(IBusinessContext ctx) {

        String siteId = WeyeThreadContextUtils.getSiteId();
        if(StringUtils.isBlank(siteId)){
            throw new AresRuntimeException();
        }
        ctx.setParam("siteId", siteId);
        SetAbout setAbout = setAboutWyService.querySiteAbout(siteId);
        if(null == setAbout){
            setAbout = new SetAbout();
        }

        return setAbout;
    }
}
