package com.learnyeai.base.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商户门店
 *
 * @author zhangpz
 */
public class ShStore extends BaseEntity {

    /**
    * 门店id
    */
    @Id
    @Column(name = "STORE_ID")
    private String storeId;

    /**
     * 门店名称
     */
    @Column(name = "STORE_NAME")
    private String storeName;
    /**
     * 门店编码
     */
    @Column(name = "STORE_CODE")
    private String storeCode;
    /**
     * 地址
     */
    @Column(name = "STORE_ADRESS")
    private String storeAdress;
    /**
     * 图片
     */
    @Column(name = "STORE_PHOTO")
    private String storePhoto;
    /**
     * 图片展示
     */
    @Column(name = "STORE_IMGS")
    private String storeImgs;
    /**
     * 负责人
     */
    @Column(name = "STORE_LINKMAN")
    private String storeLinkman;
    /**
     * 电话
     */
    @Column(name = "STORE_PHONE")
    private String storePhone;
    /**
     * 门店介绍
     */
    @Column(name = "STORE_INFO")
    private String storeInfo;
    /**
     * 经度
     */
    @Column(name = "Y_LINE")
    private String yLine;
    /**
     * 纬度
     */
    @Column(name = "X_LINE")
    private String xLine;
    /**
     * 商户方案ID
     */
    @Column(name = "MCHT_SCHM_ID")
    private String mchtSchmId;
    /**
     * 商户id
     */
    @Column(name = "MCHT_ID")
    private String mchtId;
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

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
    public String getStoreAdress() {
        return storeAdress;
    }

    public void setStoreAdress(String storeAdress) {
        this.storeAdress = storeAdress;
    }
    public String getStorePhoto() {
        return storePhoto;
    }

    public void setStorePhoto(String storePhoto) {
        this.storePhoto = storePhoto;
    }
    public String getStoreImgs() {
        return storeImgs;
    }

    public void setStoreImgs(String storeImgs) {
        this.storeImgs = storeImgs;
    }
    public String getStoreLinkman() {
        return storeLinkman;
    }

    public void setStoreLinkman(String storeLinkman) {
        this.storeLinkman = storeLinkman;
    }
    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }
    public String getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo;
    }
    public String getYLine() {
        return yLine;
    }

    public void setYLine(String yLine) {
        this.yLine = yLine;
    }
    public String getXLine() {
        return xLine;
    }

    public void setXLine(String xLine) {
        this.xLine = xLine;
    }
    public String getMchtSchmId() {
        return mchtSchmId;
    }

    public void setMchtSchmId(String mchtSchmId) {
        this.mchtSchmId = mchtSchmId;
    }
    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
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

        public static String TABLE_NAME = "SH_STORE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String storeId = "STORE_ID";  // 门店id
        public static String storeName = "STORE_NAME";  // 门店名称
        public static String storeCode = "STORE_CODE";  // 门店编码
        public static String storeAdress = "STORE_ADRESS";  // 地址
        public static String storePhoto = "STORE_PHOTO";  // 图片
        public static String storeImgs = "STORE_IMGS";  // 图片展示
        public static String storeLinkman = "STORE_LINKMAN";  // 负责人
        public static String storePhone = "STORE_PHONE";  // 电话
        public static String storeInfo = "STORE_INFO";  // 门店介绍
        public static String yLine = "Y_LINE";  // 经度
        public static String xLine = "X_LINE";  // 纬度
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案ID
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间
        public static String delFlag = "DEL_FLAG";  // 删除标记

    }
}
