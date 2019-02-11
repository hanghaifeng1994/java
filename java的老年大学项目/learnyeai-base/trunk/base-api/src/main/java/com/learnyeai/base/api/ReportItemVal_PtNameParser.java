package com.learnyeai.base.api;

import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.vo.PtsetPlatformVo;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.learnai.net.IReportItemValParser;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import org.springframework.beans.factory.annotation.Autowired;

public class ReportItemVal_PtNameParser implements IReportItemValParser {
    @Autowired
    private  BaseInfoDao baseInfoDao;
    public ReportItemVal_PtNameParser() {
    }

    public String parse(Object o, MBTransItem mbTransItem) {
        if (null == o) {
            return null;
        } else {
            PtsetSiteVo pt= baseInfoDao.querySite(o.toString());
            if(pt !=null){
                PtsetPlatformVo psite =baseInfoDao.queryPlatform(pt.getPtId());
                return null == psite ? null : psite.getPtName();
            }
            return null;
//            CustInfoVo cust = this.baseInfoDao.queryCustInfo(o.toString());
        }
    }
}
