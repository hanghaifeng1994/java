package com.learnyeai.learnai.support;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.support.ApiResult;
import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.core.support.MyPage;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.core.exception.BusinessException;
import com.learnyeai.tools.common.BeanMapUtils;
import feign.codec.DecodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ResolvableType;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by zpz on 2018/4/21.
 */
public abstract class BaseClientService<T> {
    private Class entityClass;
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public abstract BaseFeignClient<T> getFeignClient();
    public abstract Object getId(Map params);

    public Class getVoClass() {
        if(this.entityClass != null) {
            return this.entityClass;
        } else {
            ResolvableType resolvableType = ResolvableType.forClass(this.getClass());
            this.entityClass = resolvableType.as(BaseClientService.class).getGenerics()[0].resolve();
            return this.entityClass;
        }
    }
    public T convert2Bean(Map params){
        try {
            return (T) BeanMapUtils.convertMap(getVoClass(), params);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ApiResult getBusiExceptionResult(Exception e){
        ApiResult apiResult = null;
        if(e instanceof DecodeException && e.getCause() instanceof BusinessException){
            apiResult = (ApiResult) ThreadContext.get(ThreadContextUtil.API_SERVICE_RESULT_KEY);
        }

        return apiResult;
    }
    public MyPage listPage(IBusinessContext ctx) {
//        T t = convert2Bean(ctx.getParamMap());

        return getFeignClient().listPage(ctx.getParamMap());
    }
    public List<T> getList(IBusinessContext ctx) {
//        T t = convert2Bean(ctx.getParamMap());
        return getFeignClient().getList(ctx.getParamMap());
    }
    public T queryById(IBusinessContext ctx) {
        Object o = getId(ctx.getParamMap());
        return getFeignClient().view(o);
    }
    public T queryById(Object id) {
        return getFeignClient().view(id);
    }

    public int delete(IBusinessContext ctx) {
        Object o = getId(ctx.getParamMap());
        return getFeignClient().delete(o);
    }
    public int delete(Object id) {
        return getFeignClient().delete(id);
    }

    public String save(IBusinessContext ctx) {
//        T t = convert2Bean(ctx.getParamMap());
        return getFeignClient().save(ctx.getParamMap());
    }
    public String save(T t) {
        return getFeignClient().save(t);
    }
}
