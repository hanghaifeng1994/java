package com.learnyeai.news.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 资讯栏目-资讯关联表
 *
 * @author yl
 */
public class NewsCategoryArticleRel extends BaseEntity {

    /**
    * 栏目id
    */
    @Id
    @Column(name = "CAT_ID")
    private String catId;

    /**
     * 资讯id
     */
    @Column(name = "ARTICLE_ID")
    private String articleId;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }
    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public static class TF {

        public static String TABLE_NAME = "NEWS_CATEGORY_ARTICLE_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String catId = "CAT_ID";  // 栏目id
        public static String articleId = "ARTICLE_ID";  // 资讯id

    }
}
