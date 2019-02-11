package com.learnyeai.learnai.session.vo;

import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.core.config.ConfigUtils;
import com.learnyeai.learnai.session.SessionException;
import com.learnyeai.learnai.session.util.SessionManagerUtils;
import com.learnyeai.learnai.consts.ConfigName;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 简单Session实现
 *
 * @author 李超（lc3@yitong.com.cn）
 */
public class SimpleSession extends SessionData implements Session, ValidateSession,GetSessionData {
    public SimpleSession() {
        id = ThreadContextUtil.genToken();
    }

    public SimpleSession(String id) {
        if(!StringUtils.hasText(id)) {
            id = ThreadContextUtil.genToken();
        }
        this.id = id;
    }

    public SimpleSession(SessionData sessionData) {
        if(null != sessionData.attribute) {
            attribute.putAll(sessionData.attribute);
        }
        id = sessionData.id;
        createTime = sessionData.createTime;
        lastAccessTime = sessionData.lastAccessTime;
        timeout = sessionData.timeout;
        isExpire = sessionData.isExpire;
        userId = sessionData.userId;
        deviceCode = sessionData.deviceCode;
        serverId = sessionData.serverId;
        authStatus = sessionData.authStatus;
        eventId = sessionData.eventId;
        msgId = sessionData.msgId;
        version = sessionData.version;
    }
    public SessionData getSessionData(){
        SessionData sessionData = new SessionData();
        if(attribute != null){
            sessionData.attribute.putAll(attribute);
        }
        sessionData.id = id;
        sessionData.createTime = createTime;
        sessionData.lastAccessTime = lastAccessTime;
        sessionData.timeout = timeout;
        sessionData.isExpire = isExpire;
        sessionData.userId = userId;
        sessionData.deviceCode = deviceCode;
        sessionData.serverId = serverId;
        sessionData.authStatus = authStatus;
        sessionData.eventId = eventId;
        sessionData.msgId = msgId;
        sessionData.version = version;
        return sessionData;
    }
    @Override
    public void touch() {
        validate();
        this.lastAccessTime = new Date();
        onChange();
    }

    @Override
    public void setTimeout(int timeout) {
        validate();
        if(this.timeout == timeout) {
            return ;
        }
        this.timeout = timeout;
        onChange();
        return ;
    }

    @Override
    public void invalidate() {
        if(this.isExpire) {
            return ;
        }
        synchronized (this) {
            if(this.isExpire) {
                return ;
            }
            this.isExpire = true;
            onInvalidate();
            return ;
        }
    }

    @Override
    public void setAttribute(Object key, Object value) {
        validate();
        if(null == key || value == attribute.get(key)) {
            return;
        }
        attribute.put(key, value);
        onChange();
        return;
    }

    @Override
    public Object getAttribute(Object key) {
//        validate();
        if(null == key) {
            return null;
        }
        return attribute.get(key);
    }

    /**
     * 批量设置属性
     * @param attrs
     * @return
     */
    public Session resetAttributes(Map<Object, Object> attrs) {
        validate();
        attribute.clear();
        if(null != attrs) {
            attribute.putAll(attrs);
        }
        return this;
    }

    @Override
    public Collection<Object> attributeKeys() {
        return attribute.keySet();
    }

    @Override
    public Object removeAttribute(Object key) {
        validate();
        if(null == key) {
            return null;
        }
        Object v = removeKey(key);
        onChange();
        return v;
    }

    /**
     * 检查session是否有效，无效时抛出异常
     */
    @Override
    public void validate() throws SessionException {
        if(isExpire || System.currentTimeMillis() - this.lastAccessTime.getTime() > timeout * 1000) {
            throw new SessionException();
        }
    }

    /**
     * 改变时处理函数
     */
    protected void onChange() {
        isChange = true;
        SessionManagerUtils.onChange(this);
    }

    /**
     * 销毁时处理函数
     */
    protected void onInvalidate() {
        SessionManagerUtils.onInvalidate(this);
    }

    protected Object removeKey(Object key) {
        Object remove = attribute.remove(key);
        return remove;
    }


    @Override
    public void setUserId(String userId) {
        validate();
        this.userId = userId;
        onChange();
        return ;
    }


    @Override
    public void setDeviceCode(String deviceCode) {
        validate();
        this.deviceCode = deviceCode;
        onChange();
        return ;
    }

    @Override
    public String getDeviceCode() {
        validate();
        return deviceCode;
    }

    @Override
    public void setServerId(String serverId) {
        validate();
        this.serverId = serverId;
        onChange();
        return ;
    }

    @Override
    public String getServerId() {
        validate();
        return serverId;
    }

    @Override
    public void setAuthStatus(String authStatus) {
        validate();
        this.authStatus = authStatus;
        onChange();
        return ;
    }

    @Override
    public String getAuthStatus() {
        validate();
        return authStatus;
    }

    @Override
    public void setEventId(String eventId) {
        this.eventId = eventId;
        return ;
    }

    @Override
    public String getEventId() {
        return eventId;
    }

    @Override
    public void setMsgId(String msgId) {
        this.msgId = msgId;
        return ;
    }

    @Override
    public String getMsgId() {
        return msgId;
    }

    @Override
    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
        return ;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    @Override
    public void setIsChange(boolean isChange) {
        this.isChange = isChange;
        return ;
    }

    @Override
    public boolean isChange() {
        return isChange;
    }

    @Override
    public Long getVersion() {
        return null != version ? version : 0;
    }

    @Override
    public void setVersion(Long version) {
        this.version = version;
        return ;
    }
}
