package com.bluestar.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * �ַ����������߰�
 * 
 * @author peng
 * @create 2015��6��30��
 * @version
 */
@SuppressLint("SimpleDateFormat")
public class StringUtils
{
    private final static Pattern emailer = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    
    private final static Pattern phone = Pattern.compile("^((13[0-9])|170|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
    
    private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>()
    {
        @Override
        protected SimpleDateFormat initialValue()
        {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    
    private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>()
    {
        @Override
        protected SimpleDateFormat initialValue()
        {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    
    /**
     * ���ص�ǰϵͳʱ��
     * 
     * @param format
     * @return
     */
    public static String getDataTime(String format)
    {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }
    
    /**
     * ���ص�ǰϵͳʱ��
     * 
     * @return
     */
    public static String getDataTime()
    {
        return getDataTime("HH:mm");
    }
    
    /**
     * ����ֵת��Ϊmm:ss
     * 
     * @param ms
     * @return
     */
    public static String timeFormat(int ms)
    {
        StringBuilder time = new StringBuilder();
        time.delete(0, time.length());
        ms /= 1000;
        int s = ms % 60;
        int min = ms / 60;
        if (min < 10)
        {
            time.append(0);
        }
        time.append(min).append(":");
        if (s < 10)
        {
            time.append(0);
        }
        time.append(s);
        return time.toString();
    }
    
    /**
     * ���ַ���תλ��������
     * 
     * @param sdate
     * @return
     */
    public static Date toDate(String sdate)
    {
        try
        {
            return dateFormater.get().parse(sdate);
        }
        catch (ParseException e)
        {
            return null;
        }
    }
    
    /**
     * �жϸ����ַ���ʱ���Ƿ�Ϊ����
     * 
     * @param sdate
     * @return
     */
    public static boolean isToday(String sdate)
    {
        boolean b = false;
        Date time = toDate(sdate);
        Date today = new Date();
        if (time != null)
        {
            String nowDate = dateFormater2.get().format(today);
            String timeDate = dateFormater2.get().format(time);
            if (nowDate.equals(timeDate))
            {
                b = true;
            }
        }
        return b;
    }
    
    /**
     * �жϸ����ַ����Ƿ�հ״� �հ״���ָ�ɿո��Ʊ�����س��������з���ɵ��ַ��� �������ַ���Ϊnull����ַ���������true
     * 
     * @param input
     * @return
     */
    public static boolean isEmpty(String input)
    {
        if (input == null || "".equals(input))
            return true;
        
        for (int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n')
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * �ж��ǲ���һ���Ϸ��ĵ����ʼ���ַ
     * 
     * @param email
     * @return
     */
    public static boolean isEmail(String email)
    {
        if (email == null || email.trim().length() == 0)
            return false;
        return emailer.matcher(email).matches();
    }
    
    /**
     * �ж��ǲ���һ���Ϸ����ֻ�����
     * 
     * @param phoneNum
     * @return
     */
    public static boolean isPhone(String phoneNum)
    {
        if (phoneNum == null || phoneNum.trim().length() == 0)
            return false;
        return phone.matcher(phoneNum).matches();
    }
    
    /**
     * �ַ���ת����
     * 
     * @param str,��Ҫת���ַ���
     * @param defValue,ת��ʧ�����
     * @return
     */
    public static int toInt(String str, int defValue)
    {
        try
        {
            return Integer.parseInt(str);
        }
        catch (Exception e)
        {
        }
        return defValue;
    }
    
    /**
     * ����ת��
     * 
     * @param obj
     * @return
     */
    public static int toInt(Object obj)
    {
        if (obj == null)
            return 0;
        return toInt(obj.toString(), 0);
    }
    
    /**
     * Stringתlong
     * 
     * @param obj
     * @return
     */
    public static long toLong(String obj)
    {
        try
        {
            return Long.parseLong(obj);
        }
        catch (Exception e)
        {
        }
        return 0;
    }
    
    /**
     * Stringתdouble
     * 
     * @param obj
     * @return
     */
    public static double toDouble(String obj)
    {
        try
        {
            return Double.parseDouble(obj);
        }
        catch (Exception e)
        {
        }
        return 0D;
    }
    
    /**
     * �ַ���ת����
     * 
     * @param b
     * @return
     */
    public static boolean toBool(String b)
    {
        try
        {
            return Boolean.parseBoolean(b);
        }
        catch (Exception e)
        {
        }
        return false;
    }
    
    /**
     * �ж�һ���ַ����ǲ�������
     * 
     * @param str
     * @return
     */
    public static boolean isNumber(String str)
    {
        try
        {
            Integer.parseInt(str);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    
    /**
     * ��ȡAppKey
     * 
     * @param context
     * @param metaKey
     * @return
     */
    public static String getMetaValue(Context context, String metaKey)
    {
        Bundle metaData = null;
        String apiKey = null;
        if (context == null || metaKey == null)
        {
            return null;
        }
        try
        {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            if (null != ai)
            {
                metaData = ai.metaData;
            }
            if (null != metaData)
            {
                apiKey = metaData.getString(metaKey);
            }
        }
        catch (NameNotFoundException e)
        {
            
        }
        return apiKey;
    }
    
    /**
     * ��ȡ�ֻ�IMEI��
     * 
     * @param aty
     * @return
     */
    public static String getPhoneIMEI(Activity aty)
    {
        TelephonyManager tm = (TelephonyManager)aty.getSystemService(Activity.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }
    
    /**
     * MD5����
     * 
     * @param string
     * @return
     */
    public static String md5(String string)
    {
        byte[] hash;
        try
        {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        }
        catch (UnsupportedEncodingException e)
        {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }
        
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash)
        {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
    
    /**
     * KJ����
     * 
     * @param str
     * @return
     */
    public static String KJencrypt(String str)
    {
        char[] cstr = str.toCharArray();
        StringBuilder hex = new StringBuilder();
        for (char c : cstr)
        {
            hex.append((char)(c + 5));
        }
        return hex.toString();
    }
    
    /**
     * KJ����
     * 
     * @param str
     * @return
     */
    public static String KJdecipher(String str)
    {
        char[] cstr = str.toCharArray();
        StringBuilder hex = new StringBuilder();
        for (char c : cstr)
        {
            hex.append((char)(c - 5));
        }
        return hex.toString();
    }
}