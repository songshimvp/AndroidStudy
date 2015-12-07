package com.example.testprogressbar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnDia;
	private ProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//启用窗口特征，启用带进度和不带进度的进度条
		requestWindowFeature(Window.FEATURE_PROGRESS);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_main);
		
		//显示两种进度条
		setProgressBarVisibility(true);
		setProgressBarIndeterminateVisibility(true);
		//MAX=10000
		setProgress(6000);
		
		btnDia=(Button) findViewById(R.id.btnDia);
		btnDia.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
	     	    /*设置页面显示风格*/
				//新建ProgressDialog对象
				progressDialog=new ProgressDialog(MainActivity.this);
				//设置显示风格(横向)
				progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				//设置标题
				progressDialog.setTitle("对话框式进度条");
				//设置图标
				progressDialog.setIcon(R.drawable.ic_launcher);
				//设置对话框里的文字信息
				progressDialog.setMessage("欢迎你！");
				//设置"确定"按钮
				progressDialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "这是对话框式进度条！", Toast.LENGTH_LONG).show();
					}
				});
				//设置是否通过返回按钮退出对话框
				progressDialog.setCancelable(true);
				
				
				/*设置关于ProgressBar的属性*/
				//设置最大进度
				progressDialog.setMax(100);
				//设置初始化已经增长到的进度
				progressDialog.incrementProgressBy(20);
				//进度条是明确显示进度的
				progressDialog.setIndeterminate(false);
				
				//显示对话框
				progressDialog.show();
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
