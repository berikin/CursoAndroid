package es.jimenezfrontend.greetings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText txt_name;
	private Button btn_greetings;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_first);
		txt_name = (EditText)findViewById(R.id.text_name);
		btn_greetings = (Button)findViewById(R.id.btn_greetings);
		btn_greetings.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                //Creamos el Intent
            	Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            	Bundle b = new Bundle(); 
            	b.putString("name", txt_name.getText().toString());
            	intent.putExtras(b);
                startActivity(intent);
            }
        });
	}
}
