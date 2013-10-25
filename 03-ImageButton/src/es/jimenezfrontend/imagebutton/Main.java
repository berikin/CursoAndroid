package es.jimenezfrontend.imagebutton;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class Main extends Activity {
private ImageButton btn1;
private boolean checkButton=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		btn1=(ImageButton)findViewById(R.id.imageButton1);
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(checkButton)
				{
					btn1.setScaleX((float) 0.5);
					btn1.setScaleY((float) 0.5);
					checkButton=false;
				}
				else
				{
					btn1.setScaleX((float) 1.5);
					btn1.setScaleY((float) 1.5);
					checkButton=true;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
