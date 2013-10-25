package es.jimenezfrontend.spinner;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Main extends Activity
	{
	private Spinner sp1;
	private TextView t1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		t1 = (TextView) findViewById(R.id.textView1);
		sp1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors_values, android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp1.setAdapter(adapter);
		sp1.setOnItemSelectedListener(new OnItemSelectedListener()
			{

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3)
					{
					// TODO Auto-generated method stub
					switch (position)
						{
						case 0:
							t1.setBackgroundColor(getResources().getColor(R.color.dark_red));
							break;
						case 1:
							t1.setBackgroundColor(getResources().getColor(R.color.dark_blue));
							break;
						case 2:
							t1.setBackgroundColor(getResources().getColor(R.color.dark_yellow));
							break;
						case 3:
							t1.setBackgroundColor(getResources().getColor(R.color.dark_green));
							break;
						default:
							break;
						}
					}

				@Override
				public void onNothingSelected(AdapterView<?> arg0)
					{
					// TODO Auto-generated method stub

					}

			});
		}
	}
