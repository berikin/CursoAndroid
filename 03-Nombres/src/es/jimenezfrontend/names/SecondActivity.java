package es.jimenezfrontend.names;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends Activity {
	private ListView data_list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_second);
        Bundle bundle = this.getIntent().getExtras();
        String[] names=bundle.getStringArray("names");
        Log.d("cosas",names[0]);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
		data_list = (ListView)findViewById(R.id.list_names_result);
		data_list.setBackgroundColor(getResources().getColor(R.color.silver));
		data_list.setAdapter(adapter);
	}
}
