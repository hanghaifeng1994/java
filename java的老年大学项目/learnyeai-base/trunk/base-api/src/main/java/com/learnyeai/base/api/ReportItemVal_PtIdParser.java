package com.learnyeai.base.api;

import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.vo.PtsetPlatformVo;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.learnai.net.IReportItemValParser;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import org.springframework.beans.factory.annotation.Autowired;

public class ReportItemVal_PtIdParser implements IReportItemValParser {
    @Autowired
    private  BaseInfoDao baseInfoDao;
    public ReportItemVal_PtIdParser() {
    }

    public String parse(Object o, MBTransItem mbTransItem) {
        if (null == o) {
            return null;
        } else {
            PtsetSiteVo pt= baseInfoDao.querySite(o.toString());
            return null == pt ? null : pt.getPtId();
        }
    }
}
