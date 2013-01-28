package at.mg.androidfeatures.activities.newdesign;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import at.mg.androidfeatures.R;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class TabHostTest extends SherlockFragmentActivity {
	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_tabs);
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
				TestFragment.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("contacts")
				.setIndicator("Contacts"),
 TestFragment.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("custom").setIndicator("Custom"),
				TestFragment.class, null);
		// mTabHost.addTab(mTabHost.newTabSpec("throttle")
		// .setIndicator("Throttle"),
		// LoaderThrottleSupport.ThrottledLoaderListFragment.class, null);
	}
}
