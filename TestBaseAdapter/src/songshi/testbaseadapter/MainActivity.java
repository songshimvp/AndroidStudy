package songshi.testbaseadapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	private MyListAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter =new MyListAdapter<String>(this,android.R.layout.simple_list_item_1) {
			
			@Override
			protected void initListCell(int position, View listCell, ViewGroup parent) {
				// TODO Auto-generated method stub
				
				((TextView)(listCell)).setText(getItem(position));
			}
		};
		
		setListAdapter(adapter);
		
		for(int i=0;i<5;i++)
		{
			adapter.add("hello"+i);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
