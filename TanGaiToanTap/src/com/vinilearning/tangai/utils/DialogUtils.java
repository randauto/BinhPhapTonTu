package com.vinilearning.tangai.utils;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;

/**
 * Method used to show dialog.
 * 
 * @author TuanLQ.
 * 
 */
public class DialogUtils {
	private AlertDialog.Builder builder;

	private static DialogUtils instance;

	private Context mContext;

	public static DialogUtils getInstance(Context context) {
		if (instance == null) {
			instance = new DialogUtils(context);
		}

		return instance;
	}

	private DialogUtils(Context context) {
		this.mContext = context;
	}

	public void showOkAlertDialog(String title, String msg) {

		if (builder == null) {
			builder = new Builder(mContext);
		}

		if (!TextUtils.isEmpty(title)) {
			builder.setTitle(title);
		}

		if (!TextUtils.isEmpty(msg)) {
			builder.setMessage(msg);
		}

		builder.setPositiveButton(mContext.getString(android.R.string.ok),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});

		Dialog dialog = builder.create();
		dialog.setCancelable(true);
		dialog.show();
	}

	public void showErrorDialog(String title, String msg) {

		if (builder == null) {
			builder = new Builder(mContext);
		}

		if (!TextUtils.isEmpty(title)) {
			builder.setTitle(title);
		}

		if (!TextUtils.isEmpty(msg)) {
			builder.setMessage(msg);
		}

		builder.setIcon(android.R.drawable.ic_dialog_alert);
		builder.setPositiveButton(mContext.getString(android.R.string.ok),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});

		Dialog dialog = builder.create();
		dialog.setCancelable(true);
		dialog.show();
	}
}
