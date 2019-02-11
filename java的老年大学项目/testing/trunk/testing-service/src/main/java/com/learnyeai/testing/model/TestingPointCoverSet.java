package com.learnyeai.testing.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 每种题型，在不同知识点出题分别情况
 *
 * @author twang
 */
public class TestingPointCoverSet extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "PCS_ID")
    private String pcsId;

    /**
     * 名称
     */
    @Column(name = "NAME")
    private String name;
    /**
     * 出题数量
     */
    @Column(name = "QUE_NUM")
    private Integer queNum;
    /**
     * 可空，但是此时题库id必须有值，并且每个题型规则设置记录必须默认有一个题库id有值，题目章节为空的记录，如果有章节id不为空的记录，那么必须删除这个唯一的题库id不为空，章节目录为空的题型出题记录。即此二者不能同时存在。
     */
    @Column(name = "SECTION_ID")
    private String sectionId;
    /**
     * 题库
     */
    @Column(name = "QP_ID")
    private String qpId;
    /**
     * 所属题型规则
     */
    @Column(name = "QUESTIONITEM_RULE_ID")
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

        public static String TABLE_NAME = "TESTING_POINT_COVER_SET";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String pcsId = "PCS_ID";  // ID
        public static String name = "NAME";  // 名称
        public static String queNum = "QUE_NUM";  // 出题数量
        public static String sectionId = "SECTION_ID";  // 可空，但是此时题库id必须有值，并且每个题型规则设置记录必须默认有一个题库id有值，题目章节为空的记录，如果有章节id不为空的记录，那么必须删除这个唯一的题库id不为空，章节目录为空的题型出题记录。即此二者不能同时存在。
        public static String qpId = "QP_ID";  // 题库
        public static String questionitemRuleId = "QUESTIONITEM_RULE_ID";  // 所属题型规则

    }
}
