package com.example.testsqlite2;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ListActivity {

	private SimpleCursorAdapter adapter;

	private EditText etname, etsex;
	private Button btn;

	private DB db;
	private SQLiteDatabase dbRead, dbWrite;

	private OnItemLongClickListener listViewItemLongClickListener=new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				final int position, long id) {
			// TODO Auto-generated method stub
			
			new AlertDialog.Builder(MainActivity.this).setTitle("Waring").setMessage("确定删除吗？").setNegativeButton("取消", null).setPositiveButton("确定",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Cursor c=adapter.getCursor();
					c.moveToPosition(position);
					
					int itemID=c.getInt(c.getColumnIndex("_id"));
					dbWrite.delete("user", "_id=?", new String[]{itemID+""});
					refreshListView();
				}
			}).show();
			
			return true;
		}
	};

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etname = (EditText) findViewById(R.id.etName);
		etsex = (EditText) findViewById(R.id.etSex);

		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(btnAddListener);

		db = new DB(this);
		dbRead = db.getReadableDatabase(); // 获得数据库的两种操作方式
		dbWrite = db.getWritableDatabase();

		/*
		 * SQLiteDatabase dbWrite=db.getWritableDatabase();
		 * 
		 * ContentValues cv=new ContentValues(); cv.put("name", "小张");
		 * cv.put("sex", "女");
		 * 
		 * dbWrite.insert("user",null,cv); //向“user”表中插入数据
		 * 
		 * cv=new ContentValues(); cv.put("name", "小李"); cv.put("sex", "男");
		 * 
		 * dbWrite.insert("user",null,cv); //向“user”表中插入数据 db.close();
		 */

		/*
		 * SQLiteDatabase dbRead=db.getReadableDatabase(); Cursor c =
		 * dbRead.query("user", null, null, null, null, null, null);
		 * 
		 * while(c.moveToNext()){ String
		 * MyName=c.getString(c.getColumnIndex("name")); String
		 * MySex=c.getString(c.getColumnIndex("sex"));
		 * 
		 * System.out.println(String.format("name=%s and sex=%s",
		 * MyName,MySex)); }
		 */

		adapter = new SimpleCursorAdapter(this, R.layout.user_list, null,
				new String[] { "name", "sex" }, new int[] { R.id.textName,
						R.id.textSex });
		setListAdapter(adapter); // 首先要继承自ListActivity

		refreshListView();
		
		getListView().setOnItemLongClickListener(listViewItemLongClickListener);
	}

	private OnClickListener btnAddListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ContentValues cv = new ContentValues();
			cv.put("name", etname.getText().toString());
			cv.put("sex", etsex.getText().toString());
			dbWrite.insert("user", null, cv);

			refreshListView();
		}
	};

	private void refreshListView() {
		Cursor c = dbRead.query("user", null, null, null, null, null, null);
		adapter.changeCursor(c); // 刷新ListView
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
