package at.mg.androidfeatures.activities.parents;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import at.mg.androidfeatures.Configuration;
import at.mg.androidfeatures.util.Log;

public class AF_Activity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("onCreate " + this.getClass().getSimpleName());
		
		if (Configuration.DEV_MODE) {
			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
					.detectAll().penaltyLog().build());
			StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
					.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
					.build());
		}
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.d("onRestoreInstanceState " + this.getClass().getSimpleName());
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.d("onStart " + this.getClass().getSimpleName());
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.d("onResume " + this.getClass().getSimpleName());
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.d("onPause " + this.getClass().getSimpleName());
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.d("onSaveInstanceState " + this.getClass().getSimpleName());
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("onStop " + this.getClass().getSimpleName());
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("onDestroy " + this.getClass().getSimpleName());
	}
}
