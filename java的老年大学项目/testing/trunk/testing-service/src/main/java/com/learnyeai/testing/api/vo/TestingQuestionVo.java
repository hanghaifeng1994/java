package com.learnyeai.testing.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 题目
 *
 * @author twang
 */
public class TestingQuestionVo extends BaseVo {

    /**
    * ID
    */
    private String questionId;

    /**
     * 第二级章节（冗余）
     */
    private String twoSectionId;
    /**
     * 第一级章节（冗余）
     */
    private String oneSectionId;
    /**
     * 第三级章节（冗余）
     */
    private String threeSectionId;
    /**
     * 题干内容
     */
    private String stemContent;
    /**
     * 答案描述
     */
    private String answerDesc;
    /**
     * 所在章节
     */
    private String sectionId;
    /**
     * 所属题库
     */
    private String qpId;
    /**
     * 题型
     */
    private String itemTypeId;
    /**
     * 用uuid机制初次生成后面不同版本copy保持一直即可
     */
    private String onlyCode;
    /**
     * 题目版本，从1开始
     */
    private Integer version;
    /**
     * 每个唯一代码的题目只能有个一条记录此值为true
     */
    private String newversion;
    /**
     * 是否禁用
     */
    private String disabled;
    /**
     * 发布状态
     */
    private String itemPubStatus;
    /**
     * 发布时间
     */
    private Date itemPubDate;
    /**
     * 审核id
     */
    private String itemAuditId;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateDate;

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

    public static class TF {
        public static String questionId = "questionId";  // ID
        public static String twoSectionId = "twoSectionId";  // 第二级章节（冗余）
        public static String oneSectionId = "oneSectionId";  // 第一级章节（冗余）
        public static String threeSectionId = "threeSectionId";  // 第三级章节（冗余）
        public static String stemContent = "stemContent";  // 题干内容
        public static String answerDesc = "answerDesc";  // 答案描述
        public static String sectionId = "sectionId";  // 所在章节
        public static String qpId = "qpId";  // 所属题库
        public static String itemTypeId = "itemTypeId";  // 题型
        public static String onlyCode = "onlyCode";  // 用uuid机制初次生成后面不同版本copy保持一直即可
        public static String version = "version";  // 题目版本，从1开始
        public static String newversion = "newversion";  // 每个唯一代码的题目只能有个一条记录此值为true
        public static String disabled = "disabled";  // 是否禁用
        public static String itemPubStatus = "itemPubStatus";  // 发布状态
        public static String itemPubDate = "itemPubDate";  // 发布时间
        public static String itemAuditId = "itemAuditId";  // 审核id
        public static String delFlag = "delFlag";  // 删除标记
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间

    }

}
