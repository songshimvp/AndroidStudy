package com.example.testspinner;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements  OnItemSelectedListener{

	private TextView textView;
	private Spinner spinner;
	private List<String> list;
	private ArrayAdapter<String> arrayAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView=(TextView) findViewById(R.id.text);
		spinner=(Spinner) findViewById(R.id.spinner);
		textView.setText("您选择城市是北京");
		//1、设置数据源
		list=new ArrayList<String>();
		list.add("北京");
		list.add("上海");
		list.add("广州");
		list.add("深圳");
		
		//2、新建ArrayAdapter（数组适配器）
		arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
		
		//3、arrayAdapter设置一个下拉列表样式
		arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//4、spinner加载适配器
		spinner.setAdapter(arrayAdapter);
		
		//5、设置spinner监听器
		spinner.setOnItemSelectedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		String cityName=arrayAdapter.getItem(position);
		//String cityName=list.get(position)
	    textView.setText("您选择的城市是"+cityName);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

}
