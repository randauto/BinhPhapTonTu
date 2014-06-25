package com.vinilearning.tangai.common;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.vinilearning.tangai.R;

public class BaseActivity extends Activity {
	protected AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Create an ad.
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				adView = (AdView) findViewById(R.id.adView);
				AdRequest adRequest = new AdRequest.Builder().build();
				adView.loadAd(adRequest);
			}
		}, 1000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
