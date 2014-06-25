package com.vinilearning.tangai.asynctask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import com.vinilearning.tangai.activity.DashBoardActivity;
import com.vinilearning.tangai.database.DatabaseFactory;
import com.vinilearning.tangai.utils.L;

public class LoadDataAsyncTask extends AsyncTask<Void, Void, Void> {
	private Activity context;

	public LoadDataAsyncTask(Activity context) {
		this.context = context;
	}

	@Override
	protected Void doInBackground(Void... params) {
		DatabaseFactory.danhsach = DatabaseFactory.getAllDanhSach(context);

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		L.i("So danh sach: " + DatabaseFactory.danhsach.size());
		Intent intent = new Intent(context, DashBoardActivity.class);
		context.startActivity(intent);
		context.finish();
	}

}
