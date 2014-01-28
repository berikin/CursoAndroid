package es.jimenezfrontend.select_cities;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

public class Main extends Activity {
	private boolean[] checks = { false, false, false, false, false, false, false, false, false };
	final String[] cities = { "Ávila", "Burgos", "León", "Palencia", "Salamanca", "Segovia", "Soria", "Valladolid", "Zamora" };

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.layout_main );
	}

	public void open_dialog ( View v ) {
		select_cities ();
	}

	public AlertDialog select_cities () {
		AlertDialog.Builder builder = new AlertDialog.Builder ( this );
		builder.setTitle ( "Ciudades" ).setMultiChoiceItems ( cities, null, new DialogInterface.OnMultiChoiceClickListener () {

			@Override
			public void onClick ( DialogInterface dialog, int which, boolean isChecked ) {
				if ( checks[which] ) {
					checks[which] = false;
				}
				else {
					checks[which] = true;
				}
				String cities_selected = "";
				for ( int i = 0; i < checks.length; i++ ) {
					if ( checks[i] ) {
						if ( cities_selected.equals ( "" ) ) {
							cities_selected += cities[i];
						}
						else {
							cities_selected += ", " + cities[i];
						}
					}
				}
				Toast.makeText ( getApplicationContext (), "Ciudades seleccionadas: " + cities_selected, Toast.LENGTH_SHORT ).show ();
			}
		} );

		builder.create ();
		builder.show ();

		return null;
	}

}