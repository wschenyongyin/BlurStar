package com.bluestar.utils;

import com.example.blurstar.R;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * Ӧ�ó���UI���߰�����װUI��ص�һЩ����
 * 
 * @author peng
 * @create 2015-5-20
 * @version
 */
public class UIHelper
{
    
    /**
     * ��ʱ����ʾToast
     * 
     * @param context
     * @param message
     */
    public static void ToastshowShort(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    
    /**
     * ��ʱ����ʾToast
     * 
     * @param context
     * @param message
     */
    public static void ToastshowLong(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
    
    /**
     * �Զ�����ʾToastʱ��
     * 
     * @param context
     * @param message
     * @param duration
     */
    public static void ToastshowDuration(Context context, CharSequence message, int duration)
    {
        Toast.makeText(context, message, duration).show();
    }
    
    /**
     * չʾ�ȴ��Ի���
     * 
     * @param context
     * @return
     */
    public static Dialog showWaitDialog(Context context)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.loading_dialog, null);
        ImageView blow = (ImageView)view.findViewById(R.id.dialog_imgv_blow);
        Animation rotateAnimation = AnimationUtils.loadAnimation(context, R.anim.loading);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        blow.startAnimation(rotateAnimation);
        Dialog loadingDialog = new Dialog(context, R.style.LoadingDialog);
        loadingDialog.show();
        loadingDialog.setContentView(view);
        return loadingDialog;
    }
    
    public static void showLog(String classStr, String contextStr)
    {
        Log.i(classStr, contextStr);
    }
}
