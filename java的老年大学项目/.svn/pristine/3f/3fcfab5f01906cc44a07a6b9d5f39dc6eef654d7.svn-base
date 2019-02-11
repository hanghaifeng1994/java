package com.learnyeai.schoolclass.error;

/**
 * 订单已存在异常
 * 
 * @author twang
 *
 */
public class OrderExistException extends RuntimeException {

	private static final long serialVersionUID = 7911550669193172282L;

	private String orderId;
	private String orderNo;

	/**
	 * 构造一个基本异常.
	 *
	 * @param message
	 *            信息描述
	 */
	public OrderExistException(String message) {
		super(message);
	}

	public OrderExistException(String message, String orderId, String orderNo) {
		super(message);
		this.orderId = orderId;
		this.orderNo = orderNo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}
