package es.jimenezfrontend.web;

import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity {
	private Button external_app, internal_app;
	private EditText input_url;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.layout_main );
		input_url = ( EditText ) findViewById ( R.id.input_url );
		external_app = ( Button ) findViewById ( R.id.btn_app );
		internal_app = ( Button ) findViewById ( R.id.btn_internal );
		external_app.setOnClickListener ( new OnClickListener () {

			@Override
			public void onClick ( View arg0 ) {

				URL url;
				try {
					url = new URL ( input_url.getText ().toString () );
				}
				catch ( Exception e ) {
					url = null;
				}
				if ( url != null ) {
					Intent webIntent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( input_url.getText ().toString () ) );
					startActivity ( webIntent );
				}
				else {
					Toast.makeText ( getApplicationContext (), "Introduce una URL válida", Toast.LENGTH_LONG ).show ();
				}

			}
		} );
		internal_app.setOnClickListener ( new OnClickListener () {

			@Override
			public void onClick ( View arg0 ) {

				URL url;
				try {
					url = new URL ( input_url.getText ().toString () );
				}
				catch ( Exception e ) {
					url = null;
				}
				if ( url != null ) {
					Intent internal_intent = new Intent ( Main.this, Show_web.class );
					Bundle b = new Bundle ();
					b.putString ( "url", input_url.getText ().toString () );
					internal_intent.putExtras ( b );
					startActivity ( internal_intent );
				}
				else {
					Toast.makeText ( getApplicationContext (), "Introduce una URL válida", Toast.LENGTH_LONG ).show ();
				}

			}
		} );
	}

}
