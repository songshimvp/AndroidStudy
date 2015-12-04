package songshi.testchecxbox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MyGridView extends Activity {

	private GridView gridView;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_gridview);

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1);

		gridView = (GridView) findViewById(R.id.gridView);
		gridView.setAdapter(adapter);

		for (int i = 0; i < 60; i++) {
			adapter.add("hello,"+i);
		}
	}
}
