package com.learnyeai.schoolclass.api.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.learnyeai.core.support.BaseVo;

/**
 * 订单
 *
 * @author twang
 */
public class OrdOrderformVo extends BaseVo {

	public static final int TYPE_PERSON = 1; // 个人订单
	public static final int TYPE_TEAM = 2; // 集体订单

	public static final int STATUS_WAIT = 1; // 订单待付状态
	public static final int STATUS_NOVALID = 2; // 订单过期作废
	public static final int STATUS_SUCCESSED = 3; // 完成订单
	public static final int STATUS_ROLLBACK = 6; // 退单

	public static final int PAYTYPE_ONLINE = 1; // 线上
	public static final int PAYTYPE_OFFINE = 2; // 线下

	public static final int ORDER_TYPE_COURSE = 1; // 购买课程
	public static final int ORDER_TYPE_PROGRAM = 2;// 项目报名

	public static final String PAY_QD_WX = "wx"; // 支付途径 微信
	public static final String PAY_QD_ALI = "ali"; // 支付途径 支付宝
	public static final String PAY_QD_UNION = "union"; // 支付途径 银联

	public static final int PAYSOURCE_ONLINE = 3; // 在线支付
	public static final int PAYSOURCE_BANK = 1; // 支付通道 银行付款
	public static final int PAYSOURCE_FACE_TO_FACE = 2;// 现场支付

	public static final String PAY_APPTYPE_APP = "app"; // 下单应用类型 app
	public static final String PAY_APPTYPE_WXMAPP = "wxmapp"; // 下单应用类型微信小程序 app
	public static final String PAY_APPTYPE_WEB = "web"; // 下单应用类型网页

	/**
	 * 订单id
	 */
	private String orderId;

	/**
	 * 名称
	 */
	private String name;
	/**
	 * 订单号
	 */
	private String sn;
	/**
	 * 下单人id
	 */
	private String userId;
	/**
	 * 班级id
	 */
	private String czId;
	/**
	 * 下单人姓名
	 */
	private String userName;
	/**
	 * 下单人身份证
	 */
	private String idcard;
	/**
	 * 批次id
	 */
	private String batchId;
	/**
	 * 订单类型1:个人订单;2:集体订单
	 */
	private Integer type;
	/**
	 * 订单类型1:购买课程;2:班级报名
	 */
	private Integer orderType;
	/**
	 * 文件格式
	 */
	private Integer status;
	/**
	 * 订单应收
	 */
	private double needPrice;
	/**
	 * 订单实收
	 */
	private double realPrice;
	/**
	 * 状态：0未提交、1审核中、2审核通过、3审核失败、4不需要审核
	 */
	private double discount;
	/**
	 * 回调url
	 */
	private String callbackUrl;
	/**
	 * 支付方式1:线上;2:线下
	 */
	private Integer payType;
	/**
	 * 给支付平台的订单号
	 */
	private String upopSn;
	/**
	 * 支付平台是否支付成功
	 */
	private String upopSuccess;
	/**
	 * 到支付平台的查询次数
	 */
	private Integer queryNum;
	/**
	 * 是否信用卡
	 */
	private String xyk;
	/**
	 * 下单应用类型（web/app/wxmapp）
	 */
	private String payAppType;
	/**
	 * 支付应用类型（web/app/wxmapp）
	 */
	private String factPayAppType;
	/**
	 * 是否废弃订单
	 */
	private String fqStatus;
	/**
	 * 支付平台(wx/ali/union)
	 */
	private String payPath;
	/**
	 * 支付途径1:银行付款;2:现场支付;3:在线支付
	 */
	private Integer paySource;
	/**
	 * 订单付款备注
	 */
	private String remark;
	/**
	 * 支付操作者
	 */
	private String payOperator;
	/**
	 * 订单结束时间
	 */
	private Date endTime;
	/**
	 * 到支付平台的订单时间
	 */
	private Date upopTime;
	/**
	 * 废弃时间或失效时间
	 */
	private Date fqTime;
	/**
	 * 支付时间
	 */
	private Date payDate;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 站点
	 */
	private String siteId;
	/**
	 * 商户id
	 */
	private String mchtId;
	/**
	 * 商户方案id
	 */
	private String mchtSchmId;

	private List<OrdOrderformDetailVo> details = new ArrayList<OrdOrderformDetailVo>();

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCzId() {
		return czId;
	}

