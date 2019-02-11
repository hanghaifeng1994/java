package com.learnyeai.studygroup.mapper;

import com.learnyeai.studygroup.model.SgpSiteCategory;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
/**
 * @Description: 站点-学习小组
 * @author yl
 */
@MyBatisDao
public interface SgpSiteCategoryMapper extends BaseMapper<SgpSiteCategory> {
    void deleteall(String siteId,String catid);

}
