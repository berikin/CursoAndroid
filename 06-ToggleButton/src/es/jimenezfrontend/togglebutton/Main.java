package es.jimenezfrontend.togglebutton;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class Main extends Activity {
	private ToggleButton bt1;
	private ImageView img1, img2, img3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		bt1 = (ToggleButton) findViewById(R.id.toggleButton1);
		img1 = (ImageView) findViewById(R.id.imageView1);
		img2 = (ImageView) findViewById(R.id.ImageView2);
		img3 = (ImageView) findViewById(R.id.ImageView3);
		bt1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (bt1.isChecked()) {
					img1.setVisibility(View.VISIBLE);
					img2.setVisibility(View.VISIBLE);
					img3.setVisibility(View.VISIBLE);
				} else {
					img1.setVisibility(View.INVISIBLE);
					img2.setVisibility(View.INVISIBLE);
					img3.setVisibility(View.INVISIBLE);
				}
			}
		});
	}


}
