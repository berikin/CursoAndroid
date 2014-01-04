package es.jimenezfrontend.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IntentOne extends Activity{
	private TextView number;
	private Button return_to_main;
	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.first_layout );
		number = (TextView)findViewById ( R.id.numberOneLayout );
		return_to_main= (Button)findViewById ( R.id.buttonOneLayout );
		Bundle bundle = this.getIntent().getExtras();
        number.setText(bundle.getInt("number")+"");
        return_to_main.setOnClickListener ( new OnClickListener() {
			
			@Override
			public void onClick ( View v ) {
				Toast.makeText ( getApplicationContext (), "Lanzando actividad principal", Toast.LENGTH_LONG ).show ();
                Intent intent =  new Intent(IntentOne.this, Main.class);
                Bundle b = new Bundle();
                b.putInt("number", Integer.parseInt ( number.getText ().toString () ));
                intent.putExtras(b);
                startActivity(intent);
			}
		} );
	}
}
