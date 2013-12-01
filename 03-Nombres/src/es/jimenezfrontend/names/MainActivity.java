package es.jimenezfrontend.names;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView data_list;
	private Button btn_greetings;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_first);
		final String[] data=new String[]{"Pepe","Juan","Felipe"};
		ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
		data_list = (ListView)findViewById(R.id.list_names);
		data_list.setAdapter(adapter);
		data_list.setBackgroundColor(getResources().getColor(R.color.silver));
		btn_greetings = (Button)findViewById(R.id.btn_greetings);
		btn_greetings.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                //Creamos el Intent
            	Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            	Bundle b = new Bundle(); 
            	b.putStringArray("names", data);
            	intent.putExtras(b);
                startActivity(intent);
            }
        });
	}
}
