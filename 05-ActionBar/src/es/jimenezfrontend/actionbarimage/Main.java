package es.jimenezfrontend.actionbarimage;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Main extends Activity {

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.layout_main );
	}

	@Override
	public boolean onCreateOptionsMenu ( Menu menu ) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater ().inflate ( R.menu.main, menu );
		return true;
	}

	@Override
	public boolean onOptionsItemSelected ( MenuItem item ) {
		switch ( item.getItemId () ) {
			case R.id.camera:
				Toast.makeText ( getApplicationContext (), getResources ().getString ( R.string.launching ) + " " + getResources ().getString ( R.string.camera ), Toast.LENGTH_LONG ).show ();
				return true;
			case R.id.contacts:
				Toast.makeText ( getApplicationContext (), getResources ().getString ( R.string.launching ) + " " + getResources ().getString ( R.string.contacts ), Toast.LENGTH_LONG ).show ();
				return true;
			case R.id.settings:
				Toast.makeText ( getApplicationContext (), getResources ().getString ( R.string.launching ) + " " + getResources ().getString ( R.string.settings ), Toast.LENGTH_LONG ).show ();
				return true;
			default:
				return super.onOptionsItemSelected ( item );
		}
	}
}
