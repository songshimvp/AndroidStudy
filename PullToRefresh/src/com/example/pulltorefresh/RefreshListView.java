package com.example.pulltorefresh;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RefreshListView extends ListView implements OnScrollListener {

	public RefreshListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context);
		// TODO Auto-generated constructor stub
	}

	public RefreshListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
		// TODO Auto-generated constructor stub
	}

	public RefreshListView(Context context) {
		super(context);
		initView(context);
		// TODO Auto-generated constructor stub
	}

	View header; // 顶部布局文件
	int headerHeight; // 顶部布局文件的高度

	// 初始化界面，添加顶部布局文件到ListView
	private void initView(Context context) {
		LayoutInflater inflater = LayoutInflater.from(context);
		header = inflater.inflate(R.layout.header, null);

		measureView(header);// 通知父布局，占用的宽和高

		headerHeight = header.getMeasuredHeight();
		// Log.i("headerHeight", "headerHeight"+headerHeight);
		topPadding(-headerHeight); // 传入的是高度值的负值,隐藏顶部布局
		this.addHeaderView(header); // “添加”顶部布局文件

		this.setOnScrollListener(this); // 设置滚动的监听事件
	}

	// 设置header布局上边距
	private void topPadding(int topPadding) {
		header.setPadding(header.getPaddingLeft(), topPadding,
				header.getPaddingRight(), header.getPaddingBottom());
		header.invalidate();
	}

	// 通知父布局，占用的宽和高
	private void measureView(View view) {
		ViewGroup.LayoutParams lp = view.getLayoutParams();
		if (lp == null) {
			lp = new ViewGroup.LayoutParams(
					ViewGroup.LayoutParams.WRAP_CONTENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
		}

		int width = ViewGroup.getChildMeasureSpec(0, 0, lp.width);
		int height;
		int tempHeight = lp.height;
		if (tempHeight > 0) {
			height = MeasureSpec.makeMeasureSpec(tempHeight,
					MeasureSpec.EXACTLY);
		} else {
			height = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
		}

		view.measure(width, height);
	}

	int curScrollState;// 当前滚动状态

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		this.curScrollState = scrollState;
	}

	int firstVisibleItem;// 当前界面第一个可见的item的位置；
	boolean isRemark;// 标记当前是在ListView最顶端摁下的；
	int startY;// 开始Y值

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		this.firstVisibleItem = firstVisibleItem;// 通过判断firstVisibleItem，来判断是否在最顶端
	}

	IReflashListenter reflashListenter;
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if (firstVisibleItem == 0) {
				isRemark = true;
				startY = (int) ev.getY();
			}
			break;

		case MotionEvent.ACTION_MOVE:
			onMove(ev);
			break;
		case MotionEvent.ACTION_UP:
			if (state == RELESH) {
				state = REFRESHING;
				
				// 加载最新数据
				reflashViewByState();
				
				reflashListenter.onReflash();
				
			} else if (state == PULL) {
				state=NONE;
				isRemark=false;
				reflashViewByState();
			}
			break;

		}

		return super.onTouchEvent(ev);
	}

	// 判断移动过程中的操作
	int state; // 当前状态
	final int NONE = 0; // 正常状态
	final int PULL = 1; // 提示下拉状态
	final int RELESH = 2; // 提示松开释放状态
	final int REFRESHING = 3; // 正在刷新状态

	private void onMove(MotionEvent ev) {
		// TODO Auto-generated method stub
		if (!isRemark) {
			return;
		}
		int tempY = (int) ev.getY();
		int space = tempY - startY; // 记录拖动距离
		int topPadding = space - headerHeight;
		switch (state) {
		case NONE:
			if (space > 0) {
				state = PULL;
			}
			reflashViewByState();
			break;

		case PULL:
			topPadding(topPadding);
			if (space > headerHeight + 30
					&& curScrollState == SCROLL_STATE_TOUCH_SCROLL) {
				state = RELESH;
				reflashViewByState();
			}
			break;

		case RELESH:
			topPadding(topPadding);
			if (space < headerHeight + 30) {
				state = PULL;
				reflashViewByState();
			} else if (space <= 0) {
				state = NONE;
				isRemark = false;
				reflashViewByState();
			}
			break;

		}
	}

	// 根据当前状态改变界面显示
	private void reflashViewByState() {
		TextView tip = (TextView) header.findViewById(R.id.tip);
		ImageView arrow = (ImageView) header.findViewById(R.id.arrow);
		ProgressBar progress = (ProgressBar) header.findViewById(R.id.progress);

		RotateAnimation animation1 = new RotateAnimation(0, 180,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		animation1.setDuration(500);
		animation1.setFillAfter(true);
		RotateAnimation animation2 = new RotateAnimation(180, 0,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		animation1.setDuration(500);
		animation1.setFillAfter(true);
		
		switch (state) {
		case NONE:
			topPadding(-headerHeight);
			arrow.clearAnimation();
			break;

		case PULL:
			arrow.setVisibility(View.VISIBLE);
			progress.setVisibility(View.GONE);
			tip.setText("下拉可以刷新!");
			arrow.clearAnimation();
			arrow.setAnimation(animation2);
			break;
		case RELESH:
			arrow.setVisibility(View.VISIBLE);
			progress.setVisibility(View.GONE);
			tip.setText("松开可以刷新!");
			arrow.clearAnimation();
			arrow.setAnimation(animation1);
			break;
		case REFRESHING:
			topPadding(50);
			arrow.setVisibility(View.GONE);
			progress.setVisibility(View.VISIBLE);
			arrow.clearAnimation();
			tip.setText("正在刷新...");
			break;
		}
	}
	
	//获取完数据
	public void reflashComplete(){
		state = NONE;
		isRemark = false;
		reflashViewByState();
		TextView lastupdatetime = (TextView) header
				.findViewById(R.id.lastUpdate_time);
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String time = format.format(date);
		lastupdatetime.setText(time);
	}
	
	public void setInterface(IReflashListenter reflashListenter){
		this.reflashListenter=reflashListenter;
	}
	
	//刷新数据接口
	public interface IReflashListenter{
		public void onReflash();
	}
}
