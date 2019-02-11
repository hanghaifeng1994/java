package com.learnyeai.rabbitmq.config;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;


/**
 * redis的配置文件，供参考，最好是不要放在这里面，而是作为单独包
 * */

@Configuration
@ComponentScan
public class RedisConfig4Mq extends CachingConfigurerSupport{
	
//	@Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory();
//    }
    
    @Bean(name = "redisTemplateMq")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(factory);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        // 设置Jackson序列化时只包含不为空的字段
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 忽略在JSON字符串中存在，而在Java中不存在的属性
        om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        om.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        om.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        jsonRedisSerializer.setObjectMapper(om);

//        JsonRedisSerializer<Object> jsonRedisSerializer = new JsonRedisSerializer<Object>(Object.class);

        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jsonRedisSerializer);
        /**hash也同样存对象数组*/
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);
        redisTemplate.setDefaultSerializer(jsonRedisSerializer);

        return redisTemplate;
    }
}