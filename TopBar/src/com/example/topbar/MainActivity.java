package com.example.topbar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		MyTopBar topBar =(MyTopBar) findViewById(R.id.my_topbar);
		//调用自定义的Topbar的自定义的click监听事件
		topBar.setOnTopbarClickListenter(new MyTopBar.myTopbarClicklistenter() {
			
			@Override
			public void leftClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "点击了Back", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void rightClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "点击了More", Toast.LENGTH_SHORT).show();
			}
		});
		
		//topBar.setLeftIsVisible(false);
		topBar.setRightIsVisible(false);
	}

}
