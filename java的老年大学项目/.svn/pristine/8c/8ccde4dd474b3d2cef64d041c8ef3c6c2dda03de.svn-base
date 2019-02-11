package com.learnyeai.album.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.album.model.AbmPhotoGroup;
import com.learnyeai.album.service.AbmPhotoGroupWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author yl
 */
@Component
public class AbmPhotoGroupController extends BaseController<AbmPhotoGroup> {

    @Autowired
    private AbmPhotoGroupWyService abmPhotoGroupWyService;

    @Override
    protected BaseService<AbmPhotoGroup> getService() {
        return abmPhotoGroupWyService;
    }
}
