package com.learnyeai.redislock;


import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.core.config.ConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;



public class RedisLock {
	private static Logger logger = LoggerFactory.getLogger(RedisLock.class);
	
	//纳秒和毫秒之间的转换率
	public static final long MILLI_NANO_TIME = 1000 * 1000L;
	
	public static final String LOCKED = "TRUE";
	
	public static final Random RANDOM = new Random();
	private String key;
	//封装的操作redis的工具
//	private RedisClient redisClient = RedisFactory.getDefaultClient();
	
//	private boolean lock = true;


	public RedisUtil getRedisUtil(){
		RedisUtil redisUtil = RedisUtilFactory.getUtil(ConfigUtils.getValue("spring.application.name") + "_lock");
		return redisUtil;
	}

	/**
     * 
     * @param purpose 锁前缀
     * @param key 锁定的ID等东西
     */
    public RedisLock(String purpose, String key){
    	 this.key = purpose + "_" + key;
    }
	
	/**
	 * 加锁
	 * 使用方式为：
	 * lock();
	 * try{
	 * 	  executeMethod();
	 * }finally{
	 * 	 unlock();
	 * }
	 * @param timeout timeout的时间范围内轮询锁，默认2000毫秒
	 * @param expire 设置锁超时时间
	 * @return 成功 or 失败
	 */
	public boolean lock(final long timeout,final int expire){
		long nanoTime = System.nanoTime();
		long tt = timeout * MILLI_NANO_TIME;
		try {
			RedisUtil redisUtil = getRedisUtil();
			//在timeout的时间范围内不断轮询锁
			while (System.nanoTime() - nanoTime < tt) {
				//锁不存在的话，设置锁并设置锁过期时间，即加锁
				if(redisUtil.setnx(this.key, LOCKED)){
					redisUtil.setExpires(this.key, expire);
					//锁的情况下锁过期后消失，不会造成永久阻塞
//					this.lock = true;
					logger.info("{} 获取锁成功 {}", Thread.currentThread().getId(), this.key);
					return true;
				}
				/*if (this.redisClient.setnx(this.key, LOCKED) == 1) {
					this.redisClient.expire(key, expire);//设置锁过期时间是为了在没有释放
					//锁的情况下锁过期后消失，不会造成永久阻塞
//					this.lock = true;
					logger.info("{} 获取锁成功 {}", Thread.currentThread().getId(), this.key);
					return true;
				}*/
				logger.info("{} 出现锁等待 {}",Thread.currentThread().getId(), this.key);
				//短暂休眠，避免可能的活锁，当时间比较长时，500毫秒轮询一次
				Thread.sleep(Math.min(tt/5, 500));
//				Thread.sleep(3, RANDOM.nextInt(30));
			} 
		} catch (Exception e) {
			logger.error("{} locking error {} {}", Thread.currentThread().getId(), this.key, e.getMessage());
		}
		logger.error("{} 获取锁失败 {}",Thread.currentThread().getId(), this.key);
		return false;
	}
	
	public  void unlock() {
		try {
//			if(this.lock)
			{
				getRedisUtil().remove(key);
//				redisClient.delKey(key);
				logger.info("{} 释放锁 {}",Thread.currentThread().getId(), key);
			}
		} catch (Throwable e) {
			
		}
	}

}
