package com.learnyeai.testing.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 考题选项类
 *
 * @author twang
 */
public class TestingQuestionOption extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ITEM_ID")
    private String itemId;

    /**
     * 所属题目
     */
    @Column(name = "QUESTION_ID")
    private String questionId;
    /**
     * 题支内容
     */
    @Column(name = "OPTION_CONTENT")
    private String optionContent;
    /**
     * 是否答案
     */
    @Column(name = "ANSWER")
    private String answer;
    /**
     * 序号
     */
    @Column(name = "ORDER_NUM")
    private Integer orderNum;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public static class TF {

        public static String TABLE_NAME = "TESTING_QUESTION_OPTION";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String itemId = "ITEM_ID";  // ID
        public static String questionId = "QUESTION_ID";  // 所属题目
        public static String optionContent = "OPTION_CONTENT";  // 题支内容
        public static String answer = "ANSWER";  // 是否答案
        public static String orderNum = "ORDER_NUM";  // 序号

    }
}
