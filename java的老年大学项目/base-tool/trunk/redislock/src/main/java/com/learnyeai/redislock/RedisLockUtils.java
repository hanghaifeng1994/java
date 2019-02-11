package com.learnyeai.redislock;

import java.lang.reflect.Proxy;

/**
 * Created by zpz on 2018/6/6.
 */
public class RedisLockUtils {
    public static Object getProxy(Class srcClass, Object srcObj){
        //用动态代理的方式调用secKill方法
        return Proxy.newProxyInstance(srcClass.getClassLoader(),
                new Class[]{srcClass}, new CacheLockInterceptor(srcObj));
    }
    public static boolean lock(String lockedPrefix, String key){
        RedisLock lock = new RedisLock(lockedPrefix, key);
        boolean result = lock.lock(2000, 10000);
        return result;
    }

    public static boolean lock(String lockedPrefix, String key, int timeOut, int expireTime){
        RedisLock lock = new RedisLock(lockedPrefix, key);
        boolean result = lock.lock(timeOut, expireTime);
        return result;
    }

    public static boolean unlock(String lockedPrefix, String key){
        RedisLock lock = new RedisLock(lockedPrefix, key);
        lock.unlock();
        return true;
    }

}
