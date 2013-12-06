package es.jimenezfrontent.image;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SecondActivity extends Activity{
	private ImageView img_view;
	private LinearLayout parent_layout;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_second);
		img_view=new ImageView(this);
		parent_layout=(LinearLayout)findViewById(R.id.gallery_parent);
        Bundle bundle = this.getIntent().getExtras();
        String bmp=bundle.getString("imagebitmap");
		int number=Integer.valueOf(bmp);
		img_view.setImageDrawable(getResources().getDrawable(number));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        img_view.setLayoutParams(layoutParams);
		parent_layout.addView(img_view);
	}
}
