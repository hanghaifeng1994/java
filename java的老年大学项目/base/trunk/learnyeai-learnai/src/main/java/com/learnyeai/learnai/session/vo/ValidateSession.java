package com.learnyeai.learnai.session.vo;


import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.session.SessionException;

/**
 * 支持验证的Session
 * @author lc3@yitong.com.cn
 */
public interface ValidateSession extends Session {

    /**
     * 验证Session是否有效，无效时抛出异常
     * @throws SessionException
     */
    void validate() throws SessionException;
}
