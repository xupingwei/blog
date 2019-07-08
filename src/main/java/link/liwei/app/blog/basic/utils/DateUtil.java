package link.liwei.app.blog.basic.utils;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    public static String DATA_FORMATER = "yyyy-MM-dd";
    public static String DATA_FORMATER1 = "MM-dd";  //月日
    public static String DATATIME_FORMMATER2 = "MM-dd HH:mm";  //24小时制 月日时分
    public static String DATATIME_2_FORMMATER = "yyyy-MM-dd hh:mm:ss";  //12小时制 年月日时分秒
    public static String DATATIME_FORMMATER = "yyyy-MM-dd HH:mm:ss";  //24小时制 年月日时分秒
    public static String DATATIME_FORMMATER3 = "mm:ss";

    /**
     * 获取今天的0点时间
     * <p/>
     * 2014年7月12日
     */
    public static Date getTodayStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 格式 化日期，返回符合格式的字符串
     *
     * @param date
     * @param formater 如:yyyy-MM-dd HH:mm:ss
     * @return
     */
    private static String getDateStrCompact(Date date, String formater) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(formater);
        String str = format.format(date);
        return str;
    }

    /**
     * 格式 化日期，返回符合格式的字符串
     *
     * @param date
     * @param formatStr 默认 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String dateToString(Date date, String formatStr) {
        if (formatStr == null || "".equals(formatStr.trim())) {
            formatStr = "yyyy-MM-dd HH:mm:ss";
        }
        return getDateStrCompact(date, formatStr);
    }

    /**
     * 格式化日期字符串，返回符合格式的date
     *
     * @param dateStr
     * @param formater 如:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date StringToDate(String dateStr, String formater) {
        Date date = null;
        if (formater == null || "".equals(formater.trim())) {
            formater = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(formater);
        if (!StringUtils.hasText(dateStr)) {
            return date;
        }
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将日期增减 n 天
     *
     * @param date 参照日期,如果为null则取当前日期
     * @param days 增减的天数 (为正数则增加，为负数则减少)
     * @return Date
     */
    public static Date addDate(Date date, int days) {

        return addDate(date, days, Calendar.DATE);
    }

    /**
     * 取某一日期增减 n 值后的日期, n 由 dateField 决定是年、月、日 根据增加or减少的时间得到新的日期
     *
     * @param date      参照日期
     * @param counts    增减的数值
     * @param dateField int 需操作的日期字段, 取值范围如下 Calendar.YEAY 年 Calendar.MONTH 月
     *                  Calendar.DATE 日 .... Calendar.SECOND 秒
     * @return Date
     */
    public static Date addDate(Date date, int counts, int dateField) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(dateField, counts);
        return calendar.getTime();
    }

    public static void main(String[] args) {
//        Date d = addDate(new Date(), -5, Calendar.MONTH);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        //Calendar calendar = Calendar.getInstance();
//        Date theDate = d;
//
//        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
//        gcLast.setTime(theDate);
//        gcLast.set(Calendar.DAY_OF_MONTH, 1);
//        String day_first = df.format(gcLast.getTime());
//        StringBuffer str = new StringBuffer().append(day_first);
//
//
//        Calendar calendar = Calendar.getInstance();
//        // 设置日期为本月最大日期
//        calendar.setTime(d);
//        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
//        // 打印
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String s = format.format(calendar.getTime());
//        System.out.println(str + ":::" + s);
        System.out.println(getDateByTime(System.currentTimeMillis()));
    }

    public static long getTimeInMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }


    /**
     * 当前时间多少分钟之后的时间
     *
     * @param min
     * @return
     */
    public static Date getCurrentAfterTime(Date date, int min) {
        if (date == null) {
            date = new Date();
        }
        long current = getTimeInMillis(date);
        current += min * 60 * 1000;
        Date da = new Date(current);
        return da;
    }

    public static String getCurrentAfterTimeStr(Date date, int min) {
        Date da = getCurrentAfterTime(date, min);
        return dateToString(da, null);
    }


    //GMT时间转换本地标准格式时间
    public static String GMTToDateStr(String gmtStr) {
        SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try {
            date = format.parse(gmtStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format2.format(date);
    }

    public static Date GMTToDate(String gmtStr) {
        SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = null;
        try {
            date = format.parse(gmtStr);
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = format2.format(date);
            return format2.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取当月第一天
     *
     * @return
     */
    public static String getFirstDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();

        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first);
        return str.toString();

    }

    /**
     * 当月最后一天
     *
     * @return
     */
    public static String getLastDay() {
        // 获取Calendar
        Calendar calendar = Calendar.getInstance();
        // 设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        // 打印
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(calendar.getTime());
        StringBuffer str = new StringBuffer().append(s);
        return str.toString();
    }

    /**
     * Unix时间戳转换成指定格式日期
     *
     * @param timeStamp
     * @param formater
     * @return
     */
    public static String transUnixTimeStamp2Date(String timeStamp, String formater) {
        Long timestamp = Long.parseLong(timeStamp) * 1000;
        if (formater == null) {
            formater = DateUtil.DATATIME_FORMMATER;
        }
        String date = new SimpleDateFormat(formater, Locale.CHINA).format(new Date(timestamp));
        return date;

    }

    /**
     * 获取年月日时间字符串
     *
     * @param time
     * @return
     */
    public static String getDateByTimeMillis(Long time) {
        Date date = new Date(time);
        String data = DateUtil.dateToString(date, DateUtil.DATA_FORMATER);
        return data;
    }

    /**
     * 获取年月日时间字符串
     *
     * @param time
     * @return
     */
    public static String getDateByTimeMilli(Long time) {
        Date date = new Date(time);
        String data = DateUtil.dateToString(date, DateUtil.DATATIME_FORMMATER3);

        return data;
    }


    /**
     * 获取年月日时间字符串
     *
     * @param time
     * @return
     */
    public static String getDateByTime(Long time) {
        Date date = new Date(time);
        String data = DateUtil.dateToString(date, DateUtil.DATATIME_FORMMATER);
        return data;
    }

    public static String getYesterdayStart() {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -1);
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(DATA_FORMATER);
        String dateString = formatter.format(date) + " 00:00:00";
        return dateString;
    }

    /**
     * 获取当前系统的时间戳
     *
     * @return
     */
    public static String getUnixTimestamp() {
        long time = System.currentTimeMillis();
        String nowTimeStamp = String.valueOf(time / 1000);
        return nowTimeStamp;
    }

    /**
     * 课次时间差
     */
    public static String getSectTime(String SectBegin, String SectEnd) {
        Date date1 = DateUtil.StringToDate(SectBegin, DateUtil.DATATIME_FORMMATER);
        Date date2 = DateUtil.StringToDate(SectEnd, DateUtil.DATATIME_FORMMATER);
        Long a = (date2.getTime() - date1.getTime()) / (1000 * 60 * 60);
        String str = String.valueOf(a);
        return str.toString();
    }

    public static String getBeforeFirstDay(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(date);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first);
        return str.toString();
    }

    /**
     * 当月最后一天
     *
     * @return
     */
    public static String getAfterLastDay(Date date) {
        // 获取Calendar
        Calendar calendar = Calendar.getInstance();
        // 设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        // 打印
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(calendar.getTime());
        StringBuffer str = new StringBuffer().append(s);
        return str.toString();
    }

    /**
     * @param months
     * @return
     */
    public static String getBeforeTime(int months) {
        Date dNow = StringToDate(getBeforeFirstDay(new Date()), DATA_FORMATER);   //当前时间
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(calendar.MONTH, months);  //设置为前几月的时间
        String str = dateToString(calendar.getTime(), DATA_FORMATER); //格式化并返回
        return str.toString();
    }

    /**
     * 几月后的日期，
     *
     * @param months
     * @return
     */
    public static String getAfterTime(int months) {
        Date dNow = StringToDate(getAfterLastDay(new Date()), DATA_FORMATER);   //当前时间
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(calendar.MONTH, months);  //设置为前几月的时间
        String str = dateToString(calendar.getTime(), DATA_FORMATER); //格式化并返回
        return str.toString();
    }
}
