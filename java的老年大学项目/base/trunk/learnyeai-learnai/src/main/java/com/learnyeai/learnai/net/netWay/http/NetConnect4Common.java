package com.learnyeai.learnai.net.netWay.http;

import com.learnyeai.core.config.ConfigUtils;
import org.springframework.stereotype.Component;

/**
 * 通用渠道请求
 * Created by zpz on 2017/9/6.
 */
@Component
public class NetConnect4Common extends NetConnect4HttpAbstract {

    private String serverURL = ConfigUtils.getValue("channel.url");

    @Override
    protected String getServerURL() {
        return serverURL;
    }
}
