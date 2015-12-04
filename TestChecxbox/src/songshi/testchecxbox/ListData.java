package songshi.testchecxbox;

import android.content.Context;
import android.content.Intent;

public class ListData {

	private String controlName = "";
	private Context context = null;
	private Intent intent;

	public ListData(Context context, String controlName, Intent intent) {
		super();
		this.controlName = controlName;
		this.context = context;
		this.intent = intent;
	}

	public String getControlName() {
		return controlName;
	}

	public Context getContext() {
		return context;
	}

	public Intent getIntent() {
		return intent;
	}

	public void startActivity() {
		getContext().startActivity(intent);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getControlName();
	}
}
