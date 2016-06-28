package com.bluestar.utils;

import java.util.Stack;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

/**
 * Ӧ�ó���Activity�����ࣺ����Activity�����Ӧ�ó����˳�
 * 
 * @author pxh
 * @create 2015��6��29��
 * @version
 */
public class AppManager
{
    private static Stack<Activity> activityStack;
    
    private static AppManager instance;
    
    private AppManager()
    {
    }
    
    /**
     * ��һʵ��
     * 
     * @author yangwendaxia
     * @version 1.0
     * @created Jul 28, 2014
     * @return
     */
    public static AppManager getAppManager()
    {
        if (instance == null)
        {
            instance = new AppManager();
        }
        return instance;
    }
    
    /**
     * ���Activity����ջ
     * 
     * @author yangwendaxia
     * @version 1.0
     * @created Jul 28, 2014
     * @param activity
     */
    public void addActivity(Activity activity)
    {
        Log.d("AppMananger addActivity", activity.toString());
        if (activityStack == null)
        {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }
    
    /**
     * ��ȡ��ǰActivity����ջ�����һ��ѹ��ģ�
     * 
     * @author yangwendaxia
     * @version 1.0
     * @created Jul 28, 2014
     * @return
     */
    public Activity currentActivity()
    {
        Activity activity = activityStack.lastElement();
        return activity;
    }
    
    /**
     * ������ǰActivity����ջ�����һ��ѹ��ģ�
     * 
     * @author yangwendaxia
     * @version 1.0
     * @created Jul 28, 2014
     */
    public void finishActivity()
    {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }
    
    /**
     * ����ָ����Activity
     * 
     * @author yangwendaxia
     * @version 1.0
     * @created Jul 28, 2014
     * @param activity
     */
    public void finishActivity(Activity activity)
    {
        Log.d("AppManager finishActivity", activity.toString());
        if (activity != null)
        {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }
    
    /**
     * ����ָ��������Activity
     * 
     * @author yangwendaxia
     * @version 1.0
     * @created Jul 28, 2014
     * @param cls
     */
    public void finishActivity(Class<?> cls)
    {
        for (Activity activity : activityStack)
        {
            if (activity.getClass().equals(cls))
            {
                finishActivity(activity);
            }
        }
    }
    
    /**
     * ��������Activity
     * 
     * @author yangwendaxia
     * @version 1.0
     * @created Jul 28, 2014
     */
    public void finishAllActivity()
    {
        for (int i = 0, size = activityStack.size(); i < size; i++)
        {
            if (null != activityStack.get(i))
            {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }
    
    /**
     * �˳�Ӧ�ó���
     * 
     * @author yangwendaxia
     * @version 1.0
     * @created Jul 28, 2014
     * @param context
     */
    @SuppressWarnings("deprecation")
    public void AppExit(Context context)
    {
        try
        {
            finishAllActivity();
            ActivityManager activityMgr = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
        }
        catch (Exception e)
        {
        }
    }
}