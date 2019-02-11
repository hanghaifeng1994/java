package com.learnyeai.core.config;

import com.learnyeai.core.consts.ConfigEnum;
import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.tools.common.ExecutorUtils;
import com.learnyeai.tools.common.StringUtils;
import com.learnyeai.tools.observe.ObservableManager;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 参数配置管理工具，后来更新的配置，只能覆盖，不能删除配置项
 * @author lc3
 */
public class ConfigUtils {

    /**
     * 引导程序的配置文件
     */
    public static final String BOOTSTRAP_CONFIG_FILE = "classpath:/application.properties";

    /**
     * 配置文件刷新时间，单位秒
     */
    public static final String CONFIG_FILE_REFRESH_SECOND = "config_file_refresh_second";
    public static final int CONFIG_FILE_REFRESH_SECOND_DEFVAL = 300;    // 5分钟

    /**
     * 配置文件刷新时间，单位秒
     */
    public static final String SYSTEM_CACHE_REFRESH_SECOND = "system_cache_refresh_second";
    public static final int SYSTEM_CACHE_REFRESH_SECOND_DEFVAL = 300;    // 5分钟

    /**
     * 扩展配置文件的路径，多个路径用分号隔开
     */
    public static final String EXT_CONFIG_FILES = "extconfig.paths";

    /**
     * 扩展配置实现类，多个Bean用分号隔开
     */
    public static final String EXT_CONFIG_BEANs = "extconfig.beans";



    /**
     * 系统默认的resource加载器
     */
    public static final DefaultResourceLoader DEFAULT_RESOURCE_LOADER = new DefaultResourceLoader();

    private static final Logger logger = LoggerFactory.getLogger(ConfigUtils.class);
    /**
     * 系统配置缓存
     */
    private static final Properties CONFIG_CHACHE = new Properties();
    /**
     * 加载过的配置文件列表
     */
    private static final List<String> LOADED_PROPERTY_FILE_LIST = new ArrayList<String>();
    /**
     * 配置监听器
     */
    private static final Map<String, Set<ConfigListener>> CONFIGLISTENERS = new HashMap<String, Set<ConfigListener>>();
    /**
     * 上次缓存更新时间
     */
    private static Date lastUpdateDate = null;
    /**
     * 扩展Bean最后更新时间
     */
    private static Date beanLastUpdateDate = null;
    /**
     * 是否已经初始化
     */
    private static boolean hasInit = false;

    static {
        init();
    }

    private ConfigUtils() {}

    private static synchronized void init() {
        if(hasInit) {
            return;
        }
        logger.info("开始加载系统启动配置文件：" + BOOTSTRAP_CONFIG_FILE);
        Resource resource = DEFAULT_RESOURCE_LOADER.getResource(BOOTSTRAP_CONFIG_FILE);
        if(null == resource || !resource.exists()) {
            throw new IllegalArgumentException("启动配置文件没有找到：" + BOOTSTRAP_CONFIG_FILE);
        }
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(
                    new EncodedResource(resource, ConfigEnum.DEFAULT_CONFIG_FILE_ENCODING));
            loadProperties(properties);
        } catch (IOException e) {
            logger.error("加载启动配置文件失败：" + BOOTSTRAP_CONFIG_FILE, e);
            throw new RuntimeException("加载启动配置文件失败：" + BOOTSTRAP_CONFIG_FILE, e);
        }
        logger.info("成功加载系统启动配置文件：" + BOOTSTRAP_CONFIG_FILE);

