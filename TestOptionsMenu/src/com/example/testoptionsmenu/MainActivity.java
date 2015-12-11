package com.example.testoptionsmenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	
	 /** @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * 
	 * // 创建选项菜单 // (1)动态设置 // (2)通过xml设置MenuInflater.inflate();
	 * 
	 * // 设置菜单项点击事件：onOptionsItemSelected();
	 * 
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 
*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		//menu.add(groupId, itemId, order, title):返回值是MenuItem
		
		//(2)动态设置
		MenuItem menuItem = menu.add(1, 100, 1, "菜单一");
		menuItem.setTitle("Menu一");
		menuItem.setIcon(R.drawable.ic_launcher);  //API>=11时不显示图标
		
		menu.add(1, 101, 2, "菜单二");
		menu.add(1, 102, 3, "菜单三");
		menu.add(1, 103, 4, "菜单四");
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case 100:
			Intent intent=new Intent(MainActivity.this,Menu1.class);
			item.setIntent(intent);     //点击后跳转页面
			Toast.makeText(this, "点击了菜单项一", Toast.LENGTH_SHORT).show();
			break;
		case 101:
			Toast.makeText(this, "点击了菜单项二", Toast.LENGTH_SHORT).show();
			break;
		case 102:
			Toast.makeText(this, "点击了菜单项三", Toast.LENGTH_SHORT).show();
			break;
		case 103:
			Toast.makeText(this, "点击了菜单项四", Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
