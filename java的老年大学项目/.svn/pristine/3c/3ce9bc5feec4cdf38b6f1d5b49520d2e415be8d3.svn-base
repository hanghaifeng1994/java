package com.learnyeai.learnai.session.util;

import com.learnyeai.learnai.session.Session;
import com.learnyeai.core.cache.CacheDelegate;
import com.learnyeai.core.cache.CacheNames;
import com.learnyeai.core.config.ConfigUtils;
import com.learnyeai.core.cache.CacheUtils;
import com.learnyeai.learnai.session.vo.GetSessionData;
import com.learnyeai.learnai.session.vo.SessionData;
import com.learnyeai.learnai.session.vo.SimpleSession;
import com.learnyeai.tools.common.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by zpz on 2017/3/17.
 */
public class SessionUtils {
    private static CacheDelegate cache = CacheUtils.getCache(CacheNames.SESSION_CACHE_NAME);
    private static final String SESSION_VALIDATION_KEY = "session.timeout_second";
    public static Session getSession(String id) {
        if(StringUtils.isEmpty(id)) {
            return null;
        }
        Session session = null;
        Object o = cache.get(id);
        if(o instanceof SessionData){
            session = new SimpleSession((SessionData) o);
        }else {
            session = (Session) o;
        }
        return session;
    }

    public static void saveSession(Session session) {
        if(null == session || StringUtils.isEmpty(session.getId())) {
            return;
        }
        Object val = session;
        if(session instanceof GetSessionData){
            val = ((GetSessionData)session).getSessionData();
        }
        int expiretime = ConfigUtils.getValue(SESSION_VALIDATION_KEY, 2*60*60);
//        cache.put(session.getId(), val, expiretime);
        cache.put(session.getId(), val);
    }

    public static void deleteSession(String id) {
        if(StringUtils.isEmpty(id)) {
            return;
        }
        cache.evict(id);
    }
    public static Collection<Session> getAllSession() {
        Collection ll = cache.getAll();
        if(ll == null || ll.size() == 0){
            return new ArrayList<>();
        }
        if(ll.iterator().next() instanceof  Session){
            return (Collection<Session>)ll;
        }

        if(!(ll.iterator().next() instanceof SessionData)){
            return new ArrayList<>();
        }
        Collection<SessionData> list = ll;
        ArrayList<Session> rstList = new ArrayList<Session>();

        for(Iterator<SessionData> it = list.iterator(); it.hasNext(); ){
            SessionData data = it.next();
            rstList.add(new SimpleSession(data));
        }
        return rstList;
    }
}
