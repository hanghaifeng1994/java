package com.learnyeai.activity.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 活动分类-活动关联表
 *
 * @author yl
 */
public class ActCategoryActivity extends BaseEntity {

    /**
    * 活动分类id
    */
    @Id
    @Column(name = "CAT_ID")
    private String catId;

    /**
     * 活动id
     */
    @Column(name = "ACT_ID")
    private String actId;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }
    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public static class TF {

        public static String TABLE_NAME = "ACT_CATEGORY_ACTIVITY";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String catId = "CAT_ID";  // 活动分类id
        public static String actId = "ACT_ID";  // 活动id

    }
}
