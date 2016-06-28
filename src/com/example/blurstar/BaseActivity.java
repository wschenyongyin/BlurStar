package com.example.blurstar;

import com.bluestar.utils.AppManager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;



/**
 * Activity����
 * @author pxh
 * @create 2015-5-21
 * @version 
 */
public abstract class BaseActivity extends FragmentActivity
{
	private static String tag = null;

	/**
	 * @param inTag ��ǰActivity��ʶ
	 * @param useDefaultEventBus �ڵ�ǰ�������л������Ƿ�ʹ��Ĭ�ϵ�EventBus
	 */
	public BaseActivity(String inTag )
	{
		tag = inTag;
	}

	public void reportBack(String message)
	{
		reportBack(tag, message);
	}

	public void reportBack(String tag, String message)
	{
		Log.d(tag, message);
	}

	public void reportTransient(String message)
	{
		reportTransient(tag, message);
	}

	public void reportTransient(String tag, String message)
	{
		String s = tag + ":" + message;
		Toast mToast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
		mToast.show();
		reportBack(tag, message);
		Log.d(tag, message);
	}

	/**
	 * ��ת����һActivity
	 * @param activityClassReference
	 */
	public void gotoActivity(Class activityClassReference)
	{
		Intent i = new Intent(this, activityClassReference);
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
		startActivity(i);
	}

	/**
	 * �������ݲ���ת����һActivity
	 * @param bundle
	 * @param activityClassReference
	 */
	public void gotoActivity(Bundle bundle, Class activityClassReference)
	{
		Intent i = new Intent(this, activityClassReference);
		i.putExtras(bundle);
		startActivity(i);
	}

	/**
	 * �������ݲ���ת����һActivity,�����з�������
	 * @param bundle
	 * @param activityClassReference
	 * @param requestCode
	 */
	public void gotoActivityForResult(Bundle bundle, Class activityClassReference, int requestCode)
	{
		Intent i = new Intent(this, activityClassReference);
		i.putExtras(bundle);
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
		startActivityForResult(i, requestCode);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// ȥ��������
		AppManager.getAppManager().addActivity(this);
		reportBack("add activity: " + this.toString());
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		// ����Activity&�Ӷ�ջ���Ƴ�
		reportBack("onDestroy() " + this.toString());
		AppManager.getAppManager().finishActivity(this);
	}

	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2)
	{
		super.onActivityResult(arg0, arg1, arg2);
		reportBack("BaseActivity onActivityResult");
	}
}
