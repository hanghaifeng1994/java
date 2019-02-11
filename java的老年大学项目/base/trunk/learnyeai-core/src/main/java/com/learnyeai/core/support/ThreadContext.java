package com.learnyeai.core.support;

import java.util.HashMap;
import java.util.Map;

/**
 * 线程上下文管理类
 *
 */
public abstract class ThreadContext {

    private static final ThreadLocal<Map<Object, Object>> contexts =
            new InheritableThreadLocal<Map<Object, Object>>() {
                @Override
                protected Map<Object, Object> initialValue() {
                    return new HashMap<Object, Object>();
                }
            };

    protected ThreadContext(){}

    /**
     * 得到当前线程上下文
     * 
     * @return
     */
    public static Map<Object, Object> getContexts() {
        return null != contexts ? new HashMap<Object, Object>(contexts.get()) : null;
    }

    /**
     * 设置当前线程上下文
     * 
     * @param newResources
     *            新的上下文环境
     */
    public static void setContexts(Map newResources) {
        if(null == newResources || newResources.isEmpty()) {
            return;
        }
        contexts.get().clear();
        contexts.get().putAll(newResources);
    }

    /**
     * 从当前线程上下文中取值
     * 
     * @param key
     *            key
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getValue(Object key, Class<T> clazz) {
        return (T) contexts.get().get(key);
    }

    /**
     * 从当前线程上下文中取值
     * 
     * @param key
     *            键
     * @return
     */
    public static Object get(Object key) {
        return contexts.get().get(key);
    }

    /**
     * 设置当前线程上下文中的值
     * 
     * @param key
     *            键
     * @param value
     *            值
     */
    public static void put(Object key, Object value) {
        if(null == key) {
            throw new IllegalArgumentException("key不能为空");
        }

        if(null == value) {
            remove(key);
            return;
        }

        contexts.get().put(key, value);
    }

    /**
     * 删除当前线程上下文的值
     * 
     * @param key
     *            键
     * @return
     */
    public static Object remove(Object key) {
        Object value = contexts.get().remove(key);
        return value;
    }

    /**
     * 删除当前线程上下文环境
     */
    public static void remove() {
        contexts.remove();
    }

    public static boolean isContain(Object key){
        return contexts.get().containsKey(key);
    }
}
