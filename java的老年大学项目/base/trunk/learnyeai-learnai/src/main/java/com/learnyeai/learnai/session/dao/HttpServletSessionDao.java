package com.learnyeai.learnai.session.dao;

import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.session.vo.HttpServletSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * 针对HttpSession的
 * @author lc3@yitong.com.cn
 */
public class HttpServletSessionDao extends AbstractSessionDao {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 存储session
     */
    private static final Map<Object, Session> sessions =
            new WeakHashMap<Object, Session>();

    @Override
    protected Session create(String id) {
        return new HttpServletSession(ThreadContextUtil.getHttpRequest().getSession(true));
    }

    @Override
    public void create(Session session) {
        validate(session);
        sessions.put(session.getId(), session);
    }

    @Override
    public void delete(Session session) {
        validate(session);
        sessions.remove(session.getId());
    }

    @Override
    public void update(Session session) {
        validate(session);
        sessions.put(session.getId(), session);
    }

    @Override
    public Session get(String id) {
        if(null == id) {
            return null;
        }
        return sessions.get(id);
    }

    @Override
    public Collection<Session> getAllSession() {
        return Collections.unmodifiableCollection(sessions.values());
    }
}
