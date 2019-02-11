package com.learnyeai.servicebase.convert;

import com.learnyeai.core.support.ApiResult;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.core.exception.BusinessException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * 只修改read
 * json转换，设置编码
 * 写的时候定义日期格式
 */
public class FeignjsonHttpMessageConverter extends FastJsonHttpMessageConverter {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public final static Charset UTF8 = Charset.forName("UTF-8");

    private Charset charset = UTF8;


    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return this.readType(this.getType(clazz, (Class)null), inputMessage);
    }

    @Override
    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return this.readType(this.getType(type, contextClass), inputMessage);
    }

    private Object readType(Type type, HttpInputMessage inputMessage) throws IOException {
        try {
            InputStream ex = inputMessage.getBody();
            if(!inputMessage.getHeaders().containsKey("weye-service-result")){

                return JSON.parseObject(ex, charset, type);
            }

            // 只要head中存在xxx，就认为是包装类型

            // 把结果放到线程上下文中
            // 读取数据到map，map转类型
            JSONObject rstJsonObj = JSON.parseObject(ex, charset, JSONObject.class);
            String code = rstJsonObj.getString("code");
            String msg = rstJsonObj.getString("message");
            ApiResult apiResult = new ApiResult(code, msg);
            apiResult.setData(rstJsonObj);
            ThreadContext.put(ThreadContextUtil.API_SERVICE_RESULT_KEY, apiResult);
            if(!apiResult.isSuccess()){ // 错误，异常
                throw new BusinessException(code, msg);
            }

            Object result = rstJsonObj.getObject("data", type);
//            apiResult.setData(result);
            return result;
        } catch (JSONException var4) {
            throw new HttpMessageNotReadableException("JSON parse error: " + var4.getMessage(), var4);
        } catch (IOException var5) {
            throw new HttpMessageNotReadableException("I/O error while reading input message", var5);
        }
    }
}