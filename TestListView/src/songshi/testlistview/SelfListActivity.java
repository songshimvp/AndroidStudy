package songshi.testlistview;

import android.app.ListActivity;
import android.os.Bundle;

//快速创建 列表应用程序
public class SelfListActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		/*
		 * 如果使用系统提供的ListActivity,就不用下面代码，直接最后一句就可以
		 * */
		//自己创建布局——self_listactivity
		//但是要注意：此处的布局的ListView的id是固定的:android:id="@Android:id/list"，因为要去覆盖系统的。
		setContentView(R.layout.self_listactivity);
		
		
		//扩展自ListActivity后，就不用在自己去建立什么listView布局
		setListAdapter(new SelfDataAdapter(this));
	}
}
