package com.drcl.traincore.util;

import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bean、map相互转换
 */
public class BeanMapUtils {
    /**
     * 将一个 Map 对象转化为一个 JavaBean
     * @param type 要转化的类型
     * @param map 包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     * @throws IntrospectionException
     *             如果分析类属性失败
     * @throws IllegalAccessException
     *             如果实例化 JavaBean 失败
     * @throws InstantiationException
     *             如果实例化 JavaBean 失败
     * @throws InvocationTargetException
     *             如果调用属性的 setter 方法失败
     */
    public static Object convertMap(Class type, Map map)
            throws IntrospectionException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
        Object obj = type.newInstance(); // 创建 JavaBean 对象

        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        Method method = null;
        String jsonStr = null;
        for (int i = 0; i< propertyDescriptors.length; i++) {
            jsonStr = null;
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();

            if (map.containsKey(propertyName)) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                method = descriptor.getWriteMethod();
                if(null != method) {
                    Object value = map.get(propertyName);
                    if(null == value || "" == value || "null" == value) {
                        continue;
                    }
                    Class pararmType = method.getParameterTypes()[0];
                    Object param = null;
                    try{
                        if(value instanceof List) {
                            List<Object> paramList = (List)value;
                            String tempType = method.toGenericString().split("<")[1].split(">")[0];
                            Class typeClass = Class.forName(tempType);
                            List<Object> list = new ArrayList<Object>();
                            for(Object paramObj : paramList) {
                                String tempJsonStr = JsonUtil.objectToJson(paramObj);
                                Object jj = JsonUtil.mapper.readValue(tempJsonStr, typeClass);
                                list.add(jj);
                            }
                            method.invoke(obj, list);
                            continue;
                        }else {
                            jsonStr = JsonUtil.objectToJson(value);
                        }
                        param = JsonUtil.mapper.readValue(jsonStr, pararmType);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    method.invoke(obj, param);
                }
            }
        }
        return obj;
    }

    /**
     * 将一个 JavaBean 对象转化为一个  Map
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static Map<String, Object> convertBean(Object bean)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Map<String, Object> params = new HashMap<String, Object>(0);
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(bean);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    params.put(name, propertyUtilsBean.getNestedProperty(bean, name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }
}
