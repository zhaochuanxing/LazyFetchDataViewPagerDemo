package com.example.viewpagerdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Fragment1 extends BaseViewPagerFragement {

	private TextView mTvData;
	private long mData;

	@Override
	protected int getFragmentLayoutId() {
		return R.layout.fragment1;
	}

	@Override
	protected void setupView(View view) {
		super.setupView(view);

		mTvData = (TextView) view.findViewById(R.id.data);

	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

	}

	@Override
	protected void lazyFetchData() {
		super.lazyFetchData();

		mData = System.currentTimeMillis();
		mTvData.setText("" + mData);
	}

}
