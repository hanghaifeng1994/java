package com.learnyeai.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * Created by zpz on 2018/8/9.
 */
@Configuration
public class MyAbstractCachingConfiguration implements ImportAware {

    @Nullable
    protected AnnotationAttributes enableCaching;

    @Nullable
    protected CacheManager cacheManager;

    @Nullable
    protected CacheResolver cacheResolver;

    @Nullable
    protected KeyGenerator keyGenerator;

    @Nullable
    protected CacheErrorHandler errorHandler;


    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        this.enableCaching = AnnotationAttributes.fromMap(
                importMetadata.getAnnotationAttributes(MyEnableCaching.class.getName(), false));
        if (this.enableCaching == null) {
            throw new IllegalArgumentException(
                    "@MyEnableCaching is not present on importing class " + importMetadata.getClassName());
        }
    }

    @Autowired(required = false)
    void setConfigurers(Collection<CachingConfigurer> configurers) {
        if (CollectionUtils.isEmpty(configurers)) {
            return;
        }
        if (configurers.size() > 1) {
            throw new IllegalStateException(configurers.size() + " implementations of " +
                    "CachingConfigurer were found when only 1 was expected. " +
                    "Refactor the configuration such that CachingConfigurer is " +
                    "implemented only once or not at all.");
        }
        CachingConfigurer configurer = configurers.iterator().next();
        useCachingConfigurer(configurer);
    }

    /**
     * Extract the configuration from the nominated {@link CachingConfigurer}.
     */
    protected void useCachingConfigurer(CachingConfigurer config) {
        this.cacheManager = config.cacheManager();
        this.cacheResolver = config.cacheResolver();
        this.keyGenerator = config.keyGenerator();
        this.errorHandler = config.errorHandler();
    }

}
