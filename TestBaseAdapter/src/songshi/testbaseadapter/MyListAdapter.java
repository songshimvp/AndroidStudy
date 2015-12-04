package songshi.testbaseadapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

//<T>使用泛型
public abstract class MyListAdapter<T> extends BaseAdapter {

	// 如果想根据一个资源生成一个视图的话，需要用到Context
	private Context context;
	private int resourceID = 0;

	public MyListAdapter(Context context, int resourceID) {
		super();
		this.context = context;
		this.resourceID = resourceID;
	}

	public Context getContext() {
		return this.context;
	}

	private List<T> list = new ArrayList<T>();

	public void add(T item) {
		list.add(item);
	}

	public void remove(int position) {
		list.remove(position);
	}

	public void removeLast() {
		remove(getCount() - 1);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public T getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	// 此处根据外界传进来的资源的ID生成一个列表项
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(resourceID,
					null);
		}

		// list的初始化工作交给调用者来做(所以在最后设置一个抽象方法)
		initListCell(position, convertView, parent);

		return convertView;
	}

	protected abstract void initListCell(int position, View listCell,
			ViewGroup parent);
}
