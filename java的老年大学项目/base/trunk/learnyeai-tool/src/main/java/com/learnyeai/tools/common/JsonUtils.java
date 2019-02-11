package com.learnyeai.tools.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Json转换工具
 * @author 	lc3
 */
public class JsonUtils {
	protected final static ObjectMapper mapper = new ObjectMapper();
	private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    static {
//		mapper.configure(SerializationFeature.INDENT_OUTPUT, true); //格式化
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);	// 支持单引号
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);	// 识别控制字符
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);	// 忽略未知属性
		mapper.setDateFormat(new MyDateFormat());
	}

	/**
	 * object对象转换成json
	 */
	public static String objectToJson(Object obj) {
		if(null == obj) {
			return "";
		}
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			if(logger.isWarnEnabled()) {
				logger.warn("转换Json失败，转换对象类型为：" + obj.getClass().getName());
			}
		}
		return jsonString;
	}

	/**
	 * Json转Map
	 * @param json
	 * @return
	 */
	public static Map<Object, Object> jsonToMap(String json) {
		if(!StringUtils.isNotEmpty(json)) {
			return new HashMap<Object, Object>(0);
		}
		try {
			//noinspection unchecked
			return mapper.readValue(json, Map.class);
		} catch (IOException e) {
			throw new RuntimeException("Json转Map失败", e);
		}
	}

	/**
	 * Json转Object
	 * @param json json串
	 * @param clazz 返回类型
	 * @param <E> VO类型
	 * @return
	 */
	public static <E> E jsonToObject(String json, Class<E> clazz) {
		if(!StringUtils.isNotEmpty(json)) {
			return null;
		}
		try {
			//noinspection unchecked
			return mapper.readValue(json, clazz);
		} catch (IOException e) {
			throw new RuntimeException("Json转Map失败", e);
		}
	}

	/**
	 * Json转List
	 * @param json
	 * @param <E>
	 * @return
	 */
	public static <E> List<E> jsonToList(String json) {
		if(!StringUtils.isNotEmpty(json)) {
			return new ArrayList<E>(0);
		}
		try {
			//noinspection unchecked
			return mapper.readValue(json, List.class);
		} catch (IOException e) {
			throw new RuntimeException("Json转List失败", e);
		}
	}

	/**
	 * Json转List
	 * @param json
	 * @param <E>
	 * @return
	 */
	public static <E> List<E> jsonToList(String json, Class<E> clazz) {
		if(!StringUtils.isNotEmpty(json)) {
			return new ArrayList<E>(0);
		}
		try {
			CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
			//noinspection unchecked
			return mapper.readValue(json, type);
		} catch (IOException e) {
			throw new RuntimeException("Json转List失败", e);
		}
	}
}
