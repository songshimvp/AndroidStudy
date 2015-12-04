package songshi.testchecxbox;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class ProgressBarActivity extends Activity{
	
	private ProgressBar pb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progress_activity);
		
		pb=(ProgressBar) findViewById(R.id.progressBar3);
		pb.setMax(100);
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		startTime();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		stopTime();
	}
	
	private Timer timer=null;
	private TimerTask task=null;
	private int progress;
	
	public void startTime(){
		if(timer==null){
			timer=new Timer();
			task =new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					progress++;
					pb.setProgress(progress);
				}
			};
			
			timer.schedule(task, 1000, 1000);
		}
	}
	
	public void stopTime(){
		if(timer!=null){
			timer.cancel();
			task.cancel();
			
			timer=null;
			task=null;
		}
	}
}
