package com.other.updown.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author zhangbingquan
 * @desc 日期工具类
 * @time 2019-09-24 23:46
 */

public class DateUtil {
    private static char DAY_DELIMITER = '-';
    public static final String yyyy_MM_dd_style = "yyyy-MM-dd";
    public static final String yyyy_MM_style = "yyyy-MM";
    public static final String HH_mm_ss_style = "HH:mm:ss";
    public static final String yyMMdd_style = "yyMMdd";
    public static final String yyMM_style = "yyMM";
    public static final String yyyyMMdd_style = "yyyyMMdd";
    public static final String HHmmss_style = "HHmmss";
    public static final String standard_style = "yyyy-MM-dd HH:mm:ss";
    public static final String yyMMddHHmmss_style = "yyMMddHHmmss";
    public static final String yyyyMMddHHmmss_style = "yyyyMMddHHmmss";

    public DateUtil() {
    }

    public static String convertByStyle(String time, String fromStyle, String toStyle) throws ParseException {
        SimpleDateFormat fromSdf = new SimpleDateFormat(fromStyle);
        Date dateTime = fromSdf.parse(time);
        SimpleDateFormat toSdf = new SimpleDateFormat(toStyle);
        String toDateTime = toSdf.format(dateTime);
        return toDateTime;
    }

    public static String convertByStyle(String time, String fromStyle, String toStyle, String defaultVal) throws ParseException {
        String result = convertByStyle(time, fromStyle, toStyle);
        return result == null ? defaultVal : result;
    }

