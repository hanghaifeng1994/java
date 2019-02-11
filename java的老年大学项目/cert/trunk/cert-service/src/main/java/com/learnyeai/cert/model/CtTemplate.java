package com.learnyeai.cert.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.util.Date;
import java.util.List;

/**
 * 证书模板
 *
 * @author twang
 */
public class CtTemplate extends BaseEntity {

    /**
    * 证书模板id
    */
    @Id
    @Column(name = "TP_ID")
    private String tpId;

    /**
     * 模板名称
     */
    @Column(name = "TP_NAME")
    private String tpName;
    /**
     * 背景图片
     */
    @Column(name = "TP_IMAGE_BACKGROUND")
    private String tpImageBackground;
    /**
     * 固定图片
     */
    @Column(name = "TP_FIXED_IMAGE")
    private String tpFixedImage;
    /**
     * 模板内容
     */
    @Column(name = "TP_SUBJECT")
    private String tpSubject;
    /**
     * 是否启用
     */
    @Column(name = "TP_STATUS")
    private String tpStatus;
    /**
     * 文本1
     */
    @Column(name = "TP_TEXT_ONE")
    private String tpTextOne;
    /**
     * 文本2
     */
    @Column(name = "TP_TEXT_TWO")
    private String tpTextTwo;
    /**
     * 文本3
     */
    @Column(name = "TP_TEXT_THREE")
    private String tpTextThree;
    /**
     * 文本4
     */
    @Column(name = "TP_TEXT_FOUR")
    private String tpTextFour;
    /**
     * 文本5
     */
    @Column(name = "TP_TEXT_FIVE")
    private String tpTextFive;
    /**
     * 文本6
     */
    @Column(name = "TP_TEXT_SIX")
    private String tpTextSix;
    /**
     * 文本7
     */
    @Column(name = "TP_TEXT_SEVEN")
    private String tpTextSeven;
    /**
     * 文本8
     */
    @Column(name = "TP_TEXT_EIGHT")
    private String tpTextEight;
    /**
     * 文本9
     */
    @Column(name = "TP_TEXT_NINE")
    private String tpTextNine;
    /**
     * 文本10
     */
    @Column(name = "TP_TEXT_TEN")
    private String tpTextTen;
    /**
     * 图片1
     */
    @Column(name = "TP_IMAGE_ONE")
    private String tpImageOne;
    /**
     * 图片2
     */
    @Column(name = "TP_IMAGE_TWO")
    private String tpImageTwo;
    /**
     * 图片3
     */
    @Column(name = "TP_IMAGE_THREE")
    private String tpImageThree;
    /**
     * 图片4
     */
    @Column(name = "TP_IMAGE_FOUR")
    private String tpImageFour;
    /**
     * 图片5
     */
    @Column(name = "TP_IMAGE_FIVE")
    private String tpImageFive;
    /**
     * 静态文本1
     */
    @Column(name = "TP_STATIC_ONE")
    private String tpStaticOne;
    /**
     * 静态文本2
     */
    @Column(name = "TP_STATIC_TWO")
    private String tpStaticTwo;
    /**
     * 静态文本3
     */
    @Column(name = "TP_STATIC_THREE")
    private String tpStaticThree;
    /**
     * 删除标记
     */
    @Column(name = "DEL_FLAG")
    private String delFlag;
    /**
     * 站点
     */
    @Column(name = "SITE_ID")
    private String siteId;
    /**
     * 商户id
     */
    @Column(name = "MCHT_ID")
    private String mchtId;
    /**
     * 商户方案id
     */
    @Column(name = "MCHT_SCHM_ID")
    private String mchtSchmId;
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
    
