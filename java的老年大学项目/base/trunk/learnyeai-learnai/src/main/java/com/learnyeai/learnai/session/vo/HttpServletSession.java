package com.learnyeai.learnai.session.vo;

import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.session.SessionException;
import com.learnyeai.learnai.session.util.SessionManagerUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;

/**
 * HttpSession代理session
 * @author lc3@yitong.com.cn
 */
public class HttpServletSession implements Session {

    private static final String NAME_PREFIX = HttpServletSession.class.getSimpleName();
    private static final String TOUCH_OBJECT_SESSION_KEY = NAME_PREFIX + ".TOUCH_OBJECT_SESSION_KEY";
    private static final String SKEY_KEY = NAME_PREFIX + "_SKEY";
    private static final String USER_ID_KEY = NAME_PREFIX + "_USER_ID";
    private static final String DEVICE_CODE_KEY = NAME_PREFIX + "_DEVICE_CODE";
    private static final String SERVER_ID_KEY = NAME_PREFIX + "_SERVER_ID";
    private static final String AUTH_STATUS_KEY = NAME_PREFIX + "_AUTH_STATUS";
    private static final String EVENT_ID_KEY = NAME_PREFIX + "_EVENT_ID";
    private static final String MSG_ID_KEY = NAME_PREFIX + "_MSG_ID";
    private static final String MSG_ID_SET_KEY = NAME_PREFIX + "_MSG_ID_SET";

    private String id;
    private HttpSession httpSession;
    private boolean isNew = false;
    private boolean isChange = false;
    private Long version;

    public HttpServletSession(HttpSession httpSession) {
        this.httpSession = httpSession;
        this.id = ThreadContextUtil.formatToken(httpSession.getId());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Date getCreateTime() {
        return new Date(httpSession.getCreationTime() * 1000);
    }

    @Override
    public Date getLastAccessTime() {
        return new Date(httpSession.getLastAccessedTime() * 1000);
    }

    @Override
    public void touch() {
        try {
            httpSession.setAttribute(TOUCH_OBJECT_SESSION_KEY, TOUCH_OBJECT_SESSION_KEY);
            httpSession.removeAttribute(TOUCH_OBJECT_SESSION_KEY);
            onChange();
        } catch (Exception e) {
            throw new SessionException(e);
        }
        return;
    }

    @Override
    public int getTimeout() {
        return httpSession.getMaxInactiveInterval();
    }

    @Override
    public void setTimeout(int timeout) {
        try {
            httpSession.setMaxInactiveInterval((int) timeout);
            onChange();
        } catch (Exception e) {
            throw new SessionException(e);
        }
        return;
    }

    @Override
    public void invalidate() {
        try {
            SessionManagerUtils.onInvalidate(this);
            httpSession.invalidate();
        } catch (Exception e) {
            throw new SessionException(e);
        }
        return;
    }

    @Override
    public boolean isExpire() {
        try {
            httpSession.getAttribute(TOUCH_OBJECT_SESSION_KEY);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    @Override
    public void setAttribute(Object key, Object value) {
        httpSession.setAttribute(assertString(key), value);
        onChange();
        return;
    }

    @Override
    public Object getAttribute(Object key) {
        return httpSession.getAttribute(assertString(key));
    }

    @Override
    public Object removeAttribute(Object key) {
        String keyStr = assertString(key);
        Object value = httpSession.getAttribute(keyStr);
        httpSession.removeAttribute(keyStr);
        onChange();
        return value;
    }

    @Override
    public Collection<Object> attributeKeys() {
        Enumeration names = httpSession.getAttributeNames();
        Collection<Object> keys = null;
        if(null != names) {
            keys = new ArrayList<Object>();
            while (names.hasMoreElements()) {
                keys.add(names.nextElement());
            }
        }
        return keys;
    }


    @Override
    public void setUserId(String userId) {
        setAttribute(USER_ID_KEY, userId);
    }

    @Override
    public String getUserId() {
        return (String) getAttribute(USER_ID_KEY);
    }

    @Override
    public void setDeviceCode(String deviceCode) {
        setAttribute(DEVICE_CODE_KEY, deviceCode);
    }

    @Override
    public String getDeviceCode() {
        return (String) getAttribute(DEVICE_CODE_KEY);
    }

    @Override
    public void setServerId(String serverId) {
        setAttribute(SERVER_ID_KEY, serverId);
    }

    @Override
    public String getServerId() {
        return (String) getAttribute(SERVER_ID_KEY);
    }

    @Override
    public void setAuthStatus(String authStatus) {
        setAttribute(AUTH_STATUS_KEY, authStatus);
    }

    @Override
    public String getAuthStatus() {
        return (String) getAttribute(AUTH_STATUS_KEY);
    }

    @Override
    public void setEventId(String eventId) {
        setAttribute(EVENT_ID_KEY, eventId);
    }

    @Override
    public String getEventId() {
        return (String) getAttribute(EVENT_ID_KEY);
    }

    @Override
    public void setMsgId(String msgId) {
        setAttribute(MSG_ID_KEY, msgId);
    }

    @Override
    public String getMsgId() {
        return (String) getAttribute(MSG_ID_KEY);
    }

    @Override
    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
        return;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    protected HttpServletSession onChange() {
        this.isChange = true;
        return this;
    }

    @Override
    public void setIsChange(boolean isChange) {
        this.isChange = isChange;
        return;
    }

    @Override
    public boolean isChange() {
        return isChange;
    }

    /**
     * 判断并转换Object类型的key为String类型，如果为非String类型，抛异常
     * @param key
     * @return
     */
    protected String assertString(Object key) {
        if(!(key instanceof String)) {
            throw new SessionException("HttpServletSession只支持String类型的Key");
        }
        return (String) key;
    }

    @Override
    public Long getVersion() {
        return null != version ? version : 0;
    }

    @Override
    public void setVersion(Long version) {
        this.version = version;
        return;
    }
}
