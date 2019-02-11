package cn.com.weyeyun.rabbitmq.vo;

import cn.com.weyeyun.core.support.BaseVo;
import java.util.Date;

/**
 * 
 *
 * @author yl
 */
public class RabMsgTempTableVo extends BaseVo {

    /**
    * 消息id
    */
    private String msgId;

    /**
     * 消息服务的名称
     */
    private String serverName;
    /**
     * 
     */
    private String exchange;
    /**
     * 
     */
    private String routingKey;
    /**
     * 传递的消息内容
     */
    private String payload;
    /**
     * 生产者消息状态，0未确认、1已确认、2回调处理失败
     */
    private Integer msgStatus;
    /**
     * 定时器循环处理超时数据时，失败次数+1，returnTimes=0，再重新发送数据
     */
    private Integer failTimes;
    /**
     * 按一定时间规律，再次发送，处理状态：死信还是未发送都更新
     */
    private Date returnDate;
    /**
     * 
     */
    private String dealResult;
    /**
     * 
     */
    private Date dealDate;
    /**
     * 
     */
    private Date createDate;
    /**
     * 
     */
    private Date lastSendDate;
    /**
     * 上次消息发送时间
     */
    private Date lastDealMsgDate;
    /**
     *  消费者处理：0未处理、1成功、2失败、3死信队列，如果是死信定时发送
     */
    private Integer dealStatus;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
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
    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
    public Integer getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(Integer msgStatus) {
        this.msgStatus = msgStatus;
    }
    public Integer getFailTimes() {
        return failTimes;
    }

    public void setFailTimes(Integer failTimes) {
        this.failTimes = failTimes;
    }
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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
    public Integer getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }

    public static class TF {
        public static String msgId = "msgId";  // 消息id
        public static String serverName = "serverName";  // 消息服务的名称
        public static String exchange = "exchange";  // 
        public static String routingKey = "routingKey";  // 
        public static String payload = "payload";  // 传递的消息内容
        public static String msgStatus = "msgStatus";  // 生产者消息状态，0未确认、1已确认、2回调处理失败
        public static String failTimes = "failTimes";  // 定时器循环处理超时数据时，失败次数+1，returnTimes=0，再重新发送数据
        public static String returnDate = "returnDate";  // 按一定时间规律，再次发送，处理状态：死信还是未发送都更新
        public static String dealResult = "dealResult";  // 
        public static String dealDate = "dealDate";  // 
        public static String createDate = "createDate";  // 
        public static String lastSendDate = "lastSendDate";  // 
        public static String lastDealMsgDate = "lastDealMsgDate";  // 上次消息发送时间
        public static String dealStatus = "dealStatus";  //  消费者处理：0未处理、1成功、2失败、3死信队列，如果是死信定时发送

    }

}
