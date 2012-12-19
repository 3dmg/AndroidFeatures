package at.mg.androidfeatures.framents;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import at.mg.androidfeatures.util.Log;

public class AF_Fragment extends Fragment {
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d("Fragment:onAttach " + this.getClass().getSimpleName());
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Fragment:onCreate " + savedInstanceState + " " + this.getClass().getSimpleName());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d("Fragment:onCreateView " + savedInstanceState + " " + this.getClass().getSimpleName());
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.d("Fragment:onActivityCreated " + savedInstanceState + " " + this.getClass().getSimpleName());
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d("Fragment:onStart " + this.getClass().getSimpleName());
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.d("Fragment:onStop " + this.getClass().getSimpleName());
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d("Fragment:onResume " + this.getClass().getSimpleName());
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d("Fragment:onPause " + this.getClass().getSimpleName());
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.d("Fragment:onSaveInstanceState " + this.getClass().getSimpleName());
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.d("Fragment:onDestroyView " + this.getClass().getSimpleName());
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("Fragment:onDestroy " + this.getClass().getSimpleName());
	}

	@Override
	public void onDetach() {
		super.onDetach();
		Log.d("Fragment:onDetach " + this.getClass().getSimpleName());
	}

}
