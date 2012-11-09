package at.mg.androidfeatures.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.TypedValue;

public class Helpers {


	/**
	 * checks if a given intent can be called on the system
	 * 
	 * @param context
	 * @param intent
	 * @return
	 */
	public static boolean intentAvailable(Context context, Intent intent) {
		return context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).size() > 0;
	}

	/**
	 * converts dip to pixel
	 * 
	 * @param r
	 * @param dip
	 * @return
	 */
	public static float getPxFromDIP(Resources r, int dip) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, r.getDisplayMetrics());
	}

}
