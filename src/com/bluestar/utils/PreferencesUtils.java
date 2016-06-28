package com.bluestar.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * Android SharedPreferences相关工具类
 * 
 * @author peng
 * @create 2015-5-18
 * @version
 */
public class PreferencesUtils
{
    
    /**
     * 获取SharedPreferences设置
     * 
     * @param context
     * @return
     */
    public static SharedPreferences getSharedPreferences(Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
    
    public static Editor getEditor(Context context)
    {
        return getSharedPreferences(context).edit();
    }
    
    public static void prefSave(Context context, String key, Object value)
    {
        Editor editor = getEditor(context);
        if (value instanceof Integer)
        {
            editor.putInt(key, (Integer)value);
        }
        else if (value instanceof Float)
        {
            editor.putFloat(key, (Float)value);
        }
        else if (value instanceof String)
        {
            editor.putString(key, (String)value);
        }
        else if (value instanceof Boolean)
        {
            editor.putBoolean(key, (Boolean)value);
        }
        else if (value instanceof Long)
        {
            editor.putLong(key, (Long)value);
        }
        editor.commit();
    }
    
    public static String prefStringGet(Context context, String key)
    {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.getString(key, null);
    }
    
    public static int prefIntGet(Context context, String key)
    {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.getInt(key, 0);
    }
    
    public static boolean prefBooleanGet(Context context, String key)
    {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.getBoolean(key, true);
    }
    
    /**
     * 
     * @param context
     * @param key
     * @return
     */
    public static boolean isContain(Context context, String key)
    {
        SharedPreferences preferences = getSharedPreferences(context);
        if (preferences.contains(key))
        {
            return true;
        }
        return false;
    }
}
