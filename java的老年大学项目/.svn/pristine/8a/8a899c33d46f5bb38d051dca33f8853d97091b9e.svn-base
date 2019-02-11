package com.learnyeai.servicebase.convert;

import com.learnyeai.core.converter.FastjsonHttpMessageConverter;
import com.learnyeai.core.support.ApiResult;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.tools.common.JsonMapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * json转换，设置编码
 * 写的时候定义日期格式
 */
public class ServicejsonHttpMessageConverter extends FastjsonHttpMessageConverter {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public ServicejsonHttpMessageConverter() {
        super();
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
        IBusinessContext ctx = ThreadContextUtil.getCtx();
        Map<Object, Object> map = JsonMapper.jsonToMap(ss);
        ctx.getParamMap().putAll(map);
//        return JSON.parseObject(bytes1, 0, bytes1.length, this.charset.newDecoder(), clazz, new Feature[0]);
        return o;
    }
    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        // 判断是否是service、还是interface

        ApiResult result = null;
        if(obj instanceof ApiResult){
            result = (ApiResult)obj;
        }else {
            result = new ApiResult("1", "success");
            result.setData(obj);
        }
        List<String> val = new ArrayList();
        val.add("1");
        outputMessage.getHeaders().put("weye-service-result", val);

        OutputStream out = outputMessage.getBody();
        String text = JSON.toJSONString(result, SerializerFeature.WriteDateUseDateFormat);
        byte[] bytes = text.getBytes(charset);
        out.write(bytes);
    }
}