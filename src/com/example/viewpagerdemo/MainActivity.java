package com.example.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {

	private String tag = MainActivity.class.getName();

	private PagerSlidingTabStrip mTabs;
	private ViewPager mPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		mTabs.setShouldExpand(true);

		mPager = (ViewPager) findViewById(R.id.pager);

		PagerAdapter adapter = new SegmentPageAdapter(
				getSupportFragmentManager());
		mPager.setAdapter(adapter);
		mTabs.setViewPager(mPager);
	}

	private class SegmentPageAdapter extends FragmentPagerAdapter {

		private String[] title = { "F1", "f2", "f3", "f4" };

		private String[] fragments = { Fragment1.class.getName(),
				Fragment2.class.getName(), Fragment3.class.getName(),
				Fragment4.class.getName() };

		public SegmentPageAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return title[position];
		}

		@Override
		public Fragment getItem(int pos) {

			return Fragment
					.instantiate(getApplicationContext(), fragments[pos]);
		}

		@Override
		public int getCount() {
			return title.length;
		}

	}

}
