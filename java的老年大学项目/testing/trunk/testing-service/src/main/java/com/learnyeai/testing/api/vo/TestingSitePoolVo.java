package com.learnyeai.testing.api.vo;

import com.learnyeai.core.support.BaseVo;

/**
 * 将平台下面的题库自动下发到所有平台的站点。如果创建题库是选择了主站id，那么只自动下放到本平台其他子站。
 *
 * @author twang
 */
public class TestingSitePoolVo extends BaseVo {

    /**
    * ID
    */
    private String id;

    /**
     * 题库id
     */
    private String qpId;
    /**
     * 使用站点id
     */
    private String siteId;
    /**
     * 创建站点
     */
    private String tsCrtSiteId;
    /**
     * 创建平台id
     */
    private String tsCrtPlatformId;
    /**
     * 本站点是否禁用 1启用 2禁用
     */
    private String disable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getQpId() {
        return qpId;
    }

    public void setQpId(String qpId) {
        this.qpId = qpId;
    }
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getTsCrtSiteId() {
        return tsCrtSiteId;
    }

    public void setTsCrtSiteId(String tsCrtSiteId) {
        this.tsCrtSiteId = tsCrtSiteId;
    }
    public String getTsCrtPlatformId() {
        return tsCrtPlatformId;
    }

    public void setTsCrtPlatformId(String tsCrtPlatformId) {
        this.tsCrtPlatformId = tsCrtPlatformId;
    }
    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }

    public static class TF {
        public static String id = "id";  // ID
        public static String qpId = "qpId";  // 题库id
        public static String siteId = "siteId";  // 使用站点id
        public static String tsCrtSiteId = "tsCrtSiteId";  // 创建站点
        public static String tsCrtPlatformId = "tsCrtPlatformId";  // 创建平台id
        public static String disable = "disable";  // 本站点是否禁用 1启用 2禁用

    }

}
