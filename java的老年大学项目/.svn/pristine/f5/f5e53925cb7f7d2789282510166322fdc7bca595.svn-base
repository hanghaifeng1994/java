package com.learnyeai.setting.service;

import com.learnyeai.learnai.consts.PtCons;
import com.learnyeai.setting.model.SetPromotion;
import com.learnyeai.setting.mapper.SetPromotionMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhangpz
 */
@Service
public class SetPromotionWyService extends WeyeBaseService<SetPromotion> {

    @Resource
    private SetPromotionMapper setPromotionMapper;

    @Override
    public BaseMapper<SetPromotion> getMapper() {
        return setPromotionMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected Weekend<SetPromotion> genSqlExample(SetPromotion setPromotion, Map params) {
        Weekend<SetPromotion> weekend = super.genSqlExample(setPromotion, params);
        WeekendCriteria<SetPromotion, Object> c = weekend.createCriteriaAddOn();
        weekend.and(c);
        if(StringUtils.isNotBlank(setPromotion.getStatus())){
            c.andEqualTo(SetPromotion::getStatus, setPromotion.getStatus());
        }
        if(StringUtils.isNotBlank(setPromotion.getServiceType())){
            c.andEqualTo(SetPromotion::getServiceType, setPromotion.getServiceType());
        }
        return weekend;
    }

    @CacheEvict(cacheNames = "SetPromotion-site", allEntries = true)
    @Override
    public int save(SetPromotion setPromotion) {
        String id = setPromotion.getId();
        // 新建
        if(StringUtils.isBlank(id)){
            setPromotion.setStatus(PtCons.ENABLE_DISABLE.D.getVal());
            setPromotion.setSort(0l);
        }else {
            setPromotion.setStatus(null);
        }
        return super.save(setPromotion);
    }

    @CacheEvict(cacheNames = "SetPromotion-site", allEntries = true)
    @Transactional
    public void enable(String[] ids, boolean enabled){
        String val = enabled ? PtCons.ENABLE_DISABLE.E.getVal() : PtCons.ENABLE_DISABLE.D.getVal();
        SetPromotion entity = new SetPromotion();
        entity.setStatus(val);
        for(String id : ids){
            if(StringUtils.isBlank(id))
                continue;
            entity.setId(id);
            getMapper().updateByPrimaryKeySelective(entity);
        }
    }

    @CacheEvict(cacheNames = "SetPromotion-site", allEntries = true)
    @Override
    public int delete(SetPromotion setPromotion) {
        return super.delete(setPromotion);
    }

    @Cacheable(cacheNames = "SetPromotion-site",key = "#siteId + #type")
    public List<SetPromotion> querySitePromotions(String siteId, String type){
        Map pp = new HashMap();
        pp.put("serviceType", type);
        pp.put("siteId", siteId);
        pp.put("status","1");
        pp.put("sorts", "sort=0");
        return super.queryList(null, pp);
    }
}
