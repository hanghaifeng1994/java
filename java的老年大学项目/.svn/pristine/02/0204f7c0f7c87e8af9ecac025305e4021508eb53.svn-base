package cn.com.weyeyun.commoncert.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springside.modules.orm.Page;

public class BeanUtil {

	/**
	 * 拷贝集合中的数据，转换成目标类型的集合
	 * @param dest 目标集合
	 * @param orig  原集合
	 * @param destModelClass 目标类型
     * @return
     */
	public static Object copyCollectionProperties(Object dest, Object orig,
			Class destModelClass) {
		if (dest == null || orig == null) {
			return null;
		}
		try {
			if (orig instanceof Map && dest instanceof Map) {
				Map<Object, Object> destMap = (Map) dest;
				Map<Object, Object> origMap = (Map) orig;
				for (Map.Entry entry : origMap.entrySet()) {
					Object obj = destModelClass.newInstance();
					destMap.put(entry.getKey(), copyProperties(obj, entry
							.getValue()));
				}
			} else if (orig instanceof List && dest instanceof List) {
				List destList = (List) dest;
				List origList = (List) orig;
				for (Object obj : origList) {
					destList.add(copyProperties(destModelClass.newInstance(),
							obj));
				}
			} else if (orig.getClass().isArray() && dest.getClass().isArray()) {
				Object[] destArray = (Object[]) dest;
				Object[] origArray = (Object[]) orig;
				if (destArray.length < origArray.length) {
					throw new Exception("目标数组长度不够");
				}
				for (int i = 0; i < origArray.length; i++) {
					destArray[i] = copyProperties(destModelClass.newInstance(),
							origArray[i]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dest;
	}

	@SuppressWarnings( { "unchecked" })
	public static Page copyPage(Page desc, Page orig, Class destModelClass) {
		if (orig == null) {
			return null;
		}
		try {
			desc = orig;
			List list = orig.getResult();
			List listDTO = new ArrayList();
			listDTO = (List) BeanUtil.copyCollectionProperties(listDTO, list,
					destModelClass);
			desc.setResult(listDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return desc;
	}

	/*
	 * 实现不同model中属性相同的copy，且可以配置不同属性值的映射
	 */

	public static Object copyProperties(Object dest, Object orig) {
		if (dest == null || orig == null) {
			return null;
		}
		try {

			// 取得dest对象中方法的集合
			Method[] argsDestMtd = dest.getClass().getMethods();
			// dest中方法名称
			String destMtdName;
			// 方法对应的对象名称
			String destFieldName;
			// 遍历dest对象中的方法
			for (Method destMtd : argsDestMtd) {
				destMtdName = destMtd.getName(); // 获得方法名称
				if (destMtdName.startsWith("set")) { // 判断方法是否为setter方法
					destFieldName = destMtdName.replace("set", ""); // 取得变量名称（即去掉setter方法中的“set”）
					String getMethodName = "get" + destFieldName;
					Object value = null;
					Method origGetMethod = null;
					Method destGetMethod = null;
					try {
						try {
							destGetMethod = dest.getClass().getMethod(
									getMethodName);
						} catch (NoSuchMethodException e) {
							getMethodName = "is" + destFieldName;
							destGetMethod = dest.getClass().getMethod(
									getMethodName);
						}
						Mapper mapper = destGetMethod
								.getAnnotation(Mapper.class);
						if (destGetMethod != null && mapper != null
								&& !"".equals(mapper.name())
								&& !"".equals(mapper.type())) {
							if (orig.getClass().getName()
									.indexOf(mapper.type()) != -1) {
								origGetMethod = orig.getClass().getMethod(
										"get"
												+ mapper.name().substring(0, 1)
														.toUpperCase()
												+ mapper.name().substring(1));
							}
						} else if (destGetMethod != null && mapper != null
								&& !"".equals(mapper.type())) {
							if (orig.getClass().getName()
									.indexOf(mapper.type()) != -1) {
								origGetMethod = orig.getClass().getMethod(
										getMethodName);
							}

						} else if (destGetMethod != null && mapper != null
								&& !"".equals(mapper.name())) {
							origGetMethod = orig.getClass().getMethod(
									"get"
											+ mapper.name().substring(0, 1)
													.toUpperCase()
											+ mapper.name().substring(1));

						} else if (destGetMethod != null) {
							origGetMethod = orig.getClass().getMethod(
									getMethodName);
						} else {
							continue;
						}

						if (origGetMethod != null) {
							value = origGetMethod.invoke(orig);
							if (BeanAssistor.getType(value) < BeanAssistor.LIST) {
								destMtd.invoke(dest, value);
							}
						}

					} catch (NoSuchMethodException e) {
					} catch (Exception e) {
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dest;
	}

}