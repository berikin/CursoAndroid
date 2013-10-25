package es.jimenezfrontend.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main extends Activity
	{
	final String[] data = new String[30];
	private ListView ls1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		for (int i=0; i<30; i++)
			{
			data[i]="Elemento "+(i+1);
			}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, data);
		ls1=(ListView)findViewById(R.id.LstOpciones);
		ls1.setAdapter(adapter);
		}
	}
