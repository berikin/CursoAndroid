package es.jimenezfrontend.listeners;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {
	private int actual_layout;
	private Button btn_layout, btn_toast;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		actual_layout = R.layout.layout_one;
		setContentView ( actual_layout );
		btn_layout = ( Button ) findViewById ( R.id.btn_layout );
		btn_toast = ( Button ) findViewById ( R.id.btn_toast );
		click_listener ();
	}

	private void click_listener () {
		btn_layout.setOnClickListener ( this );
		btn_toast.setOnClickListener ( this );
	}

	@Override
	public void onClick ( View v ) {
		switch ( v.getId () ) {
			case R.id.btn_layout:
				switch ( actual_layout ) {
					case R.layout.layout_one:
						actual_layout = R.layout.layout_two;
						setContentView ( actual_layout );
						btn_layout = ( Button ) findViewById ( R.id.btn_layout );
						btn_toast = ( Button ) findViewById ( R.id.btn_toast );
						click_listener ();
						break;

					case R.layout.layout_two:
						actual_layout = R.layout.layout_one;
						setContentView ( actual_layout );
						btn_layout = ( Button ) findViewById ( R.id.btn_layout );
						btn_toast = ( Button ) findViewById ( R.id.btn_toast );
						click_listener ();
						break;
				}
				break;

			case R.id.btn_toast:
				LayoutInflater inflater = getLayoutInflater ();
				View layout = inflater.inflate ( R.layout.custom_toast, ( ViewGroup ) findViewById ( actual_layout ) );
				Toast toast = new Toast ( getApplicationContext () );
				toast.setGravity ( Gravity.CENTER_VERTICAL, 0, 0 );
				toast.setDuration ( Toast.LENGTH_LONG );
				toast.setView ( layout );
				toast.show ();
				break;
		}

	}
}
