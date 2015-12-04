package songshi.testbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroRec extends BroadcastReceiver {

	public final String ACTION="songshi.testbroadcastreceiver.intent.action.MyBroRec" ;
	
	@Override
	public void onReceive(Context arg0, Intent intent) {
		// TODO Auto-generated method stub
        System.out.println("MyBroadcastReceiver onReceive.data="+intent.getStringExtra("TXT1"));
	}

}
