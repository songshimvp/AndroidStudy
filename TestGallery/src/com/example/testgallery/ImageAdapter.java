package com.example.testgallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ImageAdapter extends BaseAdapter {

	private int[] res;
	private Context context;
	public ImageAdapter(int[] res,Context context) {
		super();
		this.res = res;
		this.context=context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;     //以便“无限”循环显示（一般情况下滚动不到这个最大值）
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return res[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageView=new ImageView(context);
		imageView.setBackgroundResource(res[position%res.length]);  //无限“循环”显示
		imageView.setLayoutParams(new Gallery.LayoutParams(200, 150));   //
		imageView.setScaleType(ScaleType.FIT_XY);    //设置拉伸效果
		return imageView;
	}

}
