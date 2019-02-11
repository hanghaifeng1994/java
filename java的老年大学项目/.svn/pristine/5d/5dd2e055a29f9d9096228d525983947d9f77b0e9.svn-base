package com.learnyeai.file.fastdfs;

import feign.Client;
import feign.Contract;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zpz on 2018/9/3.
 */
@Configuration
@EnableConfigurationProperties(FastDfsProperties.class)
public class FastDFSConfig {

    @Bean
    @ConditionalOnBean(Client.class)
    FeignUtils getFeignUtils(Client client){
        return new FeignUtils(null,null,client, null);
    }
}
