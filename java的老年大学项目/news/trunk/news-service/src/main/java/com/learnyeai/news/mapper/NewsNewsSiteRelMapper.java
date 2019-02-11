package com.learnyeai.news.mapper;

import com.learnyeai.news.model.NewsNewsSiteRel;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;
/**
 * @Description: 站点-资讯
 * @author yl
 */
@MyBatisDao
public interface NewsNewsSiteRelMapper extends BaseMapper<NewsNewsSiteRel> {
    int deleteBySiteAndArtId(NewsNewsSiteRel nnsr);
}
