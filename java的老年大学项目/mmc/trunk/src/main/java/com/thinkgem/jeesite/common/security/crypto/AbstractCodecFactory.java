package com.thinkgem.jeesite.common.security.crypto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Provider;
import java.security.Security;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author lc3
 */
public abstract class AbstractCodecFactory {

    private static Logger logger = LoggerFactory.getLogger(AbstractCodecFactory.class);

    static {
        for (String jce : new String[]{"com.sun.crypto.provider.SunJCE", "com.ibm.crypto.provider.IBMJCE"}) {
            try {
                Class<Provider> jceClass = (Class<Provider>) Class.forName(jce);
                Security.addProvider(jceClass.newInstance());
                if(logger.isInfoEnabled()) {
                    logger.info("成功加载JCE提供类{}", jce);
                }
            } catch (ClassNotFoundException e) {
                if (logger.isWarnEnabled()) {
                    logger.warn("JCE提供类{}不存在，自动尝试下一个", jce);
                }
            } catch (InstantiationException e) {
                if (logger.isWarnEnabled()) {
                    logger.warn("初始化JCE提供类" + jce + "失败，失败原因为", e);
                }
            } catch (IllegalAccessException e) {
                if (logger.isWarnEnabled()) {
                    logger.warn("初始化JCE提供类" + jce + "失败，失败原因为", e);
                }
            }
        }
    }

    // 缓存
    private static final Map<String, ICodec> coderMap = new WeakHashMap<String, ICodec>();

    /**
     * 通过Key创建Codec
     * @param key 密钥，或密钥关键字（由对应的Codec子类处理）
     * @return
     */
    protected abstract ICodec genCodec(String key) throws Exception;

    /**
     * 从缓存中取Codec，没命中时自动创建
     * @param key
     * @return
     */
    public ICodec getCodecByKey(String key) {
        ICodec codec = coderMap.get(key);
        if(null == codec) {
            synchronized (coderMap) {
                codec = coderMap.get(key);
                if(null == codec) {
                    try {
                        codec = genCodec(key);
                    } catch (Exception e) {
                        throw new IllegalArgumentException("初始化加解密编码器异常", e);
                    }
                    coderMap.put(key, codec);
                }
            }
        }
        return codec;
    }

    /**
     * 加密.
     * @param data 明文字节数组
     * @param key 密key
     * @return 密文字节数组
     */
    public byte[] encrypt(byte[] data, String key) {
        return getCodecByKey(key).encrypt(data);
    }

    /**
     * 加密.
     * @param data 明文16进制字符串
     * @param key 密key
     * @return 密文16进制字符串
     */
    public String encrypt(String data, String key) {
        return getCodecByKey(key).encrypt(data);
    }

    /**
     * 解密.
     * @param data 密文字节数组
     * @param key 密key
     * @return 明文字节数组
     */
    public byte[] decrypt(byte[] data, String key) {
        return getCodecByKey(key).decrypt(data);
    }

    /**
     * AES解密.
     * @param data 密文16进制字符串
     * @param key 密key
     * @return 明文16进制字符串
     */
    public String decrypt(String data, String key) {
        return getCodecByKey(key).decrypt(data);
    }
}
