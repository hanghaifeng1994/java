package cn.com.weye.modules.sh.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;
import java.util.Date;

/**
 * 商户方案
 *
 * @author yl
 */
public class ShMerchantScheme extends BBaseEntity {

    /**
     * 商家方案id
     */
    private String mchtSchmId;
    /**
     * 到期时间
     */
    private Date mchtSchmExpireDate;
    /**
     * 当前订单id
     */
    private String ordId;
    /**
     * 0禁用、1启用
     */
    private String mchtSchmStatus;
    /**
     * 0未付费、1已付费、2欠费
     */
    private String mchtSchmPayStatus;
    /**
     * 0不升级、1免费升级
     */
    private String mchtUpgradeStatus;
    /**
     * 方案版本id
     */
    private String schmEdtId;
    /**
     * 方案版本历史id
     */
    private String schmEdtHisId;
    /**
     * 商户id
     */
    private String mchtId;
    /**
     * 创建人名称
     */
    private String createUserName;
    /**
     * 修改人名称
     */
    private String updateUserName;
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
    /*
    商户名称
     */
    private String mchtName;

    /**
     * 生成订单字段
     * @return
     */

    public String getMchtName() {
        return mchtName;
    }

    public void setMchtName(String mchtName) {
        this.mchtName = mchtName;
    }

    public String getMchtSchmId() {
        return mchtSchmId;
    }

    public void setMchtSchmId(String mchtSchmId) {
        this.mchtSchmId = mchtSchmId;
    }
    public Date getMchtSchmExpireDate() {
        return mchtSchmExpireDate;
    }

    public void setMchtSchmExpireDate(Date mchtSchmExpireDate) {
        this.mchtSchmExpireDate = mchtSchmExpireDate;
    }
    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }
    public String getMchtSchmStatus() {
        return mchtSchmStatus;
    }

    public void setMchtSchmStatus(String mchtSchmStatus) {
        this.mchtSchmStatus = mchtSchmStatus;
    }
    public String getMchtSchmPayStatus() {
        return mchtSchmPayStatus;
    }

    public void setMchtSchmPayStatus(String mchtSchmPayStatus) {
        this.mchtSchmPayStatus = mchtSchmPayStatus;
    }
    public String getMchtUpgradeStatus() {
        return mchtUpgradeStatus;
    }

    public void setMchtUpgradeStatus(String mchtUpgradeStatus) {
        this.mchtUpgradeStatus = mchtUpgradeStatus;
    }
    public String getSchmEdtId() {
        return schmEdtId;
    }

    public void setSchmEdtId(String schmEdtId) {
        this.schmEdtId = schmEdtId;
    }
    public String getSchmEdtHisId() {
        return schmEdtHisId;
    }

    public void setSchmEdtHisId(String schmEdtHisId) {
        this.schmEdtHisId = schmEdtHisId;
    }
    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }
    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }
    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
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

        public static String TABLE_NAME = "SH_MERCHANT_SCHEME";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商家方案id
        public static String mchtSchmExpireDate = "MCHT_SCHM_EXPIRE_DATE";  // 到期时间
        public static String ordId = "ORD_ID";  // 当前订单id
        public static String mchtSchmStatus = "MCHT_SCHM_STATUS";  // 0禁用、1启用
        public static String mchtSchmPayStatus = "MCHT_SCHM_PAY_STATUS";  // 0未付费、1已付费、2欠费
        public static String mchtUpgradeStatus = "MCHT_UPGRADE_STATUS";  // 0不升级、1免费升级
        public static String schmEdtId = "SCHM_EDT_ID";  // 方案版本id
        public static String schmEdtHisId = "SCHM_EDT_HIS_ID";  // 方案版本历史id
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String createUserName = "CREATE_USER_NAME";  // 创建人名称
        public static String updateUserName = "UPDATE_USER_NAME";  // 修改人名称
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String delFlag = "DEL_FLAG";  // 删除标记

    }
}
