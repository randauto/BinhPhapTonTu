package com.vinilearning.tangai.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.vinilearning.tangai.R;
import com.vinilearning.tangai.activity.MainActivity;
import com.vinilearning.tangai.utils.L;

/**
 * Show details.
 */
@SuppressLint("SetJavaScriptEnabled")
public class PlaceholderFragment extends Fragment {
	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static PlaceholderFragment newInstance(int sectionNumber) {
		PlaceholderFragment fragment = new PlaceholderFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		WebView webView = (WebView) rootView.findViewById(R.id.webView);
		String fileName = ((MainActivity) getActivity()).getRight()[getArguments()
				.getInt(ARG_SECTION_NUMBER)];
		L.i("File Name: " + fileName);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setInitialScale(1);
		webView.loadUrl("file:///android_asset/web/" + fileName);
		webView.setBackgroundColor(0x00000000);
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(getArguments().getInt(
				ARG_SECTION_NUMBER));
	}
}
