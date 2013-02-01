package at.mg.androidfeatures.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.view.View;
import at.mg.androidfeatures.R;
import at.mg.androidfeatures.activities.newdesign.NDHome;
import at.mg.androidfeatures.activities.newdesign.TabHostTest;
import at.mg.androidfeatures.activities.newdesign.TabIndicatorTest;
import at.mg.androidfeatures.activities.parents.AF_Activity;
import at.mg.androidfeatures.activities.viewpager.ViewPagerTest;
import at.mg.androidfeatures.util.Log;
import at.mg.androidfeatures.views.NormalDialog;
import at.mg.androidfeatures.views.NoticeDialog;

public class MainActivity extends AF_Activity implements NoticeDialog.NoticeDialogListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        
        
        setContentView(R.layout.activity_main);
    }
    
    private void formatString(){
    	//this string can not be formated
    	String rString = getString(R.string.stop_message);
    	Log.i(rString);
    	
    	//a formatable string
    	String fString = getString(R.string.stop_message_format);
    	String formatString = String.format(fString, " text too much");
    	CharSequence styledString = Html.fromHtml(formatString);
    	Log.i(styledString);
    	
    	//plurals
    	String unicorns = getResources().getQuantityString(R.plurals.unicornCount, 1,1);
    	Log.i(unicorns);
    	unicorns = getResources().getQuantityString(R.plurals.unicornCount, 2,2);
    	Log.i(unicorns);
    	unicorns = getResources().getQuantityString(R.plurals.unicornCount, 0, "f", "g");
    	Log.i(unicorns);
    }
    
    
    
    public void showNormalDialog(View v){
    	NormalDialog nd = new NormalDialog();
    	nd.show(getSupportFragmentManager(), "NormalDialog");
    }
    

    public void showNoticeDialog(View v){
    	NoticeDialog nd = NoticeDialog.newInstance(this);
    	nd.show(getSupportFragmentManager(), "NoticeDialog");
    }

	@Override
	public void onDialogPositiveClick(DialogFragment dialog) {
		Log.i("notice positive clicked");
	}

	@Override
	public void onDialogNegativeClick(DialogFragment dialog) {
		Log.i("notice negative clicked");
	}
	
	public void gstestClick(View v){
		startActivity(new Intent(this, GoogleServiceTest.class));
	}

	public void viewpagerClick(View v) {
		startActivity(new Intent(this, ViewPagerTest.class));
	}

	public void gridtestClick(View v) {
		startActivity(new Intent(this, GridLayoutActivity.class));
	}

	public void ndClick(View v) {
		startActivity(new Intent(this, NDHome.class));
	}

	public void tabhostClick(View v) {
		startActivity(new Intent(this, TabHostTest.class));
	}

	public void tabindiClick(View v) {
		startActivity(new Intent(this, TabIndicatorTest.class));
	}
    
}
