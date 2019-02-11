package com.learnyeai.testing.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;

/**
 * 答卷的题目答题情况和判分情况
 *
 * @author twang
 */
public class TestingAnswerPaperQuestion extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 学员答卷id
     */
    @Column(name = "AW_ID")
    private String awId;
    /**
     * 实际题目
     */
    @Column(name = "QUESTION_ID")
    private String questionId;
    /**
     * 题目排序
     */
    @Column(name = "ORDER_NUM")
    private Integer orderNum;
    /**
     * 题型
     */
    @Column(name = "ITEM_TYPE_ID")
    private String itemTypeId;
    /**
     * 答题选项
     */
    @Column(name = "ITEM_IDS")
    private String itemIds;
    /**
     * 选项的id，逗号分隔，                
     */
    @Column(name = "ANSWER_ID_VALUE")
    private String answerIdValue;
    /**
     * 答题选项内容
     */
    @Column(name = "ANSWER_CONTENT_VALUE")
    private String answerContentValue;
    /**
     * 本题得分
     */
    @Column(name = "SCORE")
    private BigDecimal score;
    /**
     * 本题答对还是答错（1，对，2错，3半对）
     */
    @Column(name = "OK_STATUS")
    private String okStatus;
    /**
     * 测试id
     */
    @Column(name = "TS_ID")
    private String tsId;
    /**
     * 对象id
     */
    @Column(name = "OBJ_ID")
    private String objId;

    /**
     * 题目
     */
    @Transient
    private String stemContent;
    /**
     * 答案描述
     */
    @Transient
    private String answerDesc;
    /**
     * 研讯通答题大json串
     */
    @Transient
    private List<TestingAnswerPaperQuestion> answers;
    /**
     * 是否已经答卷0未答卷1已答卷
     */
    @Transient
    private String status;

    @Transient
    private String custId;
    @Transient
    private String czId;

    public String getStemContent() {
        return stemContent;
    }

    public void setStemContent(String stemContent) {
        this.stemContent = stemContent;
    }

    public String getAnswerDesc() {
        return answerDesc;
    }

    public void setAnswerDesc(String answerDesc) {
        this.answerDesc = answerDesc;
    }

    public List<TestingAnswerPaperQuestion> getAnswers() {
        return answers;
    }

    public void setAnswers(List<TestingAnswerPaperQuestion> answers) {
        this.answers = answers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCzId() {
        return czId;
    }

    public void setCzId(String czId) {
        this.czId = czId;
    }

    public TestingAnswerPaperQuestion() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getAwId() {
        return awId;
    }

    public void setAwId(String awId) {
        this.awId = awId;
    }
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
    public String getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(String itemTypeId) {
        this.itemTypeId = itemTypeId;
    }
    public String getItemIds() {
        return itemIds;
    }

    public void setItemIds(String itemIds) {
        this.itemIds = itemIds;
    }
    public String getAnswerIdValue() {
        return answerIdValue;
    }

    public void setAnswerIdValue(String answerIdValue) {
        this.answerIdValue = answerIdValue;
    }
    public String getAnswerContentValue() {
        return answerContentValue;
    }

    public void setAnswerContentValue(String answerContentValue) {
        this.answerContentValue = answerContentValue;
    }
    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
    public String getOkStatus() {
        return okStatus;
    }

    public void setOkStatus(String okStatus) {
        this.okStatus = okStatus;
    }
    public String getTsId() {
        return tsId;
    }

    public void setTsId(String tsId) {
        this.tsId = tsId;
    }
    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public static class TF {

        public static String TABLE_NAME = "TESTING_ANSWER_PAPER_QUESTION";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String id = "ID";  // ID
        public static String awId = "AW_ID";  // 学员答卷id
        public static String questionId = "QUESTION_ID";  // 实际题目
        public static String orderNum = "ORDER_NUM";  // 题目排序
        public static String itemTypeId = "ITEM_TYPE_ID";  // 题型
        public static String itemIds = "ITEM_IDS";  // 答题选项
        public static String answerIdValue = "ANSWER_ID_VALUE";  // 选项的id，逗号分隔，                
        public static String answerContentValue = "ANSWER_CONTENT_VALUE";  // 答题选项内容
        public static String score = "SCORE";  // 本题得分
        public static String okStatus = "OK_STATUS";  // 本题答对还是答错（1，对，2错，3半对）
        public static String tsId = "TS_ID";  // 测试id
        public static String objId = "OBJ_ID";  // 对象id

    }
}
