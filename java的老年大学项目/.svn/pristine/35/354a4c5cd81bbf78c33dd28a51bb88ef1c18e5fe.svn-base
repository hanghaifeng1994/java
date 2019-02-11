package cn.com.weyeyun.redislock;


import com.learnyeai.redislock.CacheLock;
import com.learnyeai.redislock.LockedObject;

public interface SeckillInterface {
	@CacheLock(lockedPrefix="TEST_PREFIX")
	public void secKill(String arg1,@LockedObject Long arg2);
}
