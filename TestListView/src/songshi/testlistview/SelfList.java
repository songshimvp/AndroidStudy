package songshi.testlistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class SelfList extends Activity {

	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selflist);

		lv = (ListView) findViewById(R.id.selflist);
		//lv.setAdapter(adapter);
		lv.setAdapter(new SelfDataAdapter(this));
	}
	
	
	//实际开发中，要单独建一个Adapter类
		/*private BaseAdapter adapter = new BaseAdapter() {

			
			 * private String[] data = new String[] { "hello1", "hello2", "hello3",
			 * "hello4", "hello5", "hello6", "hello7", "hello8", "hello8",
			 * "hello10", "hello11", "hello12", "hello13", "hello14", "hello15" };
			 

			// 使用SelfData类来构建数据
			private SelfData[] data = new SelfData[] {
					new SelfData("img1", "img1 description", R.drawable.qq),
					new SelfData("img2", "img2 description", R.drawable.qwqw),

			};

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub

				// 介绍一种机制：在呈现列表项时执行——每呈现一个，执行一次，通过getID来控制执行的次数
				//
				// TextView tv=null;
				// // 因为有回收机制，下面代码提高效率
				// if(convertView!=null){
				// tv = (TextView) convertView;
				// //如果有回收的列表项，就不再重新创建,这样在列表项很多时，就会省去很多的列表项创建操作
				// }
				// else{
				// tv = new TextView(SelfList.this);
				// }
				//
				// //TextView tv = new TextView(SelfList.this);
				// tv.setTextSize(50);
				// tv.setText((CharSequence) getItem(position));
				//
				// return tv;

				// 创建列表项布局 ——已优化
				LinearLayout ll = null;
				if (convertView != null) {
					ll = (LinearLayout) convertView;
				} else {
					// 此处新方法——使用一个资源创建一个布局
					// LayoutInflater:Layout的解释器
					// 后面的是，创建一个布局解释器，让它去解释一个ID
					ll = (LinearLayout) LayoutInflater.from(SelfList.this).inflate(
							R.layout.selflist2, null);
				}

				SelfData data = getItem(position);

				ImageView icon = (ImageView) ll.findViewById(R.id.img);
				TextView name = (TextView) ll.findViewById(R.id.name);
				TextView desc = (TextView) ll.findViewById(R.id.descript);

				icon.setImageResource(data.iconID);
				name.setText(data.name);
				desc.setText(data.dec);

				return ll;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public SelfData getItem(int position) {
				// TODO Auto-generated method stub
				return data[position];
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return data.length;
			}
		};*/

}
