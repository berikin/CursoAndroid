package es.jimenezfrontend.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import es.jimenezfrontend.fragments.Workers_Fragment.GoToDetailsListener;

public class Main extends FragmentActivity implements GoToDetailsListener {

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.layout_main );
		Workers_Fragment workers_list = ( Workers_Fragment ) getSupportFragmentManager ().findFragmentById ( R.id.show_fragment_workers_list );
		workers_list.setWorkersListener ( this );
	}
	@Override
	public void onWokerSelected ( Worker c ) {
		boolean valid_details = ( getSupportFragmentManager ().findFragmentById ( R.id.show_fragment_worker_details ) != null );
		if(valid_details){
			( ( Worker_Details_Fragment ) getSupportFragmentManager ().findFragmentById ( R.id.show_fragment_worker_details ) ).showDetails ( c.getDetails () );
		}
		else {
			Intent i = new Intent ( this, Details.class );
			i.putExtra ( Details.EXTRA_TEXT, c.getDetails () );
			startActivity ( i );
		}
	}

}
