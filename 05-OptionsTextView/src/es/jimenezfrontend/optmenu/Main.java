package es.jimenezfrontend.optmenu;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Main extends Activity
	{
	private TextView t1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		// ///////////////////////////////////////////////////////////
		// RECOGEMOS EL TEXTVIEW
		// ///////////////////////////////////////////////////////////
		t1 = (TextView) findViewById(R.id.tv1);
		}

	public boolean onCreateOptionsMenu(Menu menu)
		{
		getMenuInflater().inflate(R.menu.colors, menu);
		return true;
		}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
		{
		switch (item.getItemId())
			{
			case R.id.menu_to_red:
				t1.setBackgroundColor(getResources().getColor(R.color.dark_red));
				return true;
			case R.id.menu_to_blue:
				t1.setBackgroundColor(getResources().getColor(R.color.dark_blue));
				return true;
			case R.id.menu_to_yellow:
				t1.setBackgroundColor(getResources().getColor(R.color.dark_yellow));
				return true;
			case R.id.menu_to_green:
				t1.setBackgroundColor(getResources().getColor(R.color.dark_green));
				return true;
			default:
				return super.onOptionsItemSelected(item);
			}
		}
	}
