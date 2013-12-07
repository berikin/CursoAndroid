package es.jimenezfrontend.bcreceivercall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class CallListener extends BroadcastReceiver {

	@Override
	public void onReceive ( Context context, Intent intent ) {
		Bundle extra_info = intent.getExtras ();
		if ( extra_info != null ) {
			String phone_state = extra_info.getString ( TelephonyManager.EXTRA_STATE );
			Log.i ( "ESTADO DEL TELÉFONO: ", phone_state );
			if ( phone_state.equals ( TelephonyManager.EXTRA_STATE_RINGING ) ) {
				String phone_number = extra_info.getString ( TelephonyManager.EXTRA_INCOMING_NUMBER );
				Log.i ( "NÚMERO QUE LLAMA: ", phone_number );
				int duration = Toast.LENGTH_LONG;
				Toast toast = Toast.makeText ( context, "LLAMADA DE: " + phone_number, duration );
				toast.show ();
			}
		}

	}

}
