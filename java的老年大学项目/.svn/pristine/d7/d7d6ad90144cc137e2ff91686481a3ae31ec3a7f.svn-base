package com.learnyeai.core.cache;

import org.springframework.cache.Cache;

import java.util.Collection;
import java.util.Map;

/**
 * Created by zpz on 2017/3/20.
 */
public interface CacheExt {
    <T> Collection<T> getAll(Cache cache);
    <T> Collection<T> get(Cache cache, Object... keys);
    void add(Cache cache, Map<Object, Object> items);
    void evict(Cache cache, Object... keys);
    void setExpires(Cache cache, String key, long expiration);
}
