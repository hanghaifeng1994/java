package com.learnyeai.base.service;

import com.learnyeai.base.model.SmsTmpl;
import com.learnyeai.base.mapper.SmsTmplMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;

/**
 *
 * @author zhangpz
 */
@Service
public class SmsTmplWyService extends WeyeBaseService<SmsTmpl> {

    @Resource
    private SmsTmplMapper smsTmplMapper;

    @Override
    public BaseMapper<SmsTmpl> getMapper() {
        return smsTmplMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    @Override
    protected Weekend genSqlExample(SmsTmpl smsTmpl) {
        Weekend weekend = super.genSqlExample(smsTmpl);
        WeekendCriteria<SmsTmpl, Object> c = weekend.createCriteriaAddOn();
        c.andEqualTo(SmsTmpl::getStType, smsTmpl.getStType());
        weekend.and(c);
        return weekend;
    }
}
