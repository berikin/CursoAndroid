package es.jimenezfrontend.bcreceivercall;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity {
	public static final String BROADCAST_CALLS = "es.jimenezfrontend.bcreceivercall.CallListener";
	public static final String BROADCAST_SMS = "es.jimenezfrontend.bcreceivercall.SmsListener";
	public static final String BROADCAST_GPS = "es.jimenezfrontend.bcreceivercall.LocListener";
	private Button calls_button, sms_button, gps_button;
	private CallListener callListener;
	private SmsListener smsListener;
	private LocListener locListener;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.main_layout );
		callListener = new CallListener ();
		smsListener = new SmsListener ();
		locListener = new LocListener ();
		calls_button = ( Button ) findViewById ( R.id.calls_button );
		calls_button.setOnClickListener ( new OnClickListener () {

			@Override
			public void onClick ( View arg0 ) {
				Toast.makeText ( getApplicationContext (), "Escuchando llamadas", Toast.LENGTH_LONG ).show ();
				IntentFilter intentFilter = new IntentFilter ( BROADCAST_CALLS );
				registerReceiver ( callListener, intentFilter );
				Intent intent = new Intent ( BROADCAST_CALLS );
				sendBroadcast ( intent );
			}
		} );
		sms_button = ( Button ) findViewById ( R.id.sms_button );
		sms_button.setOnClickListener ( new OnClickListener () {

			@Override
			public void onClick ( View arg0 ) {
				Toast.makeText ( getApplicationContext (), "Escuchando SMS", Toast.LENGTH_LONG ).show ();
				IntentFilter intentFilter = new IntentFilter ( BROADCAST_SMS );
				registerReceiver ( smsListener, intentFilter );
				Intent intent = new Intent ( BROADCAST_SMS );
				sendBroadcast ( intent );
			}
		} );
		gps_button = ( Button ) findViewById ( R.id.gps_button );
		gps_button.setOnClickListener ( new OnClickListener () {

			@Override
			public void onClick ( View arg0 ) {
				Toast.makeText ( getApplicationContext (), "Escuchando GPS", Toast.LENGTH_LONG ).show ();
				IntentFilter intentFilter = new IntentFilter ( BROADCAST_GPS );
				registerReceiver ( locListener, intentFilter );
				Intent intent = new Intent ( BROADCAST_GPS );
				sendBroadcast ( intent );
			}
		} );

	}

}
