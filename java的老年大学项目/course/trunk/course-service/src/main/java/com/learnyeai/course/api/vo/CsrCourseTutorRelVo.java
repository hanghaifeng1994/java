package com.learnyeai.course.api.vo;

import com.learnyeai.core.support.BaseVo;

/**
 * 课程辅导老师
 *
 * @author twang
 */
public class CsrCourseTutorRelVo extends BaseVo {

    /**
    * ID
    */
    private String id;

    /**
     * 课程id
     */
    private String csId;
    /**
     * 辅导老师id
     */
    private String tutorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId;
    }
    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public static class TF {
        public static String id = "id";  // ID
        public static String csId = "csId";  // 课程id
        public static String tutorId = "tutorId";  // 辅导老师id

    }

}
