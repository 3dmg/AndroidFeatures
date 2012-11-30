package at.mg.androidfeatures.activities.newdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import at.mg.androidfeatures.R;
import at.mg.androidfeatures.util.Log;
import at.mg.androidfeatures.views.NoticeDialog.NoticeDialogListener;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.MenuItem;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

public class NDHome extends SlidingFragmentActivity implements NoticeDialogListener {

	@Override
	public void onCreate(Bundle arg0) {
		super.onCreate(arg0);

		setContentView(R.layout.activity_ndhome);

		ActionBar ab = this.getSupportActionBar();
		ab.setDisplayHomeAsUpEnabled(true);

		setBehindContentView(R.layout.slidingmenu);

		TextView tv = (TextView) findViewById(R.id.slidemenu_profile);
		if(tv != null){
			tv.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					startActivity(new Intent(NDHome.this, NDProfile.class));
					showContent();
				}
			});
		} else {
			Log.i("TV NULL");
		}

		SlidingMenu sm = getSlidingMenu();

		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm.setBehindOffset(200);

		setSlidingActionBarEnabled(false);
	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {

		getSupportMenuInflater().inflate(R.menu.activity_ndhome, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		case R.id.menu_info:
			// showNoticeDialog();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// private void showNoticeDialog() {
	// NoticeDialog nd = NoticeDialog.newInstance(this);
	// nd.show(getSupportFragmentManager(), "NoticeDialog");
	// }

	@Override
	public void onDialogPositiveClick(DialogFragment dialog) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDialogNegativeClick(DialogFragment dialog) {
		// TODO Auto-generated method stub

	}
}
