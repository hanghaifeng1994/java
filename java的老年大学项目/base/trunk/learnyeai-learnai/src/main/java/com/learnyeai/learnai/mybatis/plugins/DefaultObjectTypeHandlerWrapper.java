package com.learnyeai.learnai.mybatis.plugins;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.util.Assert;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 默认的ObjectTypeHandler实现类，会自动识别数据库，并加载对应的ObjectTypeHandler
 * 导致不能识别数据字段类型，暂时不用，只是想把oracle.sql.TIMESTAMP，类型转换成timestamp // 张配忠 2016-11-15
 * @author lc3@yitong.com.cn
 */
public class DefaultObjectTypeHandlerWrapper implements TypeHandler<Object> {

    private TypeHandler<Object> typeHandler;

    public DefaultObjectTypeHandlerWrapper() {
        typeHandler = new OracleObjectTypeHandler();
        Assert.notNull(typeHandler, "typeHandler不能为空");
    }

    public DefaultObjectTypeHandlerWrapper(TypeHandler<Object> typeHandler) {
        this.typeHandler = typeHandler;
        Assert.notNull(typeHandler, "typeHandler不能为空");
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        typeHandler.setParameter(ps, i, parameter, jdbcType);
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        return typeHandler.getResult(rs, columnName);
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        return typeHandler.getResult(rs, columnIndex);
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return typeHandler.getResult(cs, columnIndex);
    }
}
