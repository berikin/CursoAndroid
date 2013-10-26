package es.jimenezfrontend.checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;

public class Main extends Activity
	{
	private CheckBox ch1;
	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		ch1 = (CheckBox) findViewById(R.id.cb1);
		img = (ImageView) findViewById(R.id.img1);
		// ///////////////////////////////////////////////////////////
		// EVENTO PARA COMPROBAR EL CAMBIO DE CHECK
		// ///////////////////////////////////////////////////////////
		ch1.setOnCheckedChangeListener(new OnCheckedChangeListener()
			{

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
					{
					if (ch1.isChecked())
						{
						img.setVisibility(ImageView.VISIBLE);
						}
					else
						{
						img.setVisibility(ImageView.INVISIBLE);
						}

					}
			});
		}

	}
