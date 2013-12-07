package es.jimenezfrontend.bcreceivercall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SmsListener extends BroadcastReceiver {
	final SmsManager sms = SmsManager.getDefault ();

	@Override
	public void onReceive ( Context context, Intent intent ) {
		Bundle extra_info = intent.getExtras ();
		if ( extra_info != null ) {
			final Object[] pdusObj = ( Object[] ) extra_info.get ( "pdus" );
			for ( int i = 0; i < pdusObj.length; i++ ) {
				SmsMessage currentMessage = SmsMessage.createFromPdu ( ( byte[] ) pdusObj[i] );
				String phoneNumber = currentMessage.getDisplayOriginatingAddress ();
				String senderNum = phoneNumber;
				String message = currentMessage.getDisplayMessageBody ();
				Log.i ( "SMS RECIBIDO", "Número que lo envía: " + senderNum );
				Log.i ( "SMS RECIBIDO", "Mensaje: " + message );

				int duration = Toast.LENGTH_LONG;
				Toast toast = Toast.makeText ( context, "SMS DE: " + senderNum + ", CONTENIDO: " + message, duration );
				toast.show ();

			}
		}
	}

}
