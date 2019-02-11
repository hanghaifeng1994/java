package com.learnyeai.tools.common;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期帮助类，
 * 尽量使用org.apache.commons.lang.time.DateUtils
 * 日期格式化使用DateFormatUtils，用到缓存速度快
 * Created by zpz on 2017/4/28.
 */
public class DateHelper {
    protected static final Logger logger = LoggerFactory.getLogger(DateHelper.class);
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_CN = "yyyy年MM月dd日";
    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_FORMAT_CN = "yyyy年MM月dd日HH时mm分ss秒";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String TIME_FORMAT = "HH:mm:ss";

    public static final String[] CONVERT_DATE_PATTERNS = new String[]{"yyyy/MM","yyyy/MM/dd","yyyy/MM/dd HH:mm:ss"};
    public static final String[] CONVERT_DATE_PATTERNS_y_m_d = new String[]{ "yyyy-MM", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"};
    public static final String[] CONVERT_DATE_PATTERNS_ymd = new String[]{"yyyyMM","yyyyMMdd","yyyyMMddHHmmss"};

    private static final SimpleDateFormat FORMATymd = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private DateHelper() {
    }

    /**
     * 根据年、月、日构建日期
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date buildDate(Integer year, Integer month, Integer day) {
        Calendar calendar = Calendar.getInstance();
        if(null == year)
            throw new RuntimeException("构建日期失败");
        int type = Calendar.YEAR;
        calendar.set(type, year);
        if(null != month) {
            type = Calendar.MONTH;
            calendar.set(type, month);
        }
        if(null != day) {
            type = Calendar.DATE;
            calendar.set(type, day);
        }
        return DateUtils.truncate(calendar, type).getTime();
    }

    public static Date parseDate(String dateStr) {
        if (StringUtils.isEmpty(dateStr))
            return null;

        try {
            String format = "yyyyMMddHHmmssSSS";
            String dt = dateStr.replaceAll("[-/\\.: ]", "");
            if(dt.length() < format.length())
                dt = dt + format.substring(dt.length()).replaceAll("[yyyyMMddHHmmssSSS]","0");
            return FORMATymd.parse(dt);
            /*if(dateStr.indexOf("-") > 0)
                return DateUtils.parseDate(dateStr, DateHelper.CONVERT_DATE_PATTERNS_y_m_d);
            else if(dateStr.indexOf("/") > 0)
                return DateUtils.parseDate(dateStr, DateHelper.CONVERT_DATE_PATTERNS);
            else
                return DateUtils.parseDate(dateStr, DateHelper.CONVERT_DATE_PATTERNS_ymd);*/
//            return DateUtils.parseDateStrictly(dateStr,CONVERT_DATE_PATTERNS);
        } catch (ParseException e) {
            throw new RuntimeException("解析日期出错");
        }
    }
    public static Date parseDate(String dateStr, String format) {
        try {
            return DateUtils.parseDate(dateStr, new String[]{format});
        } catch (ParseException e) {
            throw new RuntimeException("解析日期出错");
        }
    }

    /**
     * 将一种字符日期转化成另外一种日期格式
     *
     * @param date
     * @param fmtSrc
     * @param fmtTag
     * @return
     */
    public static String format(String date, String fmtSrc, String fmtTag) {
        Date d = parseDate(date, fmtSrc);
        return DateFormatUtils.format(d, fmtTag);
    }

    /**
     * 获取两个日期之间间隔
     * @param start
     * @param end
     * @param type
     * @return
     */
    public static int getDateMargin(Date start, Date end, Integer type) {
        return getDateMargin(start.getTime(), end.getTime(), type);
    }

    public static int getDateMargin(long start, long end, Integer type) {
        Long margin = Long.valueOf(end - start);
        long t = DateUtils.MILLIS_PER_DAY; // 默认间隔为天
        if(null != type){
            switch (type.intValue()){
                case Calendar.DATE:
                    t = DateUtils.MILLIS_PER_DAY;
                    break;
                case Calendar.HOUR :
                    t = DateUtils.MILLIS_PER_HOUR;
                    break;
                case Calendar.MINUTE :
                    t = DateUtils.MILLIS_PER_MINUTE;
                    break;
                case Calendar.SECOND :
                    t = DateUtils.MILLIS_PER_SECOND;
                    break;
                default:
                    throw new RuntimeException("不支持类型");
            }
        }

        margin = margin.longValue() / t;
        return margin.intValue();
    }

    public static int getDateMargin(String start, String end) {
        try {
            return getDateMargin(DateUtils.parseDate(start, CONVERT_DATE_PATTERNS), DateUtils.parseDate(end,CONVERT_DATE_PATTERNS), null);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取某月的天数
     * @param year
     * @param month
     * @return
     */
    public static int getDayCountOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.add(Calendar.DATE,-1);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
    /**
     * 获取某月的天数
     * @param sDate1
     * @return
     */
    public static int getDayCountOfMonth(Date sDate1){
        Calendar cDay1 = Calendar.getInstance();
        cDay1.setTime(sDate1);
        int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);
        return lastDay;
    }

    /**
     * 获取某月的第一天
     * @param date
     * @return
     */
    public static Date getFirstDateOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        DateUtils.truncate(calendar, Calendar.MONTH);
        return calendar.getTime();
    }

    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        DateUtils.truncate(calendar, Calendar.MONTH);
        return calendar.getTime();
    }

    /**
     * 获取某季度第一天
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter(int year, int quarter) {
        boolean month = false;
        if (quarter > 4) {
            return null;
        } else {
            int month1 = (quarter - 1) * 3 + 1;
            return getFirstDayOfMonth(year, month1);
        }
    }

    public static Date getFirstDayOfYear(int year) {
        return getFirstDayOfMonth(year, 1);
    }

    public static Date getLastDateOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static Date getLastDateOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        DateUtils.truncate(calendar,Calendar.MONDAY);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static Date getLastDayOfQuarter(int year, int quarter) {
        boolean month = false;
        if (quarter > 4) {
            return null;
        } else {
            int month1 = quarter * 3;
            return getLastDateOfMonth(year, month1);
        }
    }

    public static Date getLastDayOfYear(int year) {
        return getLastDateOfMonth(year, 12);
    }

    public static Date getNextDate(Date date, int next) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, next);
        return calendar.getTime();
    }
    public static Date getNextYear(Date currentDate, int next) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(Calendar.YEAR, next);
        return cal.getTime();
    }

    public static Date getPrevDate(Date date, int Prev) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, -1 * Prev);
        return calendar.getTime();
    }

    /**
     * 获取本周第一天（星期一）
     * @param date
     * @return
     */
    public static Date getWeekFirstDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    public static Date getWeekLastDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, 1); // 下周
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        return calendar.getTime();
    }

    public static Date nowDate() {
        return Calendar.getInstance().getTime();
    }

    public static int curHour(Calendar cal) {
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int curMinute(Calendar cal) {
        return cal.get(Calendar.MINUTE);
    }

    public static int curSecond(Calendar cal) {
        return cal.get(Calendar.SECOND);
    }


    /**
     * 两个时间相差距离多少天多少小时多少分多少秒
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00
     * @return long[] 返回值为：{天, 时, 分, 秒}
     */
    public static long[] getDistanceTimes(String str1, String str2) {
        Date one;
        Date two;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = parseDate(str1);
            two = parseDate(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long[] times = {day, hour, min, sec};
        return times;
    }


    public static String getDate() {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd");
    }

    public static String getTime() {
        return DateFormatUtils.format(new Date(), "HH:mm:ss");
    }
}