package es.jimenezfrontent.image;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Main extends Activity{
	private TextView touch_text;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		touch_text=(TextView)findViewById(R.id.touch_text);
		registerForContextMenu(touch_text);
		}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo){
	    super.onCreateContextMenu(menu, v, menuInfo);
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.context_menu_one, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.context_one:
		        Intent shareIntent = new Intent(Main.this, SecondActivity.class);
		        int d = R.drawable.gallery;  
		        shareIntent.putExtra("imagebitmap", Integer.toString(d));
		        startActivity(shareIntent);
	            return true;
	        case R.id.context_two:
	            System.exit(1);
	            return true;
	        default:
	            return super.onContextItemSelected(item);
	    }
	}
}
