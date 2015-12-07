package com.example.testdatetimepicker;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {

	private DatePicker datePicker;
	private TimePicker timePicker;
	
	private Calendar calendar;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//获取日历的一个对象
		calendar=Calendar.getInstance();
		//获取年月日时分的信息
		year=calendar.get(Calendar.YEAR);
		month=calendar.get(Calendar.MONTH)+1;  //注意：Calendar类的月份是按0开始计算的
		day=calendar.get(Calendar.DAY_OF_MONTH);
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		minute=calendar.get(Calendar.MINUTE);
		setTitle(year+"-"+month+"-"+day+"-"+hour+":"+minute);
		
		datePicker=(DatePicker) findViewById(R.id.datePicker);
		timePicker=(TimePicker) findViewById(R.id.timePicker);
		
		//datePicker初始化并设置监听器
		datePicker.init(year, calendar.get(Calendar.MONTH), day, new OnDateChangedListener() {
			
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				setTitle(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
			}
		});
		
		//timePicker设置监听器
		timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
			
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				setTitle(hourOfDay+":"+minute);			
			}
		});
		
		//用对话框形式展示日期、时间
		/*new DatePickerDialog(this, new OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				setTitle(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
			}
		}, year, calendar.get(Calendar.MONTH), day).show();*/
		
		new TimePickerDialog(this, new OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				setTitle(hourOfDay+":"+minute);			
			}
		}, hour, minute, true).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
