package at.mg.androidfeatures.activities.viewpager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import at.mg.androidfeatures.framents.AF_Fragment;
import at.mg.androidfeatures.util.Log;

public class ContentFragment extends AF_Fragment {

	private int color;
	private int position;

	public void setColor(int color) {
		Log.i("ContentFragment:setColor " + color);
		this.color = color;
	}

	public void setPosition(int position) {
		Log.i("ContentFragment:setPosition " + position);
		this.position = position;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.i("ContentFragment:onCreateView");
		TextView view = new TextView(container.getContext());

		view.setText(String.valueOf(position));
		view.setTextSize(32);
		view.setGravity(Gravity.CENTER);
		view.setBackgroundColor(color);

		return view;
	}
}
