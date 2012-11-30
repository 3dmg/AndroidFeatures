package at.mg.androidfeatures.views;

import android.app.Activity;
import android.support.v4.app.DialogFragment;

public class NoticeDialog extends DialogFragment {

	/*
	 * The activity that creates an instance of this dialog fragment must
	 * implement this interface in order to receive event callbacks. Each method
	 * passes the DialogFragment in case the host needs to query it.
	 */
	public interface NoticeDialogListener {
		public void onDialogPositiveClick(DialogFragment dialog);

		public void onDialogNegativeClick(DialogFragment dialog);
	}

	// Use this instance of the interface to deliver action events
	static NoticeDialogListener mListener;

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
			throw new ClassCastException(activity.toString()
					+ " must implement NoticeDialogListener");
		}
		NoticeDialog frag = new NoticeDialog();

		return frag;
	}

}
