package com.learnyeai.resultbill.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.util.Date;

/**
 * 积分规则
 *
 * @author yl
 */
public class BilPointsRuleVo extends BaseVo {

    /**
    * ID
    */
    private String prlId;

    /**
     * url
     */
    private String url;
    /**
     * 积分
     */
    private Integer pointsNum;
    /**
     * 业务类型
     */
    private String serviceType;
    /**
     * 备注
     */
    private String remark;
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
     * 商户id
     */
    private String mchtId;
    /**
     * 商户方案id
     */
    private String mchtSchmId;

    public String getPrlId() {
        return prlId;
    }

    public void setPrlId(String prlId) {
        this.prlId = prlId;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getPointsNum() {
        return pointsNum;
    }

    public void setPointsNum(Integer pointsNum) {
        this.pointsNum = pointsNum;
    }
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public static class CF {
        public static String prlId = "prlId";  // ID
        public static String url = "url";  // url
        public static String pointsNum = "pointsNum";  // 积分
        public static String serviceType = "serviceType";  // 业务类型
        public static String remark = "remark";  // 备注
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String mchtId = "mchtId";  // 商户id
        public static String mchtSchmId = "mchtSchmId";  // 商户方案id

    }

}
