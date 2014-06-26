package com.vinilearning.tangai.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.vinilearning.tangai.R;
import com.vinilearning.tangai.common.BaseActivity;
import com.vinilearning.tangai.utils.T;

/**
 * 
 * @author TuanLQ.
 * 
 */
public class DashBoardActivity extends BaseActivity implements OnClickListener {
	private Button btnList, btnTonghop, btnGioiThieu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard_layout);

		initView();
	}

	private void initView() {
		btnList = (Button) findViewById(R.id.btnList);
		btnList.setOnClickListener(this);

		btnTonghop = (Button) findViewById(R.id.btnTongHop);
		btnTonghop.setOnClickListener(this);

		btnGioiThieu = (Button) findViewById(R.id.btnGioiThieu);
		btnGioiThieu.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnList:
			Intent intent = new Intent(getBaseContext(), MainActivity.class);
			startActivity(intent);
			break;

		case R.id.btnTongHop:

			break;
		case R.id.btnGioiThieu:
			break;

		default:
			break;
		}
	}

	private boolean doubleBackToExitPressedOnce = false;

	@Override
	public void onBackPressed() {
		if (doubleBackToExitPressedOnce) {
			super.onBackPressed();
			return;
		}

		this.doubleBackToExitPressedOnce = true;
		T.show(getString(R.string.press_again_exit));

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				doubleBackToExitPressedOnce = false;
			}
		}, 2000);

	}

}
