package com.learnyeai.album.service;

import com.learnyeai.album.model.AbmCustRel;
import com.learnyeai.album.mapper.AbmCustRelMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author yl
 */
@Service
public class AbmCustRelWyService extends WeyeBaseService<AbmCustRel> {

    @Resource
    private AbmCustRelMapper abmCustRelMapper;

    @Override
    public BaseMapper<AbmCustRel> getMapper() {
        return abmCustRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
