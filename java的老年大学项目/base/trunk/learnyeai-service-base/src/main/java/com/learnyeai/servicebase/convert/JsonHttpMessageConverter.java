package com.learnyeai.servicebase.convert;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.support.IBusinessContext;
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
 * 读取的json存放到ctx 的requestEntry
 */
public class JsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public final static Charset UTF8 = Charset.forName("UTF-8");

    private Charset charset = UTF8;

    private SerializerFeature[] features = new SerializerFeature[0];

    /**
     * 请求参数前缀
     */
    private final static String REQ_PREFIX = "{";

    /**
     * 添加支持类型，支持类型与supports方法判断是否处理
     */
    public JsonHttpMessageConverter() {
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
        //总线初始化
        IBusinessContext ctx = ThreadContextUtil.getCtx();

        try {
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

            // 借用
            ctx.setRequestEntry(new String(bytes1, charset));
//            ctx.setParam("requestData", FileUtil.readFileAsString(request.getInputStream()));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return ctx;
    }

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        OutputStream out = outputMessage.getBody();
        String text = null;
        if(obj instanceof String)
            text = obj.toString();
        else
            text = JSON.toJSONString(obj, features);
        byte[] bytes = text.getBytes(charset);
        out.write(bytes);
    }

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return super.canRead(clazz, mediaType);
    }
}