package com.learnyeai.common.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.cache.interceptor.CacheOperationInvoker;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Created by zpz on 2018/8/10.
 */
public class MyCacheInterceptor extends CacheInterceptor {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPut(Cache cache, Object key, Object result) {
        // 序列化时已经做了json序列化
        String jsonResult = "";
        if(null != result) {
//            jsonResult = JSON.toJSONString(result).replace("\"", "'");
            jsonResult = JSON.toJSONString(result, SerializerFeature.UseSingleQuotes);
        }

        super.doPut(cache, key, jsonResult);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Method method = invocation.getMethod();

        MyCacheOperationInvoker aopAllianceInvoker = new MyCacheOperationInvoker(invocation);

        try {
            Object result = execute(aopAllianceInvoker, invocation.getThis(), method,
                    invocation.getArguments());
            if(!aopAllianceInvoker.isDoInvoke()) {
                Type resultType = method.getGenericReturnType();
                if (result != null && result instanceof String) {
                    return JSON.parseObject((String) result, resultType);
                }else if(result instanceof JSONObject){
                    return ((JSONObject)result).toJavaObject(resultType);
                }
            }
            return result;
        } catch (CacheOperationInvoker.ThrowableWrapper th) {
            throw th.getOriginal();
        }

    }

    class MyCacheOperationInvoker implements CacheOperationInvoker {

        private MethodInvocation invocation;

        private boolean doInvoke = false;

        public MyCacheOperationInvoker(MethodInvocation invocation) {
            this.invocation = invocation;
        }

        @Override
        public Object invoke() {
            try {
                doInvoke = true;
                Object o = invocation.proceed();
                return invocation.proceed();
            } catch (Throwable ex) {
                throw new ThrowableWrapper(ex);
            }
        }

        public boolean isDoInvoke() {
            return doInvoke;
        }

    }
}
