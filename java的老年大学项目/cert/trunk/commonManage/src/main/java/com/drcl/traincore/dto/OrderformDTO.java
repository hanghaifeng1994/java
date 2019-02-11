package com.drcl.traincore.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

public class OrderformDTO implements Serializable {
	private static final long serialVersionUID = -8248427336075117364L;
	private String orderformId; // 订单id
	private String orderNo; // 订单号
	private String name; // 订单名称
	private Double totalPrice; // 原总金额
	private Double checkTotalPrice; // 核销总金额
	private Double checkCouponPrice;// 总价优惠金额
	private Double couponTotalPrice;// 优惠卷金额
	private Double actTotalPrice; // 实际总金额
	private String couponNo; // 优惠卷号码
	private int status; // 订单状态
	private String userId; // 用户id
	private String userName; // 用户姓名
	private String mobilephone; // 用户手机号
	private String dgId; // 导购id
	private String dgName; // 导购姓名
	private int commisionStatus; // 订单佣金状态
	private String tenantId; // 租户id
	private String storeId; // 门店id
	private Date createTime; // 生成时间
	private List<OrderformDetailDTO> details = Lists.newArrayList();

	public String getOrderformId() {
		return orderformId;
	}

	public void setOrderformId(String orderformId) {
		this.orderformId = orderformId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(String couponNo) {
		this.couponNo = couponNo;
	}

	public int getStatus() {
		return status;
	}

	public String getStatusStr() {
		String statusStr = "";
		switch (status) {
		case 0:
			statusStr = "待核销";
			break;
		case 1:
			statusStr = "核销中";
			break;
		case 2:
			statusStr = "已核销";
			break;
		case 3:
			statusStr = "已完成";
			break;
		case 9:
			statusStr = "已失效";
			break;
		default:
			break;
		}
		return statusStr;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getDgId() {
		return dgId;
	}

	public void setDgId(String dgId) {
		this.dgId = dgId;
	}

	public String getDgName() {
		return dgName;
	}

	public void setDgName(String dgName) {
		this.dgName = dgName;
	}

	public int getCommisionStatus() {
		return commisionStatus;
	}

	public String getCommisionStatusStr() {
		String commisionStatusStr = "";
		switch (commisionStatus) {
		case 0:
			commisionStatusStr = "未发放";
			break;
		case 1:
			commisionStatusStr = "已发放";
			break;
		default:
			break;
		}
		return commisionStatusStr;
	}

	public void setCommisionStatus(int commisionStatus) {
		this.commisionStatus = commisionStatus;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<OrderformDetailDTO> getDetails() {
		return details;
	}

	public void setDetails(List<OrderformDetailDTO> details) {
		this.details = details;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getCheckTotalPrice() {
		return checkTotalPrice;
	}

	public void setCheckTotalPrice(Double checkTotalPrice) {
		this.checkTotalPrice = checkTotalPrice;
	}

	public Double getCheckCouponPrice() {
		return checkCouponPrice;
	}

	public void setCheckCouponPrice(Double checkCouponPrice) {
		this.checkCouponPrice = checkCouponPrice;
	}

	public Double getCouponTotalPrice() {
		return couponTotalPrice;
	}

	public void setCouponTotalPrice(Double couponTotalPrice) {
		this.couponTotalPrice = couponTotalPrice;
	}

	public Double getActTotalPrice() {
		return actTotalPrice;
	}

	public void setActTotalPrice(Double actTotalPrice) {
		this.actTotalPrice = actTotalPrice;
	}
}
