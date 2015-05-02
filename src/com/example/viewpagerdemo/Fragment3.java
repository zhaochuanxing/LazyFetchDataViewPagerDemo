package com.example.viewpagerdemo;

import android.view.View;
import android.widget.TextView;

public class Fragment3 extends BaseViewPagerFragement {

	private TextView mTvData;
	private long mData;

	@Override
	protected int getFragmentLayoutId() {
		return R.layout.fragment3;
	}

	@Override
	protected void setupView(View view) {
		super.setupView(view);

		mTvData = (TextView) view.findViewById(R.id.data);
		mTvData.setText("" + mData);
	}

	@Override
	protected void lazyFetchData() {
		super.lazyFetchData();

		mData = System.currentTimeMillis();
		mTvData.setText("" + mData);
	}
}
