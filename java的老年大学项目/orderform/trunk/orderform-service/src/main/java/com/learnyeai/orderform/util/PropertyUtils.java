package com.learnyeai.orderform.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertyUtils {
	private static final Logger logger = LoggerFactory.getLogger(PropertyUtils.class);
	private static Map<String, Properties> propertiesMap = new HashMap<String, Properties>();

	/**
	 * pointed property name
	 * 
	 * @param propertyName
	 * @param name
	 * @return 指定配置文件中key对应的值，无返回null
	 */
	public static String getPropertyWithConfigName(String fileName, String name) {
		Properties properties = propertiesMap.get(fileName);
		if (properties == null) {
			loadPropertiesBelowClasses(fileName);
			properties = propertiesMap.get(fileName);
		}

		if (properties == null) {
			logger.error("无指定的配置文件:" + fileName + "！");
			return null;
		}

		return properties.getProperty(name);
	}

	/**
	 * 
	 * @param fileName
	 *            配置文件名
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public static String getPropertyWithConfigName(String fileName, String name, String defaultValue) {
		String value = getPropertyWithConfigName(fileName, name);
		if (value == null) {
			value = defaultValue;
		}
		return value;
	}

	private synchronized static void loadPropertiesBelowClasses(String filename) {
		try {
			Properties properties = PropertiesLoaderUtils.loadAllProperties(filename);
			propertiesMap.put(filename, properties);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}