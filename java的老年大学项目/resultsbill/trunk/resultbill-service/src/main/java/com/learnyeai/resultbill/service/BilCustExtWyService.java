package com.learnyeai.resultbill.service;

import com.learnyeai.resultbill.model.BilCustExt;
import com.learnyeai.resultbill.mapper.BilCustExtMapper;
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
public class BilCustExtWyService extends WeyeBaseService<BilCustExt> {

    @Resource
    private BilCustExtMapper bilCustExtMapper;

    @Override
    public BaseMapper<BilCustExt> getMapper() {
        return bilCustExtMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend<BilCustExt> genSqlExample(BilCustExt t, Map params) {
        Weekend<BilCustExt> weekend = super.genSqlExample(t, params);
        WeekendCriteria<BilCustExt, Object> c = weekend.createCriteriaAddOn();
        if(StringUtils.isNotBlank(t.getCustId())){
            String[] arr=(t.getCustId()).split(",");
            c.andIn(BilCustExt::getCustId, Arrays.asList(arr));
        }
        weekend.and(c);
        weekend.setOrderByClause("CREATE_DATE desc");
        return weekend;
    }
}
