package com.learnyeai.base.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 功能
 *
 * @author zhangpz
 */
public class CfgFunction extends BaseEntity {

    /**
    * 功能id
    */
    @Id
    @Column(name = "FUNC_ID")
    private String funcId;

    /**
     * 功能名称
     */
    @Column(name = "FUNC_NAME")
    private String funcName;
    /**
     * 1后管、2前端
     */
    @Column(name = "FUNC_TYPE")
    private String funcType;
    /**
     * 1接口、2html
     */
    @Column(name = "FUNC_MNG_TYPE")
    private String funcMngType;
    /**
     * url
     */
    @Column(name = "FUNC_URL")
    private String funcUrl;
    /**
     * 权限标识
     */
    @Column(name = "FUNC_PERMISSION")
    private String funcPermission;
    /**
     * 0禁用、1启用
     */
    @Column(name = "FUNC_STATUS")
    private String funcStatus;
    /**
     * 0隐藏、1显示
     */
    @Column(name = "FUNC_SHOW_STATUS")
    private String funcShowStatus;
    /**
     * 父节点
     */
    @Column(name = "PARENT_ID")
    private String parentId;
    /**
     * 所有父节点
     */
    @Column(name = "PARENT_IDS")
    private String parentIds;
    /**
     * 模块id
     */
    @Column(name = "MDL_ID")
    private String mdlId;
    /**
     * 排序
     */
    @Column(name = "SORT")
    private Integer sort;
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
    /**
     * 删除标记
     */
    @Column(name = "DEL_FLAG")
    private String delFlag;

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }
    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }
    public String getFuncType() {
        return funcType;
    }

    public void setFuncType(String funcType) {
        this.funcType = funcType;
    }
    public String getFuncMngType() {
        return funcMngType;
    }

    public void setFuncMngType(String funcMngType) {
        this.funcMngType = funcMngType;
    }
    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl;
    }
    public String getFuncPermission() {
        return funcPermission;
    }

    public void setFuncPermission(String funcPermission) {
        this.funcPermission = funcPermission;
    }
    public String getFuncStatus() {
        return funcStatus;
    }

    public void setFuncStatus(String funcStatus) {
        this.funcStatus = funcStatus;
    }
    public String getFuncShowStatus() {
        return funcShowStatus;
    }

    public void setFuncShowStatus(String funcShowStatus) {
        this.funcShowStatus = funcShowStatus;
    }
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }
    public String getMdlId() {
        return mdlId;
    }

    public void setMdlId(String mdlId) {
        this.mdlId = mdlId;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public static class TF {

        public static String TABLE_NAME = "CFG_FUNCTION";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String funcId = "FUNC_ID";  // 功能id
        public static String funcName = "FUNC_NAME";  // 功能名称
        public static String funcType = "FUNC_TYPE";  // 1后管、2前端
        public static String funcMngType = "FUNC_MNG_TYPE";  // 1接口、2html
        public static String funcUrl = "FUNC_URL";  // url
        public static String funcPermission = "FUNC_PERMISSION";  // 权限标识
        public static String funcStatus = "FUNC_STATUS";  // 0禁用、1启用
        public static String funcShowStatus = "FUNC_SHOW_STATUS";  // 0隐藏、1显示
        public static String parentId = "PARENT_ID";  // 父节点
        public static String parentIds = "PARENT_IDS";  // 所有父节点
        public static String mdlId = "MDL_ID";  // 模块id
        public static String sort = "SORT";  // 排序
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String delFlag = "DEL_FLAG";  // 删除标记

    }
}
