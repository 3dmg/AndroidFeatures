package at.mg.androidfeatures.activities;

import android.os.Bundle;
import at.mg.androidfeatures.R;
import at.mg.androidfeatures.activities.parents.AF_Activity;

public class GridLayoutActivity extends AF_Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.gridtest);
	}
}
