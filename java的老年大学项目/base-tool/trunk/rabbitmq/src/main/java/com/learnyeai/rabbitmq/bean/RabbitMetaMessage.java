package com.learnyeai.rabbitmq.bean;

import java.util.Date;

/**
 * <p><b>Description:</b> 常量类 <p>
 * <b>Company:</b> 
 *
 * @author created by hongda at 22:49 on 2017-10-23
 * @version V0.1
 */
public class RabbitMetaMessage {
	String msgId;
	String exchange;
	String routingKey;
	Object payload;
	String payloadClass;
	boolean returnCallback;
	int msgStatus = 0; // 生产者消息状态，0未确认、1已确认、2回调处理失败、3重新发送
	int failTimes; // 定时器循环处理超时数据时，失败次数+1，returnTimes=0，再重新发送数据
	int returnTimes; // 按一定时间规律，再次发送，处理状态：死信还是未发送都更新
//	Date failDate;
	Date returnDate;
	int dealStatus=0; // 消费者处理：0未处理、1成功、2失败、3死信队列，如果是死信定时发送
	String dealResult; // 生产者自己解析数据
	Date dealDate;
	Date createDate;
	Date lastSendDate; //  上次消息发送时间
	Date lastDealMsgDate; // 上次生产者处理时间

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public String getPayloadClass() {
		return payloadClass;
	}

	public void setPayloadClass(String payloadClass) {
		this.payloadClass = payloadClass;
	}

	public boolean isReturnCallback() {
		return returnCallback;
	}
	public void setReturnCallback(boolean returnCallback) {
		this.returnCallback = returnCallback;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getRoutingKey() {
		return routingKey;
	}
	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

	public int getReturnTimes() {
		return returnTimes;
	}

	public void setReturnTimes(int returnTimes) {
		this.returnTimes = returnTimes;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(int dealStatus) {
		this.dealStatus = dealStatus;
	}

	public String getDealResult() {
		return dealResult;
	}

	public void setDealResult(String dealResult) {
		this.dealResult = dealResult;
	}

	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

    public int getFailTimes() {
        return failTimes;
    }

    public void setFailTimes(int failTimes) {
        this.failTimes = failTimes;
    }

	public int getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(int msgStatus) {
		this.msgStatus = msgStatus;
	}

	public Date getLastSendDate() {
		return lastSendDate;
	}

	public void setLastSendDate(Date lastSendDate) {
		this.lastSendDate = lastSendDate;
	}

	public Date getLastDealMsgDate() {
		return lastDealMsgDate;
	}

	public void setLastDealMsgDate(Date lastDealMsgDate) {
		this.lastDealMsgDate = lastDealMsgDate;
	}
}
