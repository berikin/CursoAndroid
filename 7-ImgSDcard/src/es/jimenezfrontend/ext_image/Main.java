package es.jimenezfrontend.ext_image;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main extends Activity
	{
	private static final int SAVE = 0;
	private Button save_two;
	private ImageView pic_one, pic_two;
	private Bitmap pic_save;
	private File sdcard;
	private LinearLayout original_view;

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		original_view = (LinearLayout) findViewById(R.id.main_layout);
		pic_one = (ImageView) findViewById(R.id.pic_one);
		pic_two = (ImageView) findViewById(R.id.pic_two);
		save_two = (Button) findViewById(R.id.btn_save);
		save_two.setOnClickListener(new OnClickListener()
			{

				@Override
				public void onClick(View v)
					{
					saveBitMaps(pic_two, "pic_two.png");
					Toast.makeText(getApplicationContext(), "Imagen almacenada en la tarjeta SD", Toast.LENGTH_LONG).show();
					original_view.removeView(pic_two);
					original_view.removeView(save_two);
					}
			});
		registerForContextMenu(pic_one);

		}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
		{
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("Guardar");
		menu.add(Menu.NONE, SAVE, Menu.NONE, "Guardar");

		}

	public boolean onContextItemSelected(MenuItem item)
		{
		switch (item.getItemId())
			{
			case SAVE:
				saveBitMaps(pic_one, "pic_one.png");
				Toast.makeText(getApplicationContext(), "Imagen almacenada en la tarjeta SD", Toast.LENGTH_LONG).show();
				original_view.removeView(pic_one);
				break;

			}
		return super.onContextItemSelected(item);
		}

	public void saveBitMaps(ImageView pic, String savename)
		{
		pic_save = loadBitmapFromView(pic);
		sdcard = Environment.getExternalStorageDirectory();
		File f = new File(sdcard, savename);
		FileOutputStream out;
		try
			{
			out = new FileOutputStream(f);
			pic_save.compress(Bitmap.CompressFormat.PNG, 90, out);
			}
		catch (FileNotFoundException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}

	public static Bitmap loadBitmapFromView(View v)
		{
		Bitmap b = Bitmap.createBitmap(v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
		Canvas c = new Canvas(b);
		v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
		v.draw(c);
		return b;
		}
	}
