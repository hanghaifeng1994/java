package com.learnyeai.album.service;

import com.learnyeai.album.model.AbmCategoryPhotoRel;
import com.learnyeai.album.mapper.AbmCategoryPhotoRelMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class AbmCategoryPhotoRelWyService extends WeyeBaseService<AbmCategoryPhotoRel> {

    @Resource
    private AbmCategoryPhotoRelMapper abmCategoryPhotoRelMapper;

    @Override
    public BaseMapper<AbmCategoryPhotoRel> getMapper() {
        return abmCategoryPhotoRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend<AbmCategoryPhotoRel> genSqlExample(AbmCategoryPhotoRel t, Map params) {
        Weekend<AbmCategoryPhotoRel> weekend = super.genSqlExample(t, params);
        WeekendCriteria<AbmCategoryPhotoRel, Object> c = weekend.createCriteriaAddOn();
        if(StringUtils.isNotBlank(t.getAbmId())){
            c.andEqualTo(AbmCategoryPhotoRel::getAbmId,t.getAbmId());
        }
        weekend.and(c);
        return weekend;
    }
}
