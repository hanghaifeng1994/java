package com.learnyeai.testing.api.vo;

import com.learnyeai.core.support.BaseVo;

/**
 * 每种题型，在不同知识点出题分别情况
 *
 * @author twang
 */
public class TestingPointCoverSetVo extends BaseVo {

    /**
    * ID
    */
    private String pcsId;

    /**
     * 名称
     */
    private String name;
    /**
     * 出题数量
     */
    private Integer queNum;
    /**
     * 可空，但是此时题库id必须有值，并且每个题型规则设置记录必须默认有一个题库id有值，题目章节为空的记录，如果有章节id不为空的记录，那么必须删除这个唯一的题库id不为空，章节目录为空的题型出题记录。即此二者不能同时存在。
     */
    private String sectionId;
    /**
     * 题库
     */
    private String qpId;
    /**
     * 所属题型规则
     */
    private String questionitemRuleId;

    public String getPcsId() {
        return pcsId;
    }

    public void setPcsId(String pcsId) {
        this.pcsId = pcsId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getQueNum() {
        return queNum;
    }

    public void setQueNum(Integer queNum) {
        this.queNum = queNum;
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
    public String getQuestionitemRuleId() {
        return questionitemRuleId;
    }

    public void setQuestionitemRuleId(String questionitemRuleId) {
        this.questionitemRuleId = questionitemRuleId;
    }

    public static class TF {
        public static String pcsId = "pcsId";  // ID
        public static String name = "name";  // 名称
        public static String queNum = "queNum";  // 出题数量
        public static String sectionId = "sectionId";  // 可空，但是此时题库id必须有值，并且每个题型规则设置记录必须默认有一个题库id有值，题目章节为空的记录，如果有章节id不为空的记录，那么必须删除这个唯一的题库id不为空，章节目录为空的题型出题记录。即此二者不能同时存在。
        public static String qpId = "qpId";  // 题库
        public static String questionitemRuleId = "questionitemRuleId";  // 所属题型规则

    }

}
