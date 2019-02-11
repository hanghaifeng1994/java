package com.learnyeai.base.service;

import com.learnyeai.base.model.CustLgnInfo;
import com.learnyeai.base.mapper.CustLgnInfoMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhangpz
 */
@Service
public class CustLgnInfoWyService extends WeyeBaseService<CustLgnInfo> {

    @Resource
    private CustLgnInfoMapper custLgnInfoMapper;

    @Override
    public BaseMapper<CustLgnInfo> getMapper() {
        return custLgnInfoMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    @Override
    protected Weekend genSqlExample(CustLgnInfo custLgnInfo, Map params) {
        Weekend weekend = super.genSqlExample(custLgnInfo, params);
        WeekendCriteria<CustLgnInfo, Object> c = weekend.createCriteriaAddOn();
        if(StringUtils.isNotBlank(custLgnInfo.getUserId())){
            c.andEqualTo(CustLgnInfo::getUserId, custLgnInfo.getUserId());
        }
        weekend.and(c);
        return weekend;
    }

    /**
     * 根据客户id查询登录信息
     * @param userId
     * @return
     */
    public CustLgnInfo queryByUserId(String userId){
        CustLgnInfo pp = new CustLgnInfo();
        pp.setUserId(userId);
        List<CustLgnInfo> list = super.queryByExample(pp, null);
        return list.size()>0? list.get(0) : null;
    }
}
