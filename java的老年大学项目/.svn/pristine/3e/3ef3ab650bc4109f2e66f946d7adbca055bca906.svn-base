package com.learnyeai.tools.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 邮箱用户名和密码认证器
 * Created by XieLina on 2016/5/13 0013.
 */
public class MyAuthenticator extends Authenticator {
    String userName = null;
    String password = null;
    public MyAuthenticator() {
    }
    public MyAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}
