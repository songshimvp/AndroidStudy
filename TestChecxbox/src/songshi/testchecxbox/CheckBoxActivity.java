package songshi.testchecxbox;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class CheckBoxActivity extends Activity {

	private CheckBox cbLQ, cbZQ, cbBQ, cbPQ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.checkbox);

		cbLQ = (CheckBox) findViewById(R.id.basketball);
		cbZQ = (CheckBox) findViewById(R.id.socket);
		cbBQ = (CheckBox) findViewById(R.id.bingqiu);
		cbPQ = (CheckBox) findViewById(R.id.paiqiu);

		
		//cbBQ.setOnCheckedChangeListener(listener);
		
		findViewById(R.id.btnSub).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						String str = "你的爱好有：\n";

						if (cbLQ.isChecked()) {
							str += "篮球\n";
						}
						if (cbZQ.isChecked()) {
							str += "足球\n";
						}
						if (cbBQ.isChecked()) {
							str += "冰球\n";
						}
						if (cbPQ.isChecked()) {
							str += "排球\n";
						}

						new AlertDialog.Builder(CheckBoxActivity.this)
								.setTitle("提交的爱好").setMessage(str)
								.setPositiveButton("确定", null).show();
					}
				});

	}
}
