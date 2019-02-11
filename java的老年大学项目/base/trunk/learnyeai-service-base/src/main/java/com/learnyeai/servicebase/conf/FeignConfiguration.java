package com.learnyeai.servicebase.conf;

import com.learnyeai.core.converter.MapFormHttpMessageConverter;
import com.learnyeai.core.converter.MultipartFileHttpMessageConverter;
import com.learnyeai.core.converter.ObjFormHttpMessageConverter;
import com.learnyeai.servicebase.convert.FeignjsonHttpMessageConverter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by zpz on 2018/4/19.
 */
@Configuration
public class FeignConfiguration {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;
    @PostConstruct
    public void jacksonMap(){

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

        List<HttpMessageConverter<?>> springConverters = messageConverters.getObject().getConverters();
        for(HttpMessageConverter converter: springConverters){
            if(converter instanceof MappingJackson2HttpMessageConverter){
                ((MappingJackson2HttpMessageConverter)converter).setObjectMapper(mapper);
            }
        }
    }
    /*@Bean
    public Decoder feignDecoder () {
        final List<HttpMessageConverter<?>> springConverters = messageConverters.getObject().getConverters();
        final List<HttpMessageConverter<?>> decoderConverters
                = new ArrayList<HttpMessageConverter<?>>(springConverters.size() + 4);


        MultipartFileHttpMessageConverter multipartFileHttpMessageConverter = new MultipartFileHttpMessageConverter();
        MapFormHttpMessageConverter mapFormHttpMessageConverter = new MapFormHttpMessageConverter();
        mapFormHttpMessageConverter.addPartConverter(multipartFileHttpMessageConverter);

        ObjFormHttpMessageConverter objFormHttpMessageConverter = new ObjFormHttpMessageConverter();
        FastjsonHttpMessageConverter fastjsonHttpMessageConverter = new FastjsonHttpMessageConverter();

        decoderConverters.add(multipartFileHttpMessageConverter);
        decoderConverters.add(mapFormHttpMessageConverter);
        decoderConverters.add(objFormHttpMessageConverter);
        decoderConverters.add(fastjsonHttpMessageConverter);

        // 默认添加到最后
        decoderConverters.addAll(springConverters);
        final HttpMessageConverters httpMessageConverters = new HttpMessageConverters(decoderConverters);

        return new SpringDecoder(new ObjectFactory<HttpMessageConverters>() {
            @Override
            public HttpMessageConverters getObject() {
                return httpMessageConverters;
            }
        });
    }

    @Bean
    public Encoder feignEncoder () {
        final List<HttpMessageConverter<?>> springConverters = messageConverters.getObject().getConverters();
        final List<HttpMessageConverter<?>> decoderConverters
                = new ArrayList<HttpMessageConverter<?>>(springConverters.size() + 4);


        MultipartFileHttpMessageConverter multipartFileHttpMessageConverter = new MultipartFileHttpMessageConverter();
        MapFormHttpMessageConverter mapFormHttpMessageConverter = new MapFormHttpMessageConverter();
        mapFormHttpMessageConverter.addPartConverter(multipartFileHttpMessageConverter);

        ObjFormHttpMessageConverter objFormHttpMessageConverter = new ObjFormHttpMessageConverter();
        FastjsonHttpMessageConverter fastjsonHttpMessageConverter = new FastjsonHttpMessageConverter();

        decoderConverters.add(multipartFileHttpMessageConverter);
        decoderConverters.add(mapFormHttpMessageConverter);
        decoderConverters.add(objFormHttpMessageConverter);
        decoderConverters.add(fastjsonHttpMessageConverter);

        // 默认添加到最后
        decoderConverters.addAll(springConverters);
        final HttpMessageConverters httpMessageConverters = new HttpMessageConverters(decoderConverters);

        return new SpringEncoder(new ObjectFactory<HttpMessageConverters>() {
            @Override
            public HttpMessageConverters getObject() {
                return httpMessageConverters;
            }
        });
    }*/


    /**
     * 创建Feign请求拦截器，在发送请求前设置认证的token,各个微服务将token设置到环境变量中来达到通用
     * @return
     */
    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }
    // 作废，不有测试
    /*@Bean
    @Primary
    @Scope("prototype")
    public Encoder feignEncoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        return new SpringFormEncoder();
    }*/

    @Bean
    public MapFormHttpMessageConverter mapFormHttpMessageConverter(MultipartFileHttpMessageConverter multipartFileHttpMessageConverter) {
        MapFormHttpMessageConverter mapFormHttpMessageConverter = new MapFormHttpMessageConverter();
        mapFormHttpMessageConverter.addPartConverter(multipartFileHttpMessageConverter);
        return mapFormHttpMessageConverter;
    }

    @Bean
    public MultipartFileHttpMessageConverter multipartFileHttpMessageConverter() {
        return new MultipartFileHttpMessageConverter();
    }
    @Bean
    public ObjFormHttpMessageConverter objFormHttpMessageConverter(){
        return new ObjFormHttpMessageConverter();
    }
    // feign 使用decode 用到父类为GenericHttpMessageConverter，encode时会用到
    /*@Bean
    public FastjsonHttpMessageConverter fastjsonHttpMessageConverter(){
        return new FastjsonHttpMessageConverter();
    }*/
    @Bean
    FeignjsonHttpMessageConverter feignjsonHttpMessageConverter(){
        return new FeignjsonHttpMessageConverter();
    }


}
