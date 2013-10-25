package es.jimenezfrontend.bill;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;

public class Main extends Activity {
private Button bt1;
private EditText et1, et2;
private TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		bt1=(Button)findViewById(R.id.button1);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		tv1=(TextView)findViewById(R.id.textView3);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!et1.getText().toString().equals("") && !et2.getText().toString().equals(""))
				{
					double total,tax;
					total=Double.parseDouble(et1.getText().toString())*Integer.parseInt(et2.getText().toString());
					tax=total*0.21;
					tv1.setText((total+tax)+" Euros");
				}
			}
		});
	}

}