	public void setCzId(String czId) {
		this.czId = czId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public double getNeedPrice() {
		return needPrice;
	}

	public void setNeedPrice(double needPrice) {
		this.needPrice = needPrice;
	}

	public double getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getUpopSn() {
		return upopSn;
	}

	public void setUpopSn(String upopSn) {
		this.upopSn = upopSn;
	}

	public String getUpopSuccess() {
		return upopSuccess;
	}

	public void setUpopSuccess(String upopSuccess) {
		this.upopSuccess = upopSuccess;
	}

	public Integer getQueryNum() {
		return queryNum;
	}

	public void setQueryNum(Integer queryNum) {
		this.queryNum = queryNum;
	}

	public String getXyk() {
		return xyk;
	}

	public void setXyk(String xyk) {
		this.xyk = xyk;
	}

	public String getPayAppType() {
		return payAppType;
	}

	public void setPayAppType(String payAppType) {
		this.payAppType = payAppType;
	}

	public String getFactPayAppType() {
		return factPayAppType;
	}

	public void setFactPayAppType(String factPayAppType) {
		this.factPayAppType = factPayAppType;
	}

	public String getFqStatus() {
		return fqStatus;
	}

	public void setFqStatus(String fqStatus) {
		this.fqStatus = fqStatus;
	}

	public String getPayPath() {
		return payPath;
	}

	public void setPayPath(String payPath) {
		this.payPath = payPath;
	}

	public Integer getPaySource() {
		return paySource;
	}

	public void setPaySource(Integer paySource) {
		this.paySource = paySource;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPayOperator() {
		return payOperator;
	}

	public void setPayOperator(String payOperator) {
		this.payOperator = payOperator;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getUpopTime() {
		return upopTime;
	}

	public void setUpopTime(Date upopTime) {
		this.upopTime = upopTime;
	}

	public Date getFqTime() {
		return fqTime;
	}

	public void setFqTime(Date fqTime) {
		this.fqTime = fqTime;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	public static class TF {
		public static String orderId = "orderId"; // 订单id
		public static String name = "name"; // 名称
		public static String sn = "sn"; // 订单号
		public static String userId = "userId"; // 下单人id
		public static String czId = "czId"; // 班级id
		public static String userName = "userName"; // 下单人姓名
		public static String idcard = "idcard"; // 下单人身份证
		public static String batchId = "batchId"; // 批次id
		public static String type = "type"; // 订单类型1:个人订单;2:集体订单
		public static String orderType = "orderType"; // 订单类型1:购买课程;2:班级报名
		public static String status = "status"; // 文件格式
		public static String needPrice = "needPrice"; // 订单应收
		public static String realPrice = "realPrice"; // 订单实收
		public static String discount = "discount"; // 状态：0未提交、1审核中、2审核通过、3审核失败、4不需要审核
		public static String callbackUrl = "callbackUrl"; // 回调url
		public static String payType = "payType"; // 支付方式1:线上;2:线下
		public static String upopSn = "upopSn"; // 给支付平台的订单号
		public static String upopSuccess = "upopSuccess"; // 支付平台是否支付成功
		public static String queryNum = "queryNum"; // 到支付平台的查询次数
		public static String xyk = "xyk"; // 是否信用卡
		public static String payAppType = "payAppType"; // 下单应用类型（web/app/wxmapp）
		public static String factPayAppType = "factPayAppType"; // 支付应用类型（web/app/wxmapp）
		public static String fqStatus = "fqStatus"; // 是否废弃订单
		public static String payPath = "payPath"; // 支付平台(wx/ali/union)
		public static String paySource = "paySource"; // 支付途径1:银行付款;2:现场支付;3:在线支付
		public static String remark = "remark"; // 订单付款备注
		public static String payOperator = "payOperator"; // 支付操作者
		public static String endTime = "endTime"; // 订单结束时间
		public static String upopTime = "upopTime"; // 到支付平台的订单时间
		public static String fqTime = "fqTime"; // 废弃时间或失效时间
		public static String payDate = "payDate"; // 支付时间
		public static String createDate = "createDate"; // 创建时间
		public static String updateDate = "updateDate"; // 更新时间
		public static String siteId = "siteId"; // 站点
		public static String mchtId = "mchtId"; // 商户id
		public static String mchtSchmId = "mchtSchmId"; // 商户方案id

	}

	public List<OrdOrderformDetailVo> getDetails() {
		return details;
	}

	public void setDetails(List<OrdOrderformDetailVo> details) {
		this.details = details;
	}

}
