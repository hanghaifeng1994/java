package com.learnyeai.core.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zpz on 2018/4/18.
 */
public class RedisUtilFactory {
    private static Map<String, RedisUtil> redisUtilMap = new HashMap<String, RedisUtil>();

    public static RedisUtil getUtil(String cacheName){
        if(redisUtilMap.containsKey(cacheName)){
            return redisUtilMap.get(cacheName);
        }
        RedisUtil util = new RedisUtil(cacheName);
        redisUtilMap.put(cacheName, util);
        return util;
    }

    public static RedisUtil getUtil(String cacheName, Class objType){
        if(redisUtilMap.containsKey(cacheName)){
            return redisUtilMap.get(cacheName);
        }
        RedisUtil util = new RedisGenericUtil(cacheName, objType);
        redisUtilMap.put(cacheName, util);
        return util;
    }
}
