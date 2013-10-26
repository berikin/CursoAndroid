package es.jimenezfrontend.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Main extends Activity
	{
	// ////////////////////////////////////////////////////
	// ATRIBUTOS UTILIZADOS
	// ////////////////////////////////////////////////////
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
		// ////////////////////////////////////////////////////
		// RECOGEMOS LOS ELEMENTOS DEL LAYOUT XML NECESARIOS
		// ////////////////////////////////////////////////////
		result = (TextView) findViewById(R.id.resultView);
		rmore = (RadioButton) findViewById(R.id.more);
		rless = (RadioButton) findViewById(R.id.less);
		btnequals = (Button) findViewById(R.id.button_calculate);
		rgroup = (RadioGroup) findViewById(R.id.operationGroup);
		// ////////////////////////////////////////////////////
		// ESCUCHADOR DEL RADIOGROUP PARA ASIGNAR LA OPERACIÓN
		// ////////////////////////////////////////////////////
		rgroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
			{
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId)
					{
					switch (checkedId)
						{
						// ////////////////////////////////////////////////////
						// TANTO EN LA SUMA COMO EN LA RESTA PRIMERO
						// COMPROBAMOS QUE SE HAYA INTRODUCIDO EL 1º OPERANDO
						// ////////////////////////////////////////////////////
						case R.id.more:

							if (value1.equals(""))
								{
								result.setText("No has escrito el primer operando");
								rmore.setChecked(false);
								}
							else
								{
								operation = 1; // LA OPERACION INT 1 EQUIVALE A SUMA
								secondVal = true; // ESTA BOOLEANA SIRVE PARA SABER SI ASIGNAR LOS NUEVOS NÚMEROS EN EL SEGUNDO OPERANDO
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
								operation = 2; // LA OPERACIÓN INT 2 EQUIVALE A RESTA
								secondVal = true; // ESTA BOOLEANA SIRVE PARA SABER SI ASIGNAR LOS NUEVOS NÚMEROS EN EL SEGUNDO OPERANDO
								}
							break;
						}
					}
			});
		// ////////////////////////////////////////////////////
		// ESCUCHADOR DEL BOTÓN PARA SACAR EL RESULTADO
		// ////////////////////////////////////////////////////
		btnequals.setOnClickListener(new OnClickListener()
			{

				@Override
				public void onClick(View v)
					{
					// ////////////////////////////////////////////////////
					// EN EL SWITCH VEMOS LA OPERACIÓN. SI ÉSTA ES 0
					// SIGNIFICA QUE NO HAY NINGUNA OPERACIÓN PENDIENTE
					// EN CASO DE SUMA O RESTA TAMBIÉN COMPROBAMOS QUE
					// HAYA VALORES EN AMBOS OPERANDOS. SI TODO ES CORRECTO
					// SE PROCEDE A REALIZAR LA OPERACIÓN Y RESETEAMOS
					// LAS VARIABLES PARA VOLVER A COMENZAR
					// ////////////////////////////////////////////////////
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
								secondVal = false;
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
								secondVal = false;
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

	// ////////////////////////////////////////////////////
	// EVENTO LANZADO POR LOS BOTONES NÚMERICOS
	// RECOGEMOS LA ID QUE HA LANZADO EL EVENTO Y PONEMOS
	// SU TEXTO EN NUESTRAS VARIABLES DE OPERANDOS
	// NOS APOYAMOS EN LA BOOLEANA PARA SABER SI SERÁ
	// UN VALOR ASIGNADO AL PRIMER O AL SEGUNDO OPERANDO
	// ////////////////////////////////////////////////////
	public void addnumber(View v)
		{
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
		}
	}
