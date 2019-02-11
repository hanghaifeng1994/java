package cn.com.weye.modules.cfg.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;
import java.util.Date;

/**
 * 模块
 *
 * @author zpzxskxsk@126.com
 */
public class CfgModule extends BBaseEntity {

    /**
     * 模块id
     */
    private String mdlId;
    /**
     * 模块编码
     */
    private String mdlCode;
    /**
     * 模块名称
     */
    private String mdlName;
    /**
     * 0禁用、1启用
     */
    private String mdlStatus;
    /**
     * 员工扩展表名
     */
    private String mdlStaffTableName;
    /**
     * 用户表扩展名
     */
    private String mdlUserTableName;
    /**
     * 模块上下文
     */
    private String mdlServerContext;
    /**
     * 版本号
     */
    private String mdlVerName;
    /**
     * 版本编码
     */
    private Long mdlVerCode;
    /**
     * 版本id
     */
    private String mdlVerId;
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
     * 删除标记
     */
    private String delFlag;

    public String getMdlId() {
        return mdlId;
    }

    public void setMdlId(String mdlId) {
        this.mdlId = mdlId;
    }
    public String getMdlCode() {
        return mdlCode;
    }

    public void setMdlCode(String mdlCode) {
        this.mdlCode = mdlCode;
    }
    public String getMdlName() {
        return mdlName;
    }

    public void setMdlName(String mdlName) {
        this.mdlName = mdlName;
    }
    public String getMdlStatus() {
        return mdlStatus;
    }

    public void setMdlStatus(String mdlStatus) {
        this.mdlStatus = mdlStatus;
    }
    public String getMdlStaffTableName() {
        return mdlStaffTableName;
    }

    public void setMdlStaffTableName(String mdlStaffTableName) {
        this.mdlStaffTableName = mdlStaffTableName;
    }
    public String getMdlUserTableName() {
        return mdlUserTableName;
    }

    public void setMdlUserTableName(String mdlUserTableName) {
        this.mdlUserTableName = mdlUserTableName;
    }
    public String getMdlServerContext() {
        return mdlServerContext;
    }

    public void setMdlServerContext(String mdlServerContext) {
        this.mdlServerContext = mdlServerContext;
    }
    public String getMdlVerName() {
        return mdlVerName;
    }

    public void setMdlVerName(String mdlVerName) {
        this.mdlVerName = mdlVerName;
    }
    public Long getMdlVerCode() {
        return mdlVerCode;
    }

    public void setMdlVerCode(Long mdlVerCode) {
        this.mdlVerCode = mdlVerCode;
    }
    public String getMdlVerId() {
        return mdlVerId;
    }

    public void setMdlVerId(String mdlVerId) {
        this.mdlVerId = mdlVerId;
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

        public static String TABLE_NAME = "CFG_MODULE";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String mdlId = "MDL_ID";  // 模块id
        public static String mdlCode = "MDL_CODE";  // 模块编码
        public static String mdlName = "MDL_NAME";  // 模块名称
        public static String mdlStatus = "MDL_STATUS";  // 0禁用、1启用
        public static String mdlStaffTableName = "MDL_STAFF_TABLE_NAME";  // 员工扩展表名
        public static String mdlUserTableName = "MDL_USER_TABLE_NAME";  // 用户表扩展名
        public static String mdlServerContext = "MDL_SERVER_CONTEXT";  // 模块上下文
        public static String mdlVerName = "MDL_VER_NAME";  // 版本号
        public static String mdlVerCode = "MDL_VER_CODE";  // 版本编码
        public static String mdlVerId = "MDL_VER_ID";  // 版本id
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String delFlag = "DEL_FLAG";  // 删除标记

    }
}