    public static String getDate() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        return (new SimpleDateFormat("yyyy-MM-dd")).format(calendar.getTime());
    }

    public static Calendar getFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(5, 1);
        return calendar;
    }

    public static Calendar getFirstDayOfNextMonth() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.add(2, 1);
        calendar.set(5, 1);
        return calendar;
    }

    public static Calendar getMiddleDayOfNextMonth() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.add(2, 1);
        calendar.set(5, 15);
        return calendar;
    }

    public static Calendar getMiddleDayOfMonth() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(5, 15);
        return calendar;
    }

    public static Calendar getLastDayOfMonth() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        int i = calendar.getActualMaximum(5);
        calendar.set(5, i);
        return calendar;
    }

    public static Calendar getCalendarByPattern(String dateStr, String pattern) throws ParseException {
        if (StringUtil.isNull(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        c.setTime(df.parse(dateStr));
        return c;
    }

    public static String getDayOffset(int offset, String format) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(5, calendar.get(5) + offset);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(calendar.getTime());
    }

    public static String getMonthOffset(int offset, String format) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(2, calendar.get(2) + offset);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(calendar.getTime());
    }

    public static String getDayOffset(String date, int offset, String format) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(toDate(date));
        calendar.set(5, calendar.get(5) + offset);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(calendar.getTime());
    }

    public static String getOffsetByType(String date, int offset, String format, String offsetType) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(toDate(date));
        byte var6 = -1;
        switch (offsetType.hashCode()) {
            case -1074026988:
                if (offsetType.equals("minute")) {
                    var6 = 1;
                }
                break;
            case -906279820:
                if (offsetType.equals("second")) {
                    var6 = 2;
                }
                break;
            case 3208676:
                if (offsetType.equals("hour")) {
                    var6 = 0;
                }
        }

        switch (var6) {
            case 0:
                calendar.set(11, calendar.get(11) + offset);
                break;
            case 1:
                calendar.set(12, calendar.get(12) + offset);
                break;
            case 2:
                calendar.set(13, calendar.get(13) + offset);
                break;
            default:
                calendar.set(5, calendar.get(5) + offset);
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(calendar.getTime());
    }

    public static String getMonthOffset(Date date, int offset, String format) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.set(2, calendar.get(2) + offset);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(calendar.getTime());
    }

    public static String toString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date toDate(String date) {
        try {
            return date.length() == 10 ? (new SimpleDateFormat("yyyy-MM-dd")).parse(date) : (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(date);
        } catch (ParseException var2) {
            throw new RuntimeException(var2);
        }
    }

    public static Date toDate(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(date);
        } catch (ParseException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static long diff(int type, Date date1, Date date2) {
        long time;
        switch (type) {
            case 1:
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date1);
                time = (long) calendar.get(1);
                calendar.setTime(date2);
                return time - (long) calendar.get(1);
            case 2:
                Calendar bef = Calendar.getInstance();
                Calendar aft = Calendar.getInstance();
                bef.setTime(date2);
                aft.setTime(date1);
                int result = aft.get(2) - bef.get(2);
                int month = (aft.get(1) - bef.get(1)) * 12;
                return (long) (month + result);
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
            case 11:
            case 12:
            default:
                return date1.getTime() - date2.getTime();
            case 5:
                time = date1.getTime() / 1000L / 60L / 60L / 24L;
                return time - date2.getTime() / 1000L / 60L / 60L / 24L;
            case 10:
                time = date1.getTime() / 1000L / 60L / 60L;
                return time - date2.getTime() / 1000L / 60L / 60L;
            case 13:
                time = date1.getTime() / 1000L;
                return time - date2.getTime() / 1000L;
        }
    }

    public static String getDateTime() {
        return getDateTime(new GregorianCalendar());
    }

    private static String getDateTime(Calendar calendar) {
        StringBuffer buf = new StringBuffer("");
        buf.append(calendar.get(1));
        buf.append(DAY_DELIMITER);
        buf.append(calendar.get(2) + 1 > 9 ? calendar.get(2) + 1 + "" : "0" + (calendar.get(2) + 1));
        buf.append(DAY_DELIMITER);
        buf.append(calendar.get(5) > 9 ? calendar.get(5) + "" : "0" + calendar.get(5));
        buf.append(" ");
        buf.append(calendar.get(11) > 9 ? calendar.get(11) + "" : "0" + calendar.get(11));
        buf.append(":");
        buf.append(calendar.get(12) > 9 ? calendar.get(12) + "" : "0" + calendar.get(12));
        buf.append(":");
        buf.append(calendar.get(13) > 9 ? calendar.get(13) + "" : "0" + calendar.get(13));
        return buf.toString();
    }

    public static String dateToString(long date, String formate) {
        return dateToString(new Date(date), formate);
    }

    public static String dateToString(Date date, String formate) {
        if (date == null) {
            return "";
        } else {
            formate = formate == null ? "yyyy-MM-dd HH:mm:ss.SSS" : formate;
            return (new SimpleDateFormat(formate)).format(date);
        }
    }

    public static String dateToString(Date date) {
        return dateToString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String dateToString(long date) {
        return dateToString(new Date(date));
    }

    public static String getDayAfter(String day, int format, int delta) {
        Calendar c = Calendar.getInstance();
        Date date = null;

        try {
            date = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(day);
        } catch (ParseException var7) {
        }

        c.setTime(date);
        int iday = c.get(format);
        c.set(format, iday + delta);
        String dayAfter = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(c.getTime());
        return dayAfter;
    }

    public static Object getDayAfter(Date day, int format, int delta) {
        return getDayAfter(dateToString(day), format, delta);
    }

    public static String getWeekOfDate(Date dt) {
        String[] weekDays = new String[]{"7", "1", "2", "3", "4", "5", "6"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(7) - 1;
        if (w < 0) {
            w = 0;
        }

        return weekDays[w];
    }

    public static Date weeHours(Date date, int flag) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(11);
        int minute = cal.get(12);
        int second = cal.get(13);
        long millisecond = (long) (hour * 60 * 60 * 1000 + minute * 60 * 1000 + second * 1000);
        cal.setTimeInMillis(cal.getTimeInMillis() - millisecond);
        if (flag == 0) {
            return cal.getTime();
        } else {
            if (flag == 1) {
                cal.setTimeInMillis(cal.getTimeInMillis() + 82800000L + 3540000L + 59000L);
            }

            return cal.getTime();
        }
    }

    public static Date getNextDay1Hour() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(11, 1);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        cal.add(5, 1);
        return cal.getTime();
    }

    public static String getThisYear() {
        Calendar rightNow = Calendar.getInstance(Locale.CHINA);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(rightNow.getTime());
    }

    public static String getPreDate(String date, int type, int step) {
        Calendar calendar = new GregorianCalendar(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(5, 7)) - 1, Integer.parseInt(date.substring(8, 10)), 0, 0, 0);
        calendar.add(type, step);
        return getDateTime(calendar).substring(0, 10);
    }
}
