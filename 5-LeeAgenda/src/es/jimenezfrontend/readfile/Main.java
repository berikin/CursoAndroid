package es.jimenezfrontend.readfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Main extends Activity {
	private float scale;
	private LinearLayout form_main_layout;
	private LinearLayout.LayoutParams main_layout_params, view_layout_params, table_main_layout_params;
	private TableLayout main_table;
	private TableRow row;
	private String temp;
	private String[] cells;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		scale = getResources ().getDisplayMetrics ().density;
		prepareForm ();
		prepareTable ();
		cells = readFile ();
		if ( cells != null ) {
			for ( int i = 0; i < cells.length; i++ ) {
				prepareCell ( cells[i] );
			}
		}
		form_main_layout.addView ( main_table );
		setContentView ( form_main_layout );
	}

	private LinearLayout prepareMainLayout ( int bg_id ) {
		LinearLayout target_layout = new LinearLayout ( getApplicationContext () );
		main_layout_params = new LayoutParams ( LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT );
		int dp_margins = ( int ) ( 6 * scale + 0.5f );
		main_layout_params.setMargins ( dp_margins, dp_margins, dp_margins, dp_margins );
		target_layout.setLayoutParams ( main_layout_params );
		target_layout.setBackground ( getResources ().getDrawable ( bg_id ) );
		target_layout.setOrientation ( LinearLayout.VERTICAL );
		return target_layout;
	}

	private void prepareForm () {
		form_main_layout = prepareMainLayout ( R.drawable.background );
		view_layout_params = new LayoutParams ( LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT );
		int dp_margins = ( int ) ( 6 * scale + 0.5f );
		view_layout_params.setMargins ( dp_margins, dp_margins, dp_margins, dp_margins );
		form_main_layout.setLayoutParams ( view_layout_params );

	}

	private void prepareTable () {
		main_table = new TableLayout ( getApplicationContext () );
		table_main_layout_params = new LayoutParams ( LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT );
		main_table.setLayoutParams ( table_main_layout_params );
	}

	private void prepareCell ( String cells ) {
		row = new TableRow ( getApplicationContext () );
		String[] cell_results = cells.split ( "-" );
		for ( int i = 0; i < cell_results.length; i++ ) {
			TextView tv = new TextView ( getApplicationContext () );
			tv.setText ( cell_results[i] );
			row.addView ( tv );
		}
		main_table.addView ( row );
	}

	private String[] readFile () {
		String[] return_str = null;
		File f = new File ( Environment.getDataDirectory () + "/data/personas/personas.txt" );
		Log.d ( "dir", Environment.getDataDirectory () + "/data/personas/personas.txt" );
		Log.d ( "existe", f.exists () + "" );

		if ( f.exists () ) {
			FileInputStream fin;
			try {
				fin = new FileInputStream ( f );
				int c;
				temp = "";
				while ( ( c = fin.read () ) != -1 ) {
					temp = temp + Character.toString ( ( char ) c );
				}
				fin.close ();
				Log.d ( "existe", temp );
				return_str = temp.split ( "\n" );
				return return_str;
			}
			catch ( FileNotFoundException e ) {
				Log.e ( "error", e.toString ());
			}
			catch ( IOException e ) {
				Log.e ( "error", e.toString ());
			}
		}

		return return_str;
	}
}