    @Transient
	private List<String> siteIds;//站点id列表

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId;
    }
    public String getTpName() {
        return tpName;
    }

    public void setTpName(String tpName) {
        this.tpName = tpName;
    }
    public String getTpImageBackground() {
        return tpImageBackground;
    }

    public void setTpImageBackground(String tpImageBackground) {
        this.tpImageBackground = tpImageBackground;
    }
    public String getTpFixedImage() {
        return tpFixedImage;
    }

    public void setTpFixedImage(String tpFixedImage) {
        this.tpFixedImage = tpFixedImage;
    }
    public String getTpSubject() {
        return tpSubject;
    }

    public void setTpSubject(String tpSubject) {
        this.tpSubject = tpSubject;
    }
    public String getTpStatus() {
        return tpStatus;
    }

    public void setTpStatus(String tpStatus) {
        this.tpStatus = tpStatus;
    }
    public String getTpTextOne() {
        return tpTextOne;
    }

    public void setTpTextOne(String tpTextOne) {
        this.tpTextOne = tpTextOne;
    }
    public String getTpTextTwo() {
        return tpTextTwo;
    }

    public void setTpTextTwo(String tpTextTwo) {
        this.tpTextTwo = tpTextTwo;
    }
    public String getTpTextThree() {
        return tpTextThree;
    }

    public void setTpTextThree(String tpTextThree) {
        this.tpTextThree = tpTextThree;
    }
    public String getTpTextFour() {
        return tpTextFour;
    }

    public void setTpTextFour(String tpTextFour) {
        this.tpTextFour = tpTextFour;
    }
    public String getTpTextFive() {
        return tpTextFive;
    }

    public void setTpTextFive(String tpTextFive) {
        this.tpTextFive = tpTextFive;
    }
    public String getTpTextSix() {
        return tpTextSix;
    }

    public void setTpTextSix(String tpTextSix) {
        this.tpTextSix = tpTextSix;
    }
    public String getTpTextSeven() {
        return tpTextSeven;
    }

    public void setTpTextSeven(String tpTextSeven) {
        this.tpTextSeven = tpTextSeven;
    }
    public String getTpTextEight() {
        return tpTextEight;
    }

    public void setTpTextEight(String tpTextEight) {
        this.tpTextEight = tpTextEight;
    }
    public String getTpTextNine() {
        return tpTextNine;
    }

    public void setTpTextNine(String tpTextNine) {
        this.tpTextNine = tpTextNine;
    }
    public String getTpTextTen() {
        return tpTextTen;
    }

    public void setTpTextTen(String tpTextTen) {
        this.tpTextTen = tpTextTen;
    }
    public String getTpImageOne() {
        return tpImageOne;
    }

    public void setTpImageOne(String tpImageOne) {
        this.tpImageOne = tpImageOne;
    }
    public String getTpImageTwo() {
        return tpImageTwo;
    }

    public void setTpImageTwo(String tpImageTwo) {
        this.tpImageTwo = tpImageTwo;
    }
    public String getTpImageThree() {
        return tpImageThree;
    }

    public void setTpImageThree(String tpImageThree) {
        this.tpImageThree = tpImageThree;
    }
    public String getTpImageFour() {
        return tpImageFour;
    }

    public void setTpImageFour(String tpImageFour) {
        this.tpImageFour = tpImageFour;
    }
    public String getTpImageFive() {
        return tpImageFive;
    }

    public void setTpImageFive(String tpImageFive) {
        this.tpImageFive = tpImageFive;
    }
    public String getTpStaticOne() {
        return tpStaticOne;
    }

    public void setTpStaticOne(String tpStaticOne) {
        this.tpStaticOne = tpStaticOne;
    }
    public String getTpStaticTwo() {
        return tpStaticTwo;
    }

    public void setTpStaticTwo(String tpStaticTwo) {
        this.tpStaticTwo = tpStaticTwo;
    }
    public String getTpStaticThree() {
        return tpStaticThree;
    }

    public void setTpStaticThree(String tpStaticThree) {
        this.tpStaticThree = tpStaticThree;
    }
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }
    public String getMchtSchmId() {
        return mchtSchmId;
    }

    public void setMchtSchmId(String mchtSchmId) {
        this.mchtSchmId = mchtSchmId;
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

    public static class TF {

        public static String TABLE_NAME = "CT_TEMPLATE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String tpId = "TP_ID";  // 证书模板id
        public static String tpName = "TP_NAME";  // 模板名称
        public static String tpImageBackground = "TP_IMAGE_BACKGROUND";  // 背景图片
        public static String tpFixedImage = "TP_FIXED_IMAGE";  // 固定图片
        public static String tpSubject = "TP_SUBJECT";  // 模板内容
        public static String tpStatus = "TP_STATUS";  // 是否启用
        public static String tpTextOne = "TP_TEXT_ONE";  // 文本1
        public static String tpTextTwo = "TP_TEXT_TWO";  // 文本2
        public static String tpTextThree = "TP_TEXT_THREE";  // 文本3
        public static String tpTextFour = "TP_TEXT_FOUR";  // 文本4
        public static String tpTextFive = "TP_TEXT_FIVE";  // 文本5
        public static String tpTextSix = "TP_TEXT_SIX";  // 文本6
        public static String tpTextSeven = "TP_TEXT_SEVEN";  // 文本7
        public static String tpTextEight = "TP_TEXT_EIGHT";  // 文本8
        public static String tpTextNine = "TP_TEXT_NINE";  // 文本9
        public static String tpTextTen = "TP_TEXT_TEN";  // 文本10
        public static String tpImageOne = "TP_IMAGE_ONE";  // 图片1
        public static String tpImageTwo = "TP_IMAGE_TWO";  // 图片2
        public static String tpImageThree = "TP_IMAGE_THREE";  // 图片3
        public static String tpImageFour = "TP_IMAGE_FOUR";  // 图片4
        public static String tpImageFive = "TP_IMAGE_FIVE";  // 图片5
        public static String tpStaticOne = "TP_STATIC_ONE";  // 静态文本1
        public static String tpStaticTwo = "TP_STATIC_TWO";  // 静态文本2
        public static String tpStaticThree = "TP_STATIC_THREE";  // 静态文本3
        public static String delFlag = "DEL_FLAG";  // 删除标记
        public static String siteId = "SITE_ID";  // 站点
        public static String mchtId = "MCHT_ID";  // 商户id
        public static String mchtSchmId = "MCHT_SCHM_ID";  // 商户方案id
        public static String createBy = "CREATE_BY";  // 创建人
        public static String createDate = "CREATE_DATE";  // 创建时间
        public static String updateBy = "UPDATE_BY";  // 更新人
        public static String updateDate = "UPDATE_DATE";  // 更新时间

    }

	public List<String> getSiteIds() {
		return siteIds;
	}

	public void setSiteIds(List<String> siteIds) {
		this.siteIds = siteIds;
	}
}
