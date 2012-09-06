package at.mg.androidfeatures;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.res.Configuration;
import at.mg.androidfeatures.util.Log;

public class MyApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("MyApp:onCreate");
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		Log.i("MyApp:onConfigurationChanged");
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		Log.i("MyApp:onLowMemory");
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
		Log.i("MyApp:onTerminate");
	}

	@TargetApi(14)
	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);
		Log.i("MyApp:onTrimMemory " + level);
	}
}
