package songshi.testservice2;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class Testservice extends Service {

	public class TestServiceBinder extends Binder{
		public Testservice getTSService(){
			return Testservice.this;
		}
	}
	
	private TestServiceBinder testServiceBinder=new TestServiceBinder();
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("service onBind");
		return testServiceBinder;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		System.out.println("service onCreate");
		startTimer();
		
		super.onCreate();
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("service onDestroy");
		stopTimer();
		super.onDestroy();
		
		
	}

	private Timer timer = null;
	private TimerTask timerTask = null;

	private int i = 0;

	public void startTimer() {
		if (timer == null) {
			timer = new Timer();
			timerTask = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					i++;
					System.out.println(i);
				}
			};

			timer.schedule(timerTask, 2000, 2000);
		}
	}

	public void stopTimer() {
		if (timer != null) {
			timer.cancel();
			timerTask.cancel();

			timer = null;
			timerTask = null;
		}
	}

	public int getCurrentNum() {
		return i;
	}
}
