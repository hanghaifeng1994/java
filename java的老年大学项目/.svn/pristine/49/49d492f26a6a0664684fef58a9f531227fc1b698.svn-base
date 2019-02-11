package com.learnyeai.setting.service;

import com.learnyeai.learnai.consts.PtCons;
import com.learnyeai.setting.model.SetLinks;
import com.learnyeai.setting.mapper.SetLinksMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.setting.model.SetPromotion;
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
public class SetLinksWyService extends WeyeBaseService<SetLinks> {

    @Resource
    private SetLinksMapper setLinksMapper;

    @Override
    public BaseMapper<SetLinks> getMapper() {
        return setLinksMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected Weekend<SetLinks> genSqlExample(SetLinks setLinks, Map params) {
        Weekend<SetLinks> weekend = super.genSqlExample(setLinks, params);
        WeekendCriteria<SetLinks, Object> c = weekend.createCriteriaAddOn();
        weekend.and(c);
        if(StringUtils.isNotBlank(setLinks.getStatus())){
            c.andEqualTo(SetLinks::getStatus, setLinks.getStatus());
        }
        return weekend;
    }

    @CacheEvict(cacheNames = "SetLinks-site", key = "#setLinks.siteId")
    @Override
    public int save(SetLinks setLinks) {
        if(StringUtils.isBlank(setLinks.getId())){
            setLinks.setStatus(PtCons.ENABLE_DISABLE.D.getVal());
            setLinks.setSort(0l);
        }else {
            setLinks.setStatus(null);
        }
        return super.save(setLinks);
    }

    @CacheEvict(cacheNames = "SetLinks-site", allEntries = true)
    @Transactional
    public void enable(String[] ids, boolean enabled){
        String val = enabled ? PtCons.ENABLE_DISABLE.E.getVal() : PtCons.ENABLE_DISABLE.D.getVal();
        SetLinks entity = new SetLinks();
        entity.setStatus(val);
        for(String id : ids){
            if(StringUtils.isBlank(id))
                continue;
            entity.setId(id);
            getMapper().updateByPrimaryKeySelective(entity);
        }
    }

    @CacheEvict(cacheNames = "SetLinks-site", key = "#setLinks.siteId")
    @Override
    public int delete(SetLinks setLinks) {
        return super.delete(setLinks);
    }

    // 查询站点链接
    @Cacheable(cacheNames = "SetLinks-site")
    public List<SetLinks> querySiteLinks(String siteId){
        Map pp = new HashMap();

        pp.put("siteId", siteId);
        pp.put("status","1");
        pp.put("sorts", "sort=0");
        return queryList(null, pp);
    }
}
