package at.mg.androidfeatures.activities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import at.mg.androidfeatures.R;
import at.mg.androidfeatures.util.Log;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.AccountPicker;

public class GoogleServiceTest extends Activity {

	protected static final String NOTIFICATION_TAG = "sync";
	protected static final int NOTIFICATION_ID = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gstest);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_gstest, menu);
		return true;
	}

	public void startTest(View v) {
		Intent intent = AccountPicker.newChooseAccountIntent(null, null,
				new String[] { "com.google" }, false, null, null, null, null);
		startActivityForResult(intent, 123);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 123) {
			String accountName = data
					.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
			Log.i(accountName);
			new AuthTask().execute(accountName);
		}

	}

	private class AuthTask extends AsyncTask<String, Integer, Long> {
		@Override
		protected Long doInBackground(String... params) {
			String mail = params[0];
			try {
				String token = GoogleAuthUtil
						.getToken(GoogleServiceTest.this, mail,
								"oauth2:https://www.googleapis.com/auth/userinfo.profile");
				Log.i("token: " + token);
				URL url = new URL(
						"https://www.googleapis.com/oauth2/v1/userinfo?access_token="
								+ token);
				HttpURLConnection con = (HttpURLConnection) url
						.openConnection();
				int serverCode = con.getResponseCode();
				Log.i(serverCode + "");
				if (serverCode == 200) {
					StringBuilder sb = new StringBuilder();
			        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			        for (String line; null != (line = reader.readLine());) {
			            sb.append(line);
			        }
			        String output = sb.toString();
			        Log.i(output);
			        JSONObject json = new JSONObject(output);
			        String id = json.getString("id");
			        Log.i(id);
//			        JSONArray venues = json.getJSONObject("response").getJSONArray("groups").getJSONObject(0).getJSONArray("items");
//			        System.out.println(venues.length());
				}
			} catch (UserRecoverableAuthException userRecoverableException) {
				startActivityForResult(userRecoverableException.getIntent(), 123);
//				handleAuthError(mail, userRecoverableException.getIntent());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}

//	public void handleAuthError(String accountName, Intent intent) {
//		final Context context = getContext();
//		/*
//		 * Create an intent to start AuthNotificationActivity. This will be used
//		 * as a PendingIntent when creating the notification.
//		 */
//		final Intent trampolineIntent = new Intent(context,
//				AuthNotificationActivity.class);
//
//		/*
//		 * Inside this intent, embed the intent obtained from
//		 * UserRecoverableAuthException.getIntent() as well as the user's
//		 * account name (email) as extras. When AuthNotificationActivity is
//		 * launched it can use these extras to display the appropriate dialog to
//		 * the user to recover from the authentication error
//		 */
//		trampolineIntent.putExtra(
//				AuthNotificationActivity.NOTIFICATION_INTENT_EXTRA_INTENT,
//				intent);
//		trampolineIntent
//				.putExtra(
//						AuthNotificationActivity.NOTIFICATION_INTENT_EXTRA_ACCOUNT_NAME,
//						accountName);
//
//		final String tag;
//		final String title;
//		final String text;
//		final android.content.res.Resources resources = context.getResources();
//		if (accountName != null) {
//			tag = NOTIFICATION_TAG + "." + accountName;
//			trampolineIntent.addCategory(tag);
//			title = resources
//					.getString(Resources.string.auth_notification_title_account);
//			text = resources.getString(
//					Resources.string.auth_notification_text_account,
//					accountName);
//		} else {
//			tag = NOTIFICATION_TAG;
//			title = resources
//					.getString(Resources.string.auth_notification_title);
//			text = resources.getString(Resources.string.auth_notification_text);
//		}
//
//		/*
//		 * Create the notification specifying the intent to use to start the
//		 * activity as a PendingIntent and show the notification.
//		 */
//		final Notification notification = new Notification.Builder(context)
//				.setSmallIcon(R.drawable.stat_sys_warning)
//				.setLargeIcon(
//						BitmapFactory.decodeResource(resources,
//								Resources.drawable.app_icon))
//				.setAutoCancel(true)
//				.setContentTitle(title)
//				.setContentText(text)
//				.setContentIntent(
//						PendingIntent.getActivity(context, 0 /* requestCode */,
//								trampolineIntent,
//								PendingIntent.FLAG_CANCEL_CURRENT))
//				.getNotification();
//		final NotificationManager manager = (NotificationManager) context
//				.getSystemService(Context.NOTIFICATION_SERVICE);
//		manager.notify(tag, NOTIFICATION_ID, notification);
//	}

}
