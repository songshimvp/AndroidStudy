package songshi.testservice2;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener,
		ServiceConnection {

	private Button btnStart, btnStop, btnBind, btnUnbind, btnGetCurNum;
	private Intent serviceIntent;
	private Testservice testservice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnStart = (Button) findViewById(R.id.btnStartService);
		btnStop = (Button) findViewById(R.id.btnStopService);
		btnStart.setOnClickListener(this);
		btnStop.setOnClickListener(this);

		serviceIntent = new Intent(this, Testservice.class);

		btnBind = (Button) findViewById(R.id.bindService);
		btnUnbind = (Button) findViewById(R.id.unbindService);
		btnBind.setOnClickListener(this);
		btnUnbind.setOnClickListener(this);

		btnGetCurNum = (Button) findViewById(R.id.btmGetCurNum);
		btnGetCurNum.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnStartService:
			startService(serviceIntent);
			break;

		case R.id.btnStopService:
			stopService(serviceIntent);
			break;

		case R.id.bindService:
			bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
			break;

		case R.id.unbindService:
			unbindService(this);
			testservice = null;
			break;

		case R.id.btmGetCurNum:
			if (testservice != null) {
				System.out.println("当前Service中的数字是："
						+ testservice.getCurrentNum());
			}
			break;
		}
	}

	@Override
	public void onServiceConnected(ComponentName arg0, IBinder testBinder) {
		// TODO Auto-generated method stub
		System.out.println("service has been onServiceConnected");
		
		testservice =((Testservice.TestServiceBinder)testBinder).getTSService();
	}

	@Override
	public void onServiceDisconnected(ComponentName arg0) {
		// TODO Auto-generated method stub
		System.out.println("service has been onServiceDisconnected");
		//只有在service因异常而断开连接的时候，这个方法才会用到
	}

}
