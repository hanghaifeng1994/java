package cn.com.weye.modules.cfg.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;
import java.util.Date;

/**
 * 模块版本
 *
 * @author zpzxskxsk@126.com
 */
public class CfgModuleVersion extends BBaseEntity {

    /**
     * id
     */
    private String mdlVerId;
    /**
     * 模块id
     */
    private String mdlId;
    /**
     * 模块名称
     */
    private String mdlName;
    /**
     * 版本号
     */
    private String mdlVerName;
    /**
     * 版本编码
     */
    private Long mdlVerCode;
    /**
     * 版本内容
     */
    private String mdlVerDesc;
    /**
     * 版本日期
     */
    private Date mdlVerDate;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createDate;

    public String getMdlVerId() {
        return mdlVerId;
    }

    public void setMdlVerId(String mdlVerId) {
        this.mdlVerId = mdlVerId;
    }
    public String getMdlId() {
        return mdlId;
    }

    public void setMdlId(String mdlId) {
        this.mdlId = mdlId;
    }
    public String getMdlName() {
        return mdlName;
    }

    public void setMdlName(String mdlName) {
        this.mdlName = mdlName;
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
    public String getMdlVerDesc() {
        return mdlVerDesc;
    }

    public void setMdlVerDesc(String mdlVerDesc) {
        this.mdlVerDesc = mdlVerDesc;
    }
    public Date getMdlVerDate() {
        return mdlVerDate;
    }

    public void setMdlVerDate(Date mdlVerDate) {
        this.mdlVerDate = mdlVerDate;
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

    public static class TF {

        public static String TABLE_NAME = "CFG_MODULE_VERSION";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String mdlVerId = "MDL_VER_ID";  // id
        public static String mdlId = "MDL_ID";  // 模块id
        public static String mdlName = "MDL_NAME";  // 模块名称
        public static String mdlVerName = "MDL_VER_NAME";  // 版本号
        public static String mdlVerCode = "MDL_VER_CODE";  // 版本编码
        public static String mdlVerDesc = "MDL_VER_DESC";  // 版本内容
        public static String mdlVerDate = "MDL_VER_DATE";  // 版本日期
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间

    }
}
