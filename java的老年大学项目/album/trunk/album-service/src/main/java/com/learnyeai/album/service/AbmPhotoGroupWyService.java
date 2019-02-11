package com.learnyeai.album.service;

import com.learnyeai.album.model.AbmPhotoGroup;
import com.learnyeai.album.mapper.AbmPhotoGroupMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author yl
 */
@Service
public class AbmPhotoGroupWyService extends WeyeBaseService<AbmPhotoGroup> {

    @Resource
    private AbmPhotoGroupMapper abmPhotoGroupMapper;

    @Override
    public BaseMapper<AbmPhotoGroup> getMapper() {
        return abmPhotoGroupMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
}
