package com.example.putprefapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private SharedPreferences putPreferences;
	private Editor putEditor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 将服务器信息写入serverInfo.xml
		findViewById(R.id.buttonPut).setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				putPreferences = getSharedPreferences("serverInfo", Context.MODE_WORLD_READABLE);
				putEditor = putPreferences.edit();
				putEditor.putString("serverIP", "192.168.1.102");
				putEditor.putString("password", "123456");
				putEditor.commit();
				Toast.makeText(MainActivity.this,"服务器信息成功写入serverInfo.xml", Toast.LENGTH_LONG).show();
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
