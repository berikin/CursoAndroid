package es.jimenezfrontend.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main extends Activity {
	private Bitmap pic_post;
	private ImageView the_image;
	private LinearLayout original_view;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.layout_main );
		the_image = ( ImageView ) findViewById ( R.id.the_image );
		original_view = ( LinearLayout ) findViewById ( R.id.original_layout );
	}

	public void click_button ( View v ) {
		displayNotificacion ();
	}

	private void displayNotificacion () {
		pic_post = loadBitmapFromView ( the_image );
		Notification noti = new Notification.Builder ( getApplicationContext () ).setContentTitle ( "Foto " ).setContentText ( "Esta es la foto" ).setSmallIcon ( R.drawable.ic_launcher ).setLargeIcon ( pic_post ).setStyle ( new Notification.BigPictureStyle ().bigPicture ( pic_post ) ).build ();
		original_view.removeView ( the_image );
		NotificationManager notificationManager = ( NotificationManager ) getSystemService ( NOTIFICATION_SERVICE );

		notificationManager.notify ( 0, noti );
	}

	public static Bitmap loadBitmapFromView ( View v ) {
		Bitmap b = Bitmap.createBitmap ( v.getLayoutParams ().width, v.getLayoutParams ().height, Bitmap.Config.ARGB_8888 );
		Canvas c = new Canvas ( b );
		v.layout ( 0, 0, v.getLayoutParams ().width, v.getLayoutParams ().height );
		v.draw ( c );
		return b;
	}
}
