package songshi.testlistview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {

	private ListView listView;
	private ArrayAdapter<ListData> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 配置数据适配器
		adapter = new ArrayAdapter<ListData>(this,
				android.R.layout.simple_list_item_1);// 利用系统提供的模板

		listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);

		// adapter=new ArrayAdapter<String>(this, R.layout.list1); //自定义列表项

		/*
		 * adapter.add("hello1"); adapter.add("hello2"); adapter.add("hello3");
		 */

		adapter.add(new ListData("ming", "nan", 12));
		adapter.add(new ListData("zhang", "nan", 16));

		/*
		 * adapter.add("hello1"); adapter.add("hello2"); adapter.add("hello3");
		 */

		listView.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//ListItem 的  click事件 响应
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub

		ListData data = adapter.getItem(position);
		Toast.makeText(this, String.format("名字:%s,性别:%s,年龄:%d",data.getUserName(),data.getSex(),data.getAge()), Toast.LENGTH_SHORT).show();
	}

}
