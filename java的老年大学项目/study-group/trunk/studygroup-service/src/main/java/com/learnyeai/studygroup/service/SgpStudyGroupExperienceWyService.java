package com.learnyeai.studygroup.service;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.studygroup.model.SgpCategory;
import com.learnyeai.studygroup.model.SgpCategoryGroupRel;
import com.learnyeai.studygroup.model.SgpStudyGroupExperience;
import com.learnyeai.studygroup.mapper.SgpStudyGroupExperienceMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author yl
 */
@Service
public class SgpStudyGroupExperienceWyService extends WeyeBaseService<SgpStudyGroupExperience> {

    @Resource
    private SgpStudyGroupExperienceMapper sgpStudyGroupExperienceMapper;

    @Override
    public BaseMapper<SgpStudyGroupExperience> getMapper() {
        return sgpStudyGroupExperienceMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }


    @Override
    protected Weekend genSqlExample(SgpStudyGroupExperience s,Map params){
        Weekend w = super.genSqlExample(s,params);
        WeekendCriteria<SgpStudyGroupExperience,Object> c = w.weekendCriteria();
        if(StringUtils.isNotBlank(s.getSgpId())){
            c.andEqualTo(SgpStudyGroupExperience::getSgpId,s.getSgpId());
        }
        w.and(c);
        return w;
    }



    public void saveData(IBusinessContext ctx){
        SgpStudyGroupExperience ssge= super.convert2Bean(ctx.getParamMap());
        sgpStudyGroupExperienceMapper.insertSelective(ssge);

    }
    public Map<String,Object> deleteByExpId(IBusinessContext ctx){
        SgpStudyGroupExperience ssge= super.convert2Bean(ctx.getParamMap());
      int num =  sgpStudyGroupExperienceMapper.deleteByExpId(ssge);
      return MapUtil.newMap("num",num);
    }
}
