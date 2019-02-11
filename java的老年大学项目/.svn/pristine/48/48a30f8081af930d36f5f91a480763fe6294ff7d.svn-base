package com.learnyeai.auth.domain;

import org.jsets.shiro.model.Account;

import java.io.Serializable;

/**
 * Created by zpz on 2018/8/2.
 */
public class UserAccount implements Account, Serializable {
    private static final long serialVersionUID = 1L;

    private String account;
    private String password;
    private String userName;

    public UserAccount(String account, String password) {
        this.account = account;
        this.password = password;
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public String getPassword() {
        return password;
    }
}