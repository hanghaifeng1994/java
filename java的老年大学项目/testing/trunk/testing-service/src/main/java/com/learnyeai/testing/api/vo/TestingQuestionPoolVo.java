package com.learnyeai.testing.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 题库
 *
 * @author twang
 */
public class TestingQuestionPoolVo extends BaseVo {

    /**
    * ID
    */
    private String qpId;

    /**
     * 题库名称
     */
    private String name;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 创建站点id
     */
    private String siteId;
    /**
     * 创建平台
     */
    private String platformId;
    /**
     * 商户方案id
     */
    private String mchtSchmId;
    /**
     * 商户id
     */
    private String mchtId;

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
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }
    public String getMchtSchmId() {
        return mchtSchmId;
    }

    public void setMchtSchmId(String mchtSchmId) {
        this.mchtSchmId = mchtSchmId;
    }
    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }

    public static class TF {
        public static String qpId = "qpId";  // ID
        public static String name = "name";  // 题库名称
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String delFlag = "delFlag";  // 删除标记
        public static String siteId = "siteId";  // 创建站点id
        public static String platformId = "platformId";  // 创建平台
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id
        public static String mchtId = "mchtId";  // 商户id

    }

}
