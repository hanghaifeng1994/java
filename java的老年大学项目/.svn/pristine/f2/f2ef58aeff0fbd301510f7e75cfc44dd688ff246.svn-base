package com.learnyeai.learnai.mybatis.plugins;

import org.apache.ibatis.type.ObjectTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * 通用ibatis类型自动转换基类
 * @author lc3@yitong.com.cn
 */
public abstract class AbstractObjectTypeHandler extends ObjectTypeHandler implements TypeHandler<Object> {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    private final Map<String, String> typeHandler = getTypeHandler();

    protected abstract Map<String, String> getTypeHandler();

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return converType(super.getNullableResult(rs, columnName));
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return converType(super.getNullableResult(rs, columnIndex));
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return converType(super.getNullableResult(cs, columnIndex));
    }

    protected Object converType(Object obj) {
        if(null == obj) {
            return null;
        }
        if(null != typeHandler) {
            final Class<?> clazz = obj.getClass();
            final String name = clazz.getName();
            final String handler = typeHandler.get(name);
            if(null != handler) {
                try {
                    final Method method = clazz.getMethod(handler);
                    return method.invoke(obj, new Object[0]);
                } catch (Exception e) {
                    logger.error("ibatis自动转换类型失败", e);
                }
            }
        }
        return obj;
    }
}
