package com.learnyeai.resource.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 资源分类关联表
 *
 * @author twang
 */
public class ResCategoryResourceRel extends BaseEntity {

    /**
    * id
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
     * 资源id
     */
    @Column(name = "RES_ID")
    private String resId;

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
    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public static class TF {

        public static String TABLE_NAME = "RES_CATEGORY_RESOURCE_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // id
        public static String catId = "CAT_ID";  // 分类id
        public static String resId = "RES_ID";  // 资源id

    }
}
