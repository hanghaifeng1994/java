package com.learnyeai.base.service;

import com.learnyeai.base.mapper.CustInfoMapper;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.support.BaseMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by zpz on 2018/9/5.
 */
@Service
public class CustOtherWyService extends WeyeBaseService<CustInfo>{

    @Resource
    private CustInfoMapper custInfoMapper;

    @Override
    public BaseMapper<CustInfo> getMapper() {
        return custInfoMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    public CustInfo checkUserExists(Map pp){
        CustInfo custInfo = convert2Bean(pp);
        Weekend<CustInfo> weekend = genSqlExample(custInfo, pp);
        WeekendCriteria<CustInfo, Object> c = weekend.createCriteriaAddOn();
        weekend.and(c);
        // 登录名
        if(StringUtils.isNotBlank(custInfo.getLoginName())){
            c.andEqualTo(CustInfo::getLoginName, custInfo.getLoginName());
        }

        // 姓名
        if(StringUtils.isNotBlank(custInfo.getCustName())){
            c.andEqualTo(CustInfo::getCustName, custInfo.getCustName());
        }

        // 身份证号
        if(StringUtils.isNotBlank(custInfo.getIdcarNo())){
            c.andEqualTo(CustInfo::getIdcarNo, custInfo.getIdcarNo());
        }

        List<CustInfo> list = custInfoMapper.selectByExample(weekend);
        if(list.size() > 1)
            throw AresRuntimeException.build("custInfo.usercheck.moreUser").iniMessage("用户不存在").iniCauseMsg("找到多个用户");
        else if(list.size() == 0){
            throw AresRuntimeException.build("custInfo.usercheck.notExists").iniMessage("用户不存在").iniCauseMsg("找到多个用户");
        }

        return list.get(0);
    }

}
