package cn.com.weye.modules.sh.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;
import java.util.Date;

/**
 * 商户
 *
 * @author yl
 */
public class ShMerchant extends BBaseEntity {

    /**
     * 商户id
     */
    private String mchtId;
    /**
     * 商户名称
     */
    private String mchtName;
    /**
     * 商户shortname
     */
    private String mchtShortname;
    /**
     * 商户编码
     */
    private String mchtCode;
    /**
     * 联系人
     */
    private String mchtLinkman;
    /**
     * 手机号
     */
    private String mchtPhone;
    /**
     * 座机
     */
    private String mchtTelephone;
    /**
     * 0禁用、1启用
     */
    private String mchtStatus;
    /**
     * 地址
     */
    private String mchtAdress;
    /**
     * 行业
     */
    private String mchtIndustry;
    /**
     * 客户经理id
     */
    private String clientManagerId;
    /**
     * 客户经理名称
     */
    private String clientManagerName;
    /**
     * 1线上、2线下
     */
    private String mchtAddType;
    /**
     * logo
     */
    private String mchtLogo;
    /**
     * 创建人名称
     */
    private String createUserName;
    /**
     * 更新人名称
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
     * 备注
     */
    private String remarks;
    /**
     * 删除标记
     */
    private String delFlag;

    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }
    public String getMchtName() {
        return mchtName;
    }

    public void setMchtName(String mchtName) {
        this.mchtName = mchtName;
    }
    public String getMchtShortname() {
        return mchtShortname;
    }

    public void setMchtShortname(String mchtShortname) {
        this.mchtShortname = mchtShortname;
    }
    public String getMchtCode() {
        return mchtCode;
    }

    public void setMchtCode(String mchtCode) {
        this.mchtCode = mchtCode;
    }
    public String getMchtLinkman() {
        return mchtLinkman;
    }

    public void setMchtLinkman(String mchtLinkman) {
        this.mchtLinkman = mchtLinkman;
    }
    public String getMchtPhone() {
        return mchtPhone;
    }

    public void setMchtPhone(String mchtPhone) {
        this.mchtPhone = mchtPhone;
    }
    public String getMchtTelephone() {
        return mchtTelephone;
    }

    public void setMchtTelephone(String mchtTelephone) {
        this.mchtTelephone = mchtTelephone;
    }
    public String getMchtStatus() {
        return mchtStatus;
    }

    public void setMchtStatus(String mchtStatus) {
        this.mchtStatus = mchtStatus;
    }
    public String getMchtAdress() {
        return mchtAdress;
    }

    public void setMchtAdress(String mchtAdress) {
        this.mchtAdress = mchtAdress;
    }
    public String getMchtIndustry() {
        return mchtIndustry;
    }

    public void setMchtIndustry(String mchtIndustry) {
        this.mchtIndustry = mchtIndustry;
    }
    public String getClientManagerId() {
        return clientManagerId;
    }

    public void setClientManagerId(String clientManagerId) {
        this.clientManagerId = clientManagerId;
    }
    public String getClientManagerName() {
        return clientManagerName;
    }

    public void setClientManagerName(String clientManagerName) {
        this.clientManagerName = clientManagerName;
    }
    public String getMchtAddType() {
        return mchtAddType;
    }

    public void setMchtAddType(String mchtAddType) {
        this.mchtAddType = mchtAddType;
    }
    public String getMchtLogo() {
        return mchtLogo;
    }

    public void setMchtLogo(String mchtLogo) {
        this.mchtLogo = mchtLogo;
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
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public static class TF {

        public static String TABLE_NAME = "SH_MERCHANT";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtName = "MCHT_NAME";  // 商户名称
        public static String mchtShortname = "MCHT_SHORTNAME";  // 商户shortname
        public static String mchtCode = "MCHT_CODE";  // 商户编码
        public static String mchtLinkman = "MCHT_LINKMAN";  // 联系人
        public static String mchtPhone = "MCHT_PHONE";  // 手机号
        public static String mchtTelephone = "MCHT_TELEPHONE";  // 座机
        public static String mchtStatus = "MCHT_STATUS";  // 0禁用、1启用
        public static String mchtAdress = "MCHT_ADRESS";  // 地址
        public static String mchtIndustry = "MCHT_INDUSTRY";  // 行业
        public static String clientManagerId = "CLIENT_MANAGER_ID";  // 客户经理id
        public static String clientManagerName = "CLIENT_MANAGER_NAME";  // 客户经理名称
        public static String mchtAddType = "MCHT_ADD_TYPE";  // 1线上、2线下
        public static String mchtLogo = "MCHT_LOGO";  // logo
        public static String createUserName = "CREATE_USER_NAME";  // 创建人名称
        public static String updateUserName = "UPDATE_USER_NAME";  // 更新人名称
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String remarks = "REMARKS";  // 备注
        public static String delFlag = "DEL_FLAG";  // 删除标记

    }
}
