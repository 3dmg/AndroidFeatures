package at.mg.androidfeatures.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;

import com.actionbarsherlock.R;
import com.actionbarsherlock.app.SherlockDialogFragment;

public class NoticeDialog extends SherlockDialogFragment {

	/*
	 * The activity that creates an instance of this dialog fragment must
	 * implement this interface in order to receive event callbacks. Each method
	 * passes the DialogFragment in case the host needs to query it.
	 */
	public interface NoticeDialogListener {
		public void onDialogPositiveClick(DialogFragment dialog);

		public void onDialogNegativeClick(DialogFragment dialog);
	}

	private EditText mEditText;

	// Use this instance of the interface to deliver action events
	static NoticeDialogListener mListener;

	public NoticeDialog() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_Sherlock_Dialog);
	}

	/*
	 * Call this to instantiate a new NoticeDialog.
	 * 
	 * @param activity The activity hosting the dialog, which must implement the
	 * NoticeDialogListener to receive event callbacks.
	 * 
	 * @returns A new instance of NoticeDialog.
	 * 
	 * @throws ClassCastException if the host activity does not implement
	 * NoticeDialogListener
	 */
	public static NoticeDialog newInstance(Activity activity) {
		// Verify that the host activity implements the callback interface
		try {
			// Instantiate the NoticeDialogListener so we can send events with
			// it
			mListener = (NoticeDialogListener) activity;
		} catch (ClassCastException e) {
			// The activity doesn't implement the interface, throw exception
			throw new ClassCastException(activity.toString() + " must implement NoticeDialogListener");
		}
		NoticeDialog frag = new NoticeDialog();

		return frag;
	}

	// @Override
	// public View onCreateView(LayoutInflater inflater, ViewGroup container,
	// Bundle savedInstanceState) {
	// View view =
	// inflater.inflate(at.mg.androidfeatures.R.layout.fragment_edit_name,
	// container);
	// getDialog().setTitle("Hello");
	//
	// return view;
	// }

	// @Override
	// public Dialog onCreateDialog(Bundle savedInstanceState) {
	// View view =
	// getActivity().getLayoutInflater().inflate(at.mg.androidfeatures.R.layout.fragment_edit_name,
	// null);
	// return new AlertDialog.Builder(new ContextThemeWrapper(getActivity(),
	// at.mg.androidfeatures.R.style.AlertDialogCustom)).setTitle("Hallo")
	// .setView(view)
	// .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	// public void onClick(DialogInterface dialog, int whichButton) {
	// mListener.onDialogPositiveClick(NoticeDialog.this);
	// }
	// }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	//
	// @Override
	// public void onClick(DialogInterface dialog, int which) {
	// mListener.onDialogNegativeClick(NoticeDialog.this);
	//
	// }
	// }).setNeutralButton("Puh", null).create();
	// }

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {


		return new AlertDialog.Builder(getActivity()).setTitle("title")
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {

					}
				}).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {

					}
				}).create();
	}

}
