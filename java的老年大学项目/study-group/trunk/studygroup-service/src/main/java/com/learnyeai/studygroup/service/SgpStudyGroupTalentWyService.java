package com.learnyeai.studygroup.service;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.studygroup.model.SgpStudyGroup;
import com.learnyeai.studygroup.model.SgpStudyGroupTalent;
import com.learnyeai.studygroup.mapper.SgpStudyGroupTalentMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author yl
 */
@Service
public class SgpStudyGroupTalentWyService extends WeyeBaseService<SgpStudyGroupTalent> {
    @Resource
    private  CurrentUserInfoIml currentUserInfoIml;

    @Resource
    private SgpStudyGroupTalentMapper sgpStudyGroupTalentMapper;

    @Override
    public BaseMapper<SgpStudyGroupTalent> getMapper() {
        return sgpStudyGroupTalentMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }


    @Override
    protected Weekend genSqlExample(SgpStudyGroupTalent s,Map params){
        Weekend w = super.genSqlExample(s,params);
        WeekendCriteria<SgpStudyGroupTalent,Object> c = w.weekendCriteria();
        if(StringUtils.isNotBlank(s.getSgpId())){
            c.andEqualTo(SgpStudyGroupTalent::getSgpId,s.getSgpId());
        }
        w.and(c);
        return w;
    }


    public void saveData(IBusinessContext ctx){
        SgpStudyGroupTalent ssgt= super.convert2Bean(ctx.getParamMap());
        sgpStudyGroupTalentMapper.insertSelective(ssgt);

    }

    public Map<String,Object> deleteByTalentAndSgpId(IBusinessContext ctx){
        SgpStudyGroupTalent talent=  super.convert2Bean(ctx.getParamMap());
       int num=  sgpStudyGroupTalentMapper.deleteByTalentAndSgpId(talent);
       return MapUtil.newMap("num",num);
    }
}
