package at.mg.androidfeatures.activities.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import at.mg.androidfeatures.activities.parents.AF_Activity;
import at.mg.androidfeatures.util.Helpers;
import at.mg.androidfeatures.util.Log;

/**
 * testing the viewpager
 * 
 * http://www.androidzeitgeist.com/2012/10/examining-viewpager-14.html
 * 
 * @author User
 * 
 */

public class ViewPagerTest extends AF_Activity {

	private ViewPager viewPager;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		viewPager = new ViewPager(this);
		// has to be set for the fragment
		viewPager.setId(2);

		// how much pages should be preloaded to the left and right of the
		// current viewed page
		viewPager.setOffscreenPageLimit(2);

		viewPager.setAdapter(new TabsAdapter(getSupportFragmentManager()));

		viewPager.setOnPageChangeListener(new ViewPageChangeChecker());

		viewPager.setPageMargin((int) Helpers.getPxFromDIP(getResources(), 20));

		viewPager.setCurrentItem(1, true);

		setContentView(viewPager);


	}


	/**
	 * pager adapter for the viewpager this will save all shown fragments in the
	 * memory FragmentStatePagerAdapter will destroy the fragments, which are
	 * not visible
	 */
	public static class TabsAdapter extends FragmentPagerAdapter {

		private static final int COLORS[] = { 0xFFFF0000, 0xFF00FF00, 0xFF0000FF, 0xFFFF00FF, 0xFFFFFF00 };

		public TabsAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
		}

		@Override
		public Fragment getItem(int position) {
			Log.i("TabsAdapter:getItem " + position);
			ContentFragment fragment = new ContentFragment();

			fragment.setColor(COLORS[position]);
			fragment.setPosition(position);

			return fragment;
		}

		@Override
		public int getCount() {
			return COLORS.length;
		}
	}

	public static class ViewPageChangeChecker extends SimpleOnPageChangeListener {

		@Override
		public void onPageSelected(int position) {
			super.onPageSelected(position);
			Log.i("ViewPageChangeChecker:onPageSelected " + position);
		}

		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			super.onPageScrolled(position, positionOffset, positionOffsetPixels);
			Log.i("ViewPageChangeChecker:onPageScrolled " + position + " " + positionOffset + " " + positionOffsetPixels);
		}

		@Override
		public void onPageScrollStateChanged(int state) {
			super.onPageScrollStateChanged(state);
			switch (state) {
			case ViewPager.SCROLL_STATE_DRAGGING:
				Log.i("Indicates that the pager is currently being dragged by the user");
				break;
			case ViewPager.SCROLL_STATE_IDLE:
				Log.i("Indicates that the pager is in an idle, settled state");
				break;
			case ViewPager.SCROLL_STATE_SETTLING:
				Log.i("Indicates that the pager is in the process of settling to a final position");
				break;
			default:
				Log.i("unknown state!");
			}
		}
	}
}
