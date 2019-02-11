package com.learnyeai.schoolclass.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 班级分类-班级关联表
 *
 * @author twang
 */
public class ClzCategoryClzzRell extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 分类id
     */
    @Column(name = "CAT_ID")
    private String catId;
    /**
     * 班级id
     */
    @Column(name = "CZ_ID")
    private String czId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }
    public String getCzId() {
        return czId;
    }

    public void setCzId(String czId) {
        this.czId = czId;
    }

    public static class TF {

        public static String TABLE_NAME = "CLZ_CATEGORY_CLZZ_RELL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // ID
        public static String catId = "CAT_ID";  // 分类id
        public static String czId = "CZ_ID";  // 班级id

    }
}
