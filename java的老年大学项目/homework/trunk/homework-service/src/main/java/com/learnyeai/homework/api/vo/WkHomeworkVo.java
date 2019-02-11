package com.learnyeai.homework.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 作业
 *
 * @author twang
 */
public class WkHomeworkVo extends BaseVo {

    /**
    * 作业id
    */
    private String hwId;

    /**
     * 标题
     */
    private String hwTitle;
    /**
     * 内容
     */
    private String hwContent;
    /**
     * 0未发布、1已发布
     */
    private String hwStatus;
    /**
     * 交作业截止时间
     */
    private Date hwEnddate;
    /**
     * 单位是天
     */
    private Integer hwWorkTimeLimit;
    /**
     * 交作业人数
     */
    private Long hwSubmitNum;
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
    /**
     * 站点
     */
    private String siteId;
    /**
     * 商户id
     */
    private String mchtId;
    /**
     * 商户方案id
     */
    private String mchtSchmId;

    public String getHwId() {
        return hwId;
    }

    public void setHwId(String hwId) {
        this.hwId = hwId;
    }
    public String getHwTitle() {
        return hwTitle;
    }

    public void setHwTitle(String hwTitle) {
        this.hwTitle = hwTitle;
    }
    public String getHwContent() {
        return hwContent;
    }

    public void setHwContent(String hwContent) {
        this.hwContent = hwContent;
    }
    public String getHwStatus() {
        return hwStatus;
    }

    public void setHwStatus(String hwStatus) {
        this.hwStatus = hwStatus;
    }
    public Date getHwEnddate() {
        return hwEnddate;
    }

    public void setHwEnddate(Date hwEnddate) {
        this.hwEnddate = hwEnddate;
    }
    public Integer getHwWorkTimeLimit() {
        return hwWorkTimeLimit;
    }

    public void setHwWorkTimeLimit(Integer hwWorkTimeLimit) {
        this.hwWorkTimeLimit = hwWorkTimeLimit;
    }
    public Long getHwSubmitNum() {
        return hwSubmitNum;
    }

    public void setHwSubmitNum(Long hwSubmitNum) {
        this.hwSubmitNum = hwSubmitNum;
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
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }
    public String getMchtSchmId() {
        return mchtSchmId;
    }

    public void setMchtSchmId(String mchtSchmId) {
        this.mchtSchmId = mchtSchmId;
    }

    public static class TF {
        public static String hwId = "hwId";  // 作业id
        public static String hwTitle = "hwTitle";  // 标题
        public static String hwContent = "hwContent";  // 内容
        public static String hwStatus = "hwStatus";  // 0未发布、1已发布
        public static String hwEnddate = "hwEnddate";  // 交作业截止时间
        public static String hwWorkTimeLimit = "hwWorkTimeLimit";  // 单位是天
        public static String hwSubmitNum = "hwSubmitNum";  // 交作业人数
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String delFlag = "delFlag";  // 删除标记
        public static String siteId = "siteId";  // 站点
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id

    }

}
