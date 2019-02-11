package com.learnyeai.learnai.listener;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learnyeai.learnai.consts.AppR;

/**
 * 在线用户Session缓存实例
 * 
 * @author yaoym
 * 
 */
public class OnLineSessions {

    private Logger logger = LoggerFactory.getLogger(getClass());

	private static OnLineSessions instance;

    private Map<String, HttpSession> onLineSessions = new HashMap<String, HttpSession>();

    private String serverIp;

	private OnLineSessions() {
	}

	public static OnLineSessions getInstance() {
		if (null == instance) {
			instance = new OnLineSessions();
		}
		return instance;
	}

	public String getLocalIP() {
		try {
			if (null == serverIp) {
				serverIp = InetAddress.getLocalHost().getHostAddress();
			}
		} catch (UnknownHostException e) {
            logger.error("un know host exception:" + e);
		}
		return serverIp;
	}

    /**
     * 加入session
     * 
     * @Title: addSession
     * @param userId
     *            用户号
     * @param session
     */
    public void addSession(String userId, HttpSession session) {
        onLineSessions.put(userId, session);
    }

    /**
     * 获取客户会话
     * 
     * @param userId
     * @return
     */
    public HttpSession getSession(String userId) {
        return onLineSessions.get(userId);
    }

    /**
     * 删除该用户会话
     * 
     * @param cifNo
     */
    public void deleteSession(String cifNo) {
        onLineSessions.remove(cifNo);
    }

    /**
     * @Title: signLoginSessionCtl
     * @Description: 单点session控制
     * @param cifNo
     */
    public void signLoginSessionCtl(String cifNo) {
        //单点登录
        HttpSession session = getSession(cifNo);
        if (null != session) {
            try {
            	//设置标识为006，表示在其他机器上登录
            	session.setAttribute(AppR.CHECK_OUT, AppR.RTN_RE_LOGIN);
            } catch (Exception e) {
                logger.error("session invalidate  exception:" + e);
            }
        }
    }

}