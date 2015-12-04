package com.example.testsqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		DB db=new DB(this);
		/*SQLiteDatabase dbWrite=db.getWritableDatabase();
		
		ContentValues cv=new ContentValues();
		cv.put("name", "小张");
		cv.put("sex","男");
		dbWrite.insert("suer", null, cv);
		
		cv=new ContentValues();
		cv.put("name", "小李");
		cv.put("sex","女");
		dbWrite.insert("suer", null, cv);
		
		dbWrite.close();*/
		
		SQLiteDatabase dbRead=db.getReadableDatabase();
		Cursor c = dbRead.query("user",null,null,null,null,null,null);
		
		while(c.moveToNext()){
			String name=c.getString(c.getColumnIndex("name"));
			String sex=c.getString(c.getColumnIndex("sex"));
			System.out.println(String.format("name=%s and sex=%s", name,sex));
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
