package com.example.testbackbutton;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
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
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*private int clickCount = 0;

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		//super.onBackPressed();
		
		if (clickCount < 1) {
			Toast.makeText(this, "再按一次退出", Toast.LENGTH_LONG).show();
			clickCount++;
		}
		else{
			finish();
		}
	}*/
	
	private long lastClickTime=0;
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		//super.onBackPressed();
		
		if (lastClickTime <=0) {
			Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
			lastClickTime=System.currentTimeMillis();
		}
		else
		{
			long currentClickTime=System.currentTimeMillis();
			if(currentClickTime-lastClickTime<1000){
				finish();
			}
			else {
				lastClickTime=currentClickTime;
				Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();

			}
		}
	}
}
