package com.learnyeai.learnai.codec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zpz on 2016/4/26.
 */
public class ResponseMessageEncoder implements IMessageEncoder {
    private Logger logger = LoggerFactory.getLogger(ResponseMessageEncoder.class);
    @Override
    public Object encode(Object msgOrig) {
        return msgOrig;
    }
}
