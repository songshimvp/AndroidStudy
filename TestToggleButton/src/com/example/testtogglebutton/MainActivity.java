package com.example.testtogglebutton;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends Activity /*implements OnCheckedChangeListener */{

	
	/*private ToggleButton button;
	private ImageView view;*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relative);
		
		/*button=(ToggleButton) findViewById(R.id.toggleButton1);
		view=(ImageView) findViewById(R.id.imageView1);
		
		button.setOnCheckedChangeListener(this);*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		
		
		view.setBackgroundResource(isChecked?R.drawable.on:R.drawable.off);
	}*/

}
