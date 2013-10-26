package es.jimenezfrontend.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main extends Activity
	{
	// ///////////////////////////////////////////////////////////
	// DECLARAMOS EL ARRAY QUE TENDRÁ LOS VALORES
	// PARA EL LISTVIEW
	// ///////////////////////////////////////////////////////////
	final String[] data = new String[30];
	private ListView ls1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		// ///////////////////////////////////////////////////////////
		// ASIGNAMOS LOS VALORES A NUESTRO ARRAY
		// ///////////////////////////////////////////////////////////
		for (int i = 0; i < 30; i++)
			{
			data[i] = "Elemento " + (i + 1);
			}
		// ///////////////////////////////////////////////////////////
		// ESTABLECEMOS EL ADAPTADOR
		// ///////////////////////////////////////////////////////////
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
		ls1 = (ListView) findViewById(R.id.LstOpciones);
		// ///////////////////////////////////////////////////////////
		// ASIGNAMOS EL ADAPATADOR AL LISTVIEW
		// ///////////////////////////////////////////////////////////
		ls1.setAdapter(adapter);
		}
	}
