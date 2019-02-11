package com.learnyeai.lucene.utils;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Sql类型解析工具类
 * @author 李超（lc3）
 */
public class JavaTypeResolverUtil {

    private static final Map<JDBCType, Class> typeMap = new HashMap<JDBCType, Class>();

    static {
        typeMap.put(JDBCType.ARRAY, Object.class);
        typeMap.put(JDBCType.BIGINT, Long.class);
        typeMap.put(JDBCType.BIT, Boolean.class);
        typeMap.put(JDBCType.BOOLEAN, Boolean.class);
        typeMap.put(JDBCType.CHAR, String.class);
        typeMap.put(JDBCType.CLOB, String.class);
        typeMap.put(JDBCType.DATE, Date.class);
        typeMap.put(JDBCType.DOUBLE, Double.class);
        typeMap.put(JDBCType.FLOAT, Double.class);
        typeMap.put(JDBCType.INTEGER, Integer.class);
        typeMap.put(JDBCType.LONGVARCHAR, String.class);
        typeMap.put(JDBCType.NULL, Object.class);
        typeMap.put(JDBCType.OTHER, Object.class);
        typeMap.put(JDBCType.REAL, Float.class);
        typeMap.put(JDBCType.SMALLINT, Short.class);
        typeMap.put(JDBCType.STRUCT, Object.class);
        typeMap.put(JDBCType.TIME, Date.class);
        typeMap.put(JDBCType.TIMESTAMP, Date.class);
        typeMap.put(JDBCType.TINYINT, Byte.class);
        typeMap.put(JDBCType.VARCHAR, String.class);
    }

    /**
     * 计算JDBC对应的Java类型
     */
    public static Class calculateJavaType(int type, int scale, int length) {
        Class javaType = typeMap.get(JDBCType.valueOf(type));
        if (null == javaType) {
            switch (type) {
                case Types.DECIMAL:
                case Types.NUMERIC:
                    if (scale > 0) {
                        javaType = BigDecimal.class;
                    } else if (length > 4) {
                        javaType = Long.class;
                    } else {
                        javaType = Integer.class;
                    }
                    break;
                default:
                    javaType = null;
                    break;
            }
        }
        return null == javaType ? Object.class : javaType;
    }
}
