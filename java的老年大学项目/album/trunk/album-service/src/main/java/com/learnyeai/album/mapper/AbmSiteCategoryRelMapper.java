package com.learnyeai.album.mapper;

import com.learnyeai.album.model.AbmSiteCategoryRel;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
/**
 * @Description: 站点-相册分类
 * @author yl
 */
@MyBatisDao
public interface AbmSiteCategoryRelMapper extends BaseMapper<AbmSiteCategoryRel> {
    int deleteByCatIds(String catId);
}
