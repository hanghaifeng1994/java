package com.learnyeai.schoolclass.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 班级-资讯
 *
 * @author twang
 */
public class ClzClazzNews extends BaseEntity {

    /**
    * 班级id
    */
    @Id
    @Column(name = "CZ_ID")
    private String czId;

    /**
     * 资讯id
     */
    @Column(name = "ARTICLE_ID")
    private String articleId;
    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    private String createBy;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;

    public String getCzId() {
        return czId;
    }

    public void setCzId(String czId) {
        this.czId = czId;
    }
    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public static class TF {

        public static String TABLE_NAME = "CLZ_CLAZZ_NEWS";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String czId = "CZ_ID";  // 班级id
        public static String articleId = "ARTICLE_ID";  // 资讯id
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间

    }
}
