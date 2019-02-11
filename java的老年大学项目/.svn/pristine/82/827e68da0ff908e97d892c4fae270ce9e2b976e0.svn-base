package cn.com.weyeyun.rabbitmq.consumer.demo.model;

import cn.com.weyeyun.servicebase.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 
 *
 * @author yl
 */
public class RabMsgTempTable extends BaseEntity {

    /**
    * 消息id
    */
    @Id
    @Column(name = "MSG_ID")
    private String msgId;

    /**
     * 消息服务的名称
     */
    @Column(name = "SERVER_NAME")
    private String serverName;
    /**
     * 
     */
    @Column(name = "EXCHANGE")
    private String exchange;
    /**
     * 
     */
    @Column(name = "ROUTING_KEY")
    private String routingKey;
    /**
     * 传递的消息内容
     */
    @Column(name = "PAYLOAD")
    private String payload;
    /**
     * 生产者消息状态，0未确认、1已确认、2回调处理失败
     */
    @Column(name = "MSG_STATUS")
    private Integer msgStatus;
    /**
     * 定时器循环处理超时数据时，失败次数+1，returnTimes=0，再重新发送数据
     */
    @Column(name = "FAIL_TIMES")
    private Integer failTimes;
    /**
     * 按一定时间规律，再次发送，处理状态：死信还是未发送都更新
     */
    @Column(name = "RETURN_DATE")
    private Date returnDate;
    /**
     * 
     */
    @Column(name = "DEAL_RESULT")
    private String dealResult;
    /**
     * 
     */
    @Column(name = "DEAL_DATE")
    private Date dealDate;
    /**
     * 
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;
    /**
     * 
     */
    @Column(name = "LAST_SEND_DATE")
    private Date lastSendDate;
    /**
     * 上次消息发送时间
     */
    @Column(name = "LAST_DEAL_Msg_DATE")
    private Date lastDealMsgDate;

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

    public static class TF {

        public static String TABLE_NAME = "RAB_MSG_TEMP_TABLE";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String msgId = "MSG_ID";  // 消息id
        public static String serverName = "SERVER_NAME";  // 消息服务的名称
        public static String exchange = "EXCHANGE";  // 
        public static String routingKey = "ROUTING_KEY";  // 
        public static String payload = "PAYLOAD";  // 传递的消息内容
        public static String msgStatus = "MSG_STATUS";  // 生产者消息状态，0未确认、1已确认、2回调处理失败
        public static String failTimes = "FAIL_TIMES";  // 定时器循环处理超时数据时，失败次数+1，returnTimes=0，再重新发送数据
        public static String returnDate = "RETURN_DATE";  // 按一定时间规律，再次发送，处理状态：死信还是未发送都更新
        public static String dealResult = "DEAL_RESULT";  // 
        public static String dealDate = "DEAL_DATE";  // 
        public static String createDate = "CREATE_DATE";  // 
        public static String lastSendDate = "LAST_SEND_DATE";  // 
        public static String lastDealMsgDate = "LAST_DEAL_Msg_DATE";  // 上次消息发送时间

    }
}
