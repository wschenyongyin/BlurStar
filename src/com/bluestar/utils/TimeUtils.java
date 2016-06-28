package com.bluestar.utils;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * TimeUtils
 * 
 * @author peng
 * 
 */
@SuppressLint("SimpleDateFormat")
public class TimeUtils
{
    
    static SimpleDateFormat format = null;
    
    /**
     * 获得当前时间,以毫秒为单位
     * 
     * @return
     */
    public static long getCurrentTimeInLong()
    {
        return System.currentTimeMillis();
    }
    
    /**
     * long time to string, format is{@link 自定义时间格式}
     * 
     * @param timeType 时间格式（如：yyyy-MM-dd、yyyy年MM月dd日�?�HH:mm...�?
     */
    public static String getTime(String timeType)
    {
        format = new SimpleDateFormat(timeType);
        return format.format(new Date());
    }
    
    /**
     * long time to string, format is{@link 自定义时间格式}
     * 
     * @param timeInMillis 毫秒
     * @param timeType 时间格式（如：yyyy-MM-dd、yyyy年MM月dd日�?�HH:mm...�?
     */
    public static String getTime(long timeInMillis, String timeType)
    {
        format = new SimpleDateFormat(timeType);
        return format.format(new Date(timeInMillis));
    }
    
    /**
     * 时间格式转换
     * 
     * @param oldString 旧时间格�?
     * @param newString 新时间格�?
     * @return 自定义新时间格式
     * @throws ParseException
     */
    public static String getTime(String oldString, String newString)
        throws ParseException
    {
        format = new SimpleDateFormat(newString);
        return format.format(format.parse(oldString));
    }
    
    /**
     * 计算两时间之间相差的天数
     * 
     * @param startTime �?始时�?
     * @param endTime 结束时间
     * @return 相差天数
     */
    public static int getDaysBetween(long startTime, long endTime)
    {
        long betweentime = (startTime - endTime) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(betweentime));
    }
    
    /**
     * 计算两时间之间相差的天数
     * 
     * @param startString �?始时�?
     * @param endString 结束时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int getDaysBetween(String startString, String endString)
        throws ParseException
    {
        format = new SimpleDateFormat("yyyy-MM-dd");
        long startTime = format.parse(startString).getTime() + TimeZone.getDefault().getRawOffset();
        long endTime = format.parse(endString).getTime() + TimeZone.getDefault().getRawOffset();
        long betweentime = (startTime - endTime) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(betweentime));
    }
    
    /**
     * 计算两时间之间相差的天数
     * 
     * @param startDate �?始时�?
     * @param endDate 结束时间
     * @return 相差天数
     */
    public static int getDaysBetween(Date startDate, Date endDate)
    {
        // TimeZone.getDefault().getRawOffset():本地时区与GMT格林威治标准时间的偏移量(北京是东八区 相差的毫秒数�?28800000)
        long time1 = startDate.getTime() + TimeZone.getDefault().getRawOffset();
        long time2 = endDate.getTime() + TimeZone.getDefault().getRawOffset();
        long betweentime = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(betweentime));
    }
    
}
