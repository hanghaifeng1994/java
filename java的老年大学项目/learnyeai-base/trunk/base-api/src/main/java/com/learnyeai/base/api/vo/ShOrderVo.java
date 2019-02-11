package com.learnyeai.base.api.vo;

import com.learnyeai.core.support.BaseVo;

import java.util.Date;

/**
 * 商户订单
 *
 * @author zhangpz
 */
public class ShOrderVo extends BaseVo {

    /**
    * 订单id
    */
    private String ordId;

    /**
     * 订单号
     */
    private String ordNum;
    /**
     * 方案版本历史id
     */
    private String schmEdtHisId;
    /**
     * 方案版本价格id
     */
    private String edtPrcId;
    /**
     * 1月付、2年付
     */
    private String schmEdtPayType;
    /**
     * 方案价格
     */
    private Long schmEdtPrice;
    /**
     * 增值包价格
     */
    private Long schmEdtIncreasePrice;
    /**
     * 购买数量
     */
    private Integer ordBuyNum;
    /**
     * 开始时间
     */
    private Date serviceStartDate;
    /**
     * 结束时间
     */
    private Date serviceEndDate;
    /**
     * 总金额
     */
    private Long ordTotalAmount;
    /**
     * 交费状态0未付费、1已付费、欠费
     */
    private String ordPayStatus;
    /**
     * 优惠金额
     */
    private Long ordDiscountAmount;
    /**
     * 实际金额
     */
    private Long ordRealAmount;
    /**
     * 活动id
     */
    private String actId;
    /**
     * 0正常1作废2系统作废
     */
    private String ordStatus;
    /**
     * 1购买、2升级
     */
    private String ordType;
    /**
     * 原订单id
     */
    private String ordOldId;
    /**
     * 客户经理id
     */
    private String clientManagerId;
    /**
     * 客户经理名称
     */
    private String clientManagerName;
    /**
     * 商家方案id
     */
    private String mchtSchmId;
    /**
     * 商家id
     */
    private String mchtId;
    /**
     * 1线上交、2线下交
     */
    private String ordPayType;
    /**
     * 交费时间
     */
    private Date ordPayDate;
    /**
     * 交费人名称
     */
    private String ordPayUsername;
    /**
     * 1线上、2线下
     */
    private String ordSaleType;
    /**
     * 作废时间
     */
    private Date ordCancelDate;
    /**
     * 作废人名称
     */
    private String ordCancelUsername;
    /**
     * 作废人原因
     */
    private String ordCancelCause;
    /**
     * 创建人名称
     */
    private String createUserName;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 备注
     */
    private String remarks;

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }
    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }
    public String getSchmEdtHisId() {
        return schmEdtHisId;
    }

    public void setSchmEdtHisId(String schmEdtHisId) {
        this.schmEdtHisId = schmEdtHisId;
    }
    public String getEdtPrcId() {
        return edtPrcId;
    }

    public void setEdtPrcId(String edtPrcId) {
        this.edtPrcId = edtPrcId;
    }
    public String getSchmEdtPayType() {
        return schmEdtPayType;
    }

    public void setSchmEdtPayType(String schmEdtPayType) {
        this.schmEdtPayType = schmEdtPayType;
    }
    public Long getSchmEdtPrice() {
        return schmEdtPrice;
    }

    public void setSchmEdtPrice(Long schmEdtPrice) {
        this.schmEdtPrice = schmEdtPrice;
    }
    public Long getSchmEdtIncreasePrice() {
        return schmEdtIncreasePrice;
    }

    public void setSchmEdtIncreasePrice(Long schmEdtIncreasePrice) {
        this.schmEdtIncreasePrice = schmEdtIncreasePrice;
    }
    public Integer getOrdBuyNum() {
        return ordBuyNum;
    }

    public void setOrdBuyNum(Integer ordBuyNum) {
        this.ordBuyNum = ordBuyNum;
    }
    public Date getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(Date serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }
    public Date getServiceEndDate() {
        return serviceEndDate;
    }

    public void setServiceEndDate(Date serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }
    public Long getOrdTotalAmount() {
        return ordTotalAmount;
    }

    public void setOrdTotalAmount(Long ordTotalAmount) {
        this.ordTotalAmount = ordTotalAmount;
    }
    public String getOrdPayStatus() {
        return ordPayStatus;
    }

    public void setOrdPayStatus(String ordPayStatus) {
        this.ordPayStatus = ordPayStatus;
    }
    public Long getOrdDiscountAmount() {
        return ordDiscountAmount;
    }

    public void setOrdDiscountAmount(Long ordDiscountAmount) {
        this.ordDiscountAmount = ordDiscountAmount;
    }
    public Long getOrdRealAmount() {
        return ordRealAmount;
    }

    public void setOrdRealAmount(Long ordRealAmount) {
        this.ordRealAmount = ordRealAmount;
    }
    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }
    public String getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(String ordStatus) {
        this.ordStatus = ordStatus;
    }
    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }
    public String getOrdOldId() {
        return ordOldId;
    }

    public void setOrdOldId(String ordOldId) {
        this.ordOldId = ordOldId;
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
    public String getOrdPayType() {
        return ordPayType;
    }

    public void setOrdPayType(String ordPayType) {
        this.ordPayType = ordPayType;
    }
    public Date getOrdPayDate() {
        return ordPayDate;
    }

    public void setOrdPayDate(Date ordPayDate) {
        this.ordPayDate = ordPayDate;
    }
    public String getOrdPayUsername() {
        return ordPayUsername;
    }

    public void setOrdPayUsername(String ordPayUsername) {
        this.ordPayUsername = ordPayUsername;
    }
    public String getOrdSaleType() {
        return ordSaleType;
    }

    public void setOrdSaleType(String ordSaleType) {
        this.ordSaleType = ordSaleType;
    }
    public Date getOrdCancelDate() {
        return ordCancelDate;
    }

    public void setOrdCancelDate(Date ordCancelDate) {
        this.ordCancelDate = ordCancelDate;
    }
    public String getOrdCancelUsername() {
        return ordCancelUsername;
    }

    public void setOrdCancelUsername(String ordCancelUsername) {
        this.ordCancelUsername = ordCancelUsername;
    }
    public String getOrdCancelCause() {
        return ordCancelCause;
    }

    public void setOrdCancelCause(String ordCancelCause) {
        this.ordCancelCause = ordCancelCause;
    }
    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
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
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public static class CF {
        public static String ordId = "ordId";  // 订单id
        public static String ordNum = "ordNum";  // 订单号
        public static String schmEdtHisId = "schmEdtHisId";  // 方案版本历史id
        public static String edtPrcId = "edtPrcId";  // 方案版本价格id
        public static String schmEdtPayType = "schmEdtPayType";  // 1月付、2年付
        public static String schmEdtPrice = "schmEdtPrice";  // 方案价格
        public static String schmEdtIncreasePrice = "schmEdtIncreasePrice";  // 增值包价格
        public static String ordBuyNum = "ordBuyNum";  // 购买数量
        public static String serviceStartDate = "serviceStartDate";  // 开始时间
        public static String serviceEndDate = "serviceEndDate";  // 结束时间
        public static String ordTotalAmount = "ordTotalAmount";  // 总金额
        public static String ordPayStatus = "ordPayStatus";  // 交费状态0未付费、1已付费、欠费
        public static String ordDiscountAmount = "ordDiscountAmount";  // 优惠金额
        public static String ordRealAmount = "ordRealAmount";  // 实际金额
        public static String actId = "actId";  // 活动id
        public static String ordStatus = "ordStatus";  // 0正常1作废2系统作废
        public static String ordType = "ordType";  // 1购买、2升级
        public static String ordOldId = "ordOldId";  // 原订单id
        public static String clientManagerId = "clientManagerId";  // 客户经理id
        public static String clientManagerName = "clientManagerName";  // 客户经理名称
        public static String mchtSchmId = "mchtSchmId";  // 商家方案id
        public static String mchtId = "mchtId";  // 商家id
        public static String ordPayType = "ordPayType";  // 1线上交、2线下交
        public static String ordPayDate = "ordPayDate";  // 交费时间
        public static String ordPayUsername = "ordPayUsername";  // 交费人名称
        public static String ordSaleType = "ordSaleType";  // 1线上、2线下
        public static String ordCancelDate = "ordCancelDate";  // 作废时间
        public static String ordCancelUsername = "ordCancelUsername";  // 作废人名称
        public static String ordCancelCause = "ordCancelCause";  // 作废人原因
        public static String createUserName = "createUserName";  // 创建人名称
        public static String createBy = "createBy";  // 创建人
        public static String createDate = "createDate";  // 创建时间
        public static String remarks = "remarks";  // 备注

    }

}
