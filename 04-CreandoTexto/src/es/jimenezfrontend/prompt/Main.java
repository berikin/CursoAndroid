package es.jimenezfrontend.prompt;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class Main extends Activity {
	private EditText key, number;
	private LinearLayout target_layout;
	private Button make_views;
	private float scale;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		scale = getResources ().getDisplayMetrics ().density;
		setContentView ( R.layout.layout_main );
		key = ( EditText ) findViewById ( R.id.key_input );
		number = ( EditText ) findViewById ( R.id.number_input );
		target_layout = (LinearLayout)findViewById ( R.id.results_layout );
		make_views = ( Button ) findViewById ( R.id.button_make );
		make_views.setOnClickListener ( new OnClickListener () {

			@Override
			public void onClick ( View v ) {
				int repeats = Integer.MAX_VALUE;
				try {
					repeats = Integer.parseInt ( number.getText ().toString () );
				}
				catch ( Exception e ) {}
				if ( !key.getText ().toString ().isEmpty () && repeats != Integer.MAX_VALUE ) {
					target_layout.removeAllViews ();
					LayoutParams view_layout_params = new LayoutParams ( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );
					int dp_margins = ( int ) ( 15 * scale + 0.5f );
					int dp_paddings = ( int ) ( 20 * scale + 0.5f );
					
					view_layout_params.setMargins ( dp_margins, dp_margins, dp_margins, dp_margins );
					for(int i=0; i<repeats;i++){
						TextView out_text=new TextView(getApplicationContext ());
						String the_text = " ";
						for (int j=0;j<(repeats-i);j++){
						the_text += key.getText ().toString ()+" ";
						}
						out_text.setLayoutParams ( view_layout_params );
						out_text.setText ( the_text );
						out_text.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
						out_text.setBackground ( getResources ().getDrawable ( R.drawable.rounded_corners ) );
						out_text.setTextColor ( getResources ().getColor ( R.color.pure_black ) );
						target_layout.addView ( out_text );
					}
				}
				else{
					Toast.makeText ( getApplicationContext(), "Primero rellena los campos", Toast.LENGTH_LONG ).show ();
				}

			}
		} );
	}
}
