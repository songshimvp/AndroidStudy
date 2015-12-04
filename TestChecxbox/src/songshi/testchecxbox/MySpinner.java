package songshi.testchecxbox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MySpinner extends Activity {

	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner);
		
		adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item); 
		adapter.add("hello1");
		adapter.add("hello2");
		adapter.add("hello3");
		spinner=(Spinner)findViewById(R.id.spinner);
		spinner.setAdapter(adapter);
	}
}
