package at.mg.androidfeatures.activities.newdesign;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import at.mg.androidfeatures.R;
import at.mg.androidfeatures.util.Helpers;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Window;
import com.viewpagerindicator.IconPagerAdapter;
import com.viewpagerindicator.TitlePageIndicator;

public class NDProfile extends SherlockFragmentActivity {

	ViewPager mViewPager;
	TestFragmentAdapter mTabsAdapter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// This has to be called before setContentView and you must use the
		// class in com.actionbarsherlock.view and NOT android.view
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

		setContentView(R.layout.activity_profile);

		mViewPager = (ViewPager) findViewById(R.id.profile_viewpager);
		mViewPager.setPageMargin((int) Helpers.getPxFromDIP(getResources(), 10));

		mTabsAdapter = new TestFragmentAdapter(getSupportFragmentManager());
		// call this before the titleindicator
		mViewPager.setAdapter(mTabsAdapter);

		TitlePageIndicator titleIndicator = (TitlePageIndicator) findViewById(R.id.titles);
		// titleIndicator.setFooterIndicatorStyle(IndicatorStyle.Triangle);
		titleIndicator.setViewPager(mViewPager);

		ActionBar bar = getSupportActionBar();
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setDisplayShowHomeEnabled(true);
		bar.setDisplayShowTitleEnabled(false);
		bar.setIcon(R.drawable.ic_chat_quatscha);

		setSupportProgressBarIndeterminateVisibility(true);
		// bar.setTitle("Profil");

		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		// Add, remove or replace fragments
		ft.commit();

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	class TestFragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
		final String[] CONTENT = new String[] { "Profil", "Galerie", "Live", "Ansehen", };


		private int mCount = CONTENT.length;

		public TestFragmentAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
		}

		@Override
		public int getCount() {
			return mCount;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return CONTENT[position % CONTENT.length];
		}

		public void setCount(int count) {
			if (count > 0 && count <= 10) {
				mCount = count;
				notifyDataSetChanged();
			}
		}

		@Override
		public int getIconResId(int index) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}
