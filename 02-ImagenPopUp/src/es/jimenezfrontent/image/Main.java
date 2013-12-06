package es.jimenezfrontent.image;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import android.widget.TextView;

public class Main extends Activity {
	private TextView touch_text;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.layout_main );
		touch_text = ( TextView ) findViewById ( R.id.touch_text );
		registerForContextMenu ( touch_text );
		final PopupMenu popOptions = new PopupMenu ( this, touch_text );
		popOptions.inflate ( R.menu.pop_up_menu_one );
		try {
			Field[] fields = popOptions.getClass ().getDeclaredFields ();
			for ( Field field : fields ) {
				if ( "mPopup".equals ( field.getName () ) ) {
					field.setAccessible ( true );
					Object menuPopupHelper = field.get ( popOptions );
					Class<?> classPopupHelper = Class.forName ( menuPopupHelper.getClass ().getName () );
					Method setForceIcons = classPopupHelper.getMethod ( "setForceShowIcon", boolean.class );
					setForceIcons.invoke ( menuPopupHelper, true );
					break;
				}
			}
		}
		catch ( Exception e ) {
			Log.e ( "Forzar iconos", e.toString () );
		}
		popOptions.getMenu ();
		touch_text.setOnClickListener ( new OnClickListener () {
			@Override
			public void onClick ( View v ) {
				popOptions.show ();
			}
		} );
		popOptions.setOnMenuItemClickListener ( new PopupMenu.OnMenuItemClickListener () {
			@Override
			public boolean onMenuItemClick ( MenuItem item ) {
				switch ( item.getItemId () ) {
					case R.id.context_one:
						Intent shareIntent = new Intent ( Main.this, SecondActivity.class );
						int d = R.drawable.gallery;
						shareIntent.putExtra ( "imagebitmap", Integer.toString ( d ) );
						startActivity ( shareIntent );
						return true;
					case R.id.context_two:
						System.exit ( 1 );
						return true;
					default:
						return false;
				}
			}
		} );
	}
}
