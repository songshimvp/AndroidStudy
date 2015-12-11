package com.example.testservices;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Wifi服务
		findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				WifiManager wifiManager = (WifiManager) MainActivity.this.getSystemService(WIFI_SERVICE);
				if(wifiManager.isWifiEnabled()){
					wifiManager.setWifiEnabled(false);
					Toast.makeText(MainActivity.this, "Wifi已经关闭", Toast.LENGTH_LONG).show();
				}else{
					wifiManager.setWifiEnabled(true);
					Toast.makeText(MainActivity.this, "Wifi已经打开", Toast.LENGTH_LONG).show();	
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

	//判断网络状态服务
	public boolean isNetWordConnected(Context context){
		if(context!=null){
			ConnectivityManager connectivityManager=(ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();  
			if(networkInfo!=null){
				return networkInfo.isAvailable();   //活动状态
			}
		}
		return false;
	}
}
