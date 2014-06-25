package com.vinilearning.tangai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.vinilearning.tangai.R;
import com.vinilearning.tangai.asynctask.LoadDataAsyncTask;
import com.vinilearning.tangai.database.DatabaseFactory;

public class SplashScreen extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);

		if (DatabaseFactory.danhsach == null) {
			new LoadDataAsyncTask(SplashScreen.this).execute();
			return;
		}

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				nextMain();
			}
		}, 500);
	}

	/**
	 * Goto dashboard screen.
	 */
	private void nextMain() {
		Intent intent = new Intent(SplashScreen.this, DashBoardActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
