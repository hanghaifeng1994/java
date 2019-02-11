package com.learnyeai.learnai.listener;

import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.session.SessionListener;
import org.springframework.stereotype.Component;

/**
 * Created by zpz on 2017/3/3.
 */
@Component
public class LoginSessionListener implements SessionListener {

    @Override
    public void onStart(Session session) {

    }

    @Override
    public void onLogin(Session session) {
        // 设置登录标识，登录时已经设置了
    }

    @Override
    public void onUpdate(Session session) {

    }

    @Override
    public void onStop(Session session) {

    }

    @Override
    public void onExpiration(Session session) {
    }
}
