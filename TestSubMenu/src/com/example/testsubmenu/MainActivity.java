package com.example.testsubmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		
		//动态添加子菜单项
		/*SubMenu subMenu1 = menu.addSubMenu("文件");
		SubMenu subMenu2 = menu.addSubMenu("编辑");
		
		subMenu1.setHeaderTitle("文件操作");
		subMenu1.setHeaderIcon(R.drawable.ic_launcher);
		subMenu1.add(1, 100, 1, "新建");
		subMenu1.add(1, 101, 1, "打开");
		subMenu1.add(1, 102, 1, "保存");
		subMenu1.add(1, 103, 1, "重命名");
		
		subMenu2.setHeaderTitle("编辑操作");
		subMenu2.setHeaderIcon(R.drawable.ic_launcher);
		subMenu2.add(2, 100, 1, "粘贴");
		subMenu2.add(2, 101, 1, "复制");
		subMenu2.add(2, 102, 1, "剪切");
		subMenu2.add(2, 103, 1, "重命名");*/
		
		//通过加载XML静态加载子菜单
		MenuInflater menuInflater=getMenuInflater();
		menuInflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		//动态的点击事件
		/*if (item.getGroupId()==1) {
			switch (item.getItemId()) {
			case 100:
				Toast.makeText(this, "点击了新建", Toast.LENGTH_SHORT).show();
				break;

			case 101:
				Toast.makeText(this, "点击了打开", Toast.LENGTH_SHORT).show();
				break;
			case 102:
				Toast.makeText(this, "点击了保存", Toast.LENGTH_SHORT).show();
				break;
			case 103:
				Toast.makeText(this, "点击了重命名", Toast.LENGTH_SHORT).show();
				break;
			}
		} 
		else {
			
			switch (item.getItemId()) {
			case 100:
				Toast.makeText(this, "点击了粘贴", Toast.LENGTH_SHORT).show();
				break;

			case 101:
				Toast.makeText(this, "点击了复制", Toast.LENGTH_SHORT).show();
				break;
			case 102:
				Toast.makeText(this, "点击了剪切", Toast.LENGTH_SHORT).show();
				break;
			case 103:
				Toast.makeText(this, "点击了重命名", Toast.LENGTH_SHORT).show();
				break;
		}
			
		}*/
		
		//静态的点击事件
		switch (item.getItemId()) {
		case R.id.new_file:
			Toast.makeText(this, "点击了新建", Toast.LENGTH_SHORT).show();
			break;
		case R.id.open_file:
			Toast.makeText(this, "点击了打开", Toast.LENGTH_SHORT).show();
			break;
		case R.id.save_file:
			Toast.makeText(this, "点击了保存", Toast.LENGTH_SHORT).show();
			break;
		case R.id.rename_file:
			Toast.makeText(this, "点击了重命名", Toast.LENGTH_SHORT).show();
			break;

		case R.id.v_file:
			Toast.makeText(this, "点击了粘贴", Toast.LENGTH_SHORT).show();
			break;
		case R.id.c_edit:
			Toast.makeText(this, "点击了复制", Toast.LENGTH_SHORT).show();
			break;
		case R.id.x_edit:
			Toast.makeText(this, "点击了剪切", Toast.LENGTH_SHORT).show();
			break;
		case R.id.rename_edit:
			Toast.makeText(this, "点击了重命名", Toast.LENGTH_SHORT).show();
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}
