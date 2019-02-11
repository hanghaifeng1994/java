package com.learnyeai.auth.shiro;

import org.jsets.shiro.service.ShiroCryptoService;
import org.springframework.stereotype.Service;

/**
 * Created by zpz on 2018/8/2.
 */
@Service
public class ShiroCryptoServiceImpl extends ShiroCryptoService {
    @Override
    public String password(String plaintext) {
        return "111";
    }
}
