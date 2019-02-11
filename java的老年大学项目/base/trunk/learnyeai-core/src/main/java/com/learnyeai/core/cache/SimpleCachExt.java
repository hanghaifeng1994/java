package com.learnyeai.core.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCache;

import java.util.*;

/**
 * Created by zpz on 2017/3/20.
 */
public class SimpleCachExt implements CacheExt {
    @Override
    public <T> Collection<T> getAll(Cache cache) {
        ConcurrentMapCache mapCache = (ConcurrentMapCache) cache;
        Collection list = mapCache.getNativeCache().values();
        return list;
    }

    @Override
    public <T> Collection<T> get(Cache cache, Object... keys) {
        Collection<T> list = new ArrayList<T>();

        if(null == keys || keys.length == 0)
            return list;
        ConcurrentMapCache mapCache = (ConcurrentMapCache) cache;
        for(Object key : keys){
            list.add((T)mapCache.get(key));
        }
        return list;
    }

    @Override
    public void add(Cache cache, Map<Object, Object> items) {
        ConcurrentMapCache mapCache = (ConcurrentMapCache) cache;
        for(Iterator<Map.Entry<Object, Object>> it=items.entrySet().iterator();;){
            Map.Entry<Object, Object> o = it.next();
            mapCache.put(o.getKey(),o.getValue());
        }
    }

    @Override
    public void evict(Cache cache, Object... keys) {
        if(null == keys || keys.length == 0)
            return;
        ConcurrentMapCache mapCache = (ConcurrentMapCache) cache;
        for(Object key : keys){
            mapCache.evict(key);
        }

    }

    @Override
    public void setExpires(Cache cache, String key, long expiration) {

    }
}