        int defualtRefrechTime = CONFIG_FILE_REFRESH_SECOND_DEFVAL;
        int value = getValue(CONFIG_FILE_REFRESH_SECOND, defualtRefrechTime);
        if(value < 0) {
            logger.error("系统配置项{}有问题，为大于等于0的正整数，请检查，暂采用默认时间{}",
                    CONFIG_FILE_REFRESH_SECOND, defualtRefrechTime);
            value = defualtRefrechTime;
        }
        if(value > 0) {
            loadExtProperties();
            logger.info("开始启动定时刷新系统配置的定时器……");
            ExecutorUtils.getSystemScheduledExecutorService().scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    loadExtProperties();
                }
            }, value, value, TimeUnit.SECONDS);
            logger.info("成功启动定时刷新系统配置的定时器，更新间隔为{}秒。", value);
        }
        hasInit = true;
    }

    /**
     * 加载扩展配置文件配置
     */
    private static synchronized void loadExtProperties() {
        String extConfigFiles = getValue(EXT_CONFIG_FILES);
        logger.debug("开始加载扩展配置文件集合：" + extConfigFiles);
        Properties extProps = new Properties();
        if(StringUtils.isNotBlank(extConfigFiles)) {
            String[] files = extConfigFiles.split(ConfigEnum.SYS_DEFAULT_SPLIT_STR);
            for (String file : files) {
                loadPropFile(file, extProps);
            }
        }
        logger.debug("完成加载扩展配置文件集合：" + extConfigFiles);

        String extConfigBeans = getValue(EXT_CONFIG_BEANs);
        if (StringUtils.isNotBlank(extConfigBeans)) {
            loadBeanProps(extConfigBeans, extProps);
        }

        loadProperties(extProps);
        lastUpdateDate = new Date();
    }

    /**
     * 加载扩展Bean配置
     * @param extConfigBeans 扩展Bean
     * @param extProps 配置
     */
    private static void loadBeanProps(final String extConfigBeans, final Properties extProps) {
        if (null != SpringContextUtils.getApplicationContext()) {
            logger.debug("开始加载扩展配置Bean：" + extConfigBeans);
            String[] beans = extConfigBeans.split(ConfigEnum.SYS_DEFAULT_SPLIT_STR);
            for (String bean : beans) {
                Properties properties = null;
                try {
                    ConfigDao configDao = SpringContextUtils.getBean(bean, ConfigDao.class);
                    if (null == configDao) {
                        logger.warn("系统配置持久化bean[{}]不存在，直接忽略", bean);
                        continue;
                    }
                    properties = configDao.queryConfig(beanLastUpdateDate);
                } catch (Exception e) {
                    if (logger.isWarnEnabled()) {
                        logger.warn("执行系统配置持久化接口" + bean + "失败，直接忽略", e);
                    }
                    continue;
                }
                extProps.putAll(properties);
            }
            beanLastUpdateDate = new Date();
            logger.debug("成功加载扩展配置Bean：" + extConfigBeans);
        } else if (StringUtils.isNotBlank(extConfigBeans)) {
            logger.warn("由于Spring没有初始化完成，延迟加载扩展配置Bean：" + extConfigBeans);
            ObservableManager.get().getObservable(SpringContextUtils.class).addObserver(new Observer() {
                @Override
                public void update(Observable o, Object arg) {
                    o.deleteObserver(this);
                    Properties beanProps = new Properties();
                    loadBeanProps(extConfigBeans, beanProps);
                    loadProperties(beanProps);
                }
            });
        }
    }

    /**
     * 加载配置文件
     * @param configFile 配置文件路径
     * @param props 已有配置
     */
    private static void loadPropFile(String configFile, Properties props) {
        Assert.notNull(configFile, "configFile不能为空！");
        Assert.notNull(props, "props不能为空！");
        try {
            Resource resource = DEFAULT_RESOURCE_LOADER.getResource(configFile);
            if(null == resource || !resource.exists()) {
                logger.warn("扩展配置文件不存在：{}，直接忽略", configFile);
                return;
            }
            if(null != lastUpdateDate && resource.lastModified() <= lastUpdateDate.getTime()) {
                return;
            }
            PropertiesLoaderUtils.fillProperties(props, new EncodedResource(resource,
                    ConfigEnum.DEFAULT_CONFIG_FILE_ENCODING));
            logger.debug("成功加载扩展配置文件：{}", configFile);
        } catch (IOException e) {
            logger.warn("加载启动配置文件失败：" + BOOTSTRAP_CONFIG_FILE, e);
            return;
        }
        if(!LOADED_PROPERTY_FILE_LIST.contains(configFile)) {
            LOADED_PROPERTY_FILE_LIST.add(configFile);
        }
    }

    /**
     * 加载配置信息到系统配置缓存
     * @param properties 配置内容
     */
    private static synchronized void loadProperties(Properties properties) {
        Assert.notNull(properties, "properties不能为空！");
        for (String key : properties.stringPropertyNames()) {
            String oldVal = CONFIG_CHACHE.getProperty(key);
            String newVal = properties.getProperty(key);
            if(null == oldVal || !oldVal.equals(newVal)) {
                onConfigItemChange(key, oldVal, newVal);
                CONFIG_CHACHE.put(key, newVal);
            }
        }
    }

    /**
     * 配置修改通知接口
     * @param key 配置项
     * @param oldVal 旧值
     * @param newVal 新值
     */
    private static void onConfigItemChange(String key, String oldVal, String newVal) {
        if(logger.isDebugEnabled()) {
            logger.debug("配置项变更: {}, 旧值: {}, 新值: {}", key, oldVal, newVal);
        }
        Set<ConfigListener> configListeners = getConfigListenersByKey(key, false);
        if(null != configListeners) {
            for (ConfigListener configListener : configListeners) {
                try {
                    configListener.onChange(key, oldVal, newVal);
                } catch (Exception e) {
                    if(logger.isWarnEnabled()) {
                        logger.warn("配置项" + key + "变更，监听接口" + configListener.getClass() + "处理异常", e);
                    }
                }
            }
        }
    }

    /**
     * 注册配置监听器
     * @param key 监听的key，为空时监听所有变化，多个项可用分号分隔
     * @param listener 监听器
     */
    public static void registerConfigListener(String key, ConfigListener listener) {
        synchronized (CONFIGLISTENERS) {
            String[] keys = getKeys(key);
            if (null == keys) {
                getConfigListenersByKey(null, true).add(listener);
            } else {
                for (String s : keys) {
                    getConfigListenersByKey(s, true).add(listener);
                }
            }
        }
    }

    /**
     * 取消注销监听器
     * @param key 监听的key，为空时监听所有变化，多个项可用分号分隔
     * @param listener 监听器
     */
    public static void unRegisterConfigListener(String key, ConfigListener listener) {
        synchronized (CONFIGLISTENERS) {
            String[] keys = getKeys(key);
            if(null == keys) {
                Set<ConfigListener> configListeners = getConfigListenersByKey(null, false);
                if (null != configListeners) {
                    configListeners.remove(listener);
                }
            } else {
                for (String k : keys) {
                    Set<ConfigListener> configListeners = getConfigListenersByKey(k, false);
                    if (null != configListeners) {
                        configListeners.remove(listener);
                    }
                }
            }
        }
    }

    /**
     * 根据key获得监听器列表
     * @param key key
     * @param autoCreate 是否自动创建
     * @return
     */
    private static Set<ConfigListener> getConfigListenersByKey(String key, boolean autoCreate) {
        synchronized (CONFIGLISTENERS) {
            Set<ConfigListener> configListeners = CONFIGLISTENERS.get(key);
            if (null == configListeners && autoCreate) {
                configListeners = new LinkedHashSet<ConfigListener>();
                CONFIGLISTENERS.put(key, configListeners);
            }
            return configListeners;
        }
    }

    /**
     * 拆分配置key为具体的key集合
     * @param key 原始Key
     * @return
     */
    private static String[] getKeys(String key) {
        if(null == key) {
            return null;
        }
        return key.trim().split(ConfigEnum.SYS_DEFAULT_SPLIT_STR);
    }

    /**
     * 获得系统配置值
     * @param key 键
     * @param classType 值类型
     * @param defaultVal 默认值
     * @param <T> 值泛型类型
     * @return 特定类型值
     */
    @SuppressWarnings("unchecked")
    public static <T> T getValue(String key, Class<T> classType, T defaultVal) {
        Assert.notNull(key, "key不能为空");
        String strVal = CONFIG_CHACHE.getProperty(key);
        if(null == strVal || strVal.isEmpty()) {
            return defaultVal;
        }
        if(null == classType) {
            return (T) strVal;
        }
        if(classType.isAssignableFrom(strVal.getClass())) {
            return (T) strVal;
        } else {
            return (T) ConvertUtils.convert(strVal, classType);
        }
    }

    /**
     * 获得系统配置值
     * @param key 键
     * @param defaultVal 默认值，不能为空
     * @param <T> 泛型类型
     * @return 特定类型值
     */
    @SuppressWarnings("unchecked")
    public static <T> T getValue(String key, T defaultVal) {
        return getValue(key, (Class<T>)defaultVal.getClass(), defaultVal);
    }

    /**
     * 获得系统配置值
     * @param key 键
     * @param defaultVal 默认值
     * @return string类型值
     */
    public static String getValue(String key, String defaultVal) {
        return getValue(key, String.class, defaultVal);
    }

    /**
     * 获得系统配置值
     * @param key 键
     * @return string类型值
     */
    public static String getValue(String key) {
        return getValue(key, null);
    }

    /**
     * 得到最终字符串，替换系统中的变量，变量用"${varName}"表示，"$$"代表一个"$"
     * @param str 原始字符串
     * @return
     */
    public static String fillConfigs(String str) {
        if(StringUtils.isBlank(str)) {
            return str;
        }
        boolean in = false; // 是否在变量表达式中
        StringBuilder sb = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!in) {   // 不在变量表达式中
                if(ConfigEnum.SYS_DEFAULT_VAR_SIGN == c) { // 刚进变量表达式
                    in = true;
                    if(null == sb) {    // 补上第一变量之前的串
                        sb = new StringBuilder(str.substring(0, i));
                    }
                } else if(null != sb) { // 直到现在没有变量，如果一直没有变量，直接返回原串，提高效率
                    sb.append(c);
                }
                continue;
            }
            // 以下为在变量表达式中
            in = false;
            if(ConfigEnum.SYS_DEFAULT_VAR_SIGN == c) { // 双"$$"代表一个"$"符
                sb.append(c);
            } else if('{' == c) {
                int end = i + 1;
                while (end < str.length()) {
                    if('}' == str.charAt(end)) {
                        break;
                    }
                    end++;
                }
                String varName = str.substring(i + 1, end);
                String value = getValue(varName);
                if(null == value) { // 如果没有配置对应变量值，直接原样输出
                    sb.append(ConfigEnum.SYS_DEFAULT_VAR_SIGN).append('{').append(varName).append('}');
                } else {
                    sb.append(value);
                }
                i = end;
            } else {    // 不合法的表达式，直接原样输出
                sb.append(ConfigEnum.SYS_DEFAULT_VAR_SIGN);
                sb.append(c);
            }
        }
        return null == sb ? str : sb.toString();
    }

    /**
     * 通过前缀获取键集合
     * @param prefix 前缀
     * @return
     */
    public static Set<String> keySetStartWith(String prefix) {
        if(StringUtils.isBlank(prefix)) {
            prefix = null;
        }
        Set<String> keys = new LinkedHashSet<String>();
        for (Object key : CONFIG_CHACHE.keySet()) {
            if(!(key instanceof String)) {
                continue;
            }
            if(null == prefix || ((String) key).startsWith(prefix)) {
                keys.add((String) key);
            }
        }
        return keys;
    }

}
