package com.example.testgridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener{

	private GridView gridView;
	private List<Map<String, Object>> dataList;
	private int[] icon = { R.drawable.a, R.drawable.b, R.drawable.c,
			R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.erttre,
			R.drawable.erwrw, R.drawable.lanqiu, R.drawable.niubi,
			R.drawable.psb, R.drawable.qqq };
	private String[] iconName = { "格1", "格2", "格3", "格4", "格5", "格6", "格7",
			"格8", "格9", "格10", "格11", "格12", };
	private SimpleAdapter simpleAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		gridView = (GridView) findViewById(R.id.gridView);

		// 1、准备数据源
		// 2、新建适配器
		// 3、GridView加载适配器
		// 4、GridView配置时间监听器（OnItemClickListenter）
		dataList = new ArrayList<Map<String, Object>>();
		//getData();
		simpleAdapter = new SimpleAdapter(this, getData(),
				R.layout.gridview_item, new String[] { "image", "text" },
				new int[] { R.id.image, R.id.text });
		gridView.setAdapter(simpleAdapter);
		
		gridView.setOnItemClickListener(this);
	}

	private List<Map<String, Object>> getData() {
		// TODO Auto-generated method stub
		for (int i = 0; i < icon.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", icon[i]);
			map.put("text", iconName[i]);
			
			dataList.add(map);
		}
		return dataList;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "我是"+iconName[position], Toast.LENGTH_LONG).show();
	}

}
