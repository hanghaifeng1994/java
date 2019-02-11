package com.learnyeai.tools.common;

import org.apache.commons.beanutils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zpz on 2016/4/10.
 */
public class DateConnverter implements Converter {
    private static final Logger logger = LoggerFactory.getLogger(DateConnverter.class);

    public DateConnverter() {
    }

    public Object convert(Class clazz, Object value) {
        if(value == null) {
            return null;
        } else {
            String dateStr = value.toString();
            dateStr = dateStr.replace("T", " ");

            try {
                return DateHelper.parseDate(dateStr);
            } catch (Exception var5) {
                logger.error("将值[" + value + "]转换为日期型错误", var5);
                return null;
            }
        }
    }
}

