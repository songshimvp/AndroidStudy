package com.example.testmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
	
	/*@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
		
		switch (item.getItemId()) {
		case R.id.ShowDialog:
			//new AlertDialog.Builder(this).setTitle("Menu Dialog").setMessage("Menu Show Dialog").setPositiveButton("OK", null).show();
			break;

		default:
			//Toast.makeText(this, "Menu show toast", Toast.LENGTH_LONG).show();
			break;
		}
		
		
		switch (item.getItemId()) {
		case R.id.ShowDialog:
			new AlertDialog.Builder(this).setTitle("Menu Show Dialog").setMessage("这是菜单栏的对话框").setPositiveButton("OK",null).show();
			break;

		case R.id.ShowToast:
			Toast.makeText(this, "Menu show toast", Toast.LENGTH_LONG).show();
			break;
		}
	}*/

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {
		case R.id.ShowDialog:
			new AlertDialog.Builder(this).setTitle("Menu Dialog").setMessage("Menu Show Dialog").setPositiveButton("OK", null).show();
			break;

		default:
			Toast.makeText(this, "Menu show toast", Toast.LENGTH_LONG).show();
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
