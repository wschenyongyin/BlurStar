package com.bluestar.utils;

import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.content.Context;

/**
 * 需要传入一个上下文context对象 上传的数据集合map 请求网络的地址 servletpath 成功的回掉 listener 失败的回掉error回掉
 * 
 * @author wschenyongyin
 * 
 */
public class VolleyHttpUtils {

	public void sendPost(Context context, final Map<String, String> map,
			String servletPath, Listener<String> listener,
			ErrorListener errorlistener) {
		RequestQueue queue = Volley.newRequestQueue(context);
		StringRequest request = new StringRequest(Method.POST, servletPath,
				listener, errorlistener) {

			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				// TODO Auto-generated method stub
				return map;
			}
		};
		queue.add(request);

	}

}
