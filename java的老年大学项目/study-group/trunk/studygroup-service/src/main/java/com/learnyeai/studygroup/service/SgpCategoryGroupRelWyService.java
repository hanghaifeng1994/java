package com.learnyeai.studygroup.service;

import com.learnyeai.studygroup.model.SgpCategoryGroupRel;
import com.learnyeai.studygroup.mapper.SgpCategoryGroupRelMapper;
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
public class SgpCategoryGroupRelWyService extends WeyeBaseService<SgpCategoryGroupRel> {

    @Resource
    private SgpCategoryGroupRelMapper sgpCategoryGroupRelMapper;

    @Override
    public BaseMapper<SgpCategoryGroupRel> getMapper() {
        return sgpCategoryGroupRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend<SgpCategoryGroupRel> genSqlExample(SgpCategoryGroupRel t, Map params) {
        Weekend w=super.genSqlExample(t,params);
        WeekendCriteria<SgpCategoryGroupRel,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getCatId())){
            c.andEqualTo(SgpCategoryGroupRel::getCatId,t.getCatId());
        }
        if(StringUtils.isNotBlank(t.getSgpId())){
            c.andEqualTo(SgpCategoryGroupRel::getSgpId,t.getSgpId());
        }
        w.and(c);
        return w;
    }
}
