package com.learnyeai.base.api;

import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.learnai.net.IReportItemValParser;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import org.springframework.beans.factory.annotation.Autowired;

public class ReportItemVal_SiteNameParser implements IReportItemValParser {
    @Autowired
    private  BaseInfoDao baseInfoDao;
    public ReportItemVal_SiteNameParser() {
    }

    public String parse(Object o, MBTransItem mbTransItem) {
        if (null == o) {
            return null;
        } else {
            PtsetSiteVo pt= baseInfoDao.querySite(o.toString());
//            CustInfoVo cust = this.baseInfoDao.queryCustInfo(o.toString());
            return null == pt ? null : pt.getSiteName();
        }
    }
}
