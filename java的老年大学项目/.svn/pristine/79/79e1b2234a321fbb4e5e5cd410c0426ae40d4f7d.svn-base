package com.learnyeai.tools.observe;

import com.learnyeai.tools.observe.suport.ObservableKeysResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 被观察者管理器
 * @author lc3@yitong.com.cn
 */
public class ObservableManager<K> {

    /**
     * 被观察者缓存
     */
    private final ConcurrentMap<K, GenericObservable> obsMap =
            new ConcurrentHashMap<K, GenericObservable>();
    private static Logger logger = LoggerFactory.getLogger(ObservableManager.class);

    /**
     * 系统默认被观察才管理器
     */
    private static final ObservableManager<Class> DEFAULT =
            new ObservableManager<Class>(new ObservableKeysResolver<Class>() {
                @Override
                @SuppressWarnings("unchecked")
                public <E> List<Class> getKeys(E sourceKeys) {
                    if(null == sourceKeys || !(sourceKeys instanceof Class) || !ObservableTag.class.isAssignableFrom((Class<?>) sourceKeys)) {
                        return Collections.emptyList();
                    }
                    Class<ObservableTag> keys = (Class<ObservableTag>) sourceKeys;
                    try {
                        Method method = keys.getMethod(ObservableTag.OBSERVABLE_TAG_METHOD_NAME);
                        GenericObservable observable = (GenericObservable) method.invoke(null);
                        DEFAULT.obsMap.put(keys, observable);
                    } catch (Exception e) {
                        String message = "请检查类结构" + keys.getName() +
                                "，ObservableTag类中应该包含公共静态方法： public static GenericObservable " +
                                ObservableTag.OBSERVABLE_TAG_METHOD_NAME + "()。";
                        logger.error(message, e);
                        throw new IllegalArgumentException(message, e);
                    }
                    return super.getKeys(keys);
                }
            });
    private final ObservableKeysResolver<K> keysResolver;

    public ObservableManager() {
        this(new ObservableKeysResolver<K>());
    }

    public ObservableManager(ObservableKeysResolver<K> keysResolver) {
        Assert.notNull(keysResolver, "keysResolver不能为空");
        this.keysResolver = keysResolver;
    }

    /**
     * 得到默认被观察者管理器
     * @return 默认被观察管理器
     */
    public static ObservableManager<Class> get() {
        return DEFAULT;
    }

    /**
     * 通过源关键字得到最终关键字
     *  例如带分号的String，得到String数组
     * @param sourceKeys 原关键字
     * @param <E>
     * @return
     */
    protected <E> List<K> getKeys(E sourceKeys) {
        return keysResolver.getKeys(sourceKeys);
    }

    /**
     * 得到类对应的被观察者
     * @param key 标识
     * @param autoCreate 是否自动创建
     * @return
     */
    public GenericObservable getObservable(K key, boolean autoCreate) {
        Assert.notNull(key, "被观察者标识不能为空。");
        GenericObservable observable = obsMap.get(key);
        if(null != observable) {
            return observable;
        }
        synchronized (obsMap) {
            getKeys(key);
            observable = obsMap.get(key);
            if(null != observable) {
                return observable;
            }
            observable = new GenericObservable(key.toString());
            obsMap.put(key, observable);
        }
        return observable;
    }

    /**
     * 得到类对应的被观察者
     * @param keys 标识
     * @return
     */
    public GenericObservable getObservable(K keys) {
        return getObservable(keys, false);
    }

    /**
     * 注册观察者
     * @param sourceKeys 被观察者标识
     * @param o 观察者
     */
    public synchronized <E> ObservableManager<K> addObserver(E sourceKeys, Observer o) {
        Assert.notNull(o, "观察者不能为空");
        final List<K> keys = getKeys(sourceKeys);
        Assert.notNull(keys, "keys不能为空");
        for (K key : keys) {
            final GenericObservable observable = getObservable(key, true);
            observable.addObserver(o);
        }
        return this;
    }


    /**
     * 删除观察者
     * @param sourceKeys 被观察者标识
     * @param o 观察者
     */
    public synchronized ObservableManager<K> deleteObserver(K sourceKeys, Observer o) {
        Assert.notNull(o, "观察者不能为空");
        final List<K> keys = getKeys(sourceKeys);
        Assert.notNull(keys, "keys不能为空");
        for (K key : keys) {
            final GenericObservable observable = getObservable(key, true);
            observable.deleteObserver(o);
            if(0 == observable.countObservers()) {
                obsMap.remove(key, observable);
            }
        }
        return this;
    }

    /**
     * 向观察者们通知改变
     * @param sourceKeys 被观察者标识
     * @param arg 参数
     */
    public ObservableManager<K> notifyObservers(K sourceKeys, Object arg) {
        final List<K> keys = getKeys(sourceKeys);
        Assert.notNull(keys, "keys不能为空");
        for (K key : keys) {
            final GenericObservable observable = getObservable(key);
            if(null != observable) {
                observable.setChanged();
                observable.notifyObservers(arg);
            }
        }
        return this;
    }

    /**
     * 得到标识解析器
     * @return
     */
    public ObservableKeysResolver<K> getKeysResolver() {
        return keysResolver;
    }
}
