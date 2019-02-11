package com.learnyeai.resultbill.service;

import com.learnyeai.resultbill.model.BilCredit;
import com.learnyeai.resultbill.mapper.BilCreditMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.resultbill.model.BilPoints;
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
public class BilCreditWyService extends WeyeBaseService<BilCredit> {

    @Resource
    private BilCreditMapper bilCreditMapper;

    @Override
    public BaseMapper<BilCredit> getMapper() {
        return bilCreditMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    protected Weekend<BilCredit> genSqlExample(BilCredit t, Map params) {
        Weekend<BilCredit> weekend = super.genSqlExample(t, params);
        WeekendCriteria<BilCredit, Object> c = weekend.createCriteriaAddOn();
        if(StringUtils.isNotBlank(t.getCustId())){
            c.andEqualTo(BilCredit::getCustId,t.getCustId());
        }
        if(StringUtils.isNotBlank(t.getObjId())){
            c.andEqualTo(BilCredit::getObjId,t.getObjId());
        }
        if(StringUtils.isNotBlank(t.getServiceType())){
            c.andEqualTo(BilCredit::getServiceType,t.getServiceType());
        }
        weekend.and(c);
        weekend.setOrderByClause("CREATE_DATE desc");
        return weekend;
    }
}
