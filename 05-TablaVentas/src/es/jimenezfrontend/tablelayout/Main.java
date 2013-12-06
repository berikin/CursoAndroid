package es.jimenezfrontend.tablelayout;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
	private LinearLayout form_main_layout, table_main_layout, layout_line;
	private LinearLayout.LayoutParams main_layout_params, line_layout_params, view_layout_params, edt_layout_params;
	private float scale;
	private EditText[] years_numbers;
	private Button tap_to_table, tap_to_form;
	private String[] years;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		scale = getResources ().getDisplayMetrics ().density;
		prepareForm ();
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

	private void prepareLineLayout () {
		layout_line = new LinearLayout ( getApplicationContext () );
		line_layout_params = new LayoutParams ( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );
		int dp_margins = ( int ) ( 6 * scale + 0.5f );
		line_layout_params.setMargins ( 0, dp_margins, 0, dp_margins );
		layout_line.setLayoutParams ( line_layout_params );
		layout_line.setOrientation ( LinearLayout.HORIZONTAL );
	}

	private void prepareForm () {
		form_main_layout = prepareMainLayout ( R.drawable.background );
		view_layout_params = new LayoutParams ( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		edt_layout_params = new LayoutParams ( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );
		int dp_margins = ( int ) ( 6 * scale + 0.5f );
		int dp_paddings = ( int ) ( 10 * scale + 0.5f );
		view_layout_params.setMargins ( dp_margins, dp_margins, dp_margins, dp_margins );
		edt_layout_params.setMargins ( dp_margins, dp_margins, dp_margins, dp_margins );
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		// RECOGEMOS LOS AÑOS
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		years = new String[5];
		years[0] = getResources ().getString ( R.string.td_year_2009 );
		years[1] = getResources ().getString ( R.string.td_year_2010 );
		years[2] = getResources ().getString ( R.string.td_year_2011 );
		years[3] = getResources ().getString ( R.string.td_year_2012 );
		years[4] = getResources ().getString ( R.string.td_year_2013 );
		years_numbers = new EditText[years.length];
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		// CREAMOS LOS TEXTVIEW Y EDITTEXT
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		for ( int i = 0; i < years.length; i++ ) {
			prepareLineLayout ();
			TextView line = new TextView ( getApplicationContext () );
			line.setText ( years[i] );
			line.setLayoutParams ( view_layout_params );
			line.setBackground ( getResources ().getDrawable ( R.drawable.rounded_corners ) );
			line.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
			line.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
			layout_line.addView ( line );
			years_numbers[i] = new EditText ( getApplicationContext () );
			years_numbers[i].setHint ( getResources ().getText ( R.string.number_hint ) );
			years_numbers[i].setLayoutParams ( edt_layout_params );
			years_numbers[i].setTextColor ( getResources ().getColor ( R.color.pureblack ) );
			years_numbers[i].setHintTextColor ( getResources ().getColor ( R.color.puresea ) );
			years_numbers[i].setOnFocusChangeListener ( new OnFocusChangeListener () { // CON ESTO CAMBIA EL COLOR DEL HINT AL TENER EL FOCO

						@Override
						public void onFocusChange ( View v, boolean hasFocus ) {
							if ( hasFocus ) {
								( ( EditText ) v ).setHintTextColor ( getResources ().getColor ( R.color.pureorange ) );
							}
							else {
								( ( EditText ) v ).setHintTextColor ( getResources ().getColor ( R.color.puresea ) );
							}

						}
					} );
			years_numbers[i].setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
			years_numbers[i].setBackground ( getResources ().getDrawable ( R.drawable.edt_selector_status ) );
			InputFilter[] prefix_filters = new InputFilter[1];
			prefix_filters[0] = new InputFilter.LengthFilter ( 5 );
			years_numbers[i].setFilters ( prefix_filters );
			years_numbers[i].setRawInputType ( InputType.TYPE_CLASS_NUMBER );
			layout_line.addView ( years_numbers[i] );
			form_main_layout.addView ( layout_line );
		}
		prepareLineLayout ();
		tap_to_table = new Button ( getApplicationContext () );
		tap_to_table.setText ( getResources ().getString ( R.string.button_to_table ) );
		tap_to_table.setLayoutParams ( edt_layout_params );
		tap_to_table.setBackground ( getResources ().getDrawable ( R.drawable.rounded_corners ) );
		tap_to_table.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
		tap_to_table.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
		layout_line.addView ( tap_to_table );
		form_main_layout.addView ( layout_line );
		tap_to_table.setOnClickListener ( new OnClickListener () {

			@Override
			public void onClick ( View v ) {
				validateNumbers ();
			}
		} );
		setContentView ( form_main_layout );
	}

	private void prepareTable () {
		int dp_margins = ( int ) ( 6 * scale + 0.5f );
		int dp_paddings = ( int ) ( 5 * scale + 0.5f );
		table_main_layout = prepareMainLayout ( R.drawable.background_2 );
		TableLayout table = new TableLayout ( getApplicationContext () );
		LinearLayout.LayoutParams table_layout_params = new LayoutParams ( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );
		TableLayout.LayoutParams trow_layout_params = new TableLayout.LayoutParams ( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );
		TableRow.LayoutParams cell_layout_params = new TableRow.LayoutParams ( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		TableRow.LayoutParams double_cell_layout_params = new TableRow.LayoutParams ( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		table_layout_params.setMargins ( dp_margins, dp_margins, dp_margins, dp_margins );
		double_cell_layout_params.span = 2;
		table.setLayoutParams ( table_layout_params );
		table.setStretchAllColumns ( true );
		table.setBackgroundColor ( getResources ().getColor ( R.color.translucid_white ) );
		TableRow tbrow = new TableRow ( getApplicationContext () );
		tbrow.setLayoutParams ( trow_layout_params );
		TextView thead = new TextView ( getApplicationContext () );
		thead.setText ( getResources ().getString ( R.string.th_year ) );
		thead.setBackground ( getResources ().getDrawable ( R.drawable.table_cell ) );
		thead.setLayoutParams ( cell_layout_params );
		thead.setGravity ( Gravity.CENTER );
		thead.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
		thead.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
		tbrow.addView ( thead );
		thead = new TextView ( getApplicationContext () );
		thead.setText ( getResources ().getString ( R.string.th_product ) );
		thead.setBackground ( getResources ().getDrawable ( R.drawable.table_cell ) );
		thead.setLayoutParams ( double_cell_layout_params );
		thead.setGravity ( Gravity.CENTER );
		thead.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
		thead.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
		tbrow.addView ( thead );
		table.addView ( tbrow );
		for ( int i = 0; i < years.length; i++ ) {
			tbrow = new TableRow ( getApplicationContext () );
			tbrow.setLayoutParams ( trow_layout_params );
			TextView tbody = new TextView ( getApplicationContext () );
			tbody.setText ( years[i] );
			tbody.setBackground ( getResources ().getDrawable ( R.drawable.table_cell ) );
			tbody.setLayoutParams ( cell_layout_params );
			tbody.setGravity ( Gravity.RIGHT );
			tbody.setPadding ( dp_paddings, dp_paddings, ( dp_paddings * 4 ), dp_paddings );
			tbody.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
			tbrow.addView ( tbody );
			tbody = new TextView ( getApplicationContext () );
			tbody.setText ( years_numbers[i].getText ().toString () );
			tbody.setGravity ( Gravity.RIGHT );
			tbody.setBackground ( getResources ().getDrawable ( R.drawable.table_cell ) );
			tbody.setLayoutParams ( double_cell_layout_params );
			tbody.setPadding ( dp_paddings, dp_paddings, ( dp_paddings * 4 ), dp_paddings );
			tbody.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
			tbrow.addView ( tbody );
			table.addView ( tbrow );
		}
		tbrow = new TableRow ( getApplicationContext () );
		tbrow.setLayoutParams ( trow_layout_params );
		TextView tfooter = new TextView ( getApplicationContext () );
		tfooter.setText ( getResources ().getString ( R.string.td_total ) );
		tfooter.setBackground ( getResources ().getDrawable ( R.drawable.table_cell ) );
		tfooter.setLayoutParams ( double_cell_layout_params );
		tfooter.setGravity ( Gravity.RIGHT );
		tfooter.setPadding ( dp_paddings, dp_paddings, ( dp_paddings * 4 ), dp_paddings );
		tfooter.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
		tbrow.addView ( tfooter );
		tfooter = new TextView ( getApplicationContext () );
		int result = 0;
		for ( int i = 0; i < years_numbers.length; i++ ) {
			result += Integer.valueOf ( years_numbers[i].getText ().toString () );
		}

		tfooter.setText ( Integer.toString ( result ) );
		tfooter.setGravity ( Gravity.RIGHT );
		tfooter.setBackground ( getResources ().getDrawable ( R.drawable.table_cell ) );
		tfooter.setLayoutParams ( cell_layout_params );
		tfooter.setPadding ( dp_paddings, dp_paddings, ( dp_paddings * 4 ), dp_paddings );
		tfooter.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
		tbrow.addView ( tfooter );
		table.addView ( tbrow );
		table_main_layout.addView ( table );
		tap_to_form = new Button ( getApplicationContext () );
		tap_to_form.setText ( getResources ().getString ( R.string.button_to_form ) );
		tap_to_form.setLayoutParams ( table_layout_params );
		tap_to_form.setBackground ( getResources ().getDrawable ( R.drawable.rounded_corners ) );
		tap_to_form.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
		tap_to_form.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
		table_main_layout.addView ( tap_to_form );
		tap_to_form.setOnClickListener ( new OnClickListener () {

			@Override
			public void onClick ( View v ) {
				prepareForm ();
			}
		} );
		setContentView ( table_main_layout );
	}

	private void validateNumbers () {
		boolean valid = true;
		String invalids = "Rellena ";
		for ( int i = 0; i < years_numbers.length; i++ ) {
			int check_number = Integer.MAX_VALUE;
			try {
				check_number = Integer.valueOf ( years_numbers[i].getText ().toString () );
			}
			catch ( NumberFormatException ex ) {}
			if ( years_numbers[i].getText ().toString ().isEmpty () || check_number == Integer.MAX_VALUE ) {
				valid = false;
				invalids += " - " + years[i];
			}
		}
		if ( valid ) {
			prepareTable ();
		}
		else {
			Toast.makeText ( getApplicationContext (), invalids, Toast.LENGTH_SHORT ).show ();
		}
	}
}
