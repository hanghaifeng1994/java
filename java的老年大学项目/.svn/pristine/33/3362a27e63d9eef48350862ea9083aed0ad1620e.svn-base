package com.learnyeai.base.api.util;

import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.core.utils.SpringContextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zpz on 2018/8/22.
 */
public class SiteUtils {
    private static BaseInfoDao baseInfoDao;

    public static BaseInfoDao getBaseInfoDao() {
        if(null == baseInfoDao){
            baseInfoDao = SpringContextUtils.getBean(BaseInfoDao.class);
        }
        return baseInfoDao;
    }

    /**
     * 获取发布的站点，主站点自动下发给子站点
     * @param siteId
     * @return
     */
    public static List<PtsetSiteVo> getPubSites(String siteId){
        PtsetSiteVo site = getBaseInfoDao().querySite(siteId);

        List<PtsetSiteVo> list = new ArrayList<>();
        if("1".equals(site.getSiteType())){
            list = getBaseInfoDao().querySitesByPt(site.getPtId());
        }else {
            list.add(site);
        }
        return list;
    }
}
