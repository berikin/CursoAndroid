package es.jimenezfrontend.spinner;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;

public class Main extends Activity {
	private LinearLayout main_layout;
	private LinearLayout.LayoutParams main_layout_params, view_layout_params;
	private TextView mark, student_hint, mark_hint;
	private Spinner studentSpinner;
	private List<String> names = new ArrayList<String> ();
	private String[] marks = { "3", "6", "7", "4", "10" };
	private float scale;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		scale = getResources ().getDisplayMetrics ().density;
		prepareMainLayout ();
		prepareSpinner ();
		drawLines ();
		setContentView ( main_layout );
	}

	private void prepareMainLayout () {
		main_layout = new LinearLayout ( getApplicationContext () );
		main_layout_params = new LayoutParams ( LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT );
		int dp_margins = ( int ) ( 6 * scale + 0.5f );
		main_layout_params.setMargins ( dp_margins, dp_margins, dp_margins, dp_margins );
		main_layout.setLayoutParams ( main_layout_params );
		main_layout.setBackground ( getResources ().getDrawable ( R.drawable.background ) );
		main_layout.setOrientation ( LinearLayout.VERTICAL );
	}

	@SuppressWarnings ( { "unchecked", "rawtypes" } )
	private void prepareSpinner () {
		names.add ( "Juan" );
		names.add ( "Pepe" );
		names.add ( "Manuel" );
		names.add ( "Teresa" );
		names.add ( "Deborah" );
		studentSpinner = new Spinner ( getApplicationContext () );
		ArrayAdapter<CharSequence> adapter = new ArrayAdapter ( getApplicationContext (), android.R.layout.simple_spinner_item, names );
		adapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
		studentSpinner.setAdapter ( adapter );
		studentSpinner.setOnItemSelectedListener ( new OnItemSelectedListener () {

			@Override
			public void onItemSelected ( AdapterView<?> parent, View view, int position, long id ) {
				mark.setText ( marks[position] );

			}

			@Override
			public void onNothingSelected ( AdapterView<?> arg0 ) {

			}

		} );
	}

	private void drawLines () {
		view_layout_params = new LayoutParams ( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );
		int dp_margins = ( int ) ( 8 * scale + 0.5f );
		int dp_paddings = ( int ) ( 10 * scale + 0.5f );
		view_layout_params.setMargins ( dp_margins, dp_margins, dp_margins, dp_margins );
		student_hint = new TextView ( getApplicationContext () );
		student_hint.setText ( getResources ().getText ( R.string.student_hint ) );
		student_hint.setLayoutParams ( view_layout_params );
		student_hint.setBackground ( getResources ().getDrawable ( R.drawable.rounded_corners ) );
		student_hint.setTextColor ( getResources ().getColor ( R.color.sea_witch ) );
		student_hint.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
		main_layout.addView ( student_hint );
		studentSpinner.setLayoutParams ( view_layout_params );
		studentSpinner.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
		main_layout.addView ( studentSpinner );
		mark_hint = new TextView ( getApplicationContext () );
		mark_hint.setText ( getResources ().getText ( R.string.mark_hint ) );
		mark_hint.setLayoutParams ( view_layout_params );
		mark_hint.setBackground ( getResources ().getDrawable ( R.drawable.rounded_corners ) );
		mark_hint.setTextColor ( getResources ().getColor ( R.color.sea_witch ) );
		mark_hint.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
		main_layout.addView ( mark_hint );
		dp_margins = ( int ) ( 10 * scale + 0.5f );
		view_layout_params.setMargins ( dp_margins, dp_margins, dp_margins, dp_margins );
		mark = new TextView ( getApplicationContext () );
		mark.setLayoutParams ( view_layout_params );
		mark.setText ( marks[0] );
		mark.setTextColor ( getResources ().getColor ( R.color.sea_witch ) );
		mark.setTextSize ( 20 * scale + 0.5f );
		mark.setGravity ( Gravity.CENTER );
		mark.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
		main_layout.addView ( mark );
	}
}
