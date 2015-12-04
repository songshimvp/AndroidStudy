package songshi.testactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Act1 extends Activity {
	
	private Button btnClose;
	private TextView tvOut;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act1);
		
		btnClose = (Button)findViewById(R.id.btnClose);
		btnClose.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent();
				i.putExtra("result", "Act1页面说:收到!");
				setResult(0,i);
				
				finish();
			}
		});
		
		tvOut = (TextView) findViewById(R.id.tvOut);
		
		Bundle data1=getIntent().getExtras();
		String txt=data1.getString("txt1");
		
		tvOut.setText(txt);
	}
	
	
}
