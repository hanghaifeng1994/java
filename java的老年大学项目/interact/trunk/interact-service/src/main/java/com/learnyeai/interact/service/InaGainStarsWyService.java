package com.learnyeai.interact.service;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.interact.model.InaGainStars;
import com.learnyeai.interact.mapper.InaGainStarsMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author yl
 */
@Service
public class InaGainStarsWyService extends WeyeBaseService<InaGainStars> {

    @Resource
    private InaGainStarsMapper inaGainStarsMapper;

    @Override
    public BaseMapper<InaGainStars> getMapper() {
        return inaGainStarsMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
}
