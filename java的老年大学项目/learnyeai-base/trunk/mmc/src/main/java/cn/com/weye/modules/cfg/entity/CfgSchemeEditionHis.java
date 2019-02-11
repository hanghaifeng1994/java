package cn.com.weye.modules.cfg.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;
import java.util.Date;

/**
 * 方案版本历史
 *
 * @author zpzxskxsk@126.com
 */
public class CfgSchemeEditionHis extends BBaseEntity {

    /**
     * 方案版本历史id
     */
    private String schmEdtHisId;
    /**
     * 版本状态：0未添加升级信息 1已添加升级信息
     */
    private String schmEdtHisStatus;
    /**
     * 
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

    public static class TF {

        public static String TABLE_NAME = "CFG_SCHEME_EDITION_HIS";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String schmEdtHisId = "SCHM_EDT_HIS_ID";  // 方案版本历史id
        public static String schmEdtHisStatus = "SCHM_EDT_HIS_STATUS";  // 版本状态：0未添加升级信息 1已添加升级信息
        public static String schmEdtHisRemark = "SCHM_EDT_HIS_REMARK";  // 
        public static String schmEdtModStatus = "SCHM_EDT_MOD_STATUS";  // 编辑状态0未编辑、1修改版本信息、2修改功能包、3版本信息功能包都修改了
        public static String schmEdtId = "SCHM_EDT_ID";  // 方案版本id
        public static String schmEdtName = "SCHM_EDT_NAME";  // 方案版本名称
        public static String schmEdtDesc = "SCHM_EDT_DESC";  // 版本描述
        public static String schmEdtPhoto = "SCHM_EDT_PHOTO";  // 图片
        public static String schmEdtGrade = "SCHM_EDT_GRADE";  // 版本级别
        public static String schmId = "SCHM_ID";  // 方案id
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间

    }
}
