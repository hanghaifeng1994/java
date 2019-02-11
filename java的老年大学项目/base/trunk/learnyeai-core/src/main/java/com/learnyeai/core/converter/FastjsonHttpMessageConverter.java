package com.learnyeai.core.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * json转换，设置编码
 * 写的时候定义日期格式
 */
public class FastjsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public final static Charset UTF8 = Charset.forName("UTF-8");

    protected Charset charset = UTF8;

    private SerializerFeature[] features = new SerializerFeature[0];


    /**
     * 添加支持类型，支持类型与supports方法判断是否处理
     */
    public FastjsonHttpMessageConverter() {
        super(new MediaType("application", "json", UTF8), new MediaType("application", "*+json", UTF8));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public SerializerFeature[] getFeatures() {
        return features;
    }

    public void setFeatures(SerializerFeature... features) {
        this.features = features;
    }


    @SuppressWarnings("unchecked")
    @Override
    protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream in = inputMessage.getBody();
        byte[] buf = new byte[1024];

        while(true) {
            int len = in.read(buf);
            if(len == -1) {
                break;
            }

            if(len > 0) {
                baos.write(buf, 0, len);
            }
        }

        byte[] bytes1 = baos.toByteArray();

        /*反序列化能够自动识别如下日期格式：

        ISO-8601日期格式
        yyyy-MM-dd
        yyyy-MM-dd HH:mm:ss
        yyyy-MM-dd HH:mm:ss.SSS
                毫秒数字
        毫秒数字字符串
                .NET JSON日期格式
        new Date(1982932381111)*/
        String ss = new String(bytes1, charset);
        Object o = JSON.parseObject(ss, clazz);
//        return JSON.parseObject(bytes1, 0, bytes1.length, this.charset.newDecoder(), clazz, new Feature[0]);
        return o;
    }

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if(null == obj)
            return;

//        String jstr = JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss");
//        String ste =  JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat);
//        String json = JSONObject.toJSONString(obj,jsonmapping,SerializerFeature.WriteDateUseDateFormat);


        // 缺省景象下，fastjson将Date类型序列化为long，这个使得序列化和反序列化的过程不会导致时区题目
        OutputStream out = outputMessage.getBody();
//        String text = JSON.toJSONString(obj, features);
        String text = JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat);
        byte[] bytes = text.getBytes(charset);
        out.write(bytes);
    }
}