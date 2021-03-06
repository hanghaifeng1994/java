package com.learnyeai.news.mapper;

import com.learnyeai.news.model.NewsSiteCategoryRel;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
/**
 * @Description: 站点-栏目
 * @author yl
 */
@MyBatisDao
public interface NewsSiteCategoryRelMapper extends BaseMapper<NewsSiteCategoryRel> {
    int deleteByIdAndsiteId(NewsSiteCategoryRel nr);
}
