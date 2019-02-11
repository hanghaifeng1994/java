package com.learnyeai.testing.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.learnyeai.learnai.support.BaseEntity;

/**
 * 题目
 *
 * @author twang
 */
public class TestingQuestion extends BaseEntity {

    /**
    * ID
    */
    @Id
    @Column(name = "QUESTION_ID")
    private String questionId;

    /**
     * 第二级章节（冗余）
     */
    @Column(name = "TWO_SECTION_ID")
    private String twoSectionId;
    /**
     * 第一级章节（冗余）
     */
    @Column(name = "ONE_SECTION_ID")
    private String oneSectionId;
    /**
     * 第三级章节（冗余）
     */
    @Column(name = "THREE_SECTION_ID")
    private String threeSectionId;
    /**
     * 题干内容
     */
    @Column(name = "STEM_CONTENT")
    private String stemContent;
    /**
     * 答案描述
     */
    @Column(name = "ANSWER_DESC")
    private String answerDesc;
    /**
     * 所在章节
     */
    @Column(name = "SECTION_ID")
    private String sectionId;
    /**
     * 所属题库
     */
    @Column(name = "QP_ID")
    private String qpId;
    /**
     * 题型
     */
    @Column(name = "ITEM_TYPE_ID")
    private String itemTypeId;
    /**
     * 用uuid机制初次生成后面不同版本copy保持一直即可
     */
    @Column(name = "ONLY_CODE")
    private String onlyCode;
    /**
     * 题目版本，从1开始
     */
    @Column(name = "VERSION")
    private Integer version;
    /**
     * 每个唯一代码的题目只能有个一条记录此值为true
     */
    @Column(name = "NEWVERSION")
    private String newversion;
    /**
     * 是否禁用
     */
    @Column(name = "DISABLED")
    private String disabled;
    /**
     * 发布状态
     */
    @Column(name = "ITEM_PUB_STATUS")
    private String itemPubStatus;
    /**
     * 发布时间
     */
    @Column(name = "ITEM_PUB_DATE")
    private Date itemPubDate;
    /**
     * 审核id
     */
    @Column(name = "ITEM_AUDIT_ID")
    private String itemAuditId;
    /**
     * 删除标记
     */
    @Column(name = "DEL_FLAG")
    private String delFlag;
    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    private String createBy;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;
    /**
     * 更新人
     */
    @Column(name = "UPDATE_BY")
    private String updateBy;
    /**
     * 更新时间
     */
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
    
    @Transient
    private List<TestingQuestionOption> questionOptions ;
    @Transient
    private String typeName;
    @Transient
    private String poolName;
    @Transient
    private String sectionName;
    @Transient
    private String itemType;

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
    public String getTwoSectionId() {
        return twoSectionId;
    }

    public void setTwoSectionId(String twoSectionId) {
        this.twoSectionId = twoSectionId;
    }
    public String getOneSectionId() {
        return oneSectionId;
    }

    public void setOneSectionId(String oneSectionId) {
        this.oneSectionId = oneSectionId;
    }
    public String getThreeSectionId() {
        return threeSectionId;
    }

    public void setThreeSectionId(String threeSectionId) {
        this.threeSectionId = threeSectionId;
    }
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
    public String getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(String itemTypeId) {
        this.itemTypeId = itemTypeId;
    }
    public String getOnlyCode() {
        return onlyCode;
    }

    public void setOnlyCode(String onlyCode) {
        this.onlyCode = onlyCode;
    }
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    public String getNewversion() {
        return newversion;
    }

    public void setNewversion(String newversion) {
        this.newversion = newversion;
    }
    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }
    public String getItemPubStatus() {
        return itemPubStatus;
    }

    public void setItemPubStatus(String itemPubStatus) {
        this.itemPubStatus = itemPubStatus;
    }
    public Date getItemPubDate() {
        return itemPubDate;
    }

    public void setItemPubDate(Date itemPubDate) {
        this.itemPubDate = itemPubDate;
    }
    public String getItemAuditId() {
        return itemAuditId;
    }

    public void setItemAuditId(String itemAuditId) {
        this.itemAuditId = itemAuditId;
    }
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public List<TestingQuestionOption> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(List<TestingQuestionOption> questionOptions) {
        this.questionOptions = questionOptions;
    }

    public static class TF {

        public static String TABLE_NAME = "TESTING_QUESTION";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String questionId = "QUESTION_ID";  // ID
        public static String twoSectionId = "TWO_SECTION_ID";  // 第二级章节（冗余）
        public static String oneSectionId = "ONE_SECTION_ID";  // 第一级章节（冗余）
        public static String threeSectionId = "THREE_SECTION_ID";  // 第三级章节（冗余）
        public static String stemContent = "STEM_CONTENT";  // 题干内容
        public static String answerDesc = "ANSWER_DESC";  // 答案描述
        public static String sectionId = "SECTION_ID";  // 所在章节
        public static String qpId = "QP_ID";  // 所属题库
        public static String itemTypeId = "ITEM_TYPE_ID";  // 题型
        public static String onlyCode = "ONLY_CODE";  // 用uuid机制初次生成后面不同版本copy保持一直即可
        public static String version = "VERSION";  // 题目版本，从1开始
        public static String newversion = "NEWVERSION";  // 每个唯一代码的题目只能有个一条记录此值为true
        public static String disabled = "DISABLED";  // 是否禁用
        public static String itemPubStatus = "ITEM_PUB_STATUS";  // 发布状态
        public static String itemPubDate = "ITEM_PUB_DATE";  // 发布时间
        public static String itemAuditId = "ITEM_AUDIT_ID";  // 审核id
        public static String delFlag = "DEL_FLAG";  // 删除标记
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间

    }

}
