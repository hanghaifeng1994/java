package com.learnyeai.core.converter;

import com.learnyeai.tools.common.BeanMapUtils;
import com.learnyeai.tools.common.TypeHelper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * 支持对象的FormHttpMessageConverter
 * @author zpz
 */
public class ObjFormHttpMessageConverter implements HttpMessageConverter<Object> {

	protected Utf8FormHttpMessageConverter formHttpMessageConverter;

	public ObjFormHttpMessageConverter() {
		this.formHttpMessageConverter = new Utf8AllEncompassingFormHttpMessageConverter();
	}

	/**
	 * Set the list of {@link MediaType} objects supported by this converter.
	 */
	public void setSupportedMediaTypes(List<MediaType> supportedMediaTypes) {
		this.formHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
	}

	@Override
	public List<MediaType> getSupportedMediaTypes() {
		return formHttpMessageConverter.getSupportedMediaTypes();
	}

	/**
	 * Set the message body converters to use. These converters are used to
	 * convert objects to MIME parts.
	 */
	public void setPartConverters(List<HttpMessageConverter<?>> partConverters) {
		this.formHttpMessageConverter.setPartConverters(partConverters);
	}

	/**
	 * Add a message body converter. Such a converter is used to convert objects
	 * to MIME parts.
	 */
	public void addPartConverter(HttpMessageConverter<?> partConverter) {
		this.formHttpMessageConverter.addPartConverter(partConverter);
	}

	public void setCharset(Charset charset) {
		this.formHttpMessageConverter.setCharset(charset);
	}

	@Override
	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		if (TypeHelper.isPrimitiveClass(clazz)) {
			return false;
		}

		if (mediaType == null) {
			return true;
		}
		for (MediaType supportedMediaType : getSupportedMediaTypes()) {
			// We can't read multipart....
			if (!supportedMediaType.equals(MediaType.MULTIPART_FORM_DATA) && supportedMediaType.includes(mediaType)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		if (TypeHelper.isPrimitiveClass(clazz)) {
			return false;
		}
		if (mediaType == null || MediaType.ALL.equals(mediaType)) {
			return true;
		}
		for (MediaType supportedMediaType : getSupportedMediaTypes()) {
			if (supportedMediaType.isCompatibleWith(mediaType)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object read(Class<? extends Object> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		MultiValueMap<String, String> data = formHttpMessageConverter.read(null, inputMessage);
		// map  转成对象
		try {
			return BeanMapUtils.convertMap(clazz, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void write(Object obj, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		Map<String, Object> map = null;
		try {
			map = BeanMapUtils.convertBean(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		MultiValueMap<String, Object> multiMap = null;
		if (map == null)
			return;

		multiMap = new LinkedMultiValueMap<>();
		for (Map.Entry<String, ?> entry : map.entrySet()) {
			if(entry.getValue() == null)
				continue;
			multiMap.add(entry.getKey(), entry.getValue());
		}

		formHttpMessageConverter.write(multiMap, contentType, outputMessage);
	}

}
