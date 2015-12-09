package com.example.testgallery;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnItemSelectedListener,ViewFactory{

	//准备数据源
	private int[] resIcon = { R.drawable.item1, R.drawable.item2,
			R.drawable.item3, R.drawable.item4, R.drawable.item5,
			R.drawable.item6, R.drawable.item7, R.drawable.item8,
			R.drawable.item9, R.drawable.item10, R.drawable.item11,
			R.drawable.item12 };

	private Gallery gallery;
	private ImageAdapter adapter;
	
	private ImageSwitcher imageSwitcher;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gallery=(Gallery) findViewById(R.id.gallery);
		imageSwitcher=(ImageSwitcher) findViewById(R.id.imageSwitcher);
		
		//gallery加载适配器
		adapter=new ImageAdapter(resIcon, this);
		gallery.setAdapter(adapter);
		
		//设置监听器
		gallery.setOnItemSelectedListener(this);
		
		//ImageSwitcher
		imageSwitcher.setFactory(this);
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,	android.R.anim.fade_in));
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// imageView.setBackgroundResource(res[position%res.length]);  //无限“循环”显示
		imageSwitcher.setBackgroundResource(resIcon[position%resIcon.length]);
		/*Log.v("click", "item");
		Log.i("click", "Item");
		Log.d("click", "item");
		Toast toast=Toast.makeText(this, "click", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		
		LinearLayout toast_Layout=(LinearLayout) toast.getView();
		ImageView imageView =new ImageView(this);
		imageView.setBackgroundResource(R.drawable.ic_launcher);
		toast_Layout.addView(imageView,0);*/
		
		LayoutInflater layoutInflater=LayoutInflater.from(this);
		View toast_view=layoutInflater.inflate(R.layout.toast, null);
		Toast toast=new Toast(this);
		toast.setView(toast_view);
		toast.show();
		
	}

	
	@Override
	public View makeView() {
		// TODO Auto-generated method stub
		ImageView imageView=new ImageView(this);
		imageView.setScaleType(ScaleType.FIT_CENTER);
		
		return imageView;
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

}
