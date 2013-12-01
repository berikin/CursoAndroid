package es.jimenezfrontend.greetings;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_second);
        TextView greeting_text = (TextView)findViewById(R.id.result_greetings);
        Bundle bundle = this.getIntent().getExtras();
        greeting_text.setText("Hola " + bundle.getString("name"));
	}
}
