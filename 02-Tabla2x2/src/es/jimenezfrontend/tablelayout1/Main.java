package es.jimenezfrontend.tablelayout1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.view.View.OnClickListener;

public class Main extends Activity {
	private TextView tv1, tv2, tv3, tv4;
	private Button bt1;
	private boolean touch = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		tv1 = (TextView) findViewById(R.id.textView1);
		tv2 = (TextView) findViewById(R.id.textView2);
		tv3 = (TextView) findViewById(R.id.textView3);
		tv4 = (TextView) findViewById(R.id.textView4);
		bt1 = (Button) findViewById(R.id.button1);
		bt1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (touch) {
					String txt1 = tv1.getText().toString();
					String txt2 = tv3.getText().toString();
					tv1.setText(tv2.getText().toString());
					tv3.setText(tv4.getText().toString());
					tv2.setText(txt1);
					tv4.setText(txt2);
					touch = false;
				} else {
					String txt1 = tv2.getText().toString();
					String txt2 = tv4.getText().toString();
					tv2.setText(tv1.getText().toString());
					tv4.setText(tv3.getText().toString());
					tv1.setText(txt1);
					tv3.setText(txt2);
					touch = true;
				}

			}
		});
	}

}
