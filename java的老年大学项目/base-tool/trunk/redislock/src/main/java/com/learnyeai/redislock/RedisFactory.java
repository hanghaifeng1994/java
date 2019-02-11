package com.learnyeai.redislock;

import java.io.IOException;
import java.util.Properties;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisFactory {

	public static JedisPoolConfig getPoolConfig() throws IOException{
		Properties properties = new Properties();
		
//		InputStream in = RedisFactory.class.getClassLoader().getResourceAsStream("com/liushao/redislockframework/redis.properties");
		
		try {
//			properties.load(in);
			JedisPoolConfig config = new JedisPoolConfig();
			/*config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle", "100")));
			config.setMinIdle(Integer.parseInt(properties.getProperty("minIdle", "1")));
			config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal", "1000")));*/
			config.setMaxIdle(100);
			config.setMinIdle(1);
			config.setMaxTotal(1000);
			return config;
		} finally {
//			in.close();
		}
		
	}
	
	public static RedisClient getDefaultClient(){
		JedisPool pool = null;
		try {
			pool = new JedisPool(getPoolConfig(),"127.0.0.1", 6379, 8000000,"123456");
			RedisClient client = new RedisClient(pool);
			return client;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
