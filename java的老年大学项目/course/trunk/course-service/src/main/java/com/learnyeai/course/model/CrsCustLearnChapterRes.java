package com.learnyeai.course.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 客户学习章节-资源关联表
 *
 * @author twang
 */
public class CrsCustLearnChapterRes extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 用户学习章节id
     */
    @Column(name = "LCPT_ID")
    private String lcptId;
    /**
     * 资源id
     */
    @Column(name = "RES_ID")
    private String resId;
    /**
     * 
     */
    @Column(name = "STUDY_USER_ID")
    private String studyUserId;
    /**
     * 
     */
    @Column(name = "CS_ID")
    private String csId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getLcptId() {
        return lcptId;
    }

    public void setLcptId(String lcptId) {
        this.lcptId = lcptId;
    }
    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }
    public String getStudyUserId() {
        return studyUserId;
    }

    public void setStudyUserId(String studyUserId) {
        this.studyUserId = studyUserId;
    }
    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId;
    }

    public static class TF {

        public static String TABLE_NAME = "CRS_CUST_LEARN_CHAPTER_RES";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // ID
        public static String lcptId = "LCPT_ID";  // 用户学习章节id
        public static String resId = "RES_ID";  // 资源id
        public static String studyUserId = "STUDY_USER_ID";  // 
        public static String csId = "CS_ID";  // 

    }
}
