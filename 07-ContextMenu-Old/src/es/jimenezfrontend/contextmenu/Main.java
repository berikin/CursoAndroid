package es.jimenezfrontend.contextmenu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity
	{
	private TextView contextmen;
	private View someView, root;
	@SuppressLint("CutPasteId")
	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		contextmen = (TextView) findViewById(R.id.viewContext);
		// ///////////////////////////////////////////////////////////////////////////
		// ASIGNAMOS EL CONTEXTMENU A NUESTRO TEXTVIEW
		// ///////////////////////////////////////////////////////////////////////////
		registerForContextMenu(contextmen);
		// ///////////////////////////////////////////////////////////////////////////
		// CON LAS SIGUIENTES 3 LÍNEAS LO QUE HACEMOS ES COGER EL VIEW PADRE DE
		// NUESTRA ACTIVIDAD PARA PODER CAMBIAR EL COLOR DE FONDO
		// ///////////////////////////////////////////////////////////////////////////
		someView = findViewById(R.id.viewContext);
		root = someView.getRootView();
		root.setBackgroundColor(getResources().getColor(R.color.black));
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
		{
		// ///////////////////////////////////////////////////////////////////////////
		// CREAMOS EL MENÚ DEL ACTIONBAR
		// ///////////////////////////////////////////////////////////////////////////
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		}

	@Override
	public boolean onContextItemSelected(MenuItem item)
		{
		switch (item.getItemId())
			{
			// ///////////////////////////////////////////////////////////////////////////
			// RECOGEMOS LA VISTA PADRE PARA CAMBIAR EL FONDO Y PONEMOS EL COLOR
			// DE FONDO Y DE TEXTO APROPIADOS
			// ///////////////////////////////////////////////////////////////////////////
			case R.id.toDefault:
				someView = findViewById(R.id.viewContext);
				root = someView.getRootView();
				root.setBackgroundColor(getResources().getColor(R.color.black));
				contextmen.setTextColor(getResources().getColor(R.color.black));
				contextmen.setBackgroundColor(getResources().getColor(R.color.white));
				Toast.makeText(this, "fondo por defecto", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.toPurple:
				someView = findViewById(R.id.viewContext);
				root = someView.getRootView();
				root.setBackgroundColor(getResources().getColor(R.color.purple));
				contextmen.setTextColor(getResources().getColor(R.color.white));
				contextmen.setBackgroundColor(getResources().getColor(R.color.black));
				Toast.makeText(this, "color cambiado a morado", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.toRed:
				someView = findViewById(R.id.viewContext);
				root = someView.getRootView();
				root.setBackgroundColor(getResources().getColor(R.color.red));
				contextmen.setTextColor(getResources().getColor(R.color.white));
				contextmen.setBackgroundColor(getResources().getColor(R.color.black));
				Toast.makeText(this, "color cambiado a rojo", Toast.LENGTH_SHORT).show();
				return true;
			default:
				return super.onContextItemSelected(item);
			}
		}

	@Override
	public void onCreateContextMenu(ContextMenu menu2, View v, ContextMenuInfo menuInfo)
		{
		// ///////////////////////////////////////////////////////////////////////////
		// CREAMOS EL MENÚ CONTEXTUAL
		// ///////////////////////////////////////////////////////////////////////////
		super.onCreateContextMenu(menu2, v, menuInfo);
		getMenuInflater().inflate(R.menu.context_menu, menu2);
		}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
		{
		// ///////////////////////////////////////////////////////////////////////////
		// NOTIFICACIONES PARA CLICKS EN EL ACTION BAR MENU
		// ///////////////////////////////////////////////////////////////////////////
		switch (item.getItemId())
			{
			case R.id.action_settings:
				return true;
			case R.id.item_one:
				Toast.makeText(this, getResources().getString(R.string.itemone) + " pulsado", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.item_two:
				Toast.makeText(this, getResources().getString(R.string.itemtwo) + " pulsado", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.subitem_one:
				Toast.makeText(this, getResources().getString(R.string.subitemone) + " pulsado", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.subitem_two:
				Toast.makeText(this, getResources().getString(R.string.subitemtwo) + " pulsado", Toast.LENGTH_SHORT).show();
				return true;
			default:
				return super.onOptionsItemSelected(item);
			}
		}
	}
