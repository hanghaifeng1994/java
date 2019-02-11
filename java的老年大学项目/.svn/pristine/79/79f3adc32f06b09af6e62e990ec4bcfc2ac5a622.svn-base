package com.learnyeai.learnai.net.netMsg.filter;

import com.learnyeai.learnai.net.IReportItemValParser;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import com.learnyeai.tools.common.DateHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zpz on 2018/5/15.
 */
public class ReportItemVal_DateParser implements IReportItemValParser {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private SimpleDateFormat defDateFormat = null;

    public ReportItemVal_DateParser() {
        defDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public ReportItemVal_DateParser(String dateFormat) {
        defDateFormat = new SimpleDateFormat(dateFormat);
    }

    @Override
    public String parse(Object val, MBTransItem item) {
        if(val == null)
            return null;
        Date date = null;
        if(val instanceof java.util.Date){
            date = (Date)val;
        }else if("oracle.sql.TIMESTAMP".equals(val.getClass().getName())){
            date = getOracleTimestamp(val);
        } else if(val instanceof String) {
            try{
                date = DateHelper.parseDate(val.toString());
            }catch (Exception e){
                logger.error("日期格式有误");
            }
        }else if(val instanceof Long){
            date = new Date((Long)val);
        }

        if(null == date){
            return null;
        }

        SimpleDateFormat sdf = defDateFormat;
        String dateFomat = item.getDateFormat();
        if(null != dateFomat){
            if(ResponseValParser.dateFormatMap.containsKey(dateFomat))
                sdf = ResponseValParser.dateFormatMap.get(dateFomat);
            else{
                sdf = new SimpleDateFormat(dateFomat);
                ResponseValParser.dateFormatMap.put(dateFomat, sdf);
            }
        }

        String text = null;
        try {
            text = sdf.format(val);
        }catch (Exception e){
            text = defDateFormat.format(val); // 异常解析，使用默认格式
            logger.error(e.getMessage());
        }
        return text;
    }

    public SimpleDateFormat getDefDateFormat() {
        return defDateFormat;
    }

    public void setDefDateFormat(SimpleDateFormat defDateFormat) {
        this.defDateFormat = defDateFormat;
    }


    private Date getOracleTimestamp(Object value) {
        try {
            Class clz = value.getClass();
            Method m = clz.getMethod("timestampValue", null);
            //m = clz.getMethod("timeValue", null); 时间类型
            //m = clz.getMethod("dateValue", null); 日期类型
            return (Date) m.invoke(value, null);

        } catch (Exception e) {
            return null;
        }
    }
}
