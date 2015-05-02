package com.example.viewpagerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	
	protected static final String LOG_TAG = "nnjsx";

	/**
	 * 初始化layout里的view
	 * @param view
	 */
	protected void setupView(View view) {
	}
	
	/**
	 * 获取数据，此时fragment的view已经准备完毕
	 */
	protected void fetchData() {
		Log.i(LOG_TAG, getClass().getName() + "------>fetchData");
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		Log.i(LOG_TAG, getClass().getName() + "------>onAttach");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i(LOG_TAG, getClass().getName() + "------>onCreate");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Log.i(LOG_TAG, getClass().getName() + "------>onCreateView");

		return getFragmentView(inflater, container, savedInstanceState);
	}

	protected abstract View getFragmentView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState);

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		Log.i(LOG_TAG, getClass().getName() + "------>onViewCreated");

		setupView(view);
		
		fetchData();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Log.i(LOG_TAG, getClass().getName() + "------>onActivityCreated");
	}

	@Override
	public void onStart() {
		super.onStart();

		Log.i(LOG_TAG, getClass().getName() + "------>onStart");
	}

	@Override
	public void onResume() {
		super.onResume();

		Log.i(LOG_TAG, getClass().getName() + "------>onResume");
	}

	@Override
	public void onPause() {
		super.onPause();

		Log.i(LOG_TAG, getClass().getName() + "------>onPause");
	}

	@Override
	public void onStop() {
		super.onStop();

		Log.i(LOG_TAG, getClass().getName() + "------>onStop");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		Log.i(LOG_TAG, getClass().getName() + "------>onDestroyView");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		Log.i(LOG_TAG, getClass().getName() + "------>onDestroy");
	}

	@Override
	public void onDetach() {
		super.onDetach();

		Log.i(LOG_TAG, getClass().getName() + "------>onDetach");
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);

		Log.i(LOG_TAG, getClass().getName() + "------>setUserVisibleHint : "
				+ isVisibleToUser);
	}

}
