package com.learnyeai.learnai.session.dao;

import com.learnyeai.learnai.session.util.SessionUtils;
import com.learnyeai.learnai.session.Session;

import java.util.Collection;

/**
 * @author zhanglong@yitong.com.cn
 * @date 15/10/21
 */
public class CacheSessionDao extends AbstractSessionDao {

    @Override
    public void create(Session session) {
        validate(session);
        SessionUtils.saveSession(session);
    }

    @Override
    public void delete(Session session) {
        validate(session);
        SessionUtils.deleteSession(session.getId());
    }

    @Override
    public void update(Session session) {
        validate(session);
        SessionUtils.saveSession(session);
    }

    @Override
    public Session get(String id) {
        return SessionUtils.getSession(id);
    }

    @Override
    public Collection<Session> getAllSession() {
        return SessionUtils.getAllSession();
    }
}
