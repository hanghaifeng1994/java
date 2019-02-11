package com.learnyeai.learnai.codec;

import com.learnyeai.tools.common.JsonMapper;
import com.learnyeai.tools.common.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 负责加解密
 * Created by zpz on 2016/4/19.
 */
public class MessageCodecFactory {
    /**
     * @FieldName: logger
     * @FieldType: SysLogger
     * @Description: 日志
     */
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * @FieldName: decoder
     * @FieldType: Map<String, MessageCoder>
     * @Description: 编码/解码器
     */
    private final Map<String, MessageCoder> coder;

    /**
     * @FieldName: defaultCoder
     * @FieldType: String
     * @Description: 默认编码/解码器（key）
     */
    private final String defaultCoderKey;

    /**
     * @Title: MessageCodecFactory
     * @Description: 构造
     * @param coder
     * @param defaultCoderKey
     */
    public MessageCodecFactory(Map<String, MessageCoder> coder, String defaultCoderKey) {
        this.coder = coder;
        this.defaultCoderKey = defaultCoderKey;
    }

    /**
     * @Title: decode
     * @Description: 解码
     * @param msgOrig
     * @return
     */
    public Object decode(String key, Object msgOrig){
        Object message = msgOrig;
        for(IMessageDecoder coder : this.getDecoder(key)){
            message = coder.decode( message);
        }
        return message;
    }

    /**
     * @Title: encode
     * @Description:  @param msgOrig
     * @return
     */
    public String encode(String key, Object msgOrig){
        for(IMessageEncoder encoder : this.getEncoder(key)){
            msgOrig = encoder.encode(msgOrig);
        }
        //
        String message = null;
        if(null != msgOrig){
            try{
                if(msgOrig instanceof String)
                    message = msgOrig.toString();
                else
                    message = JsonMapper.toJsonString(msgOrig);
            }
            catch(Exception e){
                logger.error("编码器[{0}]返回类型错误", key);
                throw new RuntimeException("加密错误", e);
            }
        }
        return message;
    }

    /**
     * @Title: getDecoder
     * @Description: 返回解码器
     * @param key
     * @return
     */
    private IMessageDecoder[] getDecoder(String key) {
        key = StringUtils.isEmpty(key) ? this.defaultCoderKey : key;
        MessageCoder coder = this.coder.get(key);
        if(coder == null){
            logger.error("解码器不存在[{0}]", key);
            throw new RuntimeException(StringUtils.message("解码器不存在[{0}]", key) );
        }
        logger.debug("使用报文解码器[{0}]解码请求报文", key);
        return coder.getDecoder();
    }

    /**
     * @Title: getEncoder
     * @Description: 返回编码器
     * @param key
     * @return
     */
    private IMessageEncoder[] getEncoder(String key) {
        key = StringUtils.isEmpty(key) ? this.defaultCoderKey : key;
        MessageCoder coder = this.coder.get(key);
        if(coder == null){
            throw new RuntimeException(StringUtils.message("编码器不存在[{0}]", key) );
        }
        logger.debug("使用报文编码器[{0}]编码响应报文", key);
        return coder.getEncoder();
    }
}

