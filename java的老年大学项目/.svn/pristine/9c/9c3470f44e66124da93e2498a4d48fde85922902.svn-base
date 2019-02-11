package com.learnyeai.learnai.session.dao;



import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.session.SessionException;
import com.learnyeai.learnai.session.vo.SimpleSession;
import com.learnyeai.learnai.session.util.SessionManagerUtils;
import com.learnyeai.learnai.session.vo.ValidateSession;
import com.learnyeai.tools.common.ServerUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * SessionDao基础实现
 *
 * @author 李超（lc3@yitong.com.cn）
 */
public abstract class AbstractSessionDao implements SessionDao {

    @Override
    public Session getOrCreate(String id) {
        Session session = get(id);
        if(null != session && !session.isExpire()) {
            try {
                session.getServerId();
                return session;
            } catch (Exception e) {
                // session 失效，继续创建;
            }
        }
        session = create(id);
        session.setServerId(ServerUtils.getServerIp());
        session.setIsNew(true);
        SessionManagerUtils.onCreate(session);
        return session;
    }

    /**
     * 创建新的Session，子类可以重写
     * @param id 会话ID，根据需要选用
     * @return
     */
    protected Session create(String id) {
        return new SimpleSession(id);
    }

    /**
     * 检查session是否有效
     * @param session
     */
    protected void validate(Session session) {
        if(null == session) {
            throw new IllegalArgumentException("session不能为空");
        }
        if(null == session.getId()) {
            throw new IllegalArgumentException("session的id不能为空");
        }
    }

    @Override
    public Collection<Session> getAllSession() {
        return Collections.emptyList();
    }

    @Override
    public Collection<Session> getActiveSessions() {
        final Collection<Session> allSession = getAllSession();
        List<Session> list = new LinkedList<Session>();
        for (Session session : allSession) {
            if(session.isExpire()) {
                continue;
            }
            if(session instanceof ValidateSession) {
                try {
                    ((ValidateSession) session).validate();
                } catch (SessionException e) {
                    // do nothing
                    continue;
                }
            }
            list.add(session);
        }
        return list;
    }

    @Override
    public Collection<Session> getInvalidSessions() {
        final Collection<Session> allSession = getAllSession();
        List<Session> list = new LinkedList<Session>();
        for (Session session : allSession) {
            if(!session.isExpire() && session instanceof ValidateSession) {
                try {
                    ((ValidateSession) session).validate();
                } catch (SessionException e) {
                    list.add(session);
                }
            }
        }
        return list;
    }
}
