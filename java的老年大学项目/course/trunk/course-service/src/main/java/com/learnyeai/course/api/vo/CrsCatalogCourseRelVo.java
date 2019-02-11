package com.learnyeai.course.api.vo;

import com.learnyeai.core.support.BaseVo;

/**
 * 课程分类关联表
 *
 * @author twang
 */
public class CrsCatalogCourseRelVo extends BaseVo {

    /**
    * ID
    */
    private String id;

    /**
     * 课程分类id
     */
    private String catId;
    /**
     * 课程id
     */
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
        public static String id = "id";  // ID
        public static String catId = "catId";  // 课程分类id
        public static String csId = "csId";  // 课程id

    }

}
