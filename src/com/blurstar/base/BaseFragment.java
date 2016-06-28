package com.blurstar.base;

import com.example.blurstar.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment����
 * @author pxh
 * @create 2015-5-21
 * @version
 */

@SuppressLint("NewApi")
public abstract class BaseFragment extends Fragment
{
    public BaseFragment()
    {
    	
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    
    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }
    
    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
    }
    
    @Override
    public void onDetach()
    {
        super.onDetach();
    }
    
    @Override
    public void onResume()
    {
        super.onResume();
    }
    
    @Override
    public void onStart()
    {
        super.onStart();
    }
    
    @Override
    public void onStop()
    {
        super.onStop();
    }
    
    /**
     * ���warn��ɫlog
     * 
     * @param msg
     */
    protected void reportBackwarn(String msg)
    {
        Log.w(getClass().getSimpleName(), msg);
    }
    
    /**
     * ���info��ɫlog
     * 
     * @param msg
     */
    protected void reportBackInfo(String msg)
    {
        Log.i(getClass().getSimpleName(), msg);
    }
    
    /**
     * �������ݲ���ת����һActivity
     * 
     * @param bundle
     * @param cls
     */
    protected void gotoAct(Bundle bundle, Class<?> cls)
    {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        startActivity(intent);
    }
    
    /**
     * ��ת����һActivity
     * 
     * @param cls
     */
    protected void gotoAct(Class<?> cls)
    {
        Intent intent = new Intent(getActivity(), cls);
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        startActivity(intent);
    }
    
    /**
     * �������ݲ���ת����һActivity,�����з�������
     * 
     * @param bundle
     * @param cls
     * @param requestCode
     */
    protected void gotoActForResult(Bundle bundle, Class<?> cls, int requestCode)
    {
        Intent intent = new Intent(getActivity(), cls);
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        startActivityForResult(intent, requestCode);
    }
}
