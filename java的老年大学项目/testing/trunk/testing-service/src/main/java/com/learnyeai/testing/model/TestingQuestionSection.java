package com.learnyeai.testing.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 题库章节目录
 *
 * @author twang
 */
public class TestingQuestionSection extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "SECTION_ID")
    private String sectionId;

    /**
     * 题库
     */
    @Column(name = "QP_ID")
    private String qpId;
    /**
     * 名称
     */
    @Column(name = "NAME")
    private String name;
    /**
     * 父章节
     */
    @Column(name = "PARENT_ID")
    private String parentId;
    /**
     * 所有父ids
     */
    @Column(name = "PARENT_IDS")
    private String parentIds;
    /**
     * 目录层级
     */
    @Column(name = "LEVEL")
    private Integer level;
    /**
     * 0否 1是
     */
    @Transient
    private String haveChild;

    @Transient
    private String poolName;

    public String getHaveChild() {
        return haveChild;
    }

    public void setHaveChild(String haveChild) {
        this.haveChild = haveChild;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }
    public String getQpId() {
        return qpId;
    }

    public void setQpId(String qpId) {
        this.qpId = qpId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public static class TF {

        public static String TABLE_NAME = "TESTING_QUESTION_SECTION";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String sectionId = "SECTION_ID";  // ID
        public static String qpId = "QP_ID";  // 题库
        public static String name = "NAME";  // 名称
        public static String parentId = "PARENT_ID";  // 父章节
        public static String parentIds = "PARENT_IDS";  // 所有父ids
        public static String level = "LEVEL";  // 目录层级

    }
}
