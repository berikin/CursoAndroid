package es.jimenezfrontend.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class Details extends FragmentActivity {
	public static final String EXTRA_TEXT = "es.jimenezfrontend.fragments.EXTRA_TEXT";

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.layout_details );
		Worker_Details_Fragment details = ( Worker_Details_Fragment ) getSupportFragmentManager ().findFragmentById ( R.id.show_fragment_worker_details );
		details.showDetails ( getIntent ().getStringExtra ( EXTRA_TEXT ) );
	}
}
