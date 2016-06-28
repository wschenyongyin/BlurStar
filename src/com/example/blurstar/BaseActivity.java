package com.example.blurstar;

import com.bluestar.utils.AppManager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;



/**
 * Activity基类
 * @author pxh
 * @create 2015-5-21
 * @version 
 */
public abstract class BaseActivity extends FragmentActivity
{
	private static String tag = null;

	/**
	 * @param inTag 当前Activity标识
	 * @param useDefaultEventBus 在当前运行运行环境中是否使用默认的EventBus
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
	 * 跳转到下一Activity
	 * @param activityClassReference
	 */
	public void gotoActivity(Class activityClassReference)
	{
		Intent i = new Intent(this, activityClassReference);
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
		startActivity(i);
	}

	/**
	 * 传递数据并跳转到下一Activity
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
	 * 传递数据并跳转到下一Activity,并且有返回数据
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
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		AppManager.getAppManager().addActivity(this);
		reportBack("add activity: " + this.toString());
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		// 结束Activity&从堆栈中移除
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
