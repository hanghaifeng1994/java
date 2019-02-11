package com.learnyeai.core.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 兼容多种缓存方式 ，内存、redis
 * 1 过期就销毁
 * 2 永远不销毁
 * 3 添加访问时间，一段时间内不访问就销毁（提供轮询销毁机制，类似缓存处理）
 *
 *不处理过期，可设置某过期时间
 * // 张配忠修改 // 20170317
 */
public class CacheUtils{
	private static Logger logger = LoggerFactory.getLogger(CacheUtils.class);
	private static CacheDelegate cache = null;
	private static Map<String, CacheDelegate> map = new HashMap<String, CacheDelegate>();

	static{
		cache = getCache(CacheNames.DEFAULT_CACHE_NAME);
	}
	public static CacheDelegate getCache(String cacheName){
		if(map.containsKey(cacheName))
			return map.get(cacheName);
		CacheDelegate o = new CacheDelegate(cacheName);
		map.put(cacheName, o);
		return o;
	}

	public static void put(Map<Object, Object> items) {
		cache.put(items);
	}

	/*public static void put(String key, Object value, long expiration) {
		cache.put(key, value, expiration);
	}*/

	public static <T> Collection<T> getAll() {
		return cache.getAll();
	}

	public static <T> T get(Object key) {
		return cache.get(key);
	}
	public static <T> T get(Object key, T defaultValue) {
		T value = get(key);
		return value != null ? value : defaultValue;
	}
	public static <T> T getCacheVal(String cacheName, Object key){
		return getCache(cacheName).get(key);
	}
	public static <T> T getCacheVal(String cacheName, Object key, T defaultValue){
		T value = getCacheVal(cacheName, key);
		return value != null ? value : defaultValue;
	}

	public static void evict(Object key) {
		cache.evict(key);
	}

	public static void put(Object key, Object value) {
		cache.put(key, value);
	}
	public static void put(String cacheName, Object key, Object value) {
		getCache(cacheName).put(key, value);
	}

	public static void evicts(Object... key) {
		cache.evicts(key);
	}

	public static void clear() {
		cache.clear();
	}
}
