package com.bluestar.utils;

import android.util.Log;

/**
 * Logͳһ������
 * 
 * @author pxh
 * @create 2015-5-20
 * @version
 */
public class L {

	private L() {
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	public static int LOG_LEVEL = Log.VERBOSE;
	public static boolean isDebug = true;// �Ƿ���Ҫ��ӡbug��������application��onCreate���������ʼ��
	private static final String TAG = "main";

	// �����ĸ���Ĭ��tag�ĺ���
	public static void i(String msg) {
		if (isDebug)
			Log.i(TAG, msg);
	}

	public static void d(String msg) {
		if (isDebug)
			Log.d(TAG, msg);
	}

	public static void e(String msg) {
		if (isDebug)
			Log.e(TAG, msg);
	}

	public static void v(String msg) {
		if (isDebug)
			Log.v(TAG, msg);
	}

	public static void w(String msg) {
		if (isDebug)
			Log.w(TAG, msg);
	}

	// �����Ǵ����Զ���tag�ĺ���
	public static void i(String tag, String msg) {
		if (isDebug)
			Log.i(tag, msg);
	}

	public static void d(String tag, String msg) {
		if (isDebug)
			Log.d(tag, msg);
	}

	public static void e(String tag, String msg) {
		if (isDebug)
			Log.e(tag, msg);
	}

	public static void v(String tag, String msg) {
		if (isDebug)
			Log.v(tag, msg);
	}

	public static void w(String tag, String msg) {
		if (isDebug)
			Log.w(tag, msg);
	}

	/**
	 * ���ط��������ڴ�ӡ�쳣��Ϣ
	 * 
	 * @param tag
	 * @param ex
	 */
	public static void e(String tag, Exception ex) {
		if (LOG_LEVEL <= Log.ERROR) {
			StringBuilder sb = new StringBuilder();
			String name = getFunctionInfo();

			if (name != null) {
				sb.append(name + "-" + ex + "\r\n");
			} else {
				sb.append(ex + "\r\n");
			}

			StackTraceElement[] stackTrace = ex.getStackTrace();
			if (stackTrace != null && stackTrace.length > 0) {
				for (StackTraceElement trace : stackTrace) {
					if (trace != null) {
						sb.append("[" + trace.getFileName() + ": "
								+ trace.getLineNumber() + "]");
					}
				}
			}

			Log.e(tag, sb.toString());
		}
	}

	private static String getFunctionInfo() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

		if (stackTrace == null) {
			return null;
		}

		for (StackTraceElement track : stackTrace) {
			if (track.isNativeMethod()) {
				continue;
			}

			if (track.getClassName().equals(Thread.class.getName())) {
				continue;
			}

			if (track.getClassName().equals(L.class.getName())) {
				continue;
			}

			return "[" + Thread.currentThread().getId() + ": "
					+ track.getFileName() + ": " + track.getLineNumber() + "]";
		}
		return null;
	}
}