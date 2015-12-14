package com.example.getprefapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private SharedPreferences getPreferences;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//从serverInfo.xml获取服务器信息
		findViewById(R.id.buttonGet).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					Context context=createPackageContext("com.example.putprefapp", Context.CONTEXT_IGNORE_SECURITY);
					getPreferences=context.getSharedPreferences("serverInfo", MODE_WORLD_READABLE);
					String serverIP=getPreferences.getString("serverIP","");
					String serverPwd=getPreferences.getString("password", "");
					Toast.makeText(MainActivity.this, "服务器信息如下：IP地址：" +serverIP+"; 密码："+serverPwd, Toast.LENGTH_LONG).show();
				} catch (NameNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
