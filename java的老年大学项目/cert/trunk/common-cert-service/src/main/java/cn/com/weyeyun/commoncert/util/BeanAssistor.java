package cn.com.weyeyun.commoncert.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class BeanAssistor {
	public static int NULL = 0;
	public static int PRIMITIVE = 1;//基本数据类型
	public static int OBJECT = 2;
	public static int ARRAY = 3;
	public static int FINAL = 4;//final类型
    public static int DATE = 5;
	public static int LIST = 30;
	public static int MAP = 31;
	public static int SET = 32;
	public static int OTHER = 99;


	@SuppressWarnings("unchecked")
	public static int getType(Object obj)
	{

		if(obj == null)
		{
			return NULL;
		}
		Class clazz = null;
		if(obj instanceof Class)
		{
			clazz = (Class) obj;
		}
		else
		{
			clazz = obj.getClass();
		}
		if(clazz.isPrimitive())
		{
			return PRIMITIVE;
		}
		else if("java.lang.Object".equals(clazz.getName()))
		{
			return OBJECT;
		}
		if(clazz.isArray())
		{
			return ARRAY;
		}
        if(java.util.Date.class.isAssignableFrom(clazz))
        {
            return DATE;
        }
		else if( Modifier.isFinal(clazz.getModifiers()))
		{
			return FINAL;
		}
		if(List.class.isAssignableFrom(clazz))
		{
			return LIST;
		}
		if(Map.class.isAssignableFrom(clazz))
		{
			return MAP;
		}
		if(Set.class.isAssignableFrom(clazz))
		{
			return SET;
		}

		return OTHER;
	}

	@SuppressWarnings("unchecked")
	public static List<Object> copyCollection(List dest, List orig, Class elementType){
		for(Object object : orig)
		{
			try {
				dest.add(BeanUtil.copyProperties(elementType.newInstance(), object));
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return dest;
	}

	@SuppressWarnings("unchecked")
	public static Object copyCollection(Map dest, Map orig, Class elementType) {
		Map<Object, Object> destMap = (Map)dest;
		Map<Object, Object> origMap = (Map)orig;
		for(Map.Entry entry : origMap.entrySet())
		{
			try {
				destMap.put(entry.getKey(), BeanUtil.copyProperties(elementType.newInstance(), entry.getValue()));
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return destMap;
	}

	@SuppressWarnings("unchecked")
	public static Object copyArray(Object[] dest, Object[] orig, Class elementType) {

		List destList = new ArrayList();
		List origList = new ArrayList();
		for(Object obj : orig)
		{
			origList.add(obj);
		}
		List<Object> list = copyCollection(destList, origList, elementType);
		Object dests = Array.newInstance(elementType, list.size());//动态定义数组，比较繁琐
		for(int index =0; index < list.size(); index++)
		{
			Array.set(dests, index, list.get(index));
		}
		return dests;
	}

	public static String getOrigMethodName(Method method, Mapper mapper, String origClassName) {
		String destMethodName = method.getName();
		String origMethodName = null;
		if(method !=null && mapper !=null && !"".equals(mapper.name()) && !"".equals(mapper.type()))
		{
			if(origClassName.indexOf(mapper.type()) != -1)
			{
				origMethodName = "get" + mapper.name().substring(0, 1).toUpperCase() + mapper.name().substring(1);
			}
		}
		else if(method !=null && mapper !=null && !"".equals(mapper.type()))
		{
			if(origClassName.indexOf(mapper.type()) != -1)
			{
				origMethodName = destMethodName;
			}

		}
		else if(method !=null && mapper !=null && !"".equals(mapper.name()))
		{
			origMethodName = "get" + mapper.name().substring(0, 1).toUpperCase() + mapper.name().substring(1);

		}
		else if(method !=null)
		{
			origMethodName = destMethodName;
		}
		return origMethodName;
	}

	/**
	 * java反射bean的set方法    
	 * @param objectClass
	 * @param fieldName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Method getSetMethod(Class objectClass, String fieldName) {

		try {
			Class[] parameterTypes = new Class[1];
			Field field = getField(objectClass, fieldName);
			if(field == null)return null;
			parameterTypes[0] = field.getType();
			StringBuffer sb = new StringBuffer();
			sb.append("set");
			sb.append(fieldName.substring(0, 1).toUpperCase());
			sb.append(fieldName.substring(1));
			Method method = objectClass.getMethod(sb.toString(), parameterTypes);
			return method;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * java反射bean的属性
	 * @param objectClass
	 * @param fieldName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Field getField(Class objectClass, String fieldName) {
		for(; objectClass != Object.class; objectClass = objectClass.getSuperclass())
		{
			try {
				Field field = objectClass.getDeclaredField(fieldName);
				return field;
			}catch (NoSuchFieldException e) {
			}
		}
		return null;
	}
	/**
	 * 执行set方法    
	 *
	 * @param o 执行对象    
	 * @param fieldName 属性    
	 * @param value 值    
	 */
	public static void invokeSet(Object o, String fieldName, Object value) {
		Object[] params = null;
		Method method = getSetMethod(o.getClass().getSuperclass(), fieldName);
		if(method == null)return;
		Class[] parameterTypes = method.getParameterTypes();
		if(parameterTypes != null && parameterTypes.length > 0 && value == null)
		{
			int paramType = getType(parameterTypes[0]);
			if(boolean.class == parameterTypes[0])
			{
				params = new Object[] { false };
			}else if(paramType == 1)
			{
				params = new Object[] { 0 };
			}
		}
		if(params == null)
		{
			params = new Object[] { value };
		}
		try {
			if(method != null)
			{
				method.invoke(o, params);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
