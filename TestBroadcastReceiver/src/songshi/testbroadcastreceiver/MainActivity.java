package songshi.testbroadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnSend,btnReg,btnUnreg;
	private final MyBroRec mybc=new MyBroRec();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnSend =(Button)findViewById(R.id.btnSendBroadcast);
		btnSend.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent i=new Intent(MainActivity.this,MyBroRec.class);
				Intent i=new Intent(mybc.ACTION);
				i.putExtra("TXT1", "mainActivity say hello");
				
				
				sendBroadcast(i);
			}
		});
		
		
		
		btnReg=(Button)findViewById(R.id.btnRegRec);
		btnUnreg=(Button)findViewById(R.id.btnUnregRec);
		
		btnReg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				registerReceiver(mybc, new IntentFilter(mybc.ACTION));
			}
		});
		btnUnreg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				unregisterReceiver(mybc);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
