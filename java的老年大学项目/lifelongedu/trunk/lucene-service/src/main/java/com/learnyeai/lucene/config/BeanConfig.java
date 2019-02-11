package com.learnyeai.lucene.config;

import com.learnyeai.lucene.index.LuceneIndexProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zpz on 2018/9/10.
 */
@Configuration
@EnableConfigurationProperties(LuceneIndexProperties.class)
public class BeanConfig {
}
