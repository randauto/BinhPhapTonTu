package com.vinilearning.tangai;

import android.app.Application;

import com.vinilearning.tangai.utils.T;

public class TanGaiApplication extends Application {
	public static final boolean isDebug = true;

	@Override
	public void onCreate() {
		super.onCreate();
		T.init(this);
	}

}
