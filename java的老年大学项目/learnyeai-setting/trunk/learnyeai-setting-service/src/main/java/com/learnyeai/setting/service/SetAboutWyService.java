package com.learnyeai.setting.service;

import com.learnyeai.setting.model.SetAbout;
import com.learnyeai.setting.mapper.SetAboutMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
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
public class SetAboutWyService extends WeyeBaseService<SetAbout> {

    @Resource
    private SetAboutMapper setAboutMapper;

    @Override
    public BaseMapper<SetAbout> getMapper() {
        return setAboutMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected Weekend<SetAbout> genSqlExample(SetAbout setAbout, Map params) {
        Weekend<SetAbout> weekend = super.genSqlExample(setAbout, params);
        WeekendCriteria<SetAbout, Object> c = weekend.createCriteriaAddOn();
        weekend.and(c);
        if(StringUtils.isNotBlank(setAbout.getSiteId())){
            c.andEqualTo(SetAbout::getSiteId, setAbout.getSiteId());
        }
        return weekend;
    }
    @CacheEvict(cacheNames = "SetAbout_site", key = "#setAbout.siteId")
    @Override
    public int save(SetAbout setAbout) {
        if(StringUtils.isBlank(setAbout.getId())){
            Assert.isTrue(StringUtils.isNotBlank(setAbout.getSiteId()), "站点不能为空");
        }else {

        }
        return super.save(setAbout);
    }

    @Cacheable(cacheNames = "SetAbout_site")
    public SetAbout querySiteAbout(String siteId){
        Map pp = new HashMap();
        pp.put("siteId", siteId);
        List<SetAbout> list = super.queryList(null, pp);
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
