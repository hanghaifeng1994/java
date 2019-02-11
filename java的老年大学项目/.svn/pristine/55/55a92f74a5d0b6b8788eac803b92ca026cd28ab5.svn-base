package com.learnyeai.base.service;

import com.learnyeai.base.model.CfgSchemeEditionPrice;
import com.learnyeai.base.mapper.CfgSchemeEditionPriceMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class CfgSchemeEditionPriceWyService extends WeyeBaseService<CfgSchemeEditionPrice> {

    @Resource
    private CfgSchemeEditionPriceMapper cfgSchemeEditionPriceMapper;

    @Override
    public BaseMapper<CfgSchemeEditionPrice> getMapper() {
        return cfgSchemeEditionPriceMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
}
