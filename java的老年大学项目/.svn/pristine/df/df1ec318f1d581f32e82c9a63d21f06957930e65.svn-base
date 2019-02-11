package com.learnyeai.core.cache;

import org.springframework.cache.Cache;

import java.util.*;

/**
 * Created by zpz on 2017/3/20.
 */
public class RedisCachExt implements CacheExt {
    @Override
    public <T> Collection<T> getAll(Cache cache) {
        RedisUtil redisUtil = RedisUtilFactory.getUtil(cache.getName());
        List<T> list = redisUtil.getPattern("*");
        return list;
    }

    @Override
    public <T> Collection<T> get(Cache cache, Object... keys) {
        RedisUtil redisUtil = RedisUtilFactory.getUtil(cache.getName());
        String ss[] = new String[keys.length];
        for (int i=0; i<keys.length; i++){
            ss[i] = keys[i].toString();
        }
        return redisUtil.get(ss);
    }

    /**
     * 添加多个键值对
     * @param cache
     * @param items
     */
    @Override
    public void add(Cache cache, Map<Object, Object> items) {
        Iterator<Map.Entry<Object, Object>> entry = items.entrySet().iterator();
        while (entry.hasNext()){
            Map.Entry<Object, Object> it = entry.next();
            cache.put(it.getKey(), it.getValue());
        }
    }

    @Override
    public void evict(Cache cache, Object... keys) {
        for (Object key : keys){
            cache.evict(key);
        }
    }

    @Override
    public void setExpires(Cache cache, String key, long expiration) {
        RedisUtil redisUtil = RedisUtilFactory.getUtil(cache.getName());
        redisUtil.setExpires(key, expiration);
    }
}
