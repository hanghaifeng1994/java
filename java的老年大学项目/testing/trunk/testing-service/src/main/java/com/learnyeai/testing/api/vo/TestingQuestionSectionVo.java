package com.learnyeai.testing.api.vo;

import com.learnyeai.core.support.BaseVo;

/**
 * 题库章节目录
 *
 * @author twang
 */
public class TestingQuestionSectionVo extends BaseVo {

    /**
    * ID
    */
    private String sectionId;

    /**
     * 题库
     */
    private String qpId;
    /**
     * 名称
     */
    private String name;
    /**
     * 父章节
     */
    private String parentId;
    /**
     * 所有父ids
     */
    private String parentIds;
    /**
     * 目录层级
     */
    private Integer level;

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
        public static String sectionId = "sectionId";  // ID
        public static String qpId = "qpId";  // 题库
        public static String name = "name";  // 名称
        public static String parentId = "parentId";  // 父章节
        public static String parentIds = "parentIds";  // 所有父ids
        public static String level = "level";  // 目录层级

    }

}
