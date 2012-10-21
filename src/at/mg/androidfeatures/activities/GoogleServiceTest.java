package at.mg.androidfeatures.activities;

import java.net.HttpURLConnection;
import java.net.URL;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import at.mg.androidfeatures.R;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;

public class GoogleServiceTest extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
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
			Log.i("", accountName);
			new AuthTask().execute(accountName);
		}

	}

	private class AuthTask extends AsyncTask<String, Integer, Long> {
		@Override
		protected Long doInBackground(String... params) {
			try {
				String token = GoogleAuthUtil
						.getToken(GoogleServiceTest.this, params[0],
								"oauth2:https://www.googleapis.com/auth/userinfo.profile");
				Log.i("", "token: " + token);
				URL url = new URL(
						"https://www.googleapis.com/oauth2/v1/userinfo?access_token="
								+ token);
				HttpURLConnection con = (HttpURLConnection) url
						.openConnection();
				int serverCode = con.getResponseCode();
				Log.i("", serverCode + "");
				if (serverCode == 200) {

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}

}
