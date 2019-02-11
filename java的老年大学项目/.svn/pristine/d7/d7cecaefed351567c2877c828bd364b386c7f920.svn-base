package com.learnyeai.core.cache;

import com.learnyeai.core.utils.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Map;

/**
 * Created by zpz on 2017/3/21.
 */
final public class CacheDelegate {
    private static Logger logger = LoggerFactory.getLogger(CacheDelegate.class);
    protected CacheManager cacheManager = SpringContextUtils.getBean(CacheManager.class);
    protected CacheExt cacheExt;
    protected Cache cache;
    private RedisTemplate redisTemplate;
    private String cacheName;

    public CacheDelegate(String cacheName) {
        this.cacheName = cacheName;
        this.cache = cacheManager.getCache(cacheName);
        if(cache == null){
//            logger.error(cacheName + "缓存不存在");
            throw new RuntimeException(cacheName + "缓存不存在");
        }
    }

    protected Cache getCache(){
        return cache;
    }
    public void setCache(String cacheName){
        this.cache = cacheManager.getCache(cacheName);
    }

    protected RedisTemplate getRedisTemplate() {
        if(null == redisTemplate){
            redisTemplate = (RedisTemplate)SpringContextUtils.getBean("redisTemplate");
        }
        return redisTemplate;
    }

    /**
     * 把值放入缓存
     */
    public void put(Object key, Object value) {
        getCache().put(key, value);
    }
    /**
     * 根据KEY取得缓存中的值
     */
    public <T> T get(Object key) {
        Cache.ValueWrapper vw =  getCache().get(key);
        if(vw != null) {
            return (T)vw.get();
        }
        return null;
    }

    /**
     * 清除缓存
     */
    public void evict(Object key) {
        getCache().evict(key);
    }
    public void evicts(Object... key) {
        getCacheExt().evict(getCache(), key);
    }

    /**
     * 值放入缓存同时设置有效时长(在本框架中只有设置缓存为Redis时才有效)
     * @param key
     * @param value
     * @param expiration 超时时长。单位：分钟。设置为0时没有超时时长。
     */
    public void put(String key, Object value, long expiration) {
        getCache().put(key, value);
        if(expiration > 0) {
            setExpires(key, expiration);
        }
    }

    /**
     * 批量添加键值对
     * @param items
     */
    public void put(Map<Object, Object> items){
        getCacheExt().add(getCache(), items);
    }

    /**
     * 在Redis集群环境下,对键值设置有效时长
     * @param key
     * @param expiration 有效时长(单位分钟)
     */
    public void setExpires(String key, long expiration) {
        getCacheExt().setExpires(cache, key, expiration);
    }
    public  <T> Collection<T> getAll(){
        return getCacheExt().getAll(getCache());
    }
    public void clear(){
        getCache().clear();
    }
    private CacheExt getCacheExt(){
        if(cacheExt == null){
            if(cacheManager instanceof RedisCacheManager)
                cacheExt = new RedisCachExt();
            else if(cacheManager instanceof SimpleCacheManager)
                cacheExt = new SimpleCachExt();
        }
        return cacheExt;
    }
}
