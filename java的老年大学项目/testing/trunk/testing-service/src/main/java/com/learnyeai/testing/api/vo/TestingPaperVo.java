package com.learnyeai.testing.api.vo;

import com.learnyeai.core.support.BaseVo;

/**
 * 根据组卷规则的出的测验试卷
 *
 * @author twang
 */
public class TestingPaperVo extends BaseVo {

    /**
    * ID
    */
    private String paperId;

    /**
     * 所属组卷规则
     */
    private String paperRuleId;
    /**
     * 是否已用
     */
    private String usered;
    /**
     * 是否禁用
     */
    private String disabled;
    /**
     * 卷号
     */
    private Integer paperNum;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }
    public String getPaperRuleId() {
        return paperRuleId;
    }

    public void setPaperRuleId(String paperRuleId) {
        this.paperRuleId = paperRuleId;
    }
    public String getUsered() {
        return usered;
    }

    public void setUsered(String usered) {
        this.usered = usered;
    }
    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }
    public Integer getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(Integer paperNum) {
        this.paperNum = paperNum;
    }

    public static class TF {
        public static String paperId = "paperId";  // ID
        public static String paperRuleId = "paperRuleId";  // 所属组卷规则
        public static String usered = "usered";  // 是否已用
        public static String disabled = "disabled";  // 是否禁用
        public static String paperNum = "paperNum";  // 卷号

    }

}
