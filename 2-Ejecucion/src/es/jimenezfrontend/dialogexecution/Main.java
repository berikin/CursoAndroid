package es.jimenezfrontend.dialogexecution;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class Main extends Activity {

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.layout_main );
		AlertDialog.Builder dialog_init = new AlertDialog.Builder ( this );
		dialog_init.setTitle ( "¡Importante!" );
		dialog_init.setMessage ( "¿Quieres ejecutar la aplicación?" );
		dialog_init.setCancelable ( false );
		dialog_init.setPositiveButton ( "Si", new DialogInterface.OnClickListener () {

			@Override
			public void onClick ( DialogInterface dialog, int which ) {
				go_to_accept ();
			}
		} );
		dialog_init.setNegativeButton ( "No", new DialogInterface.OnClickListener () {

			@Override
			public void onClick ( DialogInterface dialog, int which ) {
				go_to_stop ();
			}
		} );
		dialog_init.create ();
		dialog_init.show ();

	}

	public void go_to_accept () {
		Toast.makeText ( getApplicationContext (), "Bienvenido", Toast.LENGTH_LONG ).show ();
	}

	public void go_to_stop () {
		Toast.makeText ( getApplicationContext (), "Gracias por tu tiempo", Toast.LENGTH_LONG ).show ();
		finish ();
	}

}
