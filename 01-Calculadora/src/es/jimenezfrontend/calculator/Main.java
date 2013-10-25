package es.jimenezfrontend.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Main extends Activity
	{
	private String value1 = "", value2 = "";
	private boolean secondVal = false;
	private int operation = 0;
	private TextView result;
	private Button btn, btnequals;
	private RadioButton rmore, rless;
	private RadioGroup rgroup;

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		rgroup = (RadioGroup) findViewById(R.id.operationGroup);
		result = (TextView) findViewById(R.id.resultView);
		rmore = (RadioButton) findViewById(R.id.more);
		rless = (RadioButton) findViewById(R.id.less);
		rgroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
			{
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId)
					{
					switch (checkedId)
						{
						case R.id.more:
						if (value1.equals(""))
							{
							result.setText("No has escrito el primer operando");
							rmore.setChecked(false);
							}
						else
							{
							operation = 1;
							secondVal=true;
							}
							break;

						case R.id.less:
						if (value1.equals(""))
							{
							result.setText("No has escrito el primer operando");
							rless.setChecked(false);
							}
						else
							{
							operation = 2;
							secondVal=true;
							}
						break;
						}
					}
			});
		btnequals = (Button) findViewById(R.id.button_calculate);
		btnequals.setOnClickListener(new OnClickListener()
			{

				@Override
				public void onClick(View v)
					{
					Log.d("Operacion",operation+"");
					Log.d("Valores",value1+"  "+value2);
					switch (operation)
						{
						case 0:
							result.setText("No has seleccionado una operación");
							break;
						case 1:
							if (!value1.equals("") && !value2.equals(""))
								{
								result.setText(value1 + "+" + value2 + " = " + (Integer.parseInt(value1) + Integer.parseInt(value2)));
								rmore.setChecked(false);
								rless.setChecked(false);
								value1 = "";
								value2 = "";
								operation = 0;
								secondVal=false;
								}
							else
								{
								result.setText("No has escrito los operandos");
								}
							break;
						case 2:
							if (!value1.equals("") && !value2.equals(""))
								{
								result.setText(value1 + "-" + value2 + " = " + (Integer.parseInt(value1) - Integer.parseInt(value2)));
								rmore.setChecked(false);
								rless.setChecked(false);
								value1 = "";
								value2 = "";
								operation = 0;
								secondVal=false;
								}
							else
								{
								result.setText("No has escrito los operandos");
								}
							break;
						default:
							break;
						}
					}
			});
		}

	public void addnumber(View v)
		{
		Log.d("prueba", "click");
		int button = v.getId();
		btn = (Button) findViewById(button);
		if (secondVal)
			{
			value2 += btn.getText().toString();
			result.setText(value2);
			}
		else
			{
			value1 += btn.getText().toString();
			result.setText(value1);
			}
		Log.d("prueba", value1 + " y " + value2);
		}
	}
