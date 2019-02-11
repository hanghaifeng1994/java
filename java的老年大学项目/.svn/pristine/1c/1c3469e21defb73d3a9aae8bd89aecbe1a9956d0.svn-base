package com.learnyeai.learnai.context;

import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.core.config.ConfigUtils;
import com.learnyeai.learnai.session.util.SessionManagerUtils;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.tools.common.StringUtils;
import com.learnyeai.learnai.consts.ConfigName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by zpz on 2016/5/3.
 */
public class ThreadContextUtil {

    protected static final Logger logger = LoggerFactory.getLogger(ThreadContextUtil.class);

    public static final String SESSION_KEY = ThreadContextUtil.class.getName() + "_SESSION_KEY";
    public static final String SESSION_ID_KEY = "_SESSION_ID_KEY";
    /**
     * 总线key
     */
    public static final String BUSICTX_KEY = ThreadContextUtil.class.getName() + "_BUSICTX_key";

    /**
     * 登录url标识，设置为true
     */
    public static final String IS_LOGINING_KEY = ThreadContextUtil.class.getName() + "_IS_LOGINING";
    /**
     * 是否需要检查登录
     */
    public static final String CHECK_LOGINING_KEY = ThreadContextUtil.class.getName() + "_CHECK_LOGINING";

    /*免登录类型，1是免登录*/
    public static final String LOGIN_NO_PASS_KEY = ThreadContextUtil.class.getName() + "_LOGIN_NO_PASS_KEY";

    /** request key **/
    public static final String HTTP_REQUEST_KEY = ThreadContextUtil.class.getName() + "HTTP_REQUEST_KEY";

    /**api service 结果key    feign restful调用后，存放的结果key*/
    public static final String API_SERVICE_RESULT_KEY = ThreadContextUtil.class.getName() + "api_service_result";

    /**
     * 绑定会话到当前线程
     *
     * @param session
     *            会话
     */
    public static void bindSession(Session session) {
        if(null != session) {
            ThreadContext.put(SESSION_KEY, session);
        }
    }

    /**
     * 解绑当前线程的会话
     *
     * @return
     */
    public static Session unBindSession() {
        return (Session) ThreadContext.remove(SESSION_KEY);
    }

    public static String resetSession() {
        Session session = getSession(false);
        unBindSession();
        if(null != session) {
            session.invalidate();
            return session.getId();
        }
        return "";
    }

    /**
     * 获得当前线程会话
     *
     * @return
     */
    public static Session getSession(boolean autoCreate) {
        Session session = (Session) ThreadContext.get(SESSION_KEY);
        if(null != session && !session.isExpire() || !autoCreate) {
            return session;
        }
        synchronized (SESSION_KEY) {
            session = (Session) ThreadContext.get(SESSION_KEY);
            if(null != session) {
                return session;
            }
           /* HttpServletRequest httpRequest = getHttpRequest();
            if(null == httpRequest) {
                return null;
            }*/
            String sessionId = (String)ThreadContext.get(SESSION_ID_KEY); // 在解析报文头时获取token，保存到thread中
            if(null == sessionId){
//                sessionId = httpRequest.getRequestedSessionId();
                sessionId = genSessionId();
            }

//            session = SessionManagerUtils.getDefaultManager().getOrCreateSession(
//                    ThreadContextUtil.formatToken(sessionId));
            sessionId = ThreadContextUtil.formatToken(sessionId);
            ThreadContext.put(SESSION_ID_KEY, sessionId);
            session = SessionManagerUtils.getDefaultManager().getOrCreateSession(sessionId);
            bindSession(session);
        }
        return session;
    }


    /**
     * 得到当前Session，不存在会报异常
     * @return
     */
    public static Session getSessionRequired() {
        Session session = getSession(true);
        if(null == session) {
            throw new IllegalArgumentException("当前线程没有上下文环境");
        }
        return session;
    }

    /**
     * 得到当前Session
     * @return
     */
    public static Session getSession() {
        return getSession(false);
    }


    /**
     * 绑定HttpRequest到当前线程
     * @param request 会话
     */
    public static void bindHttpRequest(HttpServletRequest request) {
        if(null != request) {
            ThreadContext.put(HTTP_REQUEST_KEY, request);
        }
    }
    /**
     * 解绑当前线程的HttpRequest
     * @return
     */
    public static HttpServletRequest unBindHttpRequest() {
        return (HttpServletRequest) ThreadContext.remove(HTTP_REQUEST_KEY);
    }

    /**
     * 获得当前线程HttpRequest
     * @return
     */
    public static HttpServletRequest getHttpRequest() {
        return (HttpServletRequest) ThreadContext.get(HTTP_REQUEST_KEY);
    }

    /**
     * 生成sessionid
     * @return
     */
    public static String genSessionId(){
        String token = genToken();
        while (null != SessionManagerUtils.getDefaultManager().getSession(token)) {
            token = genToken();
        }
        return token;
    }

    /**
     * 生成一个新的随机Token
     * @return Token串
     */
    public static String genToken() {

        int tokenLen = ConfigUtils.getValue(ConfigName.SESSION_TOKEN_LENGTH,
                ConfigName.SESSION_TOKEN_LENGTH_DEFVAL);

        String token = UUID.randomUUID().toString().replaceAll("-", "");
        if(token.length() > tokenLen){
            token = token.substring(token.length()-tokenLen);
        }else {
            token = StringUtils.leftPad(token, tokenLen, '0');
        }

        return token;
    }

    /**
     * 格式化Token，格式化成标准长度
     * @param token token
     * @return 格式化后的token
     */
    public static String formatToken(String token) {
        int tokenLen = ConfigUtils.getValue(ConfigName.SESSION_TOKEN_LENGTH,
                ConfigName.SESSION_TOKEN_LENGTH_DEFVAL);
        if(null == token) {
            return StringUtils.leftPad("", tokenLen, '0');
        }
        if(tokenLen != token.length()) {
            if(token.length() < tokenLen) {
                token = StringUtils.leftPad(token, tokenLen, '0');
            } else {
                token = token.substring(token.length()-tokenLen);
            }
        }
        return token;
    }

    /**
     * 得到当前会话的Token
     * @return
     */
    public static String getToken() {
        return (String) getSessionRequired().getId();
    }

    /**
     * 生成一个新的密Key
     * @return 密Key
     */
    public static String genSecurityKey() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    /**
     * 设置是否为登录操作
     *
     * @param isLogining
     */
    public static void setIsLogining(boolean isLogining) {
        if(isLogining) {
            ThreadContext.put(IS_LOGINING_KEY, true);
        }
    }

    /**
     * 判断当前操作是否为登录
     *
     * @return
     */
    public static boolean isLogining() {
        if(null != ThreadContext.get(IS_LOGINING_KEY)) {
            return true;
        }
        return false;
    }

    public static void bindCtx(IBusinessContext ctx){
        ThreadContext.put(BUSICTX_KEY, ctx);
    }
    public static IBusinessContext getCtx(){
        return (IBusinessContext)ThreadContext.get(BUSICTX_KEY);
    }

}
