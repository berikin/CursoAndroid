package es.jimenezfrontend.notification;

import android.os.Bundle;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity {
private Button btn1;
private int counter=5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		btn1=(Button)findViewById(R.id.button1);
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				counter--;
				btn1.setText("Te faltan "+counter+" pulsaciones");
				if(counter==0)
				{
					btn1.setText("Pulsa");
					counter=5;
					Toast t1=Toast.makeText(getApplicationContext(), "¡¡¡BRAVO!!!", Toast.LENGTH_LONG);
					t1.show();
				}
					
			}
		});
	}

}
