package com.learnyeai.learnai.key;

import com.learnyeai.learnai.key.uuid.UUIDKeyGenerator;
import org.springframework.util.Assert;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 主键生成工厂
 * @author lc3@yitong.com.cn
 */
public class KeyFactory {

    private static final ConcurrentMap<String, KeyGenerator> CONCURRENT_MAP =
            new ConcurrentHashMap<String, KeyGenerator>();

    public static KeyGenerator getKeyGenerator(String tableName) {
        Assert.notNull(tableName, "tableName不能为空！");
        tableName = tableName.toUpperCase();
        KeyGenerator keyGenerator = CONCURRENT_MAP.get(tableName);
        if(null != keyGenerator) {
            return keyGenerator;
        }
        synchronized (CONCURRENT_MAP) {
            keyGenerator = CONCURRENT_MAP.get(tableName);
            if(null != keyGenerator) {
                return keyGenerator;
            }
            /*String value = ConfigUtils.getValue(ConfigName.KEY_GENERATOR_TYPE);
            if(value==null|| value.equals(""))
                    value = ConfigName.KEY_GENERATOR_TYPE_DEFVAL;
            if("sequence".equalsIgnoreCase(value)) {
                keyGenerator = new SequenceKeyGenerator(tableName);
            } else {    // uuid
                keyGenerator = new UUIDKeyGenerator();
            }*/
            keyGenerator = new UUIDKeyGenerator();
            CONCURRENT_MAP.put(tableName, keyGenerator);
        }
        return keyGenerator;
    }

}
