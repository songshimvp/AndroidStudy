package com.example.testnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{

	NotificationManager manager;   //通知栏控制类
	int notification_ID;           //通知ID
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		manager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  //获取系统通知服务
		
		findViewById(R.id.btnSend).setOnClickListener(this);
		findViewById(R.id.btnCancle).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnSend:
			sendNotification();
			break;

		case R.id.btnCancle:
			cancleNotification();
			break;
		}
	}

	private void sendNotification() {
		Builder builder=new Notification.Builder(this);
		builder.setTicker("Hello");    // 设置手机状态栏的提示
		builder.setSmallIcon(R.drawable.ic_launcher);   // 设置手机状态栏的图标
		builder.setWhen(System.currentTimeMillis());    // 设置时间
		
		builder.setContentTitle("通知栏通知");    // 设置标题
		builder.setContentText("通知栏提示的内容"); // 设置通知内容
		
		Intent intent=new Intent(this,MainActivity.class);   //设置点击后跳转到MainActivity
		PendingIntent pendingIntent=PendingIntent.getActivity(this, 0, intent, 0);
		builder.setContentIntent(pendingIntent);   //设置点击后的意图
		
		builder.setDefaults(Notification.DEFAULT_ALL);  //直接设置成默认，就全部包含了以下设置
		/* 添加权限
		 * <uses-permission android:name="android.permission.VIBRATE"/>
	     * <uses-permission android:name="android.permission.FLASHLIGHT"/>
	     * */
		//builder.setDefaults(Notification.DEFAULT_SOUND);   //设置提示音
		//builder.setDefaults(Notification.DEFAULT_LIGHTS);  //设置指示灯
		//builder.setDefaults(Notification.DEFAULT_VIBRATE); //设置震动
		
		Notification notification=builder.build();  //获取Notification   // 4.1以上
		//Notification notification2=builder.getNotification();         // 4.1以下
			
		manager.notify(notification_ID, notification);    //通过通知栏控制类显示通知
	}
	
	private void cancleNotification() {
		// TODO Auto-generated method stub
		manager.cancel(notification_ID);    //取消通知
	}

}
