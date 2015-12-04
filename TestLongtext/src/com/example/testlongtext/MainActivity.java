package com.example.testlongtext;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends Activity {

	private AutoCompleteTextView textView;
	private MultiAutoCompleteTextView autoCompleteTextView;
	private String[] resourceData={"C++","C#","C-object","java SE","C++","java EE"};
	private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resourceData);
		textView.setAdapter(adapter);
		
		autoCompleteTextView=(MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
		autoCompleteTextView.setAdapter(adapter);
		autoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
