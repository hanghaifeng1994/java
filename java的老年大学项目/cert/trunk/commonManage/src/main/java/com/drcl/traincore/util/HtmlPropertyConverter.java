package com.drcl.traincore.util;

import org.compass.core.converter.ConversionException;
import org.compass.core.converter.basic.AbstractBasicConverter;
import org.compass.core.mapping.ResourcePropertyMapping;
import org.compass.core.marshall.MarshallingContext;

public class HtmlPropertyConverter extends AbstractBasicConverter<String> {

	@Override
	protected String doFromString(String str, ResourcePropertyMapping resourcePropertyMapping,
			MarshallingContext context) throws ConversionException {
		return str;
	}

	@Override
	protected org.compass.core.Property createProperty(String value, ResourcePropertyMapping resourcePropertyMapping,
			MarshallingContext context) {
		// 过滤html标签
		value = HtmlStringUtil.removeHTML(value);
		return super.createProperty(value, resourcePropertyMapping, context);
	}

}
