package com.learnyeai.course.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.course.mapper.CrsSiteCourseRelMapper;
import com.learnyeai.course.model.CrsSiteCourseRel;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.tools.common.StringUtils;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class CrsSiteCourseRelWyService extends WeyeBaseService<CrsSiteCourseRel> {

    @Resource
    private CrsSiteCourseRelMapper crsSiteCourseRelMapper;

    @Override
    public BaseMapper<CrsSiteCourseRel> getMapper() {
        return crsSiteCourseRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    
    @Override
    protected Weekend<CrsSiteCourseRel> genSqlExample(CrsSiteCourseRel t, Map params) {
    	Weekend<CrsSiteCourseRel> w =  super.genSqlExample(t, params);
    	WeekendCriteria<CrsSiteCourseRel, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getCsPubStatus())) {
			c.andEqualTo(CrsSiteCourseRel::getCsPubStatus, t.getCsPubStatus());
		}
		if (StringUtils.isNotBlank(t.getCsTjStatus())) {
			c.andEqualTo(CrsSiteCourseRel::getCsTjStatus, t.getCsTjStatus());
		}
		if (StringUtils.isNotBlank(t.getCsId())) {
			c.andEqualTo(CrsSiteCourseRel::getCsId, t.getCsId());
		}
		if (StringUtils.isNotBlank(t.getSiteId())) {
			c.andEqualTo(CrsSiteCourseRel::getSiteId, t.getSiteId());
		}
		if (StringUtils.isNotBlank(t.getCsAsName())) {
			c.andLike(CrsSiteCourseRel::getCsAsName, "%" + t.getCsAsName() + "%");
		}
		if(t.getSiteIds()!=null) {
			c.andIn(CrsSiteCourseRel::getSiteId, t.getSiteIds());
		}
		w.and(c);
		return w;
    	
    }
}
