/**
 * 
 */
package com.learnyeai.learnai.sso.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.learnyeai.learnai.sso.ReceiveManagerListener;
import com.learnyeai.learnai.sso.IReceiveService;

/**
 * @ClassName: PARAMSService
 * @Description: 参数服务
 * @author: mingyi.li（mylee0523@gmail.com）
 * @date: 2015年3月12日 下午1:43:51
 */
@Service
public class PARAMSService implements IReceiveService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 注册刷新参数
     */
    public static final String SUBS_TYPE_REFRESHPARAMS = "REFRESHPARAMS";

    @PostConstruct
    public void init() {
        ReceiveManagerListener.registerListener(SUBS_TYPE_REFRESHPARAMS, this);
    }

    @Override
    public void receive(Object object) {
        logger.info("ParamsService start..");

    }

}
