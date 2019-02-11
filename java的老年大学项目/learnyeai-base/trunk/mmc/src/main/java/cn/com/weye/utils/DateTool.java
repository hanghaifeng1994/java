package cn.com.weye.utils;

import com.thinkgem.jeesite.modules.act.rest.servlet.JsonpCallbackFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class DateTool {
//    private static Logger log = LoggerFactory.getLogger(JsonpCallbackFilter.class);

    private static SimpleDateFormat withTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat outTime = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) throws InterruptedException {
       /* Date date = DateTool.getLastDayOrFirstDayOfmonth("2016","09","first");
        String time = outTime.format(date);
        System.out.println(time);
        Date end = DateTool.getLastDayOrFirstDayOfmonth("2016","09","last");
        String last = outTime.format(end);
        System.out.println(last);*/

    }

    /**
     *  获取当前日期但一部分
     * @return
     */
    public static int getCurrentYear(String type){
        Calendar a= Calendar.getInstance();
        Integer date = 0;
        if (type.equals("YEAR")) {
            date = a.get(Calendar.YEAR);
        }else if (type.equals("MONTH")){
            date = a.get(Calendar.MONTH)+1;
        }else if (type.equals("DAY")) {
            date = a.get(Calendar.DATE);
        }
        return date;
    }


    /**
     * 转换指定字符为日期(包含时分秒)
     * @param time
     * @return
     */
    public static Date getDateObjectWithTime(String time){
        Date date = new Date();
        try {
            date = withTime.parse(time);
        }catch (ParseException e){
//            log.info(e.toString());
        }
        return date;
    }

    /**
     * 转换指定字符为日期(不包含时分秒)
     * @param time
     * @return
     */
    public static Date getDateObjectWithOutTime(String time){
        Date date = new Date();
        try {
            date = outTime.parse(time);
        }catch (ParseException e){
//            log.info(e.toString());
        }
        return date;
    }

    /**
     * 将指定日期转换成字符串 （包含时分秒）
     * @param date
     * @return
     */
    public static String getStringWithTime(Date date){
        String time =  withTime.format(date);
        return time;
    }
    /**
     * 将指定日期转换成字符串 （不包含时分秒）
     * @param date
     * @return
     */
    public static String getStringOutTime(Date date){
        return outTime.format(date);
    }

    /**
     * 获取当前为第几季度
     * @param date
     * @return
     */
    public static int getSeason(Date date) {

        int season = 0;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                break;
            default:
                break;
        }
        return season;
    }

    /**
     * 获取输入年份和月份的第一天或最后一天的时间字符串（不包含时分秒）
     * @param year
     * @param month
     * @param type
     * @return
     */

    public static String getLastDayOrFirstDayOfmonth(String year,String month,String type){
        Calendar cal = Calendar.getInstance();
        // 不加下面2行，就是取当前时间前一个月的第一天及最后一天
        int yearInt = Integer.parseInt(year);
        int monthInt = Integer.parseInt(month);
        cal.set(Calendar.YEAR,yearInt);
        cal.set(Calendar.MONTH, monthInt-1);

        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        if ("first".equals(type)){
            cal.set(Calendar.DAY_OF_MONTH, 1);
        }
        if ("last".equals(type)){
            cal.set(Calendar.DAY_OF_MONTH, lastDay);
        }
        Date date = cal.getTime();
        return outTime.format(date);
    }
}
