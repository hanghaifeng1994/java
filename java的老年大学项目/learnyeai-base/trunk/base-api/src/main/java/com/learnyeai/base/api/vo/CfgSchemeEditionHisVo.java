package com.learnyeai.base.api.vo;

import com.learnyeai.core.support.BaseVo;

import java.util.Date;

/**
 * 方案版本历史
 *
 * @author zhangpz
 */
public class CfgSchemeEditionHisVo extends BaseVo {

    /**
    * 方案版本历史id
    */
    private String schmEdtHisId;

    /**
     * 版本状态：0未添加升级信息 1已添加升级信息
     */
    private String schmEdtHisStatus;
    /**
     * 版本升级备注
     */
    private String schmEdtHisRemark;
    /**
     * 编辑状态0未编辑、1修改版本信息、2修改功能包、3版本信息功能包都修改了
     */
    private String schmEdtModStatus;
    /**
     * 方案版本id
     */
    private String schmEdtId;
    /**
     * 方案版本名称
     */
    private String schmEdtName;
    /**
     * 版本描述
     */
    private String schmEdtDesc;
    /**
     * 图片
     */
    private String schmEdtPhoto;
    /**
     * 版本级别
     */
    private Long schmEdtGrade;
    /**
     * 方案id
     */
    private String schmId;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createDate;

    public String getSchmEdtHisId() {
        return schmEdtHisId;
    }

    public void setSchmEdtHisId(String schmEdtHisId) {
        this.schmEdtHisId = schmEdtHisId;
    }
    public String getSchmEdtHisStatus() {
        return schmEdtHisStatus;
    }

    public void setSchmEdtHisStatus(String schmEdtHisStatus) {
        this.schmEdtHisStatus = schmEdtHisStatus;
    }
    public String getSchmEdtHisRemark() {
        return schmEdtHisRemark;
    }

    public void setSchmEdtHisRemark(String schmEdtHisRemark) {
        this.schmEdtHisRemark = schmEdtHisRemark;
    }
    public String getSchmEdtModStatus() {
        return schmEdtModStatus;
    }

    public void setSchmEdtModStatus(String schmEdtModStatus) {
        this.schmEdtModStatus = schmEdtModStatus;
    }
    public String getSchmEdtId() {
        return schmEdtId;
    }

    public void setSchmEdtId(String schmEdtId) {
        this.schmEdtId = schmEdtId;
    }
    public String getSchmEdtName() {
        return schmEdtName;
    }

    public void setSchmEdtName(String schmEdtName) {
        this.schmEdtName = schmEdtName;
    }
    public String getSchmEdtDesc() {
        return schmEdtDesc;
    }

    public void setSchmEdtDesc(String schmEdtDesc) {
        this.schmEdtDesc = schmEdtDesc;
    }
    public String getSchmEdtPhoto() {
        return schmEdtPhoto;
    }

    public void setSchmEdtPhoto(String schmEdtPhoto) {
        this.schmEdtPhoto = schmEdtPhoto;
    }
    public Long getSchmEdtGrade() {
        return schmEdtGrade;
    }

    public void setSchmEdtGrade(Long schmEdtGrade) {
        this.schmEdtGrade = schmEdtGrade;
    }
    public String getSchmId() {
        return schmId;
    }

    public void setSchmId(String schmId) {
        this.schmId = schmId;
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

    public static class CF {
        public static String schmEdtHisId = "schmEdtHisId";  // 方案版本历史id
        public static String schmEdtHisStatus = "schmEdtHisStatus";  // 版本状态：0未添加升级信息 1已添加升级信息
        public static String schmEdtHisRemark = "schmEdtHisRemark";  // 版本升级备注
        public static String schmEdtModStatus = "schmEdtModStatus";  // 编辑状态0未编辑、1修改版本信息、2修改功能包、3版本信息功能包都修改了
        public static String schmEdtId = "schmEdtId";  // 方案版本id
        public static String schmEdtName = "schmEdtName";  // 方案版本名称
        public static String schmEdtDesc = "schmEdtDesc";  // 版本描述
        public static String schmEdtPhoto = "schmEdtPhoto";  // 图片
        public static String schmEdtGrade = "schmEdtGrade";  // 版本级别
        public static String schmId = "schmId";  // 方案id
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间

    }

}
