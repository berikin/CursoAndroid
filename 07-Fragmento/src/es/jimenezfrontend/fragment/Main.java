package es.jimenezfrontend.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class Main extends FragmentActivity implements InputFragment.ToolbarListener {
	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.layout_main );
	}

	@Override
	public void onButtonClick ( String text ) {
		OutputFragment textFragment = ( OutputFragment ) getSupportFragmentManager ().findFragmentById ( R.id.second_fragment );
		textFragment.changeTextProperties ( text );

	}

}
