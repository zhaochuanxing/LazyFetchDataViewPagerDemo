package com.example.viewpagerdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseViewPagerFragement extends BaseFragment {

	private View mReuseView;

	private boolean hasFetchData;

	protected boolean isViewPrepared;

	protected abstract int getFragmentLayoutId();

	@Override
	protected View getFragmentView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {

		if (null == mReuseView) {
			mReuseView = inflater.inflate(getFragmentLayoutId(), container,
					false);
		}

		return mReuseView;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		if (mReuseView != null) {
			((ViewGroup) mReuseView.getParent()).removeView(mReuseView);
		}
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);

		if (isVisibleToUser) {
			lazyFetchDataIfPrepared();
		}
	}

	/**
	 * 懒加载的方式获取数据
	 */
	private void lazyFetchDataIfPrepared() {
		if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
			//用户可见fragment && 没有加载过数据 && 视图已经准备完毕
			lazyFetchData();
			hasFetchData = true;
		}
	}

	/**
	 * 懒加载的方式获取数据，仅在满足fragment可见和视图已经准备好的时候调用一次
	 */
	protected void lazyFetchData() {
		Log.i(LOG_TAG, getClass().getName() + "------>lazyfetchData ");
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		isViewPrepared = true;

		lazyFetchDataIfPrepared();
	}

}
