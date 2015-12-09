package com.example.testdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String[] single_list={"男","女","未知"};
	private String[] multi_list={"篮球","足球","排球","乒乓球","羽毛球"};
	private String[] item_list={"项目经理","技术工程师","测试","美工"};
	private String like="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.btnOK).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);

				builder.setTitle("确认对话框");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setMessage("这是“确认对话框”的提示内容部分！");
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								Toast.makeText(MainActivity.this, "点击了确定按钮",
										Toast.LENGTH_LONG).show();
							}
						});

				builder.setNegativeButton("取消",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								Toast.makeText(MainActivity.this, "点击了取消按钮",
										Toast.LENGTH_LONG).show();
							}
						});

				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});

		findViewById(R.id.btnSingle).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);

				builder.setTitle("单选对话框——性别");
				builder.setIcon(R.drawable.ic_launcher);

				builder.setSingleChoiceItems(single_list, 0, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						String str=single_list[which];
						Toast.makeText(MainActivity.this, "您选择的性别是："+str	, Toast.LENGTH_LONG).show();
						
					}
				});	
				
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
		
		
		findViewById(R.id.btnMulti).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);

				builder.setTitle("多选对话框——爱好");
				builder.setIcon(R.drawable.ic_launcher);

				builder.setMultiChoiceItems(multi_list,null,new DialogInterface.OnMultiChoiceClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						// TODO Auto-generated method stub
						if(isChecked){
							like+=multi_list[which];
							like+=",";
							Toast.makeText(MainActivity.this, "您选择了"+multi_list[which], Toast.LENGTH_SHORT).show();
						}
						else{
							Toast.makeText(MainActivity.this, "您取消了"+multi_list[which], Toast.LENGTH_SHORT).show();
						}
					}
				});
				
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "您的爱好有："+like, Toast.LENGTH_SHORT).show();
					}
				});
				
				builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});
				
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
	
		findViewById(R.id.btnList).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);

				builder.setTitle("列表对话框——部门");
				builder.setIcon(R.drawable.ic_launcher);

				builder.setItems(item_list, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "您是："+item_list[which], Toast.LENGTH_SHORT).show();
					}
				});
				
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
		
		
		findViewById(R.id.btnSelf).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//获取自定义的对话框布局，并转换成View对象
				LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
				View view_dialog=inflater.inflate(R.layout.dialog_layout, null);
				
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);

				builder.setTitle("自定义对话框");
				builder.setIcon(R.drawable.ic_launcher);
				
				builder.setView(view_dialog);   //设置布局，把获取的自定义布局传进去
							
				
				AlertDialog dialog = builder.create();
				dialog.show();
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
