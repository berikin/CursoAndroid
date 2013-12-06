package es.jimenezfrontend.linearcode;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class Main extends Activity {
	private LinearLayout main_layout, layout_line;
	private LinearLayout.LayoutParams main_layout_params, line_layout_params, view_layout_params;
	private EditText number, prefix;
	private TextView result_text;
	private TextWatcher editwatch;
	private float scale;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		scale = getResources ().getDisplayMetrics ().density;
		prepareMainLayout ();
		prepareWatcher ();
		drawLines ();
		setContentView ( main_layout );
		editTextInspector ();
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

	private void prepareLineLayout ( int mg_top ) {
		layout_line = new LinearLayout ( getApplicationContext () );
		line_layout_params = new LayoutParams ( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );
		int dp_margins = ( int ) ( 6 * scale + 0.5f );
		mg_top = ( int ) ( mg_top * scale + 0.5f );
		line_layout_params.setMargins ( 0, mg_top, 0, dp_margins );
		layout_line.setLayoutParams ( line_layout_params );
		layout_line.setOrientation ( LinearLayout.HORIZONTAL );
	}

	private void prepareWatcher () {
		editwatch = new TextWatcher () {

			@Override
			public void onTextChanged ( CharSequence s, int start, int before, int count ) {
				int dp_paddings = ( int ) ( 10 * scale + 0.5f );
				int prefix_value = Integer.MAX_VALUE, number_value = Integer.MAX_VALUE;
				try {
					prefix_value = Integer.valueOf ( prefix.getText ().toString () );
					number_value = Integer.valueOf ( number.getText ().toString () );
				}
				catch ( NumberFormatException ex ) {}
				if ( prefix_value != Integer.MAX_VALUE && number_value != Integer.MAX_VALUE && prefix.getText ().toString ().length () == 3 && number.getText ().toString ().length () == 6 ) {
					result_text.setText ( getResources ().getString ( R.string.valid_phone ) );
					result_text.setBackground ( getResources ().getDrawable ( R.drawable.valid_rounded_corners ) );
					result_text.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
					result_text.setTextColor ( getResources ().getColor ( R.color.puregreen ) );
				}
				else {
					result_text.setText ( getResources ().getString ( R.string.invalid_phone ) );
					result_text.setBackground ( getResources ().getDrawable ( R.drawable.invalid_rounded_corners ) );
					result_text.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
					result_text.setTextColor ( getResources ().getColor ( R.color.purered ) );
				}
			}

			@Override
			public void beforeTextChanged ( CharSequence s, int start, int count, int after ) {
				// NO LO USAMOS

			}

			@Override
			public void afterTextChanged ( Editable s ) {
				// NO LO USAMOS

			}
		};
	}

	private void editTextInspector () {
		prefix.addTextChangedListener ( editwatch );
		number.addTextChangedListener ( editwatch );
	}

	private void drawLines () {
		prepareLineLayout ( 80 );
		view_layout_params = new LayoutParams ( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		int dp_margins = ( int ) ( 6 * scale + 0.5f );
		int dp_paddings = ( int ) ( 10 * scale + 0.5f );
		view_layout_params.setMargins ( dp_margins, dp_margins, dp_margins, dp_margins );
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		// DEFINIENDO EL TEXTVIEW DE TELÉFONO
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		TextView phone_text = new TextView ( getApplicationContext () );
		phone_text.setText ( getResources ().getText ( R.string.phone_text ) );
		phone_text.setLayoutParams ( view_layout_params );
		phone_text.setBackground ( getResources ().getDrawable ( R.drawable.rounded_corners ) );
		phone_text.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
		phone_text.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
		layout_line.addView ( phone_text );
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		// DEFINIENDO EL EDIT TEXT DEL PREFIJO
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		prefix = new EditText ( getApplicationContext () );
		LinearLayout.LayoutParams prefix_layout_params = new LayoutParams ( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		prefix_layout_params.setMargins ( dp_margins, dp_margins, 0, dp_margins );
		prefix.setHint ( getResources ().getText ( R.string.prefix_hint ) );
		prefix.setLayoutParams ( prefix_layout_params );
		prefix.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
		prefix.setHintTextColor ( getResources ().getColor ( R.color.purepurple ) );
		prefix.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
		prefix.setBackground ( getResources ().getDrawable ( R.drawable.right_edittext_bg ) );
		prefix.setWidth ( ( int ) ( 100 * scale + 0.5f ) );
		InputFilter[] prefix_filters = new InputFilter[1];
		prefix_filters[0] = new InputFilter.LengthFilter ( 3 );
		prefix.setFilters ( prefix_filters );
		prefix.setRawInputType ( InputType.TYPE_CLASS_PHONE );
		layout_line.addView ( prefix );
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		// DEFINIENDO EL EDIT TEXT DEL NÚMERO
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		number = new EditText ( getApplicationContext () );
		LinearLayout.LayoutParams number_layout_params = new LayoutParams ( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );
		number_layout_params.setMargins ( 0, dp_margins, dp_margins, dp_margins );
		number.setHint ( getResources ().getText ( R.string.phone_hint ) );
		number.setLayoutParams ( number_layout_params );
		number.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
		number.setHintTextColor ( getResources ().getColor ( R.color.purepurple ) );
		number.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
		number.setBackground ( getResources ().getDrawable ( R.drawable.left_edittext_bg ) );
		InputFilter[] number_filters = new InputFilter[1];
		number_filters[0] = new InputFilter.LengthFilter ( 6 );
		number.setFilters ( number_filters );
		number.setRawInputType ( InputType.TYPE_CLASS_PHONE );
		layout_line.addView ( number );
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		// AÑADIENDO EL PRIMER LINEAR LAYOUT HORIZONTAL
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		main_layout.addView ( layout_line );
		prepareLineLayout ( 6 );
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		// DEFINIENDO EL TEXTVIEW DE TELÉFONO
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		TextView description_text = new TextView ( getApplicationContext () );
		description_text.setText ( getResources ().getText ( R.string.phone_description ) );
		description_text.setLayoutParams ( view_layout_params );
		description_text.setBackground ( getResources ().getDrawable ( R.drawable.rounded_corners ) );
		description_text.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
		description_text.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
		layout_line.addView ( description_text );
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		// DEFINIENDO EL TEXTVIEW DE RESULTADO
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		result_text = new TextView ( getApplicationContext () );
		view_layout_params = new LayoutParams ( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );
		view_layout_params.setMargins ( dp_margins, dp_margins, dp_margins, dp_margins );
		result_text.setLayoutParams ( view_layout_params );
		result_text.setBackground ( getResources ().getDrawable ( R.drawable.rounded_corners ) );
		result_text.setTextColor ( getResources ().getColor ( R.color.pureblack ) );
		result_text.setPadding ( dp_paddings, dp_paddings, dp_paddings, dp_paddings );
		result_text.setGravity ( Gravity.RIGHT );
		layout_line.addView ( result_text );
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		// AÑADIENDO EL SEGUNDO LINEAR LAYOUT HORIZONTAL
		// /////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////
		main_layout.addView ( layout_line );
	}
}
