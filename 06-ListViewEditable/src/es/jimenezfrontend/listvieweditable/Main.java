package es.jimenezfrontend.listvieweditable;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends Activity
	{
	// ///////////////////////////////////////////////////
	// DECLARACIÓN DE VARIABLES
	// ///////////////////////////////////////////////////
	private ListView ls1;
	private EditText edt1;
	private Button btn1;
	private String[] defaultItems = new String[3];
	private ArrayList<String> listItems = new ArrayList<String>();
	private ArrayAdapter<String> adapter;
	final int CONTEXT_MENU_DELETE_ITEM = 1;
	final int CONTEXT_MENU_CANCEL = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		// ///////////////////////////////////////////////////
		// RECOGEMOS EL ARRAY DE VALORES POR DEFECTO
		// ///////////////////////////////////////////////////
		defaultItems = getResources().getStringArray(R.array.listview_values);
		// ///////////////////////////////////////////////////
		// AÑADIMOS LOS VALORES POR DEFECTO A NUESTRA LISTA
		// ///////////////////////////////////////////////////
		for (int i = 0; i < defaultItems.length; i++)
			{
			listItems.add(defaultItems[i]);
			}
		// ///////////////////////////////////////////////////
		// CREAMOS EL ARRAYADAPTER CON NUESTRA LISTA VARIABLE
		// ///////////////////////////////////////////////////
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
		// ///////////////////////////////////////////////////
		// ENLAZAMOS CON LOS COMPONENTES DEL XML
		// ///////////////////////////////////////////////////
		ls1 = (ListView) findViewById(R.id.ListOne);
		edt1 = (EditText) findViewById(R.id.edt1);
		btn1 = (Button) findViewById(R.id.btn1);
		// ///////////////////////////////////////////////////
		// AÑADIMOS UN CONTEXTMENU PARA ELIMINAR ITEMS
		// ///////////////////////////////////////////////////
		registerForContextMenu(ls1);
		// ///////////////////////////////////////////////////
		// ESTABLECEMOS EL ADAPTADOR
		// ///////////////////////////////////////////////////
		ls1.setAdapter(adapter);
		// ///////////////////////////////////////////////////
		// EVENTO PARA AÑADIR NUEVOS ELEMENTOS AL LISTVIEW
		// ///////////////////////////////////////////////////
		btn1.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
					{
					// ///////////////////////////////////////////////////
					// AÑADIMOS SI HAY ALGO EN EL EDITTEXT Y LO LIMPIAMOS
					// SI ESTÁ VACÍO NO AÑADIMOS Y MOSTRAMOS UN TOAST.
					// ///////////////////////////////////////////////////
					if (!edt1.getText().toString().equals(""))
						{
						listItems.add(edt1.getText().toString());
						edt1.setText("");
						// ///////////////////////////////////////////////////
						// ASÍ HACEMOS QUE NUESTRO ADAPTADOR SE ACTUALICE
						// PARA MOSTRAR EL NUEVO ELEMENTO DEL LISTVIEW
						// ///////////////////////////////////////////////////
						adapter.notifyDataSetChanged();
						}
					else
						{
						Toast.makeText(getApplicationContext(), "No has introducido nada", Toast.LENGTH_SHORT).show();
						}
					}
			});
		}

	// ///////////////////////////////////////////////////
	// CONTEXTMENU PARA ELIMINAR ITEMS
	// ///////////////////////////////////////////////////
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
		{
		menu.add(Menu.NONE, CONTEXT_MENU_DELETE_ITEM, Menu.NONE, "Borrar");
		menu.add(Menu.NONE, CONTEXT_MENU_CANCEL, Menu.NONE, "Cancelar");
		}
	// ///////////////////////////////////////////////////
	// ESCUCHADOR DEL CONTEXTMENU PARA ELIMINAR LOS ITEMS
	// ///////////////////////////////////////////////////
	@Override
	public boolean onContextItemSelected(MenuItem item)
		{
		// ///////////////////////////////////////////////////
		// CON ESTA VARIABLE PODREMOS SABER QUÉ ELEMENTO 
		// DEL LISTVIEW HA SIDO PULSADO (ENTRE OTRAS COSAS)
		// ///////////////////////////////////////////////////
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

		switch (item.getItemId())
			{
			// ///////////////////////////////////////////////////
			// SI HEMOS PULSADO EL BOTÓN ELIMINAR INFORMAMOS
			// DEL ELEMENTO ELIMINADO CON UN TOAST, LO ELIMINAMOS
			// DE NUESTRO ARRAYLIST Y ACTUALIZAMOS EL ADAPTADOR
			// PARA QUE EL ELEMENTO DESAPAREZCA DEL LISTVIEW
			// ///////////////////////////////////////////////////
			case CONTEXT_MENU_DELETE_ITEM:
				Toast.makeText(getApplicationContext(), ls1.getItemAtPosition(info.position).toString() + " eliminado", Toast.LENGTH_SHORT).show();
				listItems.remove(info.position);
				adapter.notifyDataSetChanged();
				return (true);
			}
		return (super.onOptionsItemSelected(item));
		}
	}
