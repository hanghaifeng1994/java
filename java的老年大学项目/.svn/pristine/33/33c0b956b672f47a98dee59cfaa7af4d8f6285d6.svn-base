package com.learnyeai.tools.common;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zpz on 2018/8/24.
 */
public class MyDateFormat extends SimpleDateFormat {

    @Override
    public Date parse(String source, ParsePosition pos) {
        pos.setIndex(1);
        return DateHelper.parseDate(source);
    }
}
