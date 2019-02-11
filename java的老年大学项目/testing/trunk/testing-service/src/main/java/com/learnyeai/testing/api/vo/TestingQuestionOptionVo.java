package com.learnyeai.testing.api.vo;

import com.learnyeai.core.support.BaseVo;

/**
 * 考题选项类
 *
 * @author twang
 */
public class TestingQuestionOptionVo extends BaseVo {

    /**
    * ID
    */
    private String itemId;

    /**
     * 所属题目
     */
    private String questionId;
    /**
     * 题支内容
     */
    private String optionContent;
    /**
     * 是否答案
     */
    private String answer;
    /**
     * 序号
     */
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
        public static String itemId = "itemId";  // ID
        public static String questionId = "questionId";  // 所属题目
        public static String optionContent = "optionContent";  // 题支内容
        public static String answer = "answer";  // 是否答案
        public static String orderNum = "orderNum";  // 序号

    }

}
