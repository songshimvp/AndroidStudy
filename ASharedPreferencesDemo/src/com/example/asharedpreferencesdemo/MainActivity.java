package com.example.asharedpreferencesdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.AvoidXfermode.Mode;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences sharedPreferences=getSharedPreferences("user", Context.MODE_PRIVATE);    // 实例化SharedPreferences对象
				
				Editor editor=sharedPreferences.edit();     // 实例化SharedPreferences.Editor对象
				editor.putString("name", "张三");            // 用putString的方法保存数据 
				editor.putString("IP", "192.168.1.102");
				editor.putString("password", "123456");
				editor.commit();                            // 提交当前数据 
				
				Toast.makeText(MainActivity.this, "写入数据成功！", Toast.LENGTH_SHORT).show();
			}
		});
		
		findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 在读取SharedPreferences数据前要实例化出一个SharedPreferences对象 
				SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);  
				
				String nameStr=preferences.getString("name", "");  // 使用getString方法获得value，注意第2个参数是value的默认值
				String ipStr=preferences.getString("IP", "");
				String pwStr=preferences.getString("password", "");
				
				Toast.makeText(MainActivity.this, "用户信息：姓名："+nameStr+",IP:"+ipStr+",密码："+pwStr, Toast.LENGTH_LONG).show();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
