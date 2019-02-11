package com.learnyeai.course.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 课程辅导老师
 *
 * @author twang
 */
public class CsrCourseTutorRel extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 课程id
     */
    @Column(name = "CS_ID")
    private String csId;
    /**
     * 辅导老师id
     */
    @Column(name = "TUTOR_ID")
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

        public static String TABLE_NAME = "CSR_COURSE_TUTOR_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // ID
        public static String csId = "CS_ID";  // 课程id
        public static String tutorId = "TUTOR_ID";  // 辅导老师id

    }
}
