package com.learnyeai.album.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.album.model.AbmPhoto;
import com.learnyeai.album.service.AbmPhotoWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class AbmPhotoController extends BaseController<AbmPhoto> {

    @Autowired
    private AbmPhotoWyService abmPhotoWyService;

    @Override
    protected BaseService<AbmPhoto> getService() {
        return abmPhotoWyService;
    }

    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        if("save".equals(method)){
            abmPhotoWyService.saveData(ctx);
             return null;
        }
        if("delete".equals(method)){
            abmPhotoWyService.delBatch(ctx);
        }
        return super.execute(ctx);
    }
}
