package com.example.pulltorefresh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

import com.example.pulltorefresh.RefreshListView.IReflashListenter;

public class MainActivity extends Activity implements IReflashListenter, OnItemClickListener {
	private RefreshListView listView;
	private int NewsIcon[] = { R.drawable.tools1, R.drawable.tools2,
			R.drawable.tools3, R.drawable.tools4, R.drawable.games1,
			R.drawable.games2, R.drawable.games3, R.drawable.games4,
			R.drawable.games5, R.drawable.games6 };
	private String NewsName[] = { "ToolsItem1", "ToolsItem2", "ToolsItem3",
			"ToolsItem4", "GamesItem1", "GamesItem2", "GamesItem3",
			"GamesItem4", "GamesItem5", "GamesItem6" };
	private SimpleAdapter adapter;
	private List<Map<String, Object>> NewsDataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (RefreshListView) findViewById(R.id.newsListView);
		listView.setInterface(this);
		NewsDataList = new ArrayList<Map<String, Object>>();
		adapter = new SimpleAdapter(this, getNewsData(),
				R.layout.news_tab_item,
				new String[] { "NewsImage", "NewsName" }, new int[] {
						R.id.newsImageViewItem, R.id.newssName });
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}
	
	

	private List<? extends Map<String, ?>> getNewsData() {
		// TODO Auto-generated method stub
		for (int i = 0; i < NewsIcon.length; i++) {
			Map<String, Object> GamesMap = new HashMap<String, Object>();
			GamesMap.put("NewsImage", NewsIcon[i]);
			GamesMap.put("NewsName", NewsName[i]);
			NewsDataList.add(GamesMap);
		}
		return NewsDataList;
	}

	//获取刷新数据
	private List<? extends Map<String, ?>> getReflashNewsData() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2; i++) {
			Map<String, Object> GamesMap = new HashMap<String, Object>();
			GamesMap.put("NewsImage", NewsIcon[i]);
			GamesMap.put("NewsName", NewsName[i]+"刷新数据"+i);
			NewsDataList.add(0,GamesMap);
		}
		return NewsDataList;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// ListView的点击事件
		
	}

	@Override
	public void onReflash() {
		// TODO Auto-generated method stub
		Handler handler=new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//获取最新数据
				getReflashNewsData();
				//通知界面显示刷新数据				
				adapter = new SimpleAdapter(MainActivity.this, NewsDataList,
						R.layout.news_tab_item,
						new String[] { "NewsImage", "NewsName" }, new int[] {
								R.id.newsImageViewItem, R.id.newssName });   //传入的是整个（新旧）NewsDataList
				listView.setAdapter(adapter);
				//通知ListView刷新数据完毕
				listView.reflashComplete();
			}
		}, 2000);//此处是为了“表面上看上去有刷新延迟的效果”，实际应用中不需要
		
	}

}
