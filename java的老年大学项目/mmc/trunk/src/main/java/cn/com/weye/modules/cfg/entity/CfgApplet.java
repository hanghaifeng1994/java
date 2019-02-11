package cn.com.weye.modules.cfg.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;
import java.util.Date;

/**
 * 小程序
 *
 * @author zpzxskxsk@126.com
 */
public class CfgApplet extends BBaseEntity {

    /**
     * id
     */
    private String apltId;
    /**
     * 小程序appid
     */
    private String apltAppId;
    /**
     * 小程序secret
     */
    private String apltAppSecret;
    /**
     * 小程序名称
     */
    private String apltName;
    /**
     * 小程序描述
     */
    private String apltDesc;
    /**
     * 模块编码
     */
    private String apltMdlCode;
    /**
     * 版本编码
     */
    private Long apltVerCode;
    /**
     * 当前版本id
     */
    private String apltVerId;
    /**
     * 行业方案id
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

    public String getApltId() {
        return apltId;
    }

    public void setApltId(String apltId) {
        this.apltId = apltId;
    }
    public String getApltAppId() {
        return apltAppId;
    }

    public void setApltAppId(String apltAppId) {
        this.apltAppId = apltAppId;
    }
    public String getApltAppSecret() {
        return apltAppSecret;
    }

    public void setApltAppSecret(String apltAppSecret) {
        this.apltAppSecret = apltAppSecret;
    }
    public String getApltName() {
        return apltName;
    }

    public void setApltName(String apltName) {
        this.apltName = apltName;
    }
    public String getApltDesc() {
        return apltDesc;
    }

    public void setApltDesc(String apltDesc) {
        this.apltDesc = apltDesc;
    }
    public String getApltMdlCode() {
        return apltMdlCode;
    }

    public void setApltMdlCode(String apltMdlCode) {
        this.apltMdlCode = apltMdlCode;
    }
    public Long getApltVerCode() {
        return apltVerCode;
    }

    public void setApltVerCode(Long apltVerCode) {
        this.apltVerCode = apltVerCode;
    }
    public String getApltVerId() {
        return apltVerId;
    }

    public void setApltVerId(String apltVerId) {
        this.apltVerId = apltVerId;
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

        public static String TABLE_NAME = "CFG_APPLET";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String apltId = "APLT_ID";  // id
        public static String apltAppId = "APLT_APP_ID";  // 小程序appid
        public static String apltAppSecret = "APLT_APP_SECRET";  // 小程序secret
        public static String apltName = "APLT_NAME";  // 小程序名称
        public static String apltDesc = "APLT_DESC";  // 小程序描述
        public static String apltMdlCode = "APLT_MDL_CODE";  // 模块编码
        public static String apltVerCode = "APLT_VER_CODE";  // 版本编码
        public static String apltVerId = "APLT_VER_ID";  // 当前版本id
        public static String schmId = "SCHM_ID";  // 行业方案id
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String delFlag = "DEL_FLAG";  // 删除标记

    }
}
