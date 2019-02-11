package cn.com.weye.modules.cfg.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;
import java.util.Date;

/**
 * 方案版本升级信息
 *
 * @author zpzxskxsk@126.com
 */
public class CfgSchemeEditionUpdateInfo extends BBaseEntity {

    /**
     * id
     */
    private String edtUpId;
    /**
     * 方案版本id
     */
    private String schmEdtId;
    /**
     * 版本编码
     */
    private Long schmEdtCode;
    /**
     * 版本名称
     */
    private String edtUpVerName;
    /**
     * 版本时间
     */
    private Date edtUpVerDate;
    /**
     * 升级内容
     */
    private String edtUpContent;
    /**
     * 1版本升级、2小程序升级、3自定义升级
     */
    private String edtUpType;
    /**
     * 对象id，类型是版本时是方案版本历史id小程序时是小程序版本id
     */
    private String edtUpObjId;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createDate;

    public String getEdtUpId() {
        return edtUpId;
    }

    public void setEdtUpId(String edtUpId) {
        this.edtUpId = edtUpId;
    }
    public String getSchmEdtId() {
        return schmEdtId;
    }

    public void setSchmEdtId(String schmEdtId) {
        this.schmEdtId = schmEdtId;
    }
    public Long getSchmEdtCode() {
        return schmEdtCode;
    }

    public void setSchmEdtCode(Long schmEdtCode) {
        this.schmEdtCode = schmEdtCode;
    }
    public String getEdtUpVerName() {
        return edtUpVerName;
    }

    public void setEdtUpVerName(String edtUpVerName) {
        this.edtUpVerName = edtUpVerName;
    }
    public Date getEdtUpVerDate() {
        return edtUpVerDate;
    }

    public void setEdtUpVerDate(Date edtUpVerDate) {
        this.edtUpVerDate = edtUpVerDate;
    }
    public String getEdtUpContent() {
        return edtUpContent;
    }

    public void setEdtUpContent(String edtUpContent) {
        this.edtUpContent = edtUpContent;
    }
    public String getEdtUpType() {
        return edtUpType;
    }

    public void setEdtUpType(String edtUpType) {
        this.edtUpType = edtUpType;
    }
    public String getEdtUpObjId() {
        return edtUpObjId;
    }

    public void setEdtUpObjId(String edtUpObjId) {
        this.edtUpObjId = edtUpObjId;
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

        public static String TABLE_NAME = "CFG_SCHEME_EDITION_UPDATE_INFO";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String edtUpId = "EDT_UP_ID";  // id
        public static String schmEdtId = "SCHM_EDT_ID";  // 方案版本id
        public static String schmEdtCode = "SCHM_EDT_CODE";  // 版本编码
        public static String edtUpVerName = "EDT_UP_VER_NAME";  // 版本名称
        public static String edtUpVerDate = "EDT_UP_VER_DATE";  // 版本时间
        public static String edtUpContent = "EDT_UP_CONTENT";  // 升级内容
        public static String edtUpType = "EDT_UP_TYPE";  // 1版本升级、2小程序升级、3自定义升级
        public static String edtUpObjId = "EDT_UP_OBJ_ID";  // 对象id，类型是版本时是方案版本历史id小程序时是小程序版本id
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间

    }
}
