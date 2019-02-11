package com.learnyeai.base.api;

import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.learnai.net.IReportItemValParser;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zpz on 2018/8/28.
 */
public class ReportItemVal_UserNameParser implements IReportItemValParser {

    @Autowired
    private BaseInfoDao baseInfoDao;
    @Override
    public String parse(Object o, MBTransItem mbTransItem) {
        if(null == o)
            return null;

        CustInfoVo cust = baseInfoDao.queryCustInfo(o.toString());
        if(null == cust)
            return null;

        return cust.getCustName();
    }
}
