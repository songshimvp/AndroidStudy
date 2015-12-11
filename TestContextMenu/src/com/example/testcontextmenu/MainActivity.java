package com.example.testcontextmenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView listView;
	private SimpleAdapter simpleAdapter;
	private List<Map<String, Object>> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView);

		data = new ArrayList<Map<String, Object>>();
		simpleAdapter = new SimpleAdapter(this, getData(), R.layout.item,
				new String[] { "image", "text" }, new int[] { R.id.imageView,
						R.id.textView });

		listView.setAdapter(simpleAdapter);

		// 为ListVIew注册上下文菜单
		this.registerForContextMenu(listView);
	}

	private List<Map<String, Object>> getData() {
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("image", R.drawable.calendar);
		map1.put("text", "日历");
		data.add(map1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("image", R.drawable.camera);
		map2.put("text", "照相机");
		data.add(map2);
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("image", R.drawable.clock);
		map3.put("text", "时钟");
		data.add(map3);
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("image", R.drawable.games_control);
		map4.put("text", "游戏");
		data.add(map4);
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("image", R.drawable.world);
		map5.put("text", "地图");
		data.add(map5);

		return data;
	}

	//选项菜单
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	

	// 重写上下文菜单
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.setHeaderTitle("应用程序扩展操作");
		menu.setHeaderIcon(R.drawable.ic_launcher);
		
		//动态添加菜单项
		//menu.add(1, 100, 1, "粘贴");
		//menu.add(1, 101, 1, "复制");
		//menu.add(1, 102, 1, "剪切");
		//menu.add(1, 103, 1, "重命名");
		
		//通过XML加载菜单项
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.main_context, menu);
	}

	// 设置上下文菜单的点击事件
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		/*switch (item.getItemId()) {
		case 100:
			Toast.makeText(MainActivity.this, "点击了粘贴", Toast.LENGTH_SHORT).show();
			break;

		case 101:
			Toast.makeText(MainActivity.this, "点击了复制", Toast.LENGTH_SHORT).show();

			break;
		case 102:
			Toast.makeText(MainActivity.this, "点击了剪切", Toast.LENGTH_SHORT).show();

			break;
		case 103:
			Toast.makeText(MainActivity.this, "点击了重命名", Toast.LENGTH_SHORT).show();

			break;
		}*/
		
		switch (item.getItemId()) {
		case R.id.action_settings1:
			Toast.makeText(MainActivity.this, "点击了粘贴", Toast.LENGTH_SHORT).show();
			break;

		case R.id.action_settings2:
			Toast.makeText(MainActivity.this, "点击了复制", Toast.LENGTH_SHORT).show();

			break;
		case R.id.action_settings3:
			Toast.makeText(MainActivity.this, "点击了剪切", Toast.LENGTH_SHORT).show();

			break;
		case R.id.action_settings4:
			Toast.makeText(MainActivity.this, "点击了重命名", Toast.LENGTH_SHORT).show();

			break;
		}
		return super.onContextItemSelected(item);

	}
}
