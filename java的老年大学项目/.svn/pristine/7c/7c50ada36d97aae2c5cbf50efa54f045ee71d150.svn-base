package com.learnyeai.album.service;

import com.learnyeai.album.model.AbmSitePhotoRel;
import com.learnyeai.album.mapper.AbmSitePhotoRelMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class AbmSitePhotoRelWyService extends WeyeBaseService<AbmSitePhotoRel> {

    @Resource
    private AbmSitePhotoRelMapper abmSitePhotoRelMapper;
    protected Weekend<AbmSitePhotoRel> genSqlExample(AbmSitePhotoRel t, Map params) {
        Weekend<AbmSitePhotoRel> weekend = super.genSqlExample(t, params);
        WeekendCriteria<AbmSitePhotoRel, Object> c = weekend.createCriteriaAddOn();
        if(StringUtils.isNotBlank(t.getCatId())){
            String[] catId=(t.getCatId()).split(",");
            c.andIn(AbmSitePhotoRel::getCatId, Arrays.asList(catId));
        }
        if(t.getAbmWeight() !=null){
            c.andEqualTo(AbmSitePhotoRel::getAbmWeight,t.getAbmWeight());
        }
        weekend.and(c);
        weekend.setOrderByClause("ABM_PUB_DATE desc");
        return weekend;
    }

    @Override
    public BaseMapper<AbmSitePhotoRel> getMapper() {
        return abmSitePhotoRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

}
