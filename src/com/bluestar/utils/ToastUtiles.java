package com.bluestar.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtiles {
	public static void shortToast(Context context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
		;
	};

	public static void longToast(Context context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();
		;
	};
}
