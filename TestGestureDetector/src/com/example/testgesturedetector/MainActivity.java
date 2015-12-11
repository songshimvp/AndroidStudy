package com.example.testgesturedetector;

import android.os.Bundle;
import android.app.Activity;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView imageView;
	private GestureDetector mygestureDetector;

	// 继承SimpleOnGestureListener类，然后重载感兴趣的手势。
	class MyGestureListenter extends SimpleOnGestureListener {

		@Override
		// 重载滑动手势
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			if (e1.getX() - e2.getX() > 50) {
				Toast.makeText(MainActivity.this, "从右往左滑动", Toast.LENGTH_SHORT)
						.show();
			} else if (e2.getX() - e1.getX() > 50) {
				Toast.makeText(MainActivity.this, "从左往右滑动", Toast.LENGTH_SHORT)
						.show();
			}
			return super.onFling(e1, e2, velocityX, velocityY);
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		 * GestureDetector工作原理 
		 * 1、当接收到用户触摸消息时，将消息交给GestureDetector加工；
		 * 2、通过设置监听器获得GestureDetector处理后的手势； 
		 * 3、GestureDetector提供两个监听器：
		 *     A.OnGestureListenter：处理单击类消息；
		 *     B.OnDoubleTapListenter：处理双击类消息；
		 */
		imageView = (ImageView) findViewById(R.id.img);
		mygestureDetector = new GestureDetector(new MyGestureListenter());

		// MotionEvent——》setOnTouchListener捕获
		// ——》onTouch中GestureDetector对象将监听事件转发给MyGestureListenter(extends SimpleOnGestureListener)
		// ——》MyGestureListenter类中实现了要重载的手势
		imageView.setOnTouchListener(new OnTouchListener() {

			@Override
			// 可以捕获触摸屏幕发生的Event
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				mygestureDetector.onTouchEvent(event); // 转发event事件，转发给MyGestureListenter(extends SimpleOnGestureListener)
				return false;
			}
		});
	}

	//消除冲突
	/*@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		if(mygestureDetector!=null){
			if(mygestureDetector.onTouchEvent(ev)){
				return true;
			}
		}
		return super.dispatchTouchEvent(ev);
	}*/
	
	//必须重写onTouchEvent方法，onFling才生效
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return mygestureDetector.onTouchEvent(event);
	}
}
