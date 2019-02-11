package com.learnyeai.news.mapper;

import com.learnyeai.news.model.NewsArticle;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyBatisDao;

import java.util.List;

/**
 * @Description: 资讯
 * @author yl
 */
@MyBatisDao
public interface NewsArticleMapper extends BaseMapper<NewsArticle> {
    List<NewsArticle> queryPageByCriteria(NewsArticle na);

    List<NewsArticle> lowerSendList(NewsArticle na);
}
