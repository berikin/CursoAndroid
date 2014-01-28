package es.jimenezfrontend.readfromsd;

import java.io.File;
import java.util.Date;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;

public class Main extends Activity
	{
	private File sdcard;
	private Bitmap myBitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		sdcard = Environment.getExternalStorageDirectory();
		File file_one = new File(sdcard, "pic_one.png");
		File file_two = new File(sdcard, "pic_two.png");
		Date mod1 = new Date(file_one.lastModified());
		Date mod2 = new Date(file_two.lastModified());
		Log.d("fichero_1", mod1.toString());
		Log.d("fichero_2", mod2.toString());
		if (file_one.lastModified() > file_two.lastModified())
			{
			myBitmap = BitmapFactory.decodeFile(file_one.getAbsolutePath());
			}
		else
			{
			myBitmap = BitmapFactory.decodeFile(file_two.getAbsolutePath());
			}
		ImageView myImage = (ImageView) findViewById(R.id.image);
		myImage.setImageBitmap(myBitmap);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
		{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		}

	}
