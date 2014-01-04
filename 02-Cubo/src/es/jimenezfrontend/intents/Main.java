package es.jimenezfrontend.intents;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
	private Spinner to_intent_one, to_intent_two;
	private List<Integer> numbers = new ArrayList<Integer> ();
	private TextView cube;
	private int spinner_counter = 0;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.main_layout );
		to_intent_one = ( Spinner ) findViewById ( R.id.to_one_Spinner );
		to_intent_two = ( Spinner ) findViewById ( R.id.to_two_Spinner );
		cube = ( TextView ) findViewById ( R.id.result_number );
		for ( int i = 1; i < 101; i++ ) {
			numbers.add ( i );
		}
		ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer> ( getApplicationContext (), android.R.layout.simple_spinner_item, numbers );
		adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
		to_intent_one.setAdapter ( adapter );
		to_intent_two.setAdapter ( adapter );
		to_intent_one.setOnItemSelectedListener ( new OnItemSelectedListener () {

			@Override
			public void onItemSelected ( AdapterView<?> parent, View view, int position, long id ) {
				spinner_counter++;
				if ( spinner_counter > 2 ) {
					Toast.makeText ( getApplicationContext (), "Lanzando actividad 1", Toast.LENGTH_LONG ).show ();
					Intent intent = new Intent ( Main.this, IntentOne.class );
					Bundle b = new Bundle ();
					b.putInt ( "number", numbers.get ( position ) );
					intent.putExtras ( b );
					startActivity ( intent );
				}
			}

			@Override
			public void onNothingSelected ( AdapterView<?> arg0 ) {

			}

		} );
		to_intent_two.setOnItemSelectedListener ( new OnItemSelectedListener () {

			@Override
			public void onItemSelected ( AdapterView<?> parent, View view, int position, long id ) {
				spinner_counter++;
				if ( spinner_counter > 2 ) {
					Toast.makeText ( getApplicationContext (), "Lanzando actividad 2", Toast.LENGTH_LONG ).show ();
					Intent intent = new Intent ( Main.this, IntentTwo.class );
					Bundle b = new Bundle ();
					b.putInt ( "number", numbers.get ( position ) );
					intent.putExtras ( b );
					startActivity ( intent );
				}
			}

			@Override
			public void onNothingSelected ( AdapterView<?> arg0 ) {

			}

		} );
		try {
			Bundle bundle = this.getIntent ().getExtras ();
			cube.setText ( "El cubo es: " + ( bundle.getInt ( "number" ) * bundle.getInt ( "number" ) * bundle.getInt ( "number" ) ) );
		}
		catch ( Exception e ) {}
	}

}
