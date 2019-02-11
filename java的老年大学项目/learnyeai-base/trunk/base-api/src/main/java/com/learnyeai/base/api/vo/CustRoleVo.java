package com.learnyeai.base.api.vo;

import com.learnyeai.core.support.BaseVo;

import java.util.Date;

/**
 * 角色-暂不用
 *
 * @author zhangpz
 */
public class CustRoleVo extends BaseVo {

    /**
    * ID
    */
    private String roleId;

    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 0否、1是
     */
    private String userable;
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
     * 备注
     */
    private String remarks;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getUserable() {
        return userable;
    }

    public void setUserable(String userable) {
        this.userable = userable;
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
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public static class CF {
        public static String roleId = "roleId";  // ID
        public static String roleName = "roleName";  // 角色名称
        public static String userable = "userable";  // 0否、1是
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String updateBy = "updateBy";  // 更新人
        public static String updateDate = "updateDate";  // 更新时间
        public static String remarks = "remarks";  // 备注
        public static String delFlag = "delFlag";  // 删除标记

    }

}
