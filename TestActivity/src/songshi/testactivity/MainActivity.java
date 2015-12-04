package songshi.testactivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button btnStartAct1;
	private TextView textMain;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textMain=(TextView) findViewById(R.id.textView1);
        
        btnStartAct1 = (Button) findViewById(R.id.btnStartAct1);
        
        btnStartAct1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(MainActivity.this, Act1.class);    //此处不能直接写this
				
				//第一种、启动页面时，带上数据——适用于传递简单的数据
				i.putExtra("txt", "这是main页面传递过来的数据");
				
				//第二种、传递资源树，携带大量数据
				Bundle data=new Bundle();
				data.putString("txt1", "Bundle携带的数据");
				i.putExtras(data);
				
				//startActivity(i);
				startActivityForResult(i, 0);
			}
		});
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	String result=data.getStringExtra("result");
    	textMain.setText(result);
    	super.onActivityResult(requestCode, resultCode, data);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    }
}
