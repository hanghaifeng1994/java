package com.learnyeai.base.service;

import com.learnyeai.base.api.util.BaseCons;
import com.learnyeai.base.model.ShMerchant;
import com.learnyeai.base.mapper.ShMerchantMapper;
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
@CacheConfig(cacheNames = BaseCons.CACHE_MERCHANT)
@Service
public class ShMerchantWyService extends WeyeBaseService<ShMerchant> {

    @Resource
    private ShMerchantMapper shMerchantMapper;

    @Override
    public BaseMapper<ShMerchant> getMapper() {
        return shMerchantMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @CacheEvict(key = "#shMerchant.mchtId")
    @Override
    public int save(ShMerchant shMerchant) {
        return super.save(shMerchant);
    }

    @CacheEvict(key = "#shMerchant.mchtId")
    @Override
    public int delete(ShMerchant shMerchant) {
        return super.delete(shMerchant);
    }

    @CacheEvict
    @Override
    public int deleteById(Object id) {
        return super.deleteById(id);
    }

    @Cacheable
    @Override
    public ShMerchant queryById(Object id) {
        return super.queryById(id);
    }
}
