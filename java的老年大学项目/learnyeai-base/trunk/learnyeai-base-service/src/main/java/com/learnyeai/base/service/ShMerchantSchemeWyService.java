package com.learnyeai.base.service;

import com.learnyeai.base.api.util.BaseCons;
import com.learnyeai.base.model.ShMerchantScheme;
import com.learnyeai.base.mapper.ShMerchantSchemeMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@CacheConfig(cacheNames = BaseCons.CACHE_MERCHANTSCHEME)
@Service
public class ShMerchantSchemeWyService extends WeyeBaseService<ShMerchantScheme> {

    @Resource
    private ShMerchantSchemeMapper shMerchantSchemeMapper;

    @Override
    public BaseMapper<ShMerchantScheme> getMapper() {
        return shMerchantSchemeMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @CacheEvict(key = "#shMerchantScheme.mchtSchmId")
    @Override
    public int save(ShMerchantScheme shMerchantScheme) {
        return super.save(shMerchantScheme);
    }

    @CacheEvict(key = "#shMerchantScheme.mchtSchmId")
    @Override
    public int delete(ShMerchantScheme shMerchantScheme) {
        return super.delete(shMerchantScheme);
    }

    @CacheEvict
    @Override
    public int deleteById(Object id) {
        return super.deleteById(id);
    }

    @Cacheable
    @Override
    public ShMerchantScheme queryById(Object id) {
        return super.queryById(id);
    }
}
