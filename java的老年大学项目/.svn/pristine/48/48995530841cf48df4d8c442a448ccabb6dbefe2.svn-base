package com.learnyeai.tools.common;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zpz on 2016/4/10.
 */
public class TypeHelper {
    protected static final Logger logger = LoggerFactory.getLogger(TypeHelper.class);

    public TypeHelper() {
    }

    public static String toString(Object s, String defaultValue) {
        if(s == null)
            return defaultValue;

        if(!StringUtils.isEmpty(s.toString())) {
            if(s.getClass().isArray()) {
                try {
                    String e = "";
                    Object[] arr = (Object[])((Object[])s);

                    for(int i = 0; i < arr.length; ++i) {
                        e = e + arr[i];
                        if(i < arr.length - 1) {
                            e = e + ",";
                        }
                    }

                    return e;
                } catch (Exception var5) {
                    logger.error("类型转换错误，自动返回默认值：{0}", new Object[]{StringUtils.isEmpty(defaultValue)?"\"\"":defaultValue, var5});
                }
            }else if(s instanceof Date){
                return DateFormatUtils.format((Date)s, DateHelper.YYYYMMDDHHMMSS);
            }

            return s.toString();
        } else {
            return defaultValue;
        }
    }

    public static String toString(Object s) {
        return toString(s, "");
    }

    public static String toString(String[] arr) {
        return toString(arr, ",");
    }

    public static String toString(String[] arr, String sep) {
        if(arr == null) {
            return "";
        } else {
            String s = "";

            for(int i = 0; i < arr.length; ++i) {
                s = s + arr[i] + (i < arr.length - 1?sep:"");
            }

            return s;
        }
    }

    public static Long toLong(Object value, Long defaultValue) {
        try {
            return StringUtils.isEmpty(value)?defaultValue:Long.valueOf(toString(value));
        } catch (Exception var3) {
            logger.error("类型转换错误，自动返回默认值：{0}", new Object[]{defaultValue, var3});
            return defaultValue;
        }
    }

    public static Long toLong(Object value) {
        return toLong(value, (Long)null);
    }

    public static Double toDouble(Object value, Double defaultValue) {
        try {
            return StringUtils.isEmpty(value)?defaultValue:Double.valueOf(toString(value));
        } catch (Exception var3) {
            logger.error("类型转换错误，自动返回默认值：{0}", new Object[]{defaultValue, var3});
            return defaultValue;
        }
    }

    public static Double toDouble(Object value) {
        return toDouble(value, (Double)null);
    }

    public static Integer toInteger(Object value, Integer defaultValue) {
        try {
            return StringUtils.isEmpty(value)?defaultValue:Integer.valueOf(toString(value));
        } catch (Exception var3) {
            logger.error("类型转换错误，自动返回默认值：{0}", new Object[]{defaultValue, var3});
            return defaultValue;
        }
    }

    public static Integer toInteger(Object value) {
        return toInteger(value, (Integer)null);
    }

    public static Float toFloat(Object value, Float defaultValue) {
        try {
            return StringUtils.isEmpty(value)?defaultValue:Float.valueOf(toString(value));
        } catch (Exception var3) {
            logger.error("类型转换错误，自动返回默认值：{0}", new Object[]{defaultValue, var3});
            return defaultValue;
        }
    }

    public static Float toFloat(Object value) {
        return toFloat(value, (Float)null);
    }

    public static int toInt(Object value, int defaultValue) {
        return value instanceof Integer?((Integer)value).intValue():(value instanceof Long?((Long)value).intValue():toInteger(value + "", Integer.valueOf(defaultValue)).intValue());
    }

    public static int toInt(Object value) {
        return toInt(value, 0);
    }

    public static int toInt(Date date) {
        String s = DateFormatUtils.format(date, "yyyyMMdd");
        return toInt((Object)s);
    }

    public static Short toShort(Object value, Short defaultValue) {
        try {
            return StringUtils.isEmpty(value)?defaultValue:Short.valueOf(toString(value, "").split("\\.")[0]);
        } catch (Exception var3) {
            logger.error("类型转换错误，自动返回默认值：{0}", new Object[]{defaultValue, var3});
            return defaultValue;
        }
    }

    public static Short toShort(Object value) {
        return toShort(value, (Short)null);
    }

    public static Date toDate(String s, Date defaultValue) {
        try {
            return StringUtils.isEmpty(s)?defaultValue:DateHelper.parseDate(s);
        } catch (Exception var3) {
            logger.error("类型转换错误，自动返回默认值：{0}", new Object[]{defaultValue, var3});
            return defaultValue;
        }
    }

    public static Date toDate(String s) {
        return toDate(s, (Date)null);
    }

    public static java.sql.Date toSqlDate(String s, java.sql.Date defaultValue) {
        return (java.sql.Date)toDate(s, defaultValue);
    }

    public static java.sql.Date toSqlDate(String s) {
        return (java.sql.Date)toDate(s, (Date)null);
    }

    public static Map<String, String> toMap(Object obj) {
        try {
            return BeanHelper.UTILS.describe(obj);
        } catch (Exception var2) {
            logger.error("Object转换为Map错误", new Object[]{var2});
            return null;
        }
    }

    public static boolean isArray(Object value) {
        return value != null && value.getClass().isArray();
    }

    public static boolean isList(Object value) {
        return value instanceof List;
    }

    public static boolean isMap(Object value) {
        return value instanceof Map;
    }

    public static boolean isNumber(Object value) {
        if(value == null) {
            return false;
        } else if(value instanceof Number) {
            return true;
        } else if(value instanceof String) {
            try {
                Double.parseDouble((String)value);
                return true;
            } catch (NumberFormatException var2) {
                return false;
            }
        } else {
            return false;
        }
    }
    public static <T> T toType(Object o, Class<T> cz){
        if(o == null)
            return null;

        if(cz.getClass().isInstance(o))
            return (T)o;
        String csName = cz.getName();

        if(csName.equals(String.class.getName())){
            return (T)toString(o);
        }
        if(!isPrimitiveClass(cz)){
            return null;
        }

        if(cz.equals(Integer.class.getName())){
            Integer v = toInt(o);
            return (T)v;
        }else if(csName.equals(Float.class.getName())){
            Float v = toFloat(o);
            return (T)v;
        }else if(csName.equals(Double.class.getName())){
            Double v = toDouble(o);
            return (T)v;
        }else if(csName.equals(Long.class.getName())){
            Long v = toLong(o);
            return (T)v;
        }
        return null;

    }

    public static boolean isPrimitive(Object value) {
        return value == null || value instanceof Comparable;
    }
    public static boolean isPrimitiveClass(Class<?> clazz) {
        if(clazz == null)
            return true;
        try {
            Object o = clazz.newInstance();
            if(o instanceof Comparable)
                return true;
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}

