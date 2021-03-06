package com.learnyeai.core.cache;

import com.learnyeai.core.utils.SpringContextUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;
/**
 * Created by zpz on 2018/4/18.
 */
public class RedisUtil {

    protected RedisTemplate redisTemplate;
    protected String cacheName;

    private final static String prefix_sep = "::";

    public String genKey(String key) {
        if (key == null || key.length() == 0)
            return null;

        return cacheName + prefix_sep + key;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public RedisUtil(String cacheName) {
        this.cacheName = cacheName;
        redisTemplate = SpringContextUtils.getBean("redisTemplate");
    }

    public RedisUtil(RedisTemplate redisTemplate, String cacheName) {
        this.redisTemplate = redisTemplate;
        this.cacheName = cacheName;
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        List<Serializable> listKey = new ArrayList();
        for (String key : keys) {
            listKey.add(genKey(key));
        }
        redisTemplate.delete(listKey);
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    @SuppressWarnings("unchecked")
    public void removePattern(final String pattern) {
        if (null == pattern || pattern.length() == 0)
            return;
        Set<Serializable> keys = redisTemplate.keys(genKey(pattern));
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }
    public void removeAll() {
        Set<Serializable> keys = redisTemplate.keys(genKey("*"));
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    @SuppressWarnings("unchecked")
    public void remove(final String key) {
        String newKey = genKey(key);
        redisTemplate.delete(newKey);
        /*if (exists(newKey)) {
            redisTemplate.delete(newKey);
        }*/
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean exists(final String key) {
        return redisTemplate.hasKey(genKey(key));
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(genKey(key));
        return (T) result;
    }

    public <T> List<T> get(final String... keys) {
        List<T> list = new ArrayList<T>();
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        Collection<Serializable> keyList = new ArrayList();
        for (String key : keys) {
            keyList.add(genKey(key));
        }
        List<Object> ll = operations.multiGet(keyList);
        for(Object o : ll){
            list.add((T)o);
        }
        return list;
    }

    public <T> List<T> getPattern(final String pattern) {
        List<T> list = new ArrayList<T>();
        Set<Serializable> keys = redisTemplate.keys(genKey(pattern));
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        List<Object> ll = operations.multiGet(keys);
        for(Object o : ll){
            list.add((T)o);
        }
        /*for (Serializable key : keys) {
            T t = (T) operations.get(key);
            list.add(t);
        }*/

        return list;
    }

    public <T> List<T> getAll() {

        return getPattern("*");
    }


    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(genKey(key), value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean setnx(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            result = operations.setIfAbsent(genKey(key), value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            String newKey = genKey(key);
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(newKey, value, expireTime, TimeUnit.SECONDS);
//            redisTemplate.expire(newKey, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean set(Map<String, Serializable> keyVals){
        boolean result = false;
        try {
            Map newKeyVal = new HashMap();

            for(Iterator<Map.Entry<String, Serializable>> it = keyVals.entrySet().iterator(); it.hasNext();){
                Map.Entry<String, Serializable> entry = it.next();
                newKeyVal.put(genKey(entry.getKey()), entry.getValue());
            }
            redisTemplate.opsForValue().multiSet(newKeyVal);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean setnx(Map<String, Serializable> keyVals){
        boolean result = false;
        try {
            Map newKeyVal = new HashMap();

            for(Iterator<Map.Entry<String, Serializable>> it = keyVals.entrySet().iterator(); it.hasNext();){
                Map.Entry<String, Serializable> entry = it.next();
                newKeyVal.put(genKey(entry.getKey()), entry.getValue());
            }
            redisTemplate.opsForValue().multiSetIfAbsent(newKeyVal);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(genKey(key), delta);
    }

    public Double increment(String key, double delta) {
        return redisTemplate.opsForValue().increment(genKey(key), delta);
    }

    public void setExpires(String key, long expiration){
        redisTemplate.expire(genKey(key), expiration, TimeUnit.SECONDS);
    }
    /**
     * 移除指定key 的过期时间
     * @param key
     * @return
     */
    public boolean persist(String key){
        return redisTemplate.boundValueOps(key).persist();
    }


    /**
     * 获取指定key 的过期时间
     * @param key
     * @return
     */
    public Long getExpire(String key){
        return redisTemplate.boundValueOps(key).getExpire();
    }
    /**
     * 修改 key
     * @param key
     * @return
     */
    public void rename(String key,String newKey){
        redisTemplate.boundValueOps(key).rename(newKey);
    }


//    hash-------------------------
    /**
     * 添加 Hash 键值对
     * @param key
     * @param hashKey
     * @param value
     */
    public void hput(String key, String hashKey, String value){
        redisTemplate.opsForHash().put(genKey(key), hashKey, value);
    }

    /**
     * 批量添加 hash 的 键值对
     * 有则覆盖,没有则添加
     * @param key
     * @param map
     */
    public void hputAll(String key,Map<String,Serializable> map){
        redisTemplate.opsForHash().putAll(genKey(key), map);
    }

    /**
     * 添加 hash 键值对. 不存在的时候才添加
     * @param key
     * @param hashKey
     * @param value
     * @return
     */
    public boolean hputIfAbsent(String key, String hashKey, String value){
        return redisTemplate.opsForHash().putIfAbsent(genKey(key), hashKey, value);
    }


    /**
     * 删除指定 hash 的 HashKey
     * @param key
     * @param hashKeys
     * @return 删除成功的 数量
     */
    public Long hdelete(String key, String ...hashKeys){
        return redisTemplate.opsForHash().delete(genKey(key), hashKeys);
    }


    /**
     * 给指定 hash 的 hashkey 做增减操作
     * @param key
     * @param hashKey
     * @param number
     * @return
     */
    public Long hincrement(String key, String hashKey,long number){
        return redisTemplate.opsForHash().increment(genKey(key), hashKey, number);
    }

    /**
     * 给指定 hash 的 hashkey 做增减操作
     * @param key
     * @param hashKey
     * @param number
     * @return
     */
    public Double hincrement(String key, String hashKey,Double number){
        return redisTemplate.opsForHash().increment(genKey(key), hashKey, number);
    }

    /**
     * 获取指定 key 下的 hashkey
     * @param key
     * @param hashKey
     * @return
     */
    public <T> T hget(String key,String hashKey){
        return (T)redisTemplate.opsForHash().get(genKey(key), hashKey);
    }

    /**
     * 获取 key 下的 所有  hashkey 和 value
     * @param key
     * @return
     */
    public Map<Object,Object> hgetAll(String key){
        return redisTemplate.opsForHash().entries(genKey(key));
    }

    /**
     * 验证指定 key 下 有没有指定的 hashkey
     * @param key
     * @param hashKey
     * @return
     */
    public boolean hexists(String key,String hashKey){
        return redisTemplate.opsForHash().hasKey(genKey(key), hashKey);
    }
    /**
     * 获取指定 hash 下面的 键值对 数量
     * @param key
     * @return
     */
    public Long hSize(String key){
        return redisTemplate.opsForHash().size(genKey(key));
    }

//    List 操作------------------------
    /**
     * 指定 list 从左入栈
     * @param key
     * @return 当前队列的长度
     */
    public Long lleftPush(String key,Object value){
        return redisTemplate.opsForList().leftPush(genKey(key), value);
    }

    /**
     * 指定 list 从左出栈
     * 如果列表没有元素,会堵塞到列表一直有元素或者超时为止
     * @param key
     * @return 出栈的值
     */
    public Object lleftPop(String key){
        return redisTemplate.opsForList().leftPop(genKey(key));
    }

    /**
     * 从左边依次入栈
     * 导入顺序按照 Collection 顺序
     * 如: a b c => c b a
     * @param key
     * @param values
     * @return
     */
    public Long lleftPushAll(String key,Collection<Object> values){
        return redisTemplate.opsForList().leftPushAll(genKey(key), values);
    }

    /**
     * 指定 list 从右入栈
     * @param key
     * @return 当前队列的长度
     */
    public Long lrightPush(String key,Object value){
        return redisTemplate.opsForList().rightPush(genKey(key), value);
    }

    /**
     * 指定 list 从右出栈
     * 如果列表没有元素,会堵塞到列表一直有元素或者超时为止
     * @param key
     * @return 出栈的值
     */
    public Object lrightPop(String key){
        return redisTemplate.opsForList().rightPop(genKey(key));
    }

    /**
     * 从右边依次入栈
     * 导入顺序按照 Collection 顺序
     * 如: a b c => a b c
     * @param key
     * @param values
     * @return
     */
    public Long lrightPushAll(String key,Collection<Object> values){
        return redisTemplate.opsForList().rightPushAll(genKey(key), values);
    }


    /**
     * 根据下标获取值
     * @param key
     * @param index
     * @return
     */
    public Object lpopIndex(String key,long index){
        return redisTemplate.opsForList().index(genKey(key), index);
    }


    /**
     * 获取列表指定长度
     * @param key
     * @param index
     * @return
     */
    public Long lsize(String key,long index){
        return redisTemplate.opsForList().size(genKey(key));
    }


    /**
     * 获取列表 指定范围内的所有值
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<Object> lrange(String key,long start,long end){
        return redisTemplate.opsForList().range(genKey(key), start, end);
    }


    /**
     * 删除 key 中 值为 value 的 count 个数.
     * @param key
     * @param count
     * @param value
     * @return 成功删除的个数
     */
    public Long lremove(String key,long count,Object value){
        return redisTemplate.opsForList().remove(genKey(key), count, value);
    }


    /**
     * 删除 列表 [start,end] 以外的所有元素
     * @param key
     * @param start
     * @param end
     */
    public void ltrim(String key,long start,long end){
        redisTemplate.opsForList().trim(genKey(key), start, end);

    }

    /**
     * 将 key 右出栈,并左入栈到 key2
     *
     * @param key 右出栈的列表
     * @param key2 左入栈的列表
     * @return 操作的值
     */
    public Object lrightPopAndLeftPush(String key,String key2){
        return redisTemplate.opsForList().rightPopAndLeftPush(genKey(key), genKey(key2));

    }

    /**
     * 阻塞右弹出
     * @param key 队列key
     * @param time 单位秒
     */
    public void lbrpop(String key, long time){
        redisTemplate.opsForList().rightPop(genKey(key), time, TimeUnit.SECONDS);
    }
//    set 操作  无序不重复集合-----------------------
    /**
     * 添加 set 元素
     * @param key
     * @param values
     * @return
     */
    public Long sadd(String key ,String ...values){
        return redisTemplate.opsForSet().add(genKey(key), values);
    }
    /**
     * 获取两个集合的差集
     * @param key
     * @param otherkey
     * @return
     */
    public Set<Object> sdifference(String key ,String otherkey){
        return redisTemplate.opsForSet().difference(genKey(key), genKey(otherkey));
    }
    /**
     * 将  key 与 otherkey 的差集 ,添加到新的 newKey 集合中
     * @param key
     * @param otherkey
     * @param newKey
     * @return 返回差集的数量
     */
    public Long sdifferenceAndStore(String key ,String otherkey,String newKey){
        return redisTemplate.opsForSet().differenceAndStore(genKey(key), genKey(otherkey), genKey(newKey));
    }

    /**
     * 删除一个或多个集合中的指定值
     * @param key
     * @param values
     * @return 成功删除数量
     */
    public Long sremove(String key,Object ...values){
        return redisTemplate.opsForSet().remove(genKey(key), values);
    }
    /**
     * 将 key 中的 value 转入到 destKey 中
     * @param key
     * @param value
     * @param destKey
     * @return 返回成功与否
     */
    public boolean smoveSet(String key,Object value,String destKey){
        return redisTemplate.opsForSet().move(genKey(key), value, genKey(destKey));
    }
    /**
     * 无序集合的大小
     * @param key
     * @return
     */
    public Long sSize(String key){
        return redisTemplate.opsForSet().size(genKey(key));
    }
    /**
     * 判断 set 集合中 是否有 value
     * @param key
     * @param value
     * @return
     */
    public boolean sisMember(String key,Object value){
        return redisTemplate.opsForSet().isMember(genKey(key), value);
    }
    /**
     * 返回 key 和 othere 的并集
     * @param key
     * @param otherKey
     * @return
     */
    public Set<Object> sunionSet(String key,String otherKey){
        return redisTemplate.opsForSet().union(genKey(key), genKey(otherKey));
    }
    /**
     * 将 key 与 otherKey 的并集,保存到 destKey 中
     * @param key
     * @param otherKey
     * @param destKey
     * @return destKey 数量
     */
    public Long sunionAndStoreSet(String key, String otherKey,String destKey){
        return redisTemplate.opsForSet().unionAndStore(genKey(key), genKey(otherKey), genKey(destKey));
    }
    /**
     * 返回集合中所有元素
     * @param key
     * @return
     */
    public Set<Object> sgetAll(String key){
        return redisTemplate.opsForSet().members(genKey(key));
    }
}

