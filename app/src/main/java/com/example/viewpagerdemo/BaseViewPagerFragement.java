package com.example.viewpagerdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public abstract class BaseViewPagerFragement extends BaseFragment {

	private boolean isViewPrepared; // 标识fragment视图已经初始化完毕
	private boolean hasFetchData; // 标识已经触发过懒加载数据

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		// view被销毁后，将可以重新触发数据懒加载，因为在viewpager下，fragment不会再次新建并走onCreate的生命周期流程，将从onCreateView开始
		hasFetchData = false;
		isViewPrepared = false;
	}

	@Override
	protected void setup(View view) {
		super.setup(view);
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		Log.v(TAG, getClass().getName() + "------>isVisibleToUser = " + isVisibleToUser);
		if (isVisibleToUser) {
			lazyFetchDataIfPrepared();
		}
	}

	/**
	 * 懒加载的方式获取数据，仅在满足fragment可见和视图已经准备好的时候调用一次
	 */
	protected void lazyFetchData() {
		Log.v(TAG, getClass().getName() + "------>lazyFetchData");
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		isViewPrepared = true;

		lazyFetchDataIfPrepared();
	}

	private void lazyFetchDataIfPrepared() {
		// 用户可见fragment && 没有加载过数据 && 视图已经准备完毕
		if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
			hasFetchData = true;
			lazyFetchData();
		}

	}

}
