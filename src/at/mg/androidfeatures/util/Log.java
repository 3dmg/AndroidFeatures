package at.mg.androidfeatures.util;

import at.mg.androidfeatures.Configuration;

public class Log {

	public static void d(Object obj) {
		android.util.Log.d(getTag(), String.valueOf(obj));
	}

	public static void i(Object obj) {
		android.util.Log.i(getTag(), String.valueOf(obj));
	}

	public static void w(Object obj) {
		android.util.Log.w(getTag(), String.valueOf(obj));
	}

	public static void e(Object obj, Throwable e) {
		android.util.Log.e(getTag(), String.valueOf(obj));
		e.printStackTrace();
		// ErrorReporter.getInstance().handleException(e);
	}

	private static String getTag() {
		StackTraceElement caller = Thread.currentThread().getStackTrace()[4];
		String tag = caller.getClassName();
		if (Configuration.DEV_MODE) {
			tag += ", " + caller.getMethodName() + "()";
		}
		return tag;
	}

	private Log() {
	}

}
