package com.learnyeai.course.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 课程分类关联表
 *
 * @author twang
 */
public class CrsCatalogCourseRel extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 课程分类id
     */
    @Column(name = "CAT_ID")
    private String catId;
    /**
     * 课程id
     */
    @Column(name = "CS_ID")
    private String csId;

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
    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId;
    }

    public static class TF {

        public static String TABLE_NAME = "CRS_CATALOG_COURSE_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // ID
        public static String catId = "CAT_ID";  // 课程分类id
        public static String csId = "CS_ID";  // 课程id

    }
}
