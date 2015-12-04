package songshi.testchecxbox;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

	private ArrayAdapter<ListData> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);

		adapter = new ArrayAdapter<ListData>(this,
				android.R.layout.simple_list_item_1);
		setListAdapter(adapter);

		adapter.add(new ListData(this, "radioGroup", new Intent(this,
				RadioGroupActivity.class)));
		adapter.add(new ListData(this, "checkBox", new Intent(this,
				CheckBoxActivity.class)));
		adapter.add(new ListData(this, "mySpinner", new Intent(this,
				MySpinner.class)));
		adapter.add(new ListData(this, "myGridView", new Intent(this,
				MyGridView.class)));
		adapter.add(new ListData(this, "myGridView", new Intent(this,
				ImageSwitchActivity.class)));	
		adapter.add(new ListData(this, "myprogressBar", new Intent(this,
				ProgressBarActivity.class)));
		adapter.add(new ListData(this, "myEditText", new Intent(this,
				EdittextActivity.class)));
	
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub

		ListData data = adapter.getItem(position);
		data.startActivity();

		super.onListItemClick(l, v, position, id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
