package at.mg.androidfeatures.activities.newdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import at.mg.androidfeatures.R;
import at.mg.androidfeatures.util.Log;
import at.mg.androidfeatures.views.NoticeDialog;
import at.mg.androidfeatures.views.NoticeDialog.NoticeDialogListener;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

public class NDHome extends SlidingFragmentActivity implements NoticeDialogListener {

	private Menu mainMenu;
	private SubMenu subMenu1;

	@Override
	public void onCreate(Bundle arg0) {
		super.onCreate(arg0);

		ActionBar ab = this.getSupportActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
		ab.setLogo(R.drawable.logo);
		ab.setDisplayUseLogoEnabled(true);
		ab.setDisplayShowTitleEnabled(false);

		setContentView(R.layout.activity_ndhome);


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
		sm.setBehindOffset(100);

		setSlidingActionBarEnabled(false);
	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {

		mainMenu = menu;

		subMenu1 = menu.addSubMenu("");
		subMenu1.add("Settings");
		subMenu1.add(0, 23, 0, "About");
		subMenu1.add("Help");

		MenuItem subMenu1Item = subMenu1.getItem();
		subMenu1Item.setIcon(R.drawable.ic_menu_moreoverflow_normal_holo_light);
		subMenu1Item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		return super.onCreateOptionsMenu(menu);

		// getSupportMenuInflater().inflate(R.menu.activity_ndhome, menu);
		// return true;
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			mainMenu.performIdentifierAction(subMenu1.getItem().getItemId(), 0);
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		case R.id.menu_info:

			return true;
		case 23:
			showNoticeDialog();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void showNoticeDialog() {
		NoticeDialog nd = NoticeDialog.newInstance(this);
		nd.show(getSupportFragmentManager(), "fragment_edit_name");
	}

	@Override
	public void onDialogPositiveClick(DialogFragment dialog) {
		Toast.makeText(this, "pos clicked", Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onDialogNegativeClick(DialogFragment dialog) {
		Toast.makeText(this, "neg clicked", Toast.LENGTH_SHORT).show();

	}
}
