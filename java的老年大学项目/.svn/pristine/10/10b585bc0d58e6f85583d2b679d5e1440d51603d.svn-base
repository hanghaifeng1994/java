package com.learnyeai.learnai.session.vo;

import com.learnyeai.core.config.ConfigUtils;
import com.learnyeai.learnai.consts.ConfigName;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zpz on 2018/9/26.
 */
public class SessionData implements Serializable {
    /**
     * Session Id
     */
    protected String id;
    /**
     * 创建时间
     */
    protected Date createTime = new Date();
    /**
     * 最后访问时间
     */
    protected Date lastAccessTime = new Date();
    /**
     * 超时时间间隔，单位：秒
     */
    protected int timeout = ConfigUtils.getValue(ConfigName.SESSION_TIMEOUT_SECOND,
            ConfigName.SESSION_TIMEOUT_SECOND_DEFVAL);
    /**
     * 是否已过期
     */
    protected boolean isExpire = false;
    /**
     * 用户标识
     */
    protected String userId;
    /**
     * 设备编号
     */
    protected String deviceCode;
    /**
     * 服务器标识
     */
    protected String serverId;
    /**
     * 用户认证状态
     */
    protected String authStatus;
    /**
     * 新增状态
     */
    protected boolean isNew;
    /**
     * 改变状态
     */
    protected boolean isChange;
    /**
     * 事件ID
     */
    protected String eventId;
    /**
     * 消息ID
     */
    protected String msgId;
    /**
     * 版本，用于乐观锁
     */
    protected Long version;

    protected final Map<Object, Object> attribute = new HashMap<Object, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isExpire() {
        return isExpire;
    }

    public void setExpire(boolean expire) {
        isExpire = expire;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isChange() {
        return isChange;
    }

    public void setChange(boolean change) {
        isChange = change;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Map<Object, Object> getAttribute() {
        return attribute;
    }

    @Override
    public String toString() {
        return "SimpleSession{" +
                ", id='" + id + '\'' +
                ", createTime=" + createTime +
                ", lastAccessTime=" + lastAccessTime +
                ", timeout=" + timeout +
                ", isExpire=" + isExpire +
                ", userId='" + userId + '\'' +
                ", deviceCode='" + deviceCode + '\'' +
                ", serverId='" + serverId + '\'' +
                ", authStatus='" + authStatus + '\'' +
                ", isNew=" + isNew +
                ", isChange=" + isChange +
                ", eventId='" + eventId + '\'' +
                ", msgId='" + msgId + '\'' +
                ", version=" + version +
                '}';
    }
}
