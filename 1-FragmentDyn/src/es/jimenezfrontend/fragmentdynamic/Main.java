package es.jimenezfrontend.fragmentdynamic;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.WindowManager;

public class Main extends FragmentActivity {

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		WindowManager wm = getWindowManager ();
		Display display = wm.getDefaultDisplay ();
		Point screen_mobile = new Point ();
		display.getSize ( screen_mobile );

		if ( screen_mobile.x > screen_mobile.y ) {
			setContentView ( R.layout.layout_portrait );
		}
		else {
			setContentView ( R.layout.layout_vertical );
		}
	}

}
