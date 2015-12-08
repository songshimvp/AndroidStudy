package com.example.testviewpager;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter {

	private List<View> viewList;
	private List<String> titleList;

	public MyPagerAdapter(List<View> viewList, List<String> titleList) {
		this.viewList = viewList;
		this.titleList = titleList;
	}

	// 返回的是页卡的数量
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return viewList.size();
	}

	// View是否来自与对象
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	// 实例化一个页卡
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(viewList.get(position));
		return viewList.get(position);
	}

	// 销毁页卡
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {

		container.removeView(viewList.get(position));
	}
	
	//设置ViewPager页卡的标题
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return titleList.get(position);
	}
}
