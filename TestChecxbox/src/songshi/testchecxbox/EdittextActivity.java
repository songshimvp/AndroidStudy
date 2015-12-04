package songshi.testchecxbox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class EdittextActivity extends Activity {
	
	private AutoCompleteTextView autoCompleteTextView;
	private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit);
		
		adapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
		adapter.add("hello 1");
		adapter.add("hello 2");
		adapter.add("hello 3");
		adapter.add("hello 4");
		adapter.add("hello 5");
		adapter.add("java vertion");
		adapter.add("java SE");
		
		autoCompleteTextView=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		
		autoCompleteTextView.setAdapter(adapter);
	}
}
