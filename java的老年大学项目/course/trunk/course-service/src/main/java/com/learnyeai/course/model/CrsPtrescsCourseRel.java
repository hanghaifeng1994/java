package com.learnyeai.course.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 课程-平台资源大类
 *
 * @author twang
 */
public class CrsPtrescsCourseRel extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 平台资源分类id
     */
    @Column(name = "PTRES_CS_ID")
    private String ptresCsId;
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
    public String getPtresCsId() {
        return ptresCsId;
    }

    public void setPtresCsId(String ptresCsId) {
        this.ptresCsId = ptresCsId;
    }
    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId;
    }

    public static class TF {

        public static String TABLE_NAME = "CRS_PTRESCS_COURSE_REL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // ID
        public static String ptresCsId = "PTRES_CS_ID";  // 平台资源分类id
        public static String csId = "CS_ID";  // 课程id

    }
}
