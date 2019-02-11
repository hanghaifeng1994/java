package com.learnyeai.resultbill.service;

import com.learnyeai.resultbill.model.BilPoints;
import com.learnyeai.resultbill.mapper.BilPointsMapper;
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
public class BilPointsWyService extends WeyeBaseService<BilPoints> {

    @Resource
    private BilPointsMapper bilPointsMapper;

    @Override
    public BaseMapper<BilPoints> getMapper() {
        return bilPointsMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend<BilPoints> genSqlExample(BilPoints t, Map params) {
        Weekend<BilPoints> weekend = super.genSqlExample(t, params);
        WeekendCriteria<BilPoints, Object> c = weekend.createCriteriaAddOn();
        if(StringUtils.isNotBlank(t.getCustId())){
            c.andEqualTo(BilPoints::getCustId,t.getCustId());
        }
        if(StringUtils.isNotBlank(t.getObjId())){
            c.andEqualTo(BilPoints::getObjId,t.getObjId());
        }
        if(StringUtils.isNotBlank(t.getServiceType())){
            c.andEqualTo(BilPoints::getServiceType,t.getServiceType());
        }
        weekend.and(c);
        weekend.setOrderByClause("CREATE_DATE desc");
        return weekend;
    }
}
