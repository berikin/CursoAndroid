package es.jimenezfrontend.texttotable;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity
	{
	private EditText et1;
	private TextView[] tvs;

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		et1=(EditText)findViewById(R.id.text);
		tvs=new TextView[9];
		tvs[0]=(TextView)findViewById(R.id.tv1);
		tvs[1]=(TextView)findViewById(R.id.tv2);
		tvs[2]=(TextView)findViewById(R.id.tv3);
		tvs[3]=(TextView)findViewById(R.id.tv4);
		tvs[4]=(TextView)findViewById(R.id.tv5);
		tvs[5]=(TextView)findViewById(R.id.tv6);
		tvs[6]=(TextView)findViewById(R.id.tv7);
		tvs[7]=(TextView)findViewById(R.id.tv8);
		tvs[8]=(TextView)findViewById(R.id.tv9);
		et1.addTextChangedListener(new TextWatcher()
			{
				
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count)
					{
					// TODO Auto-generated method stub
					String text=et1.getText().toString();
					for (int i=0; i<tvs.length;i++)
						{tvs[i].setText(text);}
					}
				
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after)
					{
					// TODO Auto-generated method stub
					
					}
				
				@Override
				public void afterTextChanged(Editable s)
					{
					// TODO Auto-generated method stub
					
					}
			});
		}
	}
