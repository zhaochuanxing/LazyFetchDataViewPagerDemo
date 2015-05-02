package com.example.viewpagerdemo;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.github.androidprogresslayout.ProgressLayout;

public class Fragment1 extends BaseViewPagerFragement {

	private TextView mTvData;
	private long mData;
	private ProgressLayout progressLayout;

	@Override
	protected int getFragmentLayoutId() {
		return R.layout.fragment1;
	}

	@Override
	protected void setupView(View view) {
		super.setupView(view);

		mTvData = (TextView) view.findViewById(R.id.data);
		progressLayout = (ProgressLayout) view.findViewById(R.id.progress);
	}

	@Override
	protected void lazyFetchData() {
		super.lazyFetchData();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				mData = System.currentTimeMillis();
				mTvData.setText("" + mData);

				progressLayout.showContent();
			}
		}, 2000);

	}

}
